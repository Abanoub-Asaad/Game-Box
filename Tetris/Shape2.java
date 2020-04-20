package Tetris;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Shape2 extends Shapes
{ 
   
 
    public void Basic(Rectangle[] rectangles, float x, float y, Group group) {
        rectangles[0] = new Rectangle(x, y, width, height);
        rectangles[1] = new Rectangle(x + width + 1, y, width, height);
        rectangles[2] = new Rectangle(x, y += height + 1, width, height);
        rectangles[3] = new Rectangle(x + width + 1, y, width, height);
        
        for (int i = 0; i < 4; i++) {
            rectangles[i].setFill(Color.DEEPPINK);
            group.getChildren().add(rectangles[i]);
        }
       // shapeObj.tranformation(rectangles, 550, 550, 500, 500);

    }
   
}
