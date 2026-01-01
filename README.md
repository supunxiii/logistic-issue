## Overview

LOGISTIC-ISSUE is a console-based Java application developed for **COMP50004-K-II - Data Structures and Algorithms**. The system models loading goods and managing deliveries for a logistics company using a carefully chosen set of data structures and algorithms. It stores operational data, generates essential outputs such as invoices, and includes documented logic with pseudocode, drawback analysis, and recommendations for future improvements.

Designed and developed by Supun Wijesooriya in September 2023.

![Java 16](https://img.shields.io/badge/Java-16-007396?style=flat-square&logo=java&logoColor=white)

## Features

1. **Priority Queue-Based Loading (Milestone 1)**

   - Loads packages onto a van using a priority queue
   - Enforces a maximum capacity of 13 packages
   - Displays package details and delivery order

2. **Invoice Generation**

   - Outputs invoice details when a package is delivered
   - Includes customer, address, weight, and price data

3. **Shortest Path Routing (Milestone 2)**

   - Uses Dijkstra’s algorithm to compute shortest delivery paths
   - Sorts and displays delivery locations by distance

4. **Backup and Delivery Schedule**

   - Saves computed paths to a backup file
   - Reads and prints a categorised van schedule from backup

5. **Console Menu Workflow**

   - Menu-driven options for loading, delivering, listing, and scheduling
   - Separate runnable drivers for each milestone

## Technologies Used

- **Java 16**: Core language (class file version 60.0)
- **Java Standard Library**: Collections, I/O, and console input handling
- **No External Libraries**: Implementation is fully hand-written

## Project Specifications

- **Course**: COMP50004-K-II - Data Structures and Algorithms
- **Problem Focus**: Loading goods and delivery management in a logistics company
- **Data Structures**: Priority queue, linked nodes, adjacency list graph
- **Algorithms**: Dijkstra’s shortest path
- **Outputs**: Invoice generation and delivery schedule reports
- **Documentation**: Logic explanation, pseudocode, drawback analysis, and future improvement recommendations
- **Development Year**: 2023

## Graph

![Delivery Graph](https://github.com/supunxiii/supunxiii/blob/7653f59dcf38771e7791a1cc0795c9d6b4cdcd3c/user-interfaces/logistic-issue/graph.png)

## Getting Started

To run the project locally, follow these steps:

1. Clone the repository:

   ```shell
   git clone https://github.com/supunxiii/logistic-issue.git
   ```

2. Navigate to the project directory:

   ```shell
   cd logistic-issue/DataStructuresAssignment
   ```

3. Compile the source files:

   ```shell
   javac -d out src/firstmilestone/*.java src/secondmilestone/*.java
   ```

4. Run Milestone 1 (Priority Queue):

   ```shell
   java -cp out firstmilestone.Driver
   ```

5. Run Milestone 2 (Shortest Paths):

   ```shell
   java -cp out secondmilestone.Driver
   ```

## Project Structure

```
logistic-issue/
├── DataStructuresAssignment/
│   ├── src/
│   │   ├── firstmilestone/
│   │   │   ├── Driver.java
│   │   │   ├── Node.java
│   │   │   ├── Package.java
│   │   │   └── PriorityQueue.java
│   │   └── secondmilestone/
│   │       ├── Dijkstra.java
│   │       ├── DijkstraLinkedList.java
│   │       ├── Driver.java
│   │       ├── Node.java
│   │       └── PriorityQueue.java
│   ├── backup_co-ordinates.txt
│   └── DataStructuresAssignment.iml
└── README.md
```

## Developer

This project was developed in **September 2023** by:

- **Supun Wijesooriya** - Software Developer

## Contributing

Contributions to the LOGISTIC-ISSUE project are welcome! If you would like to contribute, please follow these steps:

1. Fork the repository.

2. Create a new branch:

   ```shell
   git checkout -b feature/your-feature-name
   ```

3. Make your changes and commit them:

   ```shell
   git commit -m "Add your commit message"
   ```

4. Push your changes to your forked repository:

   ```shell
   git push origin feature/your-feature-name
   ```

5. Open a pull request to the main repository, describing your changes and the purpose of the pull request.

## Important Notes

- This is a console-based Java application designed for academic assessment
- The delivery schedule is saved to `backup_co-ordinates.txt`
- All logic is implemented without external libraries or frameworks
- Outputs include invoice-style summaries for deliveries

## Contact

For any enquiries or feedback, please contact the developer:

- **Supun Wijesooriya**: [GitHub Profile](https://github.com/supunxiii)
- **Project Repository**: [logistic-issue](https://github.com/supunxiii/logistic-issue)

---

_Designed and developed in September 2023_
