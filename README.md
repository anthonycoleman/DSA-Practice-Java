# DSA Practice Java

A comprehensive Data Structures and Algorithms practice environment in Java, designed for focused learning of individual concepts.

## 🚀 Quick Start

```bash
# Clone the repository
git clone https://github.com/[your-username]/DSA-Practice-Java.git
cd DSA-Practice-Java

# Run all tests
./gradlew test

# Run tests for a specific algorithm
./gradlew test --tests "*BubbleSort*"
./gradlew test --tests "*BinarySearch*"
./gradlew test --tests "*BFS*"
```

## 📁 Project Structure

This project uses a **focused learning approach** with individual files for each algorithm:

```
src/
├── main/java/com/dsa/
│   ├── algorithms/
│   │   ├── sorting/
│   │   │   ├── BubbleSort.java
│   │   │   ├── QuickSort.java
│   │   │   ├── MergeSort.java
│   │   │   ├── SelectionSort.java
│   │   │   └── InsertionSort.java
│   │   ├── searching/
│   │   │   ├── LinearSearch.java
│   │   │   └── BinarySearch.java
│   │   ├── graph/
│   │   │   ├── BreadthFirstSearch.java
│   │   │   └── DepthFirstSearch.java
│   │   └── dp/
│   │       ├── FibonacciRecursive.java
│   │       ├── FibonacciMemoization.java
│   │       └── FibonacciTabulation.java
│   └── datastructures/
│       ├── Stack.java
│       ├── Queue.java
│       ├── LinkedList.java
│       ├── BST.java
│       ├── Graph.java
│       ├── MinHeap.java
│       ├── HashTable.java
│       └── Trie.java
└── test/java/com/dsa/
    ├── algorithms/... (individual test files)
    └── datastructures/... (individual test files)
```

## 🌟 Key Features

- **Individual Focus**: One algorithm per file for targeted practice
- **Comprehensive Testing**: 300+ test methods covering edge cases
- **Complete Documentation**: Time/space complexity analysis for each algorithm
- **Command-Line Friendly**: Run specific tests with simple commands
- **IDE Integration**: Click-to-run test buttons in IntelliJ/VS Code
- **Two Branches**: `main` (complete) and `practice` (empty stubs)

## 🎯 Algorithms Included

### Sorting Algorithms
| Algorithm | Time Complexity | Space | Best For |
|-----------|----------------|--------|----------|
| Bubble Sort | O(n²) / O(n) best | O(1) | Educational, small datasets |
| Quick Sort | O(n log n) avg | O(log n) | General purpose, in-place |
| Merge Sort | O(n log n) | O(n) | Stable sort, linked lists |
| Selection Sort | O(n²) | O(1) | Memory constrained |
| Insertion Sort | O(n²) / O(n) best | O(1) | Small/nearly sorted arrays |

### Searching Algorithms
| Algorithm | Time Complexity | Space | Prerequisites |
|-----------|----------------|--------|---------------|
| Linear Search | O(n) | O(1) | None |
| Binary Search | O(log n) | O(1) | Sorted array |

### Graph Algorithms
| Algorithm | Time Complexity | Space | Use Case |
|-----------|----------------|--------|----------|
| BFS | O(V + E) | O(V) | Shortest path, level traversal |
| DFS | O(V + E) | O(V) | Pathfinding, topological sort |

### Dynamic Programming
| Algorithm | Time Complexity | Space | Approach |
|-----------|----------------|--------|----------|
| Fibonacci Recursive | O(2ⁿ) | O(n) | Naive recursion |
| Fibonacci Memoization | O(n) | O(n) | Top-down DP |
| Fibonacci Tabulation | O(n) | O(1) | Bottom-up DP |

## 🛠️ Usage

### Running Tests

```bash
# All tests
./gradlew test

# Specific algorithm category
./gradlew test --tests "*Sorting*"
./gradlew test --tests "*Searching*"
./gradlew test --tests "*Graph*"
./gradlew test --tests "*DP*"

# Individual algorithms
./gradlew test --tests "BubbleSortTest"
./gradlew test --tests "*QuickSort*"
./gradlew test --tests "*BinarySearch*"

# Data structures
./gradlew test --tests "*Stack*"
./gradlew test --tests "*LinkedList*"
```

### Test Coverage

```bash
# Generate coverage report
./gradlew test jacocoTestReport

# View report
open build/reports/jacoco/test/html/index.html
```

### Practice Mode

Switch to the practice branch for empty method implementations:

```bash
# Switch to practice branch
git checkout practice

# Now implement algorithms from scratch
# Tests will guide your implementation
./gradlew test --tests "BubbleSortTest"
```

## 🧪 Test Categories

Each algorithm includes comprehensive tests for:

- **Basic Functionality**: Core algorithm behavior
- **Edge Cases**: Empty arrays, single elements, null inputs
- **Boundary Conditions**: Two elements, sorted/reverse sorted
- **Data Variety**: Duplicates, negative numbers, extreme values
- **Performance**: Large datasets (1000+ elements)
- **Error Handling**: Invalid inputs, out-of-bounds

## 🎓 Learning Path

### Beginner Path
1. **Linear Search** → understand basic searching
2. **Bubble Sort** → understand basic sorting and optimization
3. **Stack & Queue** → understand basic data structures
4. **Binary Search** → understand divide-and-conquer

### Intermediate Path
1. **Quick Sort & Merge Sort** → advanced sorting techniques
2. **LinkedList & BST** → pointer manipulation and tree structures
3. **BFS & DFS** → graph traversal algorithms
4. **Hash Table** → understand hashing and collision handling

### Advanced Path
1. **Dynamic Programming** → memoization vs tabulation
2. **MinHeap** → heap operations and heap sort
3. **Trie** → prefix trees and string algorithms
4. **Graph** → adjacency representations

## 🚀 IDE Setup

### IntelliJ IDEA
1. Import as Gradle project
2. Enable auto-import for Gradle
3. Run tests by clicking green arrows next to test methods
4. Use `Ctrl+Shift+F10` to run current test

### VS Code
1. Install Java Extension Pack
2. Install Gradle for Java extension
3. Tests appear in Test Explorer
4. Click play button to run individual tests

## 🔧 Development

### Project Requirements
- Java 11+
- Gradle 7+
- JUnit 5

### Building from Source

```bash
# Clean build
./gradlew clean build

# Run all tests with output
./gradlew test --info

# Build without tests
./gradlew assemble
```

## 📊 Statistics

- **Total Algorithms**: 13 individual implementations
- **Total Data Structures**: 8 complete implementations  
- **Total Test Methods**: 300+ comprehensive tests
- **Test Coverage**: High line and branch coverage
- **Lines of Code**: ~3,000+ (including tests and documentation)

## 🤝 Contributing

This project serves as a template for DSA practice environments. See `DSA_PRACTICE_TEMPLATE.md` for creating similar projects in other languages.

## 📄 License

MIT License - feel free to use this for learning and teaching.

## 🎯 Branch Strategy

- **`main`**: Complete implementations with full functionality
- **`practice`**: Empty method stubs for hands-on practice

**Learning Tip**: Study the `main` branch implementations, then switch to `practice` to implement from scratch!

---

**Happy Coding! 🎉**

*Each algorithm file contains detailed complexity analysis and test commands. Start with any algorithm that interests you and use the tests to guide your learning.*