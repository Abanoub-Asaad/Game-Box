package Tetris;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DrawSquareShape 
{ 
   float width, height;
    Shapes shapeObj ;

    public DrawSquareShape() {
        width = 50f;
        height = 50f;
        shapeObj = new Shapes();
    }
 
    public void Basic(Rectangle[] rectangles, float x, float y, Group group ) {
         rectangles[0] = new Rectangle(x, y, width, height);
          rectangles[1] = new Rectangle(x+width+1, y, width, height);
          rectangles[2] = new Rectangle(x, y+=height+1, width, height);
          rectangles[3] = new Rectangle(x+width+1, y, width, height);
           for (int i = 0; i < 4; i++) {
                rectangles[i].setFill(Color.FUCHSIA);
            group.getChildren().add(rectangles[i]);
        }
         shapeObj.tranformation(rectangles, 550, 550, 500, 500);
         
         
    }
    public void turn90(Rectangle[] rectangles, float x, float y, Group group ) {
        Basic(rectangles, x, y, group);
    }
      
     public void turn180(Rectangle[] rectangles, float x, float y, Group group) {
         Basic(rectangles, x, y, group);
     }
        public void turn270(Rectangle[] rectangles, float x, float y, Group group) {
            Basic(rectangles, x, y, group);
     }
           public void turn360(Rectangle[] rectangles, float x, float y, Group group) {
               Basic(rectangles, x, y, group);
     }
}
