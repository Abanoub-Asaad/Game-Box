package Tetris;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import static Tetris.Controller.SIZE;
import static Tetris.Controller.XMAX;

public class Shape2 extends Shape {

    @Override
    protected  void Basic(Rectangle[] rectangles, Pane group) {
     
        for (int i = 0; i < 4; i++) {
            rectangles[i] = new Rectangle();
            rectangles[i].setHeight(49);
            rectangles[i].setWidth(49);
        }
        
        setShape(rectangles[0], rectangles[1], rectangles[2], rectangles[3]);
        rectangles[0].setX(rectangles[0].getX()+700);
        rectangles[1].setX(rectangles[1].getX()+700);
        rectangles[2].setX(rectangles[2].getX()+700);
        rectangles[3].setX(rectangles[3].getX()+700);
        
        rectangles[0].setY(rectangles[0].getY()+145);
        rectangles[1].setY(rectangles[1].getY()+145);
        rectangles[2].setY(rectangles[2].getY()+145);
        rectangles[3].setY(rectangles[3].getY()+145);
        
        for (int i = 0; i < 4; i++) {
            rectangles[i].setFill(Color.DEEPPINK);
            group.getChildren().add(rectangles[i]);
        }
    }
    
    @Override
    protected void setShape(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {

        a.setX(XMAX / 2 - SIZE);
        b.setX(XMAX / 2);
        c.setX(XMAX / 2 - SIZE);
        c.setY(SIZE);
        d.setX(XMAX / 2);
        d.setY(SIZE);

    }
@Override
     protected Rectangle[] getShape() {
        
         return Next;

    }

    @Override
    protected void MoveTurn(Form form, int num_turn, Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
