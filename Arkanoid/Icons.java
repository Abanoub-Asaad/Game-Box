/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkanoid;

import java.util.ArrayList;
import java.util.Collections;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author egypt
 */
public class Icons {

    private final Image expand_img = new Image("Resources/Arkanoid/icons/expand.png", 100, 20, false, false);
    private final Image shrink_img = new Image("Resources/Arkanoid/icons/shrink.png", 100, 20, false, false);
    private final Image slow_img = new Image("Resources/Arkanoid/icons/slow.png", 100, 20, false, false);
    private final Image fast_img = new Image("Resources/Arkanoid/icons/fast.png", 100, 20, false, false);
    private final Image empty_img = new Image("Resources/Arkanoid/icons/empty.png", 100, 20, false, false);
    private static final Image heart_img = new Image("Resources/Arkanoid/icons/life.png", 35, 35, false, false);
    private final Image shot_gun_img = new Image("Resources/Arkanoid/icons/laser.png", 100, 20, false, false);
    private final Image extra50_img = new Image("Resources/Arkanoid/icons/extra50.png", 100, 20, false, false);
    private final Image extra100_img = new Image("Resources/Arkanoid/icons/extra100.png", 100, 20, false, false);

    private static ImageView expand_IV = new ImageView();
    private static ImageView slow_IV = new ImageView();
    private static ImageView extra50_IV = new ImageView();
    private static ImageView extra100_IV = new ImageView();
    private static ImageView shoot_IV = new ImageView();
    private static ImageView fast_IV = new ImageView();
    private static ImageView empty_IV = new ImageView();
    private static ImageView shrink_IV = new ImageView();
    private static ImageView heart_IV = new ImageView();

    private final TranslateTransition expand_TR = new TranslateTransition();
    private final TranslateTransition slow_TR = new TranslateTransition();
    private final TranslateTransition shoot_TR = new TranslateTransition();
    private final TranslateTransition fast_TR = new TranslateTransition();
    private final TranslateTransition shrink_TR = new TranslateTransition();
    private final TranslateTransition empty_TR = new TranslateTransition();
    private final TranslateTransition heart_TR = new TranslateTransition();
    private final TranslateTransition extra100_TR = new TranslateTransition();
    private final TranslateTransition extra50_TR = new TranslateTransition();
    private final TranslateTransition translate10 = new TranslateTransition();

    private int[] random_numbers = new int[10];
    private double yOfCurrentIcon, xOfCurrentIcon;
    private int num_of_icon;
    public ArrayList<ImageView> heart_array = new ArrayList<>();

    public Icons() {
        ArkanoidMain.root.getChildren().addAll(expand_IV, slow_IV, extra100_IV, extra50_IV, shoot_IV, fast_IV, empty_IV, shrink_IV, heart_IV);
        makeRandomNumbersForIcons();
    }

