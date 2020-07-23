
package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Eng.Waleed
 */
public class player1_2 {

    public static Scene scene;

    private static boolean playable = true;
    private static boolean turnX = true;
    private static Tile[][] board = new Tile[3][3];
    private static List<Combo> combos = new ArrayList<>();
    public static Group root = new Group();
    static Bloom bloom = new Bloom();

    private Parent createContent() {
        Image background = new Image("Resources/XO/6.jpg", 1400, 800, false, false);
        ImageView IV = new ImageView(background);
        root.getChildren().add(IV);
        setInformationOfPlayers();
        int xAxis = 250, yAxis = 170;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                Tile tile = new Tile();
                tile.setLayoutY(yAxis);
                tile.setTranslateX(j * 150);
                tile.setTranslateY(i * 150);
                tile.setLayoutX(xAxis);

                root.getChildren().add(tile);

                board[j][i] = tile;
            }
        }

        // horizontal
        for (int y = 0; y < 3; y++) {
            combos.add(new Combo(board[0][y], board[1][y], board[2][y]));
        }

        // vertical
        for (int x = 0; x < 3; x++) {
            combos.add(new Combo(board[x][0], board[x][1], board[x][2]));
        }

        // diagonals
        combos.add(new Combo(board[0][0], board[1][1], board[2][2]));
        combos.add(new Combo(board[2][0], board[1][1], board[0][2]));

        return root;
    }

    public Scene start() {

        scene = new Scene(createContent(), 1370, 750);
        return scene;

    }

    private void checkState() {
        for (Combo combo : combos) {

            if (combo.isComplete()) {
                playable = false;
                playWinAnimation(combo);
                return;

            }
        }
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(board[j][i].text.getText().equals("X")) && !(board[j][i].text.getText().equals("O"))) {
                    full = false;
                    break;
                }
            }
        }
        if (full) {
            new Alert(Alert.AlertType.INFORMATION, " Draw!").showAndWait();
            playable = false;
            sound.mediaPlayer_back.stop();
        }
    }

    private void playWinAnimation(Combo combo) {
        Line line = new Line();
        line.setStartX(combo.tiles[0].getCenterX());
        line.setStartY(combo.tiles[0].getCenterY());
        line.setEndX(combo.tiles[0].getCenterX());
        line.setEndY(combo.tiles[0].getCenterY());
        root.getChildren().add(line);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                new KeyValue(line.endXProperty(), combo.tiles[2].getCenterX()),
                new KeyValue(line.endYProperty(), combo.tiles[2].getCenterY())));
        timeline.play();
        String str;
        if ("X".equals(combo.tiles[2].getValue())) {
            str = "Player 1";
        } else {
            str = "Player 2";
        }
        new Alert(Alert.AlertType.INFORMATION, str + " Won the game!").showAndWait();
        sound.mediaPlayer_back.stop();
    }

    private class Combo {

        private Tile[] tiles;

        public Combo(Tile... tiles) {
            this.tiles = tiles;
        }

        public boolean isComplete() {
            if (tiles[0].getValue().isEmpty()) {
                return false;
            }

            return tiles[0].getValue().equals(tiles[1].getValue())
                    && tiles[0].getValue().equals(tiles[2].getValue());
        }
    }

    private class Tile extends StackPane {

        final private Text text = new Text();

        public Tile() {
            Rectangle border = new Rectangle(150, 150);
            border.setFill(Color.ALICEBLUE);
            border.setStroke(Color.FUCHSIA);
            text.setFont(Font.font(70));
            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);
            setOnMouseClicked(event -> {
                if (playable) {
                    if (event.getButton() == MouseButton.PRIMARY && turnX) {
                        drawX();
                        turnX = false;
                        checkState();
                    } else if (event.getButton() == MouseButton.PRIMARY && !turnX) {
                        drawO();
                        turnX = true;
                        checkState();
                    }
                } else {
                    return;
                }
            });
        }

        public double getCenterX() {
            return getTranslateX() + 250 + 75;
        }

        public double getCenterY() {
            return getTranslateY() + 170 + 85;
        }

        public String getValue() {
            return text.getText();
        }

        private void drawX() {
            text.setText("X");
            text.setFill(Color.BLUE);
            text.setFont((Font.font("Copperplate Gothic Bold", FontWeight.BOLD, FontPosture.REGULAR, 100)));
            text.setEffect(bloom);
        }

        private void drawO() {
            text.setText("O");
            text.setFill(Color.CHOCOLATE);
            text.setFont((Font.font("Copperplate Gothic Bold", FontWeight.BOLD, FontPosture.REGULAR, 100)));
            text.setEffect(bloom);

        }
    }

    public static void setInformationOfPlayers() {
        Text Player1 = new Text();
        Text Player2 = new Text();

        Player1.setText(" Player 1 : X");
        Player1.setX(800);
        Player1.setY(200);
        Player1.setFill(Color.BLUE);
        Player1.setFont((Font.font("Copperplate Gothic Bold", FontWeight.BOLD, FontPosture.REGULAR, 50)));
        Player1.setEffect(bloom);
        Player1.toFront();

        Player2.setText(" Player 2 : O");
        Player2.setX(800);
        Player2.setY(250);
        Player2.setFill(Color.CHOCOLATE);
        Player2.setFont((Font.font("Copperplate Gothic Bold", FontWeight.BOLD, FontPosture.REGULAR, 50)));
        Player2.setEffect(bloom);
        Player2.toFront();
        root.getChildren().addAll(Player1, Player2);

    }

}
