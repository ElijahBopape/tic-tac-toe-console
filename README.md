# Tic Tac Toe (Java Console)

A simple tic-tac-toe game I made in Java for practice. You can play against a friend on the same keyboard or against a (not very clever) computer.

## What I practised
- 2D arrays (`char[3][3]`)
- Nested loops
- Turning a number 1–9 into a row and column using `/` and `%`
- Writing a win-check for rows, columns and diagonals
- `Random` for the computer's moves

## How to run
You need Java 17 or newer.

```bash
cd src
javac TicTacToe.java
java TicTacToe
```

Squares are numbered like a phone keypad:
```
 1 | 2 | 3
---+---+---
 4 | 5 | 6
---+---+---
 7 | 8 | 9
```

## Known limitations
- The computer picks random squares, so it's easy to beat.
- There's no score tracking between rounds.

## Ideas for later
- Make the computer block your winning move
- Keep a scoreboard
