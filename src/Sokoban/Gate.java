package Sokoban;

import static Sokoban.Player.player_imageView;
import javafx.scene.image.ImageView;

public class Gate {

    /**
     * check if the player moves around an open gate to prevent him from going
     * through it . the parameters are the direction that the player want to
     * reach
     *
     * @param dir_x
     * @param dir_y
     * @return
     */
    protected boolean checkPlayer_Gate(int dir_x, int dir_y) {

        for (ImageView gate_iv : Map.Gates_Imageviews_Array) {

            if (player_imageView.getX() + dir_x * 50 == gate_iv.getX()
                    && player_imageView.getY() + dir_y * 50 == gate_iv.getY()) {
                
                return true;
            }

        }
        
      
        return false;

    }

    /**
     * Check if there's a box will moves through an open gate to prevent it. the
     * parameters are the directions that the box will move to.
     *
     * @param dir_x
     * @param dir_y
     * @return
     */
    protected boolean checkBox_Gate(int dir_x, int dir_y, int curIndexBox) {

        for (ImageView gate_iv : Map.Gates_Imageviews_Array) {

            if (Map.Boxes_Imageviews_Array.get(curIndexBox).getX() + dir_x * 50 == gate_iv.getX()
                    && Map.Boxes_Imageviews_Array.get(curIndexBox).getY() + dir_y * 50 == gate_iv.getY()) {
                return true;

            }
        }
        return false;
    }

}
