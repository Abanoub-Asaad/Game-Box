package Tetris;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import static Tetris.Controller.SIZE;
import static Tetris.Controller.XMAX;

public class Shape3 extends Shape {

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
            rectangles[i].setFill(Color.MEDIUMORCHID);
            group.getChildren().add(rectangles[i]);
        }
    }
    
    @Override
    protected void setShape(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        a.setX(XMAX / 2 + SIZE);
        b.setX(XMAX / 2 - SIZE);
        b.setY(SIZE);
        c.setX(XMAX / 2);
        c.setY(SIZE);
        d.setX(XMAX / 2 + SIZE);
        d.setY(SIZE);

    }

    @Override
     protected Rectangle[] getShape() {
        
         return Next;

    }

    @Override
    protected void MoveTurn(Form form, int num_turn, Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        
        if (num_turn == 1 && checkRectangle(a, 1, -1) && checkRectangle(c, 1, 1) && checkRectangle(b, 2, 2)) {
                    MoveRight(form.a);
                    MoveDown(form.a);
                    MoveUp(form.c);
                    MoveRight(form.c);
                    MoveUp(form.b);
                    MoveUp(form.b);
                    MoveRight(form.b);
                    MoveRight(form.b);
                    form.changeForm();
                    
                }
                if (num_turn == 2 && checkRectangle(a, -1, -1) && checkRectangle(b, 2, -2) && checkRectangle(c, 1, -1)) {
                    MoveDown(form.a);
                    MoveLeft(form.a);
                    MoveRight(form.b);
                    MoveRight(form.b);
                    MoveDown(form.b);
                    MoveDown(form.b);
                    MoveRight(form.c);
                    MoveDown(form.c);
                    form.changeForm();
                    
                }
                if (num_turn == 3 && checkRectangle(a, -1, 1) && checkRectangle(c, -1, -1) && checkRectangle(b, -2, -2)) {
                    MoveLeft(form.a);
                    MoveUp(form.a);
                    MoveDown(form.c);
                    MoveLeft(form.c);
                    MoveDown(form.b);
                    MoveDown(form.b);
                    MoveLeft(form.b);
                    MoveLeft(form.b);
                    form.changeForm();
                    
                }
                if (num_turn == 4 && checkRectangle(a, 1, 1) && checkRectangle(b, -2, 2) && checkRectangle(c, -1, 1)) {
                    MoveUp(form.a);
                    MoveRight(form.a);
                    MoveLeft(form.b);
                    MoveLeft(form.b);
                    MoveUp(form.b);
                    MoveUp(form.b);
                    MoveLeft(form.c);
                    MoveUp(form.c);
                    form.changeForm();
                    
                }
    
    }

}
