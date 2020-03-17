
package Tetris;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class board {
    
     public  GridPane root;
     // public static  VBox vbox = new VBox();
   public    static  Rectangle  [][] grids = new Rectangle [20][15];
   public    static  GridPane grid = new GridPane();
   
   public  static   Rectangle[][] draw_back_ground(){
     for(int row = 0; row < 20 ; row++){
      for(int column = 0; column <15; column ++){
        Rectangle b = new Rectangle(50,50);
            b.setFill(Color.BLACK);
            b.setStroke(Color.WHITESMOKE);
            grids[row][column] = b;
            grid.add(grids[row][column] , row , column);
            grid.setGridLinesVisible(true);
      }
    }
        
          return  grids  ;
     }
             
         
}
