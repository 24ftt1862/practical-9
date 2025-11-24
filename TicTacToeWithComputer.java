import java.util.Scanner;

public class TicTacToeWithComputer {

    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBoard();

        while (true) {
            printBoard();
            playerTurn();

            if (checkWinner('X')) {
                printBoard();
                System.out.println("Game ended, Player Win");
                break;
            }
            if (isFull()) {
                printBoard();
                System.out.println("Game ended, Draw");
                break;
            }

            computerTurn();

            if (checkWinner('O')) {
                printBoard();
                System.out.println("Game ended, CPU Win");
                break;
            }
        }
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---------");
        }
        System.out.println();
    }

    static void playerTurn() {
        System.out.println("Player's turn");
        int row, col;
        while (true) {
            System.out.print("Enter a row (0,1 or 2): ");
            row = sc.nextInt();
            System.out.print("Enter a column (0,1 or 2): ");
            col = sc.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = 'X';
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    static void computerTurn() {
        int row, col;
        do {
            row = (int) (Math.random() * 3);
            col = (int) (Math.random() * 3);
        } while (board[row][col] != ' ');
        board[row][col] = 'O';
    }

    static boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    static boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }
}


