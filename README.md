# Algorithmic Sudoku in Java 

A fully interactive, command-line based Sudoku game written in Java. This project demonstrates the practical application of Data Structures and Algorithms (DSA) to generate, validate, and solve Sudoku puzzles efficiently right in your terminal.

## Description
This is not just a simple Sudoku game; it's an algorithmic approach to puzzle generation and solving. The game generates a completely unique, logically valid board every time you play, guaranteeing exactly one unique solution using advanced backtracking techniques.

## Features
* **Algorithmic Puzzle Generation:** Utilizes a custom **Linear Congruential Generator (LCG)** algorithm to ensure true randomness and unique puzzles every session without relying on pre-made boards.
* **Backtracking Solver & Validator:** Implements an optimized backtracking algorithm (`solveBoard` and `countSolutions`) to guarantee that every generated puzzle has exactly one valid solution.
* **4 Difficulty Levels:** Choose from Child, Beginner, Intermediate, and Advanced. The difficulty adjusts the number of hidden cells dynamically.
* **Colored Terminal UI:** A visually appealing console interface using ANSI escape codes for clear grid formatting, separating 3x3 blocks, and providing interactive user feedback.
* **Interactive Gameplay:** Features a built-in timer to track your solving speed and a "3-Lives" system for wrong inputs.

## Screenshots

<img width="618" height="299" alt="Main Menu" src="https://github.com/user-attachments/assets/9c83140a-d082-41e7-85cc-9f3301d48ab1" />
<br><br>
<img width="662" height="753" alt="Gameplay Grid" src="https://github.com/user-attachments/assets/079889ea-5300-41c3-a5a4-2fab15364c1d" />

## Project Structure

To ensure the custom terminal colors work correctly, the project relies on the following structure:

```text
Algorithmic-Sudoku-Java/
├── Sudoku.java                # Main game logic, backtracking, and LCG algorithm
└── Theme/
    └── Colors.java            # ANSI color codes for the terminal interface
```
## How to Run
To play the game on your local machine, follow these steps:

1. Clone the repository:
   ```bash
    git clone https://github.com/mohammed1elmaghraby/Algorithmic-Sudoku-Java.git
   ```
2. Navigate to the project directory:
      ```bash
       cd Algorithmic-Sudoku-Java
      ```
3. Compile the Java file:
    ```bash
      javac Sudoku.java Theme/Colors.java
      ```
4. Run the game:
    ```bash
      java Sudoku
      ```

## Algorithms Used
1- Linear Congruential Generator (LCG): Used to create a pseudorandom number generator from scratch using mathematical formulas 
(seed = (a * seed + c) % m) rather than using Java's built-in Random class.

2- Backtracking Algorithm: The core engine of the game. It uses recursion to explore all possible numbers (1-9) for empty cells, placing valid numbers and backtracking when it hits a dead end.

## License
This project is licensed under the MIT License.


## Developed with ❤️ by Mohammed Elmaghraby.
