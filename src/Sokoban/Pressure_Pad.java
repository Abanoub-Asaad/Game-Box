package Sokoban;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pressure_Pad {

    protected static boolean levelHasvePad = false;
    protected static boolean BoxOnPad;
    protected boolean PlayerOnPad;
    private static Image boxOnPad = new Image("Resources/Sokoban/crate_39.png", 50, 50, true, true);
    protected static ImageView boxOnPad_iv = new ImageView();
    protected static int pressure_pad_posX;
    protected static int pressure_pad_posY;

    /**
     * Main method for The pad
     */
    protected void check_pad_isPressed() {

        BoxOnPad = checkBoxOnPad();
        PlayerOnPad = checkPlayerOnPad();

        if (BoxOnPad) {
            System.out.println("Box On Pad");
        } else if (PlayerOnPad) {
            System.out.println("Player On Pad");
        }

        if (BoxOnPad) {
            Sokoban_Main.root.getChildren().remove(boxOnPad_iv);
            boxOnPad_iv.setImage(boxOnPad);
            boxOnPad_iv.setX(pressure_pad_posX);
            boxOnPad_iv.setY(pressure_pad_posY);
            Sokoban_Main.root.getChildren().add(boxOnPad_iv);
        } else {
            Sokoban_Main.root.getChildren().remove(boxOnPad_iv);
            BoxOnPad = false;
        }

        if (BoxOnPad || PlayerOnPad) {
            openGates();
        } else {
            closeGates();
        }
    }

    /**
     * Method to open the gates, by making their images equal null when there's
     * something pressed on the pad, so the gates will be opened
     */
    private static void openGates() {
        for (ImageView gate_iv : Map.Gates_Imageviews_Array) {
            gate_iv.setImage(null);
            // Sokoban_Main.root.getChildren().remove(gate_iv);
        }
    }

    /**
     * Method to open the gates, by puting their images to their specific places
     * when the gates are open so surely there is a thing pressed on the pad but
     * when this thing moves, the gates will be closed
     */
    private static void closeGates() {
        for (ImageView gate_iv : Map.Gates_Imageviews_Array) {
            gate_iv.setImage(Map.gate);
        }
    }

    /**
     * check if there's a box pressed on the pad
     *
     * @return
     */
    private static boolean checkBoxOnPad() {
        for (ImageView box_iv : Map.Boxes_Imageviews_Array) {

            if (pressure_pad_posX == box_iv.getX() && pressure_pad_posY == box_iv.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * check if the player pressed on the pad
     *
     * @return
     */
    private static boolean checkPlayerOnPad() {

        if (Player.player_imageView.getX() == pressure_pad_posX && Player.player_imageView.getY() == pressure_pad_posY) {
            return true;
        }
        return false;
    }

}
