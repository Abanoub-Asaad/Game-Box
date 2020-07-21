package Tetris;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import static Tetris.Tetris_Main.MESH;
import static Tetris.Tetris_Main.MOVE;
import static Tetris.Tetris_Main.SIZE;
import static Tetris.Tetris_Main.XMAX;
import static Tetris.Tetris_Main.YMAX;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;

public abstract class Shape {

    Rectangle []Next = new Rectangle [4];
    public static Lighting lighting = new Lighting(new Light.Distant(225, 55, Color.WHITE));
    
    protected abstract void setShape(Rectangle a, Rectangle b, Rectangle c, Rectangle d);
    protected abstract Rectangle[] getShape() ;
    protected abstract  void MoveTurn(Form form, int num_turn, Rectangle a, Rectangle b, Rectangle c, Rectangle d);
    protected abstract void Basic(Rectangle[] rectangles, Pane group);

    protected void MoveDown(Rectangle rect) {
        if (rect.getY() + MOVE < YMAX) {
            rect.setY(rect.getY() + MOVE);
        }

    }

    protected void MoveRight(Rectangle rect) {
        if (rect.getX() + MOVE <= XMAX - SIZE) {
            rect.setX(rect.getX() + MOVE);
        }
    }

    protected void MoveLeft(Rectangle rect) {
        if (rect.getX() - MOVE >= 0) {
            rect.setX(rect.getX() - MOVE);
        }
    }

    protected void MoveUp(Rectangle rect) {
        if (rect.getY() - MOVE > 0) {
            rect.setY(rect.getY() - MOVE);
        }
    }
    
    protected boolean checkRectangle(Rectangle rect, int x, int y) {
        boolean xb = false;
        boolean yb = false;
        if (x >= 0) {
            xb = rect.getX() + x * MOVE <= XMAX - SIZE;
        }
        if (x < 0) {
            xb = rect.getX() + x * MOVE >= 0;
        }
        if (y >= 0) {
            yb = rect.getY() - y * MOVE > 0;
        }
        if (y < 0) {
            yb = rect.getY() + y * MOVE < YMAX;
        }
        return xb && yb && MESH[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;
    }
}
