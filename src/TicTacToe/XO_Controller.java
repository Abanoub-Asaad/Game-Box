package TicTacToe;

import static TicTacToe.XO_Main.XO_group;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class XO_Controller {

    /**
     * iStart is the x dimension of the first square jStart is the y dimension
     * of the first square iIncrement is the increment value that on x axis
     * jIncrement is the increment value that on y axis
     */
    private static int[] iStart = {0, 1, 2, 0, 0, 0, 0, 0};
    private static int[] jStart = {0, 0, 0, 0, 1, 2, 0, 2};
    private static int[] iIncrement = {0, 0, 0, 1, 1, 1, 1, 1};
    private static int[] jIncrement = {1, 1, 1, 0, 0, 0, 1, -1};

    static boolean IsPlayerPlay = false;
    Core coreObj;
    private static String winner = " ";
    static Text win = new Text();

    /**
     * Design for "Your Turn" text
     *
     * @param group
     */
    protected static void SetYourTurn(Group group) {
        Text YourTurn = new Text();
        YourTurn.setText(" Your Turn ");
        YourTurn.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80)));
        YourTurn.setFill(Color.GOLD);
        YourTurn.setX(750);
        YourTurn.setY(350);
        group.getChildren().add(YourTurn);

        FadeTransition textFade = new FadeTransition(Duration.seconds(3));
        textFade.setNode(YourTurn);
        textFade.setFromValue(1);
        textFade.setToValue(0);
        textFade.setCycleCount(1);
        textFade.play();
    }

    protected static void SetPlayerSympol(Group group, Text playerText, String playerChar, double x, double y) {
        Bloom bloom = new Bloom();
        playerText = new Text();

        playerText.setText(playerChar);
        playerText.setX(x);
        playerText.setY(y);
        playerText.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80)));
        playerText.setFill(Color.BLUE);
        playerText.setEffect(bloom);

        group.getChildren().add(playerText);
    }

    protected static void HandleClickOnRectangles(Rectangle[][] rectangles, String[][] sym, Text playerText, String playerChar, int DEPTH, Scene XOScene, Group group) {

        XOScene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (!checkIfGameIsFinishedOrNot(sym) && winner.equals(" ")) {
                    winner = XO_Controller.getWinnerIfThere(sym);
                    Label:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (rectangles[i][j].getBoundsInParent().intersects(e.getX(), e.getY(), 0, 0)) {
                                if (sym[i][j].equals(" ")) {
                                    SetPlayerSympol(group, playerText, playerChar, rectangles[i][j].getX() + 50, rectangles[i][j].getY() + 100);
                                    sym[i][j] = playerChar;
                                    System.out.println(" player = " + i + j);
                                    IsPlayerPlay = true;

                                    if (IsPlayerPlay) {
                                        if (winner.equals(" ") && !checkIfGameIsFinishedOrNot(sym)) {
                                            Core.computerTurn(rectangles, sym, DEPTH, XO_group);
                                            SetYourTurn(group);

                                        } else {
                                            break Label;
                                        }
                                    }
                                }
                            }
                        }

                    }

                    Core.playerTurn = !Core.playerTurn;
                    winner = XO_Controller.getWinnerIfThere(sym);
                } else {
                    if (winner.equals(" ") && checkIfGameIsFinishedOrNot(sym)) {
                        win.setText(" Draw ");
                        win.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80)));
                        win.setFill(Color.GOLD);
                        win.setX(800);
                        win.setY(500);
                        group.getChildren().add(win);
                        sound.mediaPlayer_back.stop();
                    } else {
                        if (winner.equals("X")) {
                            win.setText(" X Wins ");
                            win.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80)));
                            win.setFill(Color.GOLD);
                            win.setX(800);
                            win.setY(500);
                            group.getChildren().add(win);
                            sound.mediaPlayer_back.stop();
                        } else {
                            win.setText(" O Wins ");
                            win.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80)));
                            win.setFill(Color.GOLD);
                            win.setX(800);
                            win.setY(500);
                            group.getChildren().add(win);
                            sound.mediaPlayer_back.stop();
                        }
                    }
                }
            }
        });

    }

    protected static void playerTurn(Rectangle[][] board, Text playerText, String[][] symbol, String playerChar, int DEPTH, Scene scene, Group group) {
        SetYourTurn(group);
        HandleClickOnRectangles(board, symbol, playerText, playerChar, DEPTH, scene, group);

    }

    /**
     * Here we represent the matrix of the Game as numbers from 0 to 8 (i * 3) +
     * j --> to calculate the number of the square that is available from his
     * indices that in row i and column j
     *
     * @param board the current state of the board.
     */
    protected static List<Integer> availableMoves(String[][] sym) {
        List<Integer> availableSquares = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sym[i][j].equals(" ")) {
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
    protected static int evaluate(String[][] sym, String player) {
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
                String currentSquare = sym[i][j];

                if (!currentSquare.equals(" ")) {
                    if (currentSquare.equals(player)) {
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
     * To check if there's A Winner or not Either the player or the AI
     */
    protected static String getWinnerIfThere(String[][] sym) {
        for (int line = 0; line < iStart.length; line++) {
            boolean xWin = true;
            boolean oWin = true;

            int i = iStart[line];
            int j = jStart[line];

            int k = 0;

            do {
                String currentSquare = sym[i][j];

                if (!currentSquare.equals("X")) {
                    xWin = false;
                }
                if (!currentSquare.equals("O")) {
                    oWin = false;
                }

                i += iIncrement[line];
                j += jIncrement[line];

                k++;
            } while (k < 3);

            if (xWin) {
                return "X";
            }
            if (oWin) {
                return "O";
            }
        }

        return " ";
    }


    /*
     * To Check if The Board's complete and The Game is finished
     */
    protected static boolean checkIfGameIsFinishedOrNot(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }

        return true;
    }

    protected static String[][] copyBoard(String[][] board) {
        String[][] copyBoard = new String[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(board[i], 0, copyBoard[i], 0, 3);
        }
        return copyBoard;
    }

}
