package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XO_Controller {

    /**
     * iStart is the x dimension of the first square
     * jStart is the y dimension of the first square
     * iIncrement is the increment value that on x axis
     * jIncrement is the increment value that on y axis
    */
    private static int[] iStart =     {0, 1, 2, 0, 0, 0, 0, 0};
    private static int[] jStart =     {0, 0, 0, 0, 1, 2, 0, 2};
    private static int[] iIncrement = {0, 0, 0, 1, 1, 1, 1, 1};
    private static int[] jIncrement = {1, 1, 1, 0, 0, 0, 1, -1};
    
    private static Scanner scanner = new Scanner(System.in);
    
    
    /**
     * If The Turn to the Player
     */
    protected static void playerTurn(char[][] board, char playerLetter) {

        System.out.println("#===============Your Turn===============#");

        boolean validMove;
        do {
            System.out.print("Enter a number for an empty square:");
            int move = scanner.nextInt();
            if (move > 9 || move < 1 || board[(move - 1) / 3][(move - 1) % 3] != ' ')
            {
                validMove = false;
                System.out.println("Invalid Square!");
            } 
            else
            {
                board[(move - 1) / 3][(move - 1) % 3] = playerLetter;
                validMove = true;
            }

        } while (!validMove);

    }

    
    /**
     * Print Board to the Screen  
     * @param GameBoard
    */
    protected static void printBoard(char[][] board) {
        System.out.println("-------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "\t|\t");
            }
            System.out.println("\n-------------------------");
        }
        System.out.println();
    }
    
    

    /**
     * Here we represent the matrix of the Game as numbers from 0 to 8 (i * 3) +
     * j --> to calculate the number of the square that is available from his
     * indices that in row i and column j
     *
     * @param board the current state of the board.
     */
    protected static List<Integer> availableMoves(char[][] board) {
        List<Integer> availableSquares = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    availableSquares.add(i * 3 + j);
                }
            }
        }

        return availableSquares;
    }

    
    
    /**
     * Here we evaluate the number the possible opportunities for winning if in
     * a specific line , there are 2 squares with X and an empty square --> +10
     * if in a specific line , there is a square with X and 2 empty squares -->
     * +1
     *
     * if in a specific line , there are 2 squares with O and an empty square
     * --> -10 if in a specific line , there is a square with O and 2 empty
     * squares --> -1
     */
    protected static int evaluate(char[][] board, char player) {
        int value = 0;

        /**
         * For each line of the eight lines
         */
        for (int line = 0; line < iStart.length; line++) {

            int i = iStart[line];
            int j = jStart[line];


            /*
             * Number of squares in the line for each player
             */
            int playersSquare = 0;
            int opponentSquare = 0;

            int emptySquares = 0;

            int k = 0;
            do {
                char currentSquare = board[i][j];

                if (currentSquare != ' ') {
                    if (currentSquare == player) {
                        playersSquare++;
                    } else {
                        opponentSquare++;
                    }
                } else {
                    emptySquares++;
                }

                i += iIncrement[line];
                j += jIncrement[line];

                k++;
            } while (k < 3);

            if (playersSquare == 2 && emptySquares == 1) {
                value += 10;
            } else if (playersSquare == 1 && emptySquares == 2) {
                value += 1;
            }

            if (opponentSquare == 2 && emptySquares == 1) {
                value -= 10;
            } else if (opponentSquare == 1 && emptySquares == 2) {
                value -= 1;
            }
        }

        return value;
    }

    
    /**
     * To check if there's A Winner or not 
     * Either the player or the AI
    */
    protected static char getWinnerIfThere(char[][] board) {
        for (int line = 0; line < iStart.length; line++) {
            boolean xWin = true;
            boolean oWin = true;

            int i = iStart[line];
            int j = jStart[line];

            int k = 0;

            do {
                char currentSquare = board[i][j];

                if (currentSquare != 'X') {
                    xWin = false;
                }
                if (currentSquare != 'O') {
                    oWin = false;
                }

                i += iIncrement[line];
                j += jIncrement[line];

                k++;
            } while (k < 3);

            if (xWin) {
                return 'X';
            }
            if (oWin) {
                return 'O';
            }
        }

        return ' ';
    }

    
    /*
     * To Check if The Board's complete and The Game is finished
    */
    protected static boolean checkIfGameIsFinishedOrNot(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    protected static char[][] copyBoard(char[][] board) {
        char[][] copyBoard = new char[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(board[i], 0, copyBoard[i], 0, 3);
        }
        return copyBoard;
    }

}
