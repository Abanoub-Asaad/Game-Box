package Sokoban;

import GameLoop.GameBox_Core;
import java.io.BufferedWriter;
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

public class start_level {

    static GameBox_Core get_root = new GameBox_Core();
  
    static Pane pane_storeName = new Pane();
    static Line sep;
 
    static Scene scene_StoreName = new Scene(pane_storeName, 1370, 750);
    static TextField Enter_Name_Text;

    static Button btn_play;


    static FileWriter filewriter;
    static BufferedWriter bufferwriter;

    static String PlayerName_string;

    public static Scene store_name() throws IOException {

        scene_StoreName.getStylesheets().add(start_level.class.getResource("css1.css").toExternalForm());

        Enter_Name_Text = new TextField();
        btn_play = new Button();

        pane_storeName.setId("pane");
        Enter_Name_Text.setTranslateX(450);
        Enter_Name_Text.setTranslateY(350);
        Enter_Name_Text.setId("label");
        Enter_Name_Text.setPromptText("Enter your name");
        Enter_Name_Text.setFocusTraversable(false);
        addTextLimiter(Enter_Name_Text, 14);

        btn_play.setTranslateX(450);
        btn_play.setTranslateY(430);
        btn_play.setId("start");
        btn_play.setText("Play");

        sep = new Line(300, 300, 1000, 0);

        sep.setStroke(Color.LIMEGREEN);

        pane_storeName.getChildren().addAll(Enter_Name_Text, btn_play);

        GetName();
        
        //=============================// 

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

    public static void GetName() throws IOException {
        
        btn_play.setOnAction(e -> {

            PlayerName_string = Enter_Name_Text.getText();

            Time.seconds = 0;
            GameBox_Core.Root.setScene(Sokoban_Main.sokoban_scene);
            
        });

    }

}