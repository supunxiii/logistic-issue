package secondmilestone;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dijkstra<T extends String> {

    // method to calculate the shortest path from the source node using Dijkstra's algorithm
    public List<Node<T>> calculateShortestPath(Node<T> source) {
        source.setDistance(0);
        Set<secondmilestone.Node<T>> settledNodes = new HashSet<>();
        secondmilestone.PriorityQueue<secondmilestone.Node<T>> unsettledNodes = new PriorityQueue<>();
        unsettledNodes.add(source);
        while (!unsettledNodes.isEmpty()) {
            secondmilestone.Node<T> currentNode = unsettledNodes.poll();
            currentNode.getAdjacentNodes()
                    .entrySet().stream()
                    .filter(entry -> !settledNodes.contains(entry.getKey()))
                    .forEach(entry -> {
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                        unsettledNodes.add(entry.getKey());
                    });
            settledNodes.add(currentNode);
        }
        // after the calculation return a sorted list of nodes based on the total distance/weight
        return settledNodes.stream()
                .sorted(Comparator.comparingInt(Node::getDistance))
                .collect(Collectors.toList());
    }

    // Helper method
    private void evaluateDistanceAndPath(secondmilestone.Node<T> adjacentNode, Integer edgeWeight, secondmilestone.Node<T> sourceNode) {
        Integer newDistance = sourceNode.getDistance() + edgeWeight;
        if (newDistance < adjacentNode.getDistance()) {
            adjacentNode.setDistance(newDistance);
            adjacentNode.setShortestPath(Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode)).toList());
        }
    }

    // method to print the calculated paths and distances
    public void printPaths(List<Node<T>> nodes) {
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream()
                    .map(Node::getName)
                    .map(Objects::toString)
                    .collect(Collectors.joining(" -> "));
            System.out.println((path.isBlank()
                    ? "%s : %s".formatted(node.getName(), node.getDistance())
                    : "%s -> %s : %s".formatted(path, node.getName(), node.getDistance()))
            );
        });
    }

    // method to perform merge sort on a list of nodes based on distances
    private List<Node<T>> mergeSort(List<Node<T>> nodes) {
        int size = nodes.size();
        if (size <= 1) {
            return nodes;
        }

        int middle = size / 2;
        List<Node<T>> left = nodes.subList(0, middle);
        List<Node<T>> right = nodes.subList(middle, size);

        // recursively applying mergeSort to the left and right sublists
        left = mergeSort(left);
        right = mergeSort(right);

        // merging the sorted left and right sublists
        return merge(left, right);
    }


    // method to merge two sorted lists (left and right) into a single sorted list
    private List<Node<T>> merge(List<Node<T>> left, List<Node<T>> right) {
        List<Node<T>> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).getDistance() < right.get(rightIndex).getDistance()) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }


    // method to return all the nodes after being sorted by mergeSort which uses Merge Sort
    public List<Node<T>> sortNodesByDistance(List<Node<T>> nodes) {
        return mergeSort(nodes);
    }


    // outputs all the nodes excluding the source node
    public <U extends Comparable<U>> void printAllNodes(List<Node<T>> nodes) {
        System.out.println("<============= THE CURRENT DELIVERY LOCATIONS =============>\n");
        nodes.stream()
                .filter(node -> !node.getName().equals("WAREHOUSE"))
                .sorted(Comparator.comparing(node -> node.getName().toString()))
                .map(Node::getName)
                .forEach(System.out::println);
    }


    // method to save path data to a file as a backup strategy
    public void savePathsToFile(List<Node<T>> nodes, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            nodes.forEach(node -> {
                String path = node.getShortestPath().stream()
                        .map(Node::getName)
                        .map(Objects::toString)
                        .collect(Collectors.joining(" -> "));
                String line = (path.isBlank()
                        ? String.format("%s : %s", node.getName(), node.getDistance())
                        : String.format("%s -> %s : %s", path, node.getName(), node.getDistance()));

                try {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("\nGrid co-ordinates are saved successfully to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // method to read the data written in the backup_co-ordinates.txt and makes the van schedule based on the closest adjacent node to the source node in the 'path'
    public void readPathsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Map<String, List<String>> categoryPaths = new HashMap<>();
            String line;
            String currentCategory = null;
            boolean isEmpty = true;

            while ((line = reader.readLine()) != null) {
                if (line.contains("->")) {
                    String[] parts = line.split(" -> ");
                    String category = parts[1].trim();
                    currentCategory = category;
                    categoryPaths.computeIfAbsent(category, k -> new ArrayList<>()).add(line);
                    isEmpty = false; // file is not empty
                } else if (currentCategory != null) {
                    categoryPaths.get(currentCategory).add(line);
                    isEmpty = false; // file is not empty
                }
            }
            // checks if the backup_co-ordinates.txt file is empty
            if (isEmpty) {
                System.out.println("Currently, there's no data available. Save the data to continue.");
            } else {
                // Print categorized paths
                for (Map.Entry<String, List<String>> entry : categoryPaths.entrySet()) {
                    // Remove any number part or ":" from category label and trim leading/trailing spaces
                    String categoryLabel = entry.getKey().replaceAll("[:\\d]", "").trim();
                    System.out.println("\nPackages with below location(s) should be loaded to the van headed to " + categoryLabel + ":");
                    for (String path : entry.getValue()) {
                        // Remove ": number" part from each path
                        String cleanPath = path.replaceAll(" : \\d+", "");
                        System.out.println(cleanPath);
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

