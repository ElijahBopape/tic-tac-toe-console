# Tic Tac Toe (Java Console)

Hey! Fancy a game? 🎮

This is good old tic-tac-toe, written in Java and played right in your terminal. You can play against a friend on the same keyboard, or against the computer. Fair warning: the computer is not very clever, so you'll probably win.

## What you'll need

Just **Java 17 or newer** (the JDK, so you can compile it).

To check, open a terminal and run:

```bash
java -version
javac -version
```

If you see 17 or higher for both, you're ready. If not, you can get a free JDK from [Adoptium](https://adoptium.net/).

## Running it

From the project folder:

```bash
cd src
javac TicTacToe.java
java TicTacToe
```

## How to play

First you pick a mode:

```
1. Player vs Player
2. Player vs Computer
```

Then you take turns choosing a square. The squares are numbered like a phone keypad:

```
 1 | 2 | 3
---+---+---
 4 | 5 | 6
---+---+---
 7 | 8 | 9
```

Get three in a row (across, down or diagonally) and you win. When the game ends, it'll ask if you want to play again.

If you pick a square that's already taken, or type something that isn't 1 to 9, it'll just ask you again. No crashing.

## What I was practising

- 2D arrays (the board is a `char[3][3]`)
- Nested loops
- Turning a number from 1 to 9 into a row and column using `/` and `%` (this part made me feel quite clever)
- Checking for a win across rows, columns and diagonals
- Using `Random` for the computer's moves

## Things I know aren't perfect

- The computer just picks random empty squares, so it's very easy to beat.
- There's no scoreboard between rounds.

## What I'd like to add next

- Make the computer at least block you when you're about to win
- Keep score across rounds

Enjoy, and let me know if you manage to lose to the computer 😄
