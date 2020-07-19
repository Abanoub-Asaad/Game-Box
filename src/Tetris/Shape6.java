package Tetris;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import static Tetris.Controller.MoveLeft;
import static Tetris.Controller.MoveRight;
import static Tetris.Controller.SIZE;
import static Tetris.Controller.XMAX;

public class Shape6 extends Shape {

    @Override
    protected  void Basic(Rectangle[] rectangles, Pane group) {
     
        for (int i = 0; i < 4; i++) {
            rectangles[i] = new Rectangle();
            rectangles[i].setHeight(49);
            rectangles[i].setWidth(49);
        }
        
        setShape(rectangles[0], rectangles[1], rectangles[2], rectangles[3]);
        rectangles[0].setX(rectangles[0].getX()+670);
        rectangles[1].setX(rectangles[1].getX()+670);
        rectangles[2].setX(rectangles[2].getX()+670);
        rectangles[3].setX(rectangles[3].getX()+670);
        
        rectangles[0].setY(rectangles[0].getY()+150);
        rectangles[1].setY(rectangles[1].getY()+150);
        rectangles[2].setY(rectangles[2].getY()+150);
        rectangles[3].setY(rectangles[3].getY()+150);
        
        for (int i = 0; i < 4; i++) {
            rectangles[i].setFill(Color.LIME);
            group.getChildren().add(rectangles[i]);
        }
    }
    
    @Override
    protected void setShape(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        a.setX(XMAX / 2 - SIZE);
        b.setX(XMAX / 2);
        c.setX(XMAX / 2);
        c.setY(SIZE);
        d.setX(XMAX / 2 + SIZE);

    }

    @Override
     protected Rectangle[] getShape() {
        
         return Next;

    }

    @Override
    protected void MoveTurn(Form form, int num_turn, Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
    
        if (num_turn == 1 && checkRectangle(a, 1, 1) && checkRectangle(d, -1, -1) && checkRectangle(c, -1, 1)) {
                    MoveUp(form.a);
                    MoveRight(form.a);
                    MoveDown(form.d);
                    MoveLeft(form.d);
                    MoveLeft(form.c);
                    MoveUp(form.c);
                    form.changeForm();
                    
                }
                if (num_turn == 2 && checkRectangle(a, 1, -1) && checkRectangle(d, -1, 1) && checkRectangle(c, 1, 1)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveLeft(form.d);
                    MoveUp(form.d);
                    MoveUp(form.c);
                    MoveRight(form.c);
                    form.changeForm();
                     
                }
                if (num_turn == 3 && checkRectangle(a, -1, -1) && checkRectangle(d, 1, 1) && checkRectangle(c, 1, -1)) {
                    MoveDown(form.a);
                    MoveLeft(form.a);
                    MoveUp(form.d);
                    MoveRight(form.d);
                    MoveRight(form.c);
                    MoveDown(form.c);
                    form.changeForm();
                     
                }
                if (num_turn == 4 && checkRectangle(a, -1, 1) && checkRectangle(d, 1, -1) && checkRectangle(c, -1, -1)) {
                    MoveLeft(form.a);
                    MoveUp(form.a);
                    MoveRight(form.d);
                    MoveDown(form.d);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    form.changeForm();
                     
                }
    }

}
