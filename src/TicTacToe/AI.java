
package TicTacToe;


public class AI extends XO_Controller{
    
    
    protected static int minMax(char[][] board, int depth, char player) {
        double bestMoveValue = Double.NEGATIVE_INFINITY;
        int bestMove = 0;

        for (int move : availableMoves(board)) {
            /*
             * Avoid modifying the board because it is needed for the other moves
             */
            char[][] copyBoard = copyBoard(board);
            copyBoard[move / 3][move % 3] = player;

            double moveValue = min(copyBoard, depth - 1, player);
            if (moveValue > bestMoveValue) {
                bestMoveValue = moveValue;
                bestMove = move;
            }

        }

        return bestMove;
    }

    protected static double min(char[][] board, int depth, char player) {

        char winner = getWinnerIfThere(board);
        if (winner != ' ') {
            if (winner == player) {
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

        char opponent = player == 'X' ? 'O' : 'X';

        double bestMoveValue = Double.POSITIVE_INFINITY;

        for (int move : availableMoves(board)) {
            char[][] copyBoard = copyBoard(board);
            copyBoard[move / 3][move % 3] = opponent;

            double moveValue = max(copyBoard, depth - 1, player);

            if (moveValue < bestMoveValue) {
                bestMoveValue = moveValue;
            }
        }

        return bestMoveValue;

    }

    protected static double max(char[][] board, int depth, char player) {
        char winner = getWinnerIfThere(board);
        if (winner != ' ') {
            if (winner == player) {
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
            char[][] copyBoard = copyBoard(board);
            copyBoard[move / 3][move % 3] = player;

            double moveValue = min(copyBoard, depth - 1, player);
            if (moveValue > bestMoveValue) {
                bestMoveValue = moveValue;
            }

        }

        return bestMoveValue;
    }
    
}
