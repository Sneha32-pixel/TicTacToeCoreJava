
import java.util.Scanner;

/**
 * 
 */
public class TicTacToe {

    static char[][] board = new char[3][3];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        int count = 0;
        char symbol = 'X';

        while (true) {

            displayBoard();

            // Display player turn
            if (symbol == 'X') {
                System.out.println("Bob's turn (X)");
            } else {
                System.out.println("Sneha's turn (O)");
            }

            System.out.print("Enter row (0-2): ");
            int row = sc.nextInt();

            System.out.print("Enter column (0-2): ");
            int col = sc.nextInt();

            // Validate position
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position. Try again.");
                continue;
            }

            if (board[row][col] != ' ') {
                System.out.println("Position already filled. Try again.");
                continue;
            }

            // Place symbol
            board[row][col] = symbol;
            count++;

            // Check winner
            if (checkWinner(symbol)) {

                displayBoard();

                if (symbol == 'X') {
                    System.out.println("Bob wins!");
                } else {
                    System.out.println("Sneha wins!");
                }

                break;
            }

            // Check draw
            if (count == 9) {
                displayBoard();
                System.out.println("Match Draw!");
                break;
            }

            // Switch player
            if (symbol == 'X') {
                symbol = 'O';
            } else {
                symbol = 'X';
            }
        }

        sc.close();
    }

    static void displayBoard() {

        System.out.println();

        for (int i = 0; i < 3; i++) {

            System.out.println(
                " " + board[i][0] + " | "
                    + board[i][1] + " | "
                    + board[i][2]
            );

            if (i < 2) {
                System.out.println("---+---+---");
            }
        }

        System.out.println();
    }

    static boolean checkWinner(char symbol) {

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol &&
                board[1][i] == symbol &&
                board[2][i] == symbol) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {
            return true;
        }

        return false;
    }
}
