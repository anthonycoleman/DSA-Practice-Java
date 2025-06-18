# Java DSA Practice Gym

This project is a personal "gym" for mastering fundamental Data Structures and Algorithms in Java. It was built to develop deep implementation fluency—or "muscle memory"—independent of specific LeetCode problems, preparing for the demands of technical interviews.

The repository contains a comprehensive, test-driven scaffold for core DSA concepts, including:
- **Sorting Algorithms**: Bubble, Selection, Insertion, Merge, and Quick Sort.
- **Searching Algorithms**: Linear and Binary Search.
- **Core Data Structures**: Stack, Queue, Singly Linked List, Binary Search Tree, Graph, Min-Heap, Hash Table, and Trie.
- **Advanced Algorithm Paradigms**: Graph Traversals (BFS, DFS) and an introduction to Dynamic Programming.

### Workflow

The intended workflow is to:
1. Pick a topic (e.g., `BinarySearchTree.java`).
2. Implement the methods from scratch.
3. Run the tests via `gradle test` to validate the implementation.
4. Reset the code to its original state with `git restore .` for repeated practice.

### Accessing Solutions and Advanced Workflow

This repository includes a `solutions` branch that contains complete, tested implementations for all data structures and algorithms. This allows you to check your work or get unstuck.

**Recommended Workflow for Using Solutions:**

1.  **Attempt Implementation First**: Always try to implement the data structure or algorithm on the `main` branch yourself. This is crucial for building muscle memory.
2.  **Save Your Progress**: If you want to view the solution or need to switch context, save your current work on the `main` branch:
    ```bash
    # Stash your current uncommitted changes, including untracked files
    git stash push -u -m "My practice on [Topic]"
    # The -m adds a descriptive message to your stash.
    ```
3.  **Switch to the Solutions Branch**:
    ```bash
    git switch solutions
    ```
4.  **View the Solution**: Navigate to the relevant file (e.g., `src/main/java/com/dsa/datastructures/stack/Stack.java`) to see the complete implementation.
5.  **Return to Your Practice**:
    ```bash
    git switch main
    ```
6.  **Restore Your Work**:
    ```bash
    # To apply the most recent stash and remove it from the stash list:
    git stash pop
    # Or, if you have multiple stashes, list them with `git stash list`
    # and apply a specific one with `git stash apply stash@{N}` (where N is the stash number),
    # then `git stash drop stash@{N}` if you're done with it.
    ```

**Important Notes:**
*   The `solutions` branch is intended as a reference. Avoid copying code directly without understanding it.
*   Ensure your `main` branch is clean (no uncommitted changes) or your changes are stashed before switching branches to avoid conflicts.
*   The tests on the `main` branch are designed to fail initially. They will pass once you correctly implement the solutions. All tests should pass on the `solutions` branch.

**Simplifying Branch Switching (Optional Shell Aliases):**

To make switching between practice and solution contexts faster, you can add aliases to your shell configuration file (e.g., `~/.zshrc`, `~/.bashrc`).

Example for Zsh (`~/.zshrc`):
```bash
# DSA Practice Aliases
alias dsa_practice_save="git stash push -u -m 'DSA practice progress'"
alias dsa_view_solutions="dsa_practice_save && git switch solutions"
alias dsa_return_to_practice="git switch main && git stash pop"
```

Example for Bash (`~/.bashrc`):
```bash
# DSA Practice Aliases
alias dsa_practice_save='git stash push -u -m "DSA practice progress"'
alias dsa_view_solutions='dsa_practice_save && git switch solutions'
alias dsa_return_to_practice='git switch main && git stash pop'
```
Remember to source your shell configuration file (e.g., `source ~/.zshrc` or `source ~/.bashrc`) or open a new terminal window after adding aliases for them to take effect.
