
package TicTacToe;

import static TicTacToe.XO_Controller.availableMoves;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class AI extends XO_Controller{
    
    
    protected static int minMax(String[][]sym, int depth, String player ) {
        double bestMoveValue = Double.NEGATIVE_INFINITY;
        int bestMove = 0;

        for (int move : availableMoves(sym)) {
            /*
             * Avoid modifying the board because it is needed for the other moves
             */
            String[][] copyBoard = copyBoard(sym);
            copyBoard[move / 3][move % 3] = player;

            double moveValue = min(copyBoard, depth - 1, player);
            if (moveValue > bestMoveValue) {
                bestMoveValue = moveValue;
                bestMove = move;
            }

        }

        return bestMove;
    }

    protected static double min(String[][] board, int depth, String player) {

        String winner = getWinnerIfThere(board);
        if (!winner.equals(" ")) {
            if (winner .equals(player)) {
                return Double.POSITIVE_INFINITY;
            } else {
                return Double.NEGATIVE_INFINITY;
            }
        }

        if (checkIfGameIsFinishedOrNot(board))
            return 0;

        if (depth == 0) {
            return evaluate(board, player);
        }

        String opponent = player.equals("X") ? "O" : "X";

        double bestMoveValue = Double.POSITIVE_INFINITY;

        for (int move : availableMoves(board)) {
            String[][] copyBoard = copyBoard(board);
            copyBoard[move / 3][move % 3] = opponent;

            double moveValue = max(copyBoard, depth - 1, player);

            if (moveValue < bestMoveValue) {
                bestMoveValue = moveValue;
            }
        }

        return bestMoveValue;

    }

    protected static double max(String[][] board, int depth,String player) {
       String winner = getWinnerIfThere(board);
        if (!winner .equals(" ")) {
            if (winner.equals(player)) {
                return Double.POSITIVE_INFINITY;
            } else {
                return Double.NEGATIVE_INFINITY;
            }
        }

        if (checkIfGameIsFinishedOrNot(board))
            return 0;
        if (depth == 0) {
            return evaluate(board, player);
        }


        double bestMoveValue = Double.NEGATIVE_INFINITY;

        for (int move : availableMoves(board)) {
            String[][] copyBoard = copyBoard(board);
            copyBoard[move / 3][move % 3] = player;

            double moveValue = min(copyBoard, depth - 1, player);
            if (moveValue > bestMoveValue) {
                bestMoveValue = moveValue;
            }

        }

        return bestMoveValue;
    }
    
}