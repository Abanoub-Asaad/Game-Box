/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import GameLoop.GameBox_Core;
import GameLoop.Games;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.stream.Stream;

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.effect.Glow; 
/**
 *
 * @author Eng.Waleed
 */
public class Tic_Menu {
  

    final Color[] fill = new Color[11];
   
    double width, height;
    Circle[] circles = new Circle[0];
    double[][] moveBy = new double[0][2];
    double[] radiusDivs = new double[0];
// to get the scene of player vs player
    static  player1_2 p= new player1_2();
    
    
    private static Button player_vs_pc_btn = new Button("Player Vs PC");
    private static Button p_vs_p_btn = new Button("Player Vs Player");
    private static Button exit_btn = new Button(" EXIT ");
        private static Button BACK_btn = new Button(" BACK ");
//boolean flag = false;
     private static Pane menu_pane = new Pane();
    private static VBox text_pane = new VBox(22);
    
    static    Timeline timeline;
    static   Scene menu_scene = new Scene(menu_pane, 1375, 750);
   public static Scene design() throws Exception{
                        GameBox_Core.Root.setScene(menu_scene);

        menu_scene.getStylesheets().add(Tic_Menu.class.getResource("css2.css").toExternalForm());
        
        player_vs_pc_btn.setId("menubutton");
        exit_btn.setId("menubutton");
        p_vs_p_btn.setId("menubutton");
BACK_btn.setId("menubutton");
        player_vs_pc_btn.setLayoutX(100);
        player_vs_pc_btn.setLayoutY(100);
        
        p_vs_p_btn.setLayoutX(100);
        p_vs_p_btn.setLayoutY(150);

        exit_btn.setLayoutX(100);
        exit_btn.setLayoutY(250);
        
        BACK_btn.setLayoutX(100);
        BACK_btn.setLayoutY(200);

        player_vs_pc_btn.setOnAction(e -> {
            sound.mediaPlayer_back.play();
               XO_Main.getInstanceFromXO().openTicTacToeMain(GameBox_Core.Root);
               
                GameBox_Core.Root.setScene(XO_Main.XO_scene);
         });
         BACK_btn.setOnAction(e -> {
            sound.mediaPlayer_back.stop();
               
                GameBox_Core.Root.setScene(Games.gamesScene);
         });
         
       p_vs_p_btn.setOnAction(e -> {
           sound.mediaPlayer_back.play();
                GameBox_Core.Root.setScene(p.start());
                 
         });
        
         exit_btn.setOnAction(e -> {
                  GameBox_Core.Root.close();
                    sound.mediaPlayer_back.stop();
         });
        
          player_vs_pc_btn.setOnMouseEntered(event -> {
              // 
            setborder(player_vs_pc_btn);
        });
        
          exit_btn.setOnMouseEntered(event -> {
              // 
            setborder(exit_btn);
        });
        
          p_vs_p_btn.setOnMouseEntered(event -> {
              // 
            setborder(p_vs_p_btn);
        });
        
            BACK_btn.setOnMouseEntered(event -> {
              // 
            setborder(BACK_btn);
        });
        player_vs_pc_btn.setOnMouseExited(event -> {
             timeline.stop();
        });
          
       
           p_vs_p_btn.setOnMouseExited(event -> {
             timeline.stop();
        });
          exit_btn.setOnMouseExited(event -> {
             timeline.stop();
        });
             BACK_btn.setOnMouseExited(event -> {
             timeline.stop();
        });
        text_pane.setLayoutX(540);
        text_pane.setLayoutY(220);
        text_pane.setPrefSize(280, 400);
        text_pane.getChildren().addAll(player_vs_pc_btn, p_vs_p_btn, exit_btn,BACK_btn);
        
       
        return menu_scene;
         
     }
   
