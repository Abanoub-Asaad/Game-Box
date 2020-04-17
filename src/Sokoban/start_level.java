package Sokoban;

import GameLoop.GameBox_Core;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class start_level {

    public GameBox_Core get_root = new GameBox_Core();
    public Sokoban_Main s;
    public static Pane pane_storeName = new Pane();
    public static Line sep;

    public static Scene scene_StoreName = new Scene(pane_storeName, 1370, 750);
    static TextField textField;

    public static Button btn_start;

    static File file = new File("C:\\Game-Box\\src\\Resources\\Sokoban\\sokoban_player.txt");

    static FileWriter filewriter;
    static BufferedWriter bufferwriter;

    public static String PlayerName_string;

    public static Scene store_name() throws IOException {

        scene_StoreName.getStylesheets().add(start_level.class.getResource("css1.css").toExternalForm());

        textField = new TextField();
        btn_start = new Button();

        pane_storeName.setId("pane");
        textField.setTranslateX(450);
        textField.setTranslateY(350);
        textField.setId("label");
        textField.setPromptText("Enter your name");
        textField.setFocusTraversable(false);
        addTextLimiter(textField, 14);

        btn_start.setTranslateX(450);
        btn_start.setTranslateY(430);
        btn_start.setId("start");
        btn_start.setText("play");

        sep = new Line(300, 300, 1000, 0);

        sep.setStroke(Color.LIMEGREEN);

        pane_storeName.getChildren().addAll(textField, btn_start);

        GetName(null);
        //============================= 

        return scene_StoreName;
    }

    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }

    public static void GetName(Stage stage) throws IOException {
        
        btn_start.setOnAction(e -> {

            PlayerName_string = textField.getText();

            Time.seconds = 0;
            GameBox_Core.Root.setScene(Sokoban_Main.sokoban_scene);
            
        });

    }

    public String getPlayerName() {
        return PlayerName_string;
    }
}
