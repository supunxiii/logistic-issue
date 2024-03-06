package firstmilestone;

public class Node {
    int priority;
    Package info;
    Node link;

    public Node(Package info, int priority) {
        this.priority = priority;
        this.info = info;
        this.link = null;
    }
}