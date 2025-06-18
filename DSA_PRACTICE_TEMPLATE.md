# DSA Practice Environment - Universal Template

This template is designed to help you (or an AI assistant like Cascade) scaffold a comprehensive Data Structures and Algorithms (DSA) practice environment in various programming languages.

**Original Java Project (for context and reference):** [https://github.com/anthonycoleman/DSA-Practice-Java](https://github.com/anthonycoleman/DSA-Practice-Java)

**AI Assistant Used for Original Scaffolding:** Cascade (by Windsurf)
**IDE Used:** Windsurf

## I. Core Objective & User Goal:

My primary goal is to create a comprehensive practice environment for mastering fundamental Data Structures and Algorithms (DSA) in **`[PROGRAMMING_LANGUAGE_HERE]`**. I want to build "muscle memory" for these concepts, similar to how one learns long division before tackling complex word problems.

The project should consist of:
1.  Empty method/function stubs for core algorithms and data structure operations.
2.  A corresponding unit test suite for each module. These tests should be comprehensive, covering common cases, edge cases, and expected error conditions. Initially, all tests should fail.
3.  The setup should support a test-driven development (TDD) approach.
4.  I will practice by implementing the stubs and then using `git restore .` to revert to the clean scaffold for repeated practice.

## II. Language-Specific Setup:

*   **Target Programming Language:** **`[PROGRAMMING_LANGUAGE_HERE]`** (e.g., Python, JavaScript, C#, Visual Basic, C++, Rust, Go)
*   **Build System & Project Management:**
    *   Please use the standard and idiomatic build system or project management tools for **`[PROGRAMMING_LANGUAGE_HERE]`**.
    *   *User: If you have a preference (e.g., Maven for Java, Poetry for Python, Vite for a JS frontend project), please specify it here. Otherwise, the AI assistant should choose a common default.*
    *   Examples:
        *   Java: Gradle (default) or Maven
        *   Python: `pip` with `venv` and `requirements.txt` (default), or Poetry/PDM
        *   JavaScript/TypeScript: `npm` (default) or `yarn`, with `package.json`
        *   C#: .NET CLI (`dotnet new sln`, `dotnet new classlib`, etc.)
        *   Visual Basic (.NET): .NET CLI (`dotnet new sln`, `dotnet new classlib`, etc.)
        *   C++: CMake
        *   Rust: Cargo
        *   Go: Go Modules
*   **Testing Framework:**
    *   Please use a standard and idiomatic testing framework for **`[PROGRAMMING_LANGUAGE_HERE]`**.
    *   *User: If you have a preference, please specify it here. Otherwise, the AI assistant should choose a common default.*
    *   Examples:
        *   Java: JUnit 5
        *   Python: `pytest` (default) or `unittest`
        *   JavaScript/TypeScript: Jest (default) or Mocha/Chai
        *   C#: MSTest (default), NUnit, or xUnit
        *   Visual Basic (.NET): MSTest (default), NUnit, or xUnit
        *   C++: Google Test (default) or Catch2
        *   Rust: Built-in testing framework (`#[test]`)
        *   Go: Built-in `testing` package
*   **Project Structure:**
    *   Create a clean, idiomatic project structure for **`[PROGRAMMING_LANGUAGE_HERE]`**, ensuring a clear separation between source code and test code.
    *   Use appropriate naming conventions and file extensions for the language.

## III. DSA Modules to Scaffold:

For each module listed below, please:
1.  Create a source file (e.g., `Sorting.vb`, `sorting.py`, `Stack.cs`) containing empty function/method stubs. Each stub should be clearly marked (e.g., `// TODO: Implement...` or language equivalent).
2.  Create a corresponding test file with comprehensive unit tests that initially fail.

*   **A. Core Algorithms:**
    *   **Sorting:** (Operates on an array/list of integers)
        *   Methods/Functions: `bubbleSort`, `selectionSort`, `insertionSort`, `mergeSort`, `quickSort`.
    *   **Searching:** (Operates on a sorted array/list of integers)
        *   Methods/Functions: `linearSearch`, `binarySearch`.

*   **B. Core Data Structures:**
    *   *(For generic structures, implement them generically if idiomatic in `[PROGRAMMING_LANGUAGE_HERE]`. If not, default to operating on integers or strings, or specify a type).*
    *   **Stack:**
        *   Methods: `push`, `pop`, `peek`, `isEmpty`, `size`.
    *   **Queue:**
        *   Methods: `enqueue`, `dequeue`, `peek`, `isEmpty`, `size`.
    *   **Singly Linked List:**
        *   Include a Node structure (as an inner class/struct or separate, as idiomatic).
        *   Methods: `addFirst`, `addLast`, `removeFirst`, `removeLast`, `get(index)`, `contains(value)`, `size`, `isEmpty`.
    *   **Binary Search Tree (BST):** (For comparable types if possible)
        *   Include a Node structure.
        *   Methods: `insert(value)`, `search(value)`, `delete(value)`, `inOrderTraversal()`, `preOrderTraversal()`, `postOrderTraversal()`, `isEmpty()`.
    *   **Graph (Adjacency List representation):**
        *   Constructor to specify if directed or undirected (e.g., `Graph(isDirected: boolean)`).
        *   Methods: `addVertex(vertex)`, `addEdge(source, destination)`, `getVertices()`, `getNeighbors(vertex)`, `getVertexCount()`.
    *   **Min-Heap:** (Array-based implementation, for comparable types if possible)
        *   Methods: `insert(item)`, `peek()`, `extractMin()`, `size()`, `isEmpty()`.
    *   **Hash Table (Separate Chaining for collision resolution):** (For key-value pairs)
        *   Include an Entry structure (key, value).
        *   Methods: `put(key, value)`, `get(key)`, `remove(key)`, `containsKey(key)`, `size()`, `isEmpty()`.
    *   **Trie (Prefix Tree):** (For strings)
        *   Include a TrieNode structure (children map, `isEndOfWord` flag).
        *   Methods: `insert(word)`, `search(word)`, `startsWith(prefix)`.

*   **C. Advanced Algorithm Paradigms:**
    *   **Graph Traversals:** (Operates on the `Graph` structure created above)
        *   Methods/Functions: `bfs(graph, startVertex)`, `dfs(graph, startVertex)`. Both should return a list/collection of visited nodes in order.
    *   **Dynamic Programming (Introduction):**
        *   Methods/Functions for Fibonacci sequence:
            *   `fibonacciRecursive(n)` (naive recursive solution)
            *   `fibonacciWithMemoization(n)` (top-down DP with memoization)
            *   `fibonacciWithTabulation(n)` (bottom-up DP with tabulation)

## IV. Git & GitHub Integration:

1.  After all modules are scaffolded and initial (failing) tests are written, initialize a Git repository in the project's root directory.
2.  Add all project files to the staging area.
3.  Create an initial commit with a message like: "Initial commit: DSA practice scaffold for **`[PROGRAMMING_LANGUAGE_HERE]`**".
4.  Create a `README.md` file. Include a brief project title, a short description (similar to the one used for the Java project, but adapted for **`[PROGRAMMING_LANGUAGE_HERE]`**), and a "Workflow" section explaining the TDD and `git restore .` practice method. Commit this `README.md`.
5.  Prompt me (the user) to create a new, empty repository on GitHub.com.
6.  Once I provide the HTTPS URL for the new GitHub repository, perform the following Git commands:
    *   `git remote add origin [USER_PROVIDED_URL]`
    *   `git branch -m master main` (or ensure the default branch is named `main`)
    *   `git push -u origin main`
    *   If the push fails due to authentication, guide me on how to run the push command from my own terminal and use a Personal Access Token (PAT).

## VI. Accessing Solutions and Advanced Workflow:

For projects scaffolded using this template, it's highly recommended to also create and maintain a `solutions` branch. This branch should contain complete, tested implementations for all the data structures and algorithms.

**Purpose of the `solutions` Branch:**
*   Provides a reference to check your work.
*   Helps you get unstuck if you encounter difficulties during implementation.
*   Ensures you have a working example of each concept.

**Recommended Workflow for Using Solutions (similar to the Java project):**

1.  **Attempt Implementation First**: Always try to implement the data structure or algorithm on the `main` (or your primary practice) branch yourself. This is crucial for building muscle memory.
2.  **Save Your Progress**: If you want to view the solution or need to switch context, save your current work on your practice branch:
    ```bash
    # Stash your current uncommitted changes, including untracked files
    git stash push -u -m "My practice on [Topic] in [PROGRAMMING_LANGUAGE_HERE]"
    # The -m adds a descriptive message to your stash.
    ```
3.  **Switch to the Solutions Branch**:
    ```bash
    git switch solutions
    # (Ensure this branch exists and is up-to-date)
    ```
4.  **View the Solution**: Navigate to the relevant file to see the complete implementation.
5.  **Return to Your Practice Branch**:
    ```bash
    git switch main # Or your primary practice branch name
    ```
6.  **Restore Your Work**:
    ```bash
    # To apply the most recent stash and remove it from the stash list:
    git stash pop
    # Or, if you have multiple stashes, list them with `git stash list`
    # and apply a specific one with `git stash apply stash@{N}` (where N is the stash number),
    # then `git stash drop stash@{N}` if you're done with it.
    ```

**Important Notes for the `solutions` Branch Workflow:**
*   The `solutions` branch is intended as a reference. Avoid copying code directly without understanding it.
*   Ensure your practice branch is clean (no uncommitted changes) or your changes are stashed before switching branches to avoid conflicts.
*   Tests on the practice branch should initially fail and pass once you correctly implement the solutions. All tests should pass on the `solutions` branch.
*   When scaffolding a new language project, after implementing all solutions on the `solutions` branch, remember to push it to the remote repository (e.g., `git push origin solutions`).

**Simplifying Branch Switching (Optional Shell Aliases):**

You can adapt the shell alias examples from the Java project's `README.md` for your specific shell and workflow.

Example for Zsh (`~/.zshrc`):
```bash
# DSA Practice Aliases for [PROGRAMMING_LANGUAGE_HERE]
alias dsa_lang_save="git stash push -u -m '[LANG] practice progress'"
alias dsa_lang_view_solutions="dsa_lang_save && git switch solutions"
alias dsa_lang_return_to_practice="git switch main && git stash pop"
```
Replace `[LANG]` with a short identifier for the programming language.

---

## V. Final Deliverables & Confirmation:

*   Confirm that all requested DSA modules and their corresponding test files have been created.
*   Confirm that the standard test command for **`[PROGRAMMING_LANGUAGE_HERE]`** (e.g., `gradle test`, `pytest`, `npm test`) runs and shows the expected initial failures for all tests.
*   Confirm that the project has been successfully pushed to the provided GitHub repository, including the `README.md`.
*   Remind me of the `git restore .` command for my practice workflow.

---
