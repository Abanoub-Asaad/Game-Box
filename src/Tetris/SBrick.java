
package Tetris;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class SBrick extends Shapes{

   
    public void Basic(Rectangle[] rect, float x, float y, Group root) {
        rect[0] = new Rectangle(x, y, width-1, height);
        rect[1] = new Rectangle(x + width , y, width-1, height);
        rect[2] = new Rectangle(x, y + height , width-1, height);
        rect[3] = new Rectangle(x - width , y + height, width-1, height);
        for (int i = 0; i < 4; i++) {
            rect[i].setFill(Color.BLUE);
            root.getChildren().addAll(rect[i]);
        }
      //  shapeObj.tranformation(rect, 550, 550,500,500);

    }

    public void turn90(Rectangle[] rect, float x, float y, Group root) {
        rect[0] = new Rectangle(x, y, width-1, height);
        rect[1] = new Rectangle(x + width, y, width-1, height);
        rect[2] = new Rectangle(x, y - height, width-1, height);
        rect[3] = new Rectangle(x + width, y + height, width-1, height);
        for (int i = 0; i < 4; i++) {
            rect[i].setFill(Color.CRIMSON);
            root.getChildren().addAll(rect[i]);
        }
       // shapeObj.tranformation(rect, 500, 500, 550, 450);
    }
      public void turn180(Rectangle[] rect, float x, float y, Group root) {
          Basic(rect, width, width, root);
      }
         public void turn270(Rectangle[] rect, float x, float y, Group root) {
          turn90(rect, width, width, root);
      }
            public void turn360(Rectangle[] rect, float x, float y, Group root) {
          Basic(rect, width, width, root);
      }
}
