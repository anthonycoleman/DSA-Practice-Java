# DSA Practice Project Template

**Original Java Implementation:** [DSA-Practice-Java](https://github.com/[your-username]/DSA-Practice-Java)

This template provides a comprehensive prompt for creating a Data Structures and Algorithms practice environment in any programming language. This project structure was refined through extensive development and testing to create the optimal learning experience.

## Language-Specific Instructions

**Before using this template:**
1. Replace `[YOUR_LANGUAGE]` with your target language (e.g., Python, JavaScript, C++, Go, Rust, etc.)
2. Replace `[BUILD_TOOL]` with your language's build/package manager (e.g., pip/pytest, npm/jest, CMake, go mod, cargo, etc.)
3. Replace `[TESTING_FRAMEWORK]` with appropriate testing framework (e.g., pytest, Jest, Google Test, etc.)
4. Replace `[your-username]` with your GitHub username

## LLM Prompt for Project Creation

---

**PROMPT START:**

Create a comprehensive Data Structures and Algorithms (DSA) practice environment in [YOUR_LANGUAGE]. This should be a complete, production-ready project that enables focused learning and practice of individual algorithms and data structures.

## Project Requirements

### 1. Project Structure & Build System
- Use [BUILD_TOOL] as the build system with proper dependency management
- Use [TESTING_FRAMEWORK] for testing with comprehensive test coverage
- Include code coverage reporting tools if available for [YOUR_LANGUAGE]
- Create proper directory structure separating source code, tests, and documentation
- Include configuration files for the build system and testing framework

### 2. Branch Strategy (CRITICAL)
- **main branch**: Complete implementations with full functionality
- **practice branch**: Empty method stubs for practice (to be created later)
- This is the opposite of typical "template" projects - learners checkout main to see solutions, practice branch for empty stubs

### 3. Individual Algorithm Files (ESSENTIAL)
Each algorithm/data structure must be in its own separate file to enable focused practice:

**Sorting Algorithms** (individual files):
- Bubble Sort - O(n²) with optimization for best case O(n)
- Quick Sort - O(n log n) average, O(n²) worst case
- Merge Sort - O(n log n) guaranteed, stable sort
- Selection Sort - O(n²) find minimum approach
- Insertion Sort - O(n²) efficient for small/nearly sorted arrays

**Searching Algorithms** (individual files):
- Linear Search - O(n) sequential search
- Binary Search - O(log n) for sorted arrays

**Graph Algorithms** (individual files):
- Breadth-First Search (BFS) - queue-based level traversal
- Depth-First Search (DFS) - both iterative (stack) and recursive implementations

**Dynamic Programming** (individual files):
- Fibonacci Recursive - O(2^n) naive approach
- Fibonacci Memoization - O(n) top-down DP with caching
- Fibonacci Tabulation - O(n) time, O(1) space bottom-up DP

**Data Structures** (individual files):
- Stack - LIFO with push/pop/peek/isEmpty
- Queue - FIFO with enqueue/dequeue/front/isEmpty  
- LinkedList - with insert/delete/find/display operations
- Binary Search Tree - with insert/search/delete/traversals
- Graph - adjacency list representation with add/remove edges
- MinHeap - binary heap with insert/extractMin/heapify
- HashTable - with put/get/remove/containsKey operations
- Trie - prefix tree with insert/search/startsWith operations

### 4. Comprehensive Documentation
Each algorithm file must include:
- **Time Complexity**: Big O notation for best, average, worst cases
- **Space Complexity**: Memory usage analysis
- **Algorithm Explanation**: Clear description of how it works
- **Use Cases**: When to use this algorithm
- **Test Commands**: Exact command-line instructions to run tests for this specific algorithm

Example format:
```
/**
 * [Algorithm Name] Implementation
 * 
 * Time Complexity: O(?) - [explanation]
 * Space Complexity: O(?) - [explanation]
 * 
 * [Detailed explanation of algorithm approach and methodology]
 * 
 * Use Cases:
 * - [When to use this algorithm]
 * - [Advantages and disadvantages]
 * 
 * Test this implementation:
 * [BUILD_TOOL] test --filter "[AlgorithmName]Test"
 * [BUILD_TOOL] test --filter "*[AlgorithmName]*"
 */
```

### 5. Exhaustive Test Coverage
Create individual test files for each algorithm with comprehensive edge cases:

**Test Categories for Each Algorithm:**
- Empty input (arrays, null values)
- Single element cases
- Two element cases  
- Already sorted input
- Reverse sorted input
- Random order input
- Duplicate elements
- Negative numbers
- Extreme values (max/min possible values)
- Large datasets (performance testing)
- Boundary conditions specific to the algorithm

**Target:** 300+ total test methods across all algorithms with high line coverage

### 6. Individual Test Files
Each algorithm should have its own test file (e.g., `BubbleSortTest.[ext]`, `QuickSortTest.[ext]`) to enable focused testing of individual concepts.

### 7. Error Handling
All algorithms must handle edge cases gracefully:
- Null/undefined inputs
- Empty collections
- Invalid parameters
- Out of bounds conditions

### 8. Command-Line Testing
Ensure all tests can be run from command line with specific filters:
- Run all tests: `[BUILD_TOOL] test`
- Run specific algorithm: `[BUILD_TOOL] test --filter "*BubbleSort*"`
- Run specific category: `[BUILD_TOOL] test --filter "*Sorting*"`

### 9. IDE Integration
Structure the project so it works seamlessly with popular IDEs for [YOUR_LANGUAGE], allowing developers to click "run test" buttons next to individual test methods.

### 10. Performance Considerations
- Include performance tests for large datasets
- Document expected performance characteristics
- Include timing measurements where appropriate

## Implementation Notes

### Critical Design Decisions
1. **One algorithm per file**: This is essential for focused learning
2. **Individual test files**: Enables focused practice and testing
3. **Complete main branch**: Learners can see working solutions immediately
4. **Comprehensive edge case testing**: Builds confidence in implementations
5. **Command-line accessibility**: Essential for various development environments

### Common Pitfalls to Avoid
- Don't group multiple algorithms in single files
- Don't skip edge case testing
- Don't forget null/empty input handling
- Don't omit performance analysis documentation
- Don't create practice branch initially - this comes after main branch is complete

### Testing Strategy
- Start with basic functionality tests
- Add comprehensive edge cases
- Include performance tests for large datasets
- Verify all error conditions are handled
- Ensure 100% test pass rate before creating practice branch

## Deliverables

1. Complete project with proper [YOUR_LANGUAGE] structure
2. All algorithms implemented in individual files
3. Comprehensive test suite with 300+ test methods
4. All tests passing with high coverage
5. Clear documentation with complexity analysis
6. Command-line test execution working
7. Ready for practice branch creation (but don't create it yet)

## Final Verification
Before considering the project complete:
- [ ] All tests pass: `[BUILD_TOOL] test`
- [ ] Each algorithm is in its own file
- [ ] Each algorithm has comprehensive documentation
- [ ] Test commands are included in implementation files
- [ ] Edge cases are thoroughly tested
- [ ] Error handling is implemented
- [ ] Command-line testing works for individual algorithms
- [ ] Project builds successfully from scratch

**PROMPT END**

---

## Usage Instructions

1. Copy the prompt section above
2. Replace all placeholder values with your target language specifics
3. Provide the prompt to your preferred LLM (Claude, ChatGPT, etc.)
4. Work with the LLM to refine the implementation as needed
5. Create the practice branch after the main branch is complete and tested

## Contributing

Found improvements or language-specific optimizations? Please contribute back to the community by submitting issues or pull requests to the original repository.