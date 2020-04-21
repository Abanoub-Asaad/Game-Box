package Arkanoid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PlayerNameFile {

    Scene scene_StoreName;
    Pane pane_storeName;

    TextField entername_TF = new TextField();
    Button start = new Button();
    Line sep;

    private static File file = new File("C:\\Game-Box\\src\\Resources\\Arkanoid\\player.txt");
    FileWriter filewriter;
    BufferedWriter bufferwriter;

    private static String PlayerName_string;


    // A Function To make The Scene Of Writing Player Name 
    public Scene MakeScene_PlayerName(Stage Arkanoid_main_stage) throws IOException {
        pane_storeName = new Pane();
        scene_StoreName = new Scene(pane_storeName, 1370, 750);
//         BaseClsas.check_Escape(scene_StoreName, Menu.stage_menu,Menu.sceneButtons );
        //============Background
        Image playerName_img = new Image("Resources/Arkanoid/background3.jpg", 1400, 780, false, true);
        ImageView playerName_iv = new ImageView(playerName_img);
        pane_storeName.getChildren().add(playerName_iv);
        //=========================

        entername_TF.setTranslateX(470);
        entername_TF.setTranslateY(350);
        entername_TF.setPrefSize(410, 50);
        entername_TF.setFont(Font.font("CoubraFont", FontWeight.BOLD, 35));
        entername_TF.setPromptText("Enter Your Name");
        entername_TF.setFocusTraversable(false);
        addTextLimiter(entername_TF, 14);

        start.setTranslateX(470);
        start.setTranslateY(430);
        start.setPrefSize(410, 35);
        start.setFont(new Font("Arial", 30));
        start.setTextFill(Color.BLACK);
        start.setText("START");
        start.setStyle("-fx-border-color:#5f27cd; -fx-background-color: #663333 ");
        start.setCursor(new ImageCursor(Menu.cursor_img_hand));

        sep = new Line(300, 300, 1000, 0);

        sep.setStroke(Color.LIMEGREEN);

        //=============================
        filewriter = new FileWriter(file, true);
        bufferwriter = new BufferedWriter(filewriter);

        start.setOnAction(e -> {
            try {
                PlayerName_string = entername_TF.getText();

                if (PlayerName_string.length() > 0 && !PlayerName_string.contains(" ")) //Validation
                {
                    bufferwriter.write(entername_TF.getText() + "\n");
                    bufferwriter.close();
                    ArkanoidMain.getInstanceFromArkanoid().openArkanoidMain(Arkanoid_main_stage);

                    Sound.mediaPlayer_background.play();
                }
            } catch (IOException ex) {
                System.out.println("NOT Success");
            }

        });
        pane_storeName.getChildren().addAll(entername_TF, start);

        //=============================
        pane_storeName.setCursor(new ImageCursor(Menu.cursor_img));
        Arkanoid_main_stage.setScene(scene_StoreName);
        Arkanoid_main_stage.setMaximized(true);
        Arkanoid_main_stage.setResizable(false);

        return scene_StoreName;
    }

    public String getPlayerName() {
        return PlayerName_string;
    }

    //A function to Determine The Limit of The TextField
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

    public static File getFile() {
        return file;
    }

}
