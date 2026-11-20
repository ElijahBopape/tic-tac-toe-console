import java.util.Random;
import java.util.Scanner;

/**
 * TicTacToe
 *
 * A two-mode tic-tac-toe game I made for practice:
 *  - Player vs Player on the same keyboard
 *  - Player vs a simple computer that picks random free squares
 *
 * I used a 2D char array for the board because a 3x3 grid maps naturally to rows and columns.
 */
public class TicTacToe {

    private static final char EMPTY = ' ';
    private static final char[][] board = new char[3][3];
    private static final Scanner input = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("=== Tic Tac Toe ===");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        System.out.print("Choose a mode: ");
        boolean vsComputer = input.nextLine().trim().equals("2");

        boolean playAgain = true;
        while (playAgain) {
            playGame(vsComputer);
            System.out.print("Play again? (y/n): ");
            playAgain = input.nextLine().trim().equalsIgnoreCase("y");
        }
        System.out.println("Thanks for playing!");
    }

    private static void playGame(boolean vsComputer) {
        clearBoard();
        char currentPlayer = 'X';

        // A game can have at most 9 moves, so I loop up to 9 times.
        for (int move = 0; move < 9; move++) {
            printBoard();

            if (vsComputer && currentPlayer == 'O') {
                computerMove();
            } else {
                playerMove(currentPlayer);
            }

            if (hasWon(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                return;
            }

            // I switch players using the ternary operator.
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        printBoard();
        System.out.println("It's a draw!");
    }

    private static void clearBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    private static void printBoard() {
        System.out.println();
        for (int row = 0; row < 3; row++) {
            System.out.println(" " + board[row][0] + " | " + board[row][1] + " | " + board[row][2]);
            if (row < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    /**
     * The player types a number from 1 to 9. I picked this because it's easier
     * than typing a row and a column. I convert the number into row and column.
     *   1 | 2 | 3
     *   4 | 5 | 6
     *   7 | 8 | 9
     */
    private static void playerMove(char player) {
        while (true) {
            System.out.print("Player " + player + ", pick a square (1-9): ");
            String line = input.nextLine().trim();
            try {
                int square = Integer.parseInt(line);
                if (square < 1 || square > 9) {
                    System.out.println("Pick a number from 1 to 9.");
                    continue;
                }
                int row = (square - 1) / 3; // integer division gives the row
                int col = (square - 1) % 3; // remainder gives the column

                if (board[row][col] != EMPTY) {
                    System.out.println("That square is taken.");
                    continue;
                }
                board[row][col] = player;
                return;
            } catch (NumberFormatException e) {
                System.out.println("Please type a number.");
            }
        }
    }

    // My computer player isn't smart, it just picks a random empty square.
    private static void computerMove() {
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (board[row][col] == EMPTY) {
                board[row][col] = 'O';
                System.out.println("Computer picked square " + (row * 3 + col + 1));
                return;
            }
        }
    }

    // I check all 3 rows, all 3 columns and both diagonals.
    private static boolean hasWon(char p) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) return true; // row
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) return true; // column
        }
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) return true; // diagonal
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) return true; // other diagonal
        return false;
    }
}
