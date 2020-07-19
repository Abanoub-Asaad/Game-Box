package Tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Form {

    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color;
    protected String name;
    public int form = 1;

    Form(){
        
    }
    
    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;

        switch (name) {
            case "j":
                color = Color.GOLD;
                break;
            case "l":
                color = Color.MEDIUMORCHID;
                break;
            case "o":
                color = Color.DEEPPINK;
                break;
            case "s":
                color = Color.DARKORANGE;
                break;
            case "t":
                color = Color.LIME;
                break;
            case "z":
                color = Color.RED;
                break;
            case "i":
                color = Color.BLUE;
                break;

        }
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }

    public String getName() {
        return name;
    }

    public void changeForm() {
        if (form != 4) {
            form++;
        } else {
            form = 1;
        }
    }
}