    private  static void setborder(Button btn) {

        Color[] colors = Stream.of("#3b064d", "#8105d8", "deeppink", "blueviolet", "steelblue", "#ed0cef","#fe59d7")
                .map(Color::web)
                .toArray(Color[]::new);
        
        List<Border> list = new ArrayList<>();
        
        int mills[] = {-50};
        KeyFrame keyFrames[]  = Stream.iterate(0, i -> i+1)
                .limit(100)
                .map(i -> new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop[]{new Stop(0, colors[i%colors.length]), new Stop(1, colors[(i+1)%colors.length])}))
                .map(lg -> new Border(new BorderStroke(lg, BorderStrokeStyle.SOLID, new CornerRadii(30), new BorderWidths(5))))
                .map(b -> new KeyFrame(Duration.millis(mills[0]+=300), new KeyValue(btn.borderProperty(), b, Interpolator.EASE_IN)))
                .toArray(KeyFrame[]::new);
        
        timeline = new Timeline(keyFrames);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    public static int randInt(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}
   public  Scene start() throws Exception {
        Tic_Menu.design();
        Random random = new Random();
     
        menu_pane.setStyle("-fx-background-color:derive(black, 10%);");
        fill[0]=Color.web("#3b064d",1);
        fill[1]=Color.web("#8105d8",1);
        fill[2]=Color.web("pink",1);
        fill[3]=Color.web( "blueviolet",1);
        fill[4]=Color.web("steelblue",1);
        fill[5]=Color.web( "#fe59d7",1);
        fill[6]=Color.web( "#ed0cef",1);
        fill[7]=Color.web( "#d0bdf4",1);
        fill[8]=Color.web( "#f95d9b",1);
        fill[9]=Color.web( "#d9d9d9",1);
        fill[10]=Color.web( "#ffde22",1);
        DoubleSupplier randomFraction = () -> (random.nextBoolean() ? 1 : -1) * random.nextDouble();

        InvalidationListener resizeListener = e -> {
            double oldW = width;
            double oldH = height;

            width = 1370;
            height = 750;

            double min = Math.min(width-850, height-450);
            double max = Math.max(width-930, height-500);
            int size =70 ;
          //  (int) Math.sqrt(max)
            int sizePrev =  circles.length;
            circles = sizePrev == size ? circles : Arrays.copyOf(circles, size);
            radiusDivs = sizePrev == size ? radiusDivs : Arrays.copyOf(radiusDivs, size);
            moveBy = sizePrev == size ? moveBy : Arrays.copyOf(moveBy, size);

            if (sizePrev < size) {
                for (int i = sizePrev; i < size; i++) {
                    
                    Color c1 = fill[randInt(0, fill.length-1)]; 
                    Circle c = circles[i] = new Circle(10,c1);
                    c.getStyleClass().add("circles");
                  
                    double r = radiusDivs[i] = 0.5 + random.nextDouble();
                    c.setRadius((min / 10) * radiusDivs[i]);
                    c.setCenterX(r + random.nextInt((int) (width - r)));
                    c.setCenterY(r + random.nextInt((int) (height - r)));

                    moveBy[i] = new double[] { randomFraction.getAsDouble(), randomFraction.getAsDouble() };
                }
            }
            int limit = sizePrev > size ? size : sizePrev;
            for (int i = 0; i < limit; i++) {
                Circle c = circles[i];

                c.setRadius((min / 10) * radiusDivs[i]);
                c.setCenterX(width * (c.getCenterX() / oldW));
                c.setCenterY(height * (c.getCenterY() / oldH));
            }
            menu_pane.getChildren().setAll(circles);
            menu_pane.getChildren().addAll(text_pane);
        };

        menu_scene.widthProperty().addListener(resizeListener);
        menu_scene.heightProperty().addListener(resizeListener);
        resizeListener.invalidated(null);

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                for (int i = 0; i < circles.length; i++) {
                    Circle c = circles[i];
                    double x = c.getCenterX();
                    double y = c.getCenterY();
                    double r = c.getRadius();

                    if (x - r < 0)
                        moveBy[i][0] = random.nextDouble();
                    else if (x + r > width)
                        moveBy[i][0] = -1 * random.nextDouble();
                    if (y - r < 0)
                        moveBy[i][1] = random.nextDouble();
                    else if (y + r > height)
                        moveBy[i][1] = -1 * random.nextDouble();

                    c.setCenterX(x + moveBy[i][0]);
                    c.setCenterY(y + moveBy[i][1]);
                }
            }
        }.start();
        
          
        return menu_scene;
    }
}

