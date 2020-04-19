
package Sokoban;

import Sokoban.Map;
import static Sokoban.Player.player_imageView;
import javafx.scene.image.ImageView;


public class Pipe {
    
     /*
     *  This Method is used to check if the desired position have a pipe or not
     */
      protected static int checkPipe(int dir_x, int dir_y) {
          int i = 1 ;
        for (ImageView pipe_iv : Map.Pipes_Imageviews_Array) {

            if (player_imageView.getX() + dir_x * 50 == pipe_iv.getX()
                    && player_imageView.getY() + dir_y * 50 == pipe_iv.getY()) {
                return i;
            }
            ++i;
        }    
        return 3;
    }
    
     /*
     *  This Method is used to check if the desired position when the player get off the pipe 
     *  have a pipe or not
     */
      protected static boolean checkIfThereIsABoxNextToThePipe(int desiredX , int desiredY) {

        for (ImageView box_iv : Map.Boxes_Imageviews_Array) {

            if (desiredX == box_iv.getX() && desiredY== box_iv.getY()) {
                return true;
            }
        }    
        return false;
    } 
      
      
      protected static boolean isPipe(int x , int y){
          for (ImageView box_iv : Map.Boxes_Imageviews_Array){
              
               for (ImageView pipe_iv : Map.Pipes_Imageviews_Array) {
                   
                   if(pipe_iv.getX() == x && pipe_iv.getY() == y){
                       return true;
                   }
               }          
          }
           return false;
      }
      
}