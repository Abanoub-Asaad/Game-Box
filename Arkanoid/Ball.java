/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkanoid;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author egypt
 */
public class Ball {

    private Image ballImage = new Image("Resources/Arkanoid/ball.png", 30, 30, false, false);
    private ImageView ball_iv = new ImageView(ballImage);

    private double Height = 48;
    private double Width = 50;
    private double stepX = 1;
    private double stepY = -1;
    private double speed = 5;

    public double getX() {
        return ball_iv.getX();
    }

    public ImageView getBall_iv() {
        return ball_iv;
    }

    public void setBall_iv(ImageView ball_iv) {
        this.ball_iv = ball_iv;
    }

    public void setX(double x) {
        ball_iv.setX(x);
    }

    public double getY() {
        return ball_iv.getY();
    }

    public void setY(double y) {
        ball_iv.setY(y);
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double Height) {
        this.Height = Height;
    }

    public double getWidth() {
        return Width;
    }

    public void setWidth(double Width) {
        this.Width = Width;
    }

    public double getStepX() {
        return stepX;
    }

    public void setStepX(double stepX) {
        this.stepX = stepX;
    }

    public double getStepY() {
        return stepY;
    }

    public void setStepY(double stepY) {
        this.stepY = stepY;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

}