    private void transation_icon() {

        switch (num_of_icon) {
            case 0:
                slow_IV.setImage(slow_img);
                slow_IV.setX(xOfCurrentIcon);
                slow_IV.setY(yOfCurrentIcon);
                slow_TR.setToY(650);
                slow_TR.setDuration(Duration.millis(2500));
                slow_TR.setCycleCount(1);
                slow_TR.setAutoReverse(false);
                slow_TR.setNode(slow_IV);
                slow_TR.play();
                break;
            case 1:
                expand_IV.setImage(expand_img);
                expand_IV.setX(xOfCurrentIcon);
                expand_IV.setY(yOfCurrentIcon);
                expand_TR.setToY(650);
                expand_TR.setDuration(Duration.millis(2500));
                expand_TR.setCycleCount(1);
                expand_TR.setAutoReverse(false);
                expand_TR.setNode(expand_IV);
                expand_TR.play();
                break;
            case 3:
                heart_IV.setImage(heart_img);
                heart_IV.setX(xOfCurrentIcon);
                heart_IV.setY(yOfCurrentIcon);
                heart_TR.setToY(650);
                heart_TR.setDuration(Duration.millis(2500));
                heart_TR.setCycleCount(1);
                heart_TR.setAutoReverse(false);
                heart_TR.setNode(heart_IV);
                heart_TR.play();
                break;
            case 4:
                extra100_IV.setImage(extra100_img);
                extra100_IV.setX(xOfCurrentIcon);
                extra100_IV.setY(yOfCurrentIcon);
                extra100_TR.setToY(650);
                extra100_TR.setDuration(Duration.millis(2500));
                extra100_TR.setCycleCount(1);
                extra100_TR.setAutoReverse(false);
                extra100_TR.setNode(extra100_IV);
                extra100_TR.play();
                break;
            case 5:
                shoot_IV.setImage(shot_gun_img);
                shoot_IV.setX(xOfCurrentIcon);
                shoot_IV.setY(yOfCurrentIcon);
                shoot_TR.setToY(650);
                shoot_TR.setDuration(Duration.millis(2500));
                shoot_TR.setCycleCount(1);
                shoot_TR.setAutoReverse(false);
                shoot_TR.setNode(shoot_IV);
                shoot_TR.play();
                break;
            case 6:
                shrink_IV.setImage(shrink_img);
                shrink_IV.setX(xOfCurrentIcon);
                shrink_IV.setY(yOfCurrentIcon);
                shrink_TR.setToY(650);
                shrink_TR.setDuration(Duration.millis(2500));
                shrink_TR.setCycleCount(1);
                shrink_TR.setAutoReverse(false);
                shrink_TR.setNode(shrink_IV);
                shrink_TR.play();
                break;
            case 7:
                extra50_IV.setImage(extra50_img);
                extra50_IV.setX(xOfCurrentIcon);
                extra50_IV.setY(yOfCurrentIcon);
                extra50_TR.setToY(700);
                extra50_TR.setDuration(Duration.millis(2500));
                extra50_TR.setCycleCount(1);
                extra50_TR.setAutoReverse(false);
                extra50_TR.setNode(extra50_IV);
                extra50_TR.play();
                break;
            case 8:
                fast_IV.setImage(fast_img);
                fast_IV.setX(xOfCurrentIcon);
                fast_IV.setY(yOfCurrentIcon);
                fast_TR.setToY(650);
                fast_TR.setDuration(Duration.millis(2500));
                fast_TR.setCycleCount(1);
                fast_TR.setAutoReverse(false);
                fast_TR.setNode(fast_IV);
                fast_TR.play();
                break;
            case 9:
                empty_IV.setImage(empty_img);
                empty_IV.setX(xOfCurrentIcon);
                empty_IV.setY(yOfCurrentIcon);
                empty_TR.setToY(650);
                empty_TR.setDuration(Duration.millis(2500));
                empty_TR.setCycleCount(1);
                empty_TR.setAutoReverse(false);
                empty_TR.setNode(empty_IV);
                empty_TR.play();
                break;

        }

    }

    public void check_number(ImageView brick) {

        for (int i = 0; i < 9; i++) {
            if (random_numbers[i] == Arkanoid_Map.bricks_arraylist.indexOf(brick)) {
                num_of_icon = i;
                xOfCurrentIcon = brick.getX();
                yOfCurrentIcon = brick.getY();
                transation_icon();
            }
        }
    }

    private void makeRandomNumbersForIcons() {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < Arkanoid_Map.bricks_arraylist.size(); i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        for (int j = 0; j < 9; j++) {
            random_numbers[j] = numbers.get(j);
        }

    }

    public void DrawHeart() {

        for (int i = 0; i < 5; i++) {
            heart_IV = new ImageView(heart_img);
            heart_IV.setX(1060 + i * 35);
            heart_IV.setY(20);
            ArkanoidMain.root.getChildren().add(heart_IV);
            heart_array.add(heart_IV);
        }
    }

    public static ImageView getExpand_IV() {
        return expand_IV;
    }

    public static void setExpand_IV(ImageView expand_IV) {
        Icons.expand_IV = expand_IV;
    }

    public static ImageView getSlow_IV() {
        return slow_IV;
    }

    public static void setSlow_IV(ImageView slow_IV) {
        Icons.slow_IV = slow_IV;
    }

    public static ImageView getExtra50_IV() {
        return extra50_IV;
    }

    public static void setExtra50_IV(ImageView extra50_IV) {
        Icons.extra50_IV = extra50_IV;
    }

    public static ImageView getExtra100_IV() {
        return extra100_IV;
    }

    public static void setExtra100_IV(ImageView extra100_IV) {
        Icons.extra100_IV = extra100_IV;
    }

    public static ImageView getShoot_IV() {
        return shoot_IV;
    }

    public static void setShoot_IV(ImageView shoot_IV) {
        Icons.shoot_IV = shoot_IV;
    }

    public static ImageView getFast_IV() {
        return fast_IV;
    }

    public static void setFast_IV(ImageView fast_IV) {
        Icons.fast_IV = fast_IV;
    }

    public static ImageView getEmpty_IV() {
        return empty_IV;
    }

    public static void setEmpty_IV(ImageView empty_IV) {
        Icons.empty_IV = empty_IV;
    }

    public static ImageView getShrink_IV() {
        return shrink_IV;
    }

    public static void setShrink_IV(ImageView shrink_IV) {
        Icons.shrink_IV = shrink_IV;
    }

    public static ImageView getHeart_IV() {
        return heart_IV;
    }

    public static void setHeart_IV(ImageView heart_IV) {
        Icons.heart_IV = heart_IV;
    }

    public static Image getHeart_img() {
        return heart_img;
    }
}
