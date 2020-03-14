package Sokoban;

import javafx.scene.image.ImageView;

public class Player extends Piece
{
    protected static ImageView player_imageView = new ImageView(); 
    
    protected static void checkForThePlayer (int dir_x , int dir_y)
    {
        if(!checkBox(dir_x , dir_y) && !checkWall(dir_x , dir_y) )
        {
            moveThePlayer(dir_x , dir_y);
        }
    }
    
    /*
     *  This Method is used to check if the desired position have a box or not
    */
    private static boolean checkBox(int dir_x , int dir_y ) 
    {
        for(ImageView box_iv : Map.Boxes_Imageviews_Array)
        {
            
            if(Player.player_imageView.getX()+dir_x*50 == box_iv.getX() &&
               Player.player_imageView.getY()+dir_y*50 == box_iv.getY())
            {
                return true ;
            }
 
        }
        return  false ;
    }
    
    /*
     *  This Method is used to check if the desired position have a wall or not
    */
    private static boolean checkWall(int dir_x , int dir_y )
    {
        for(ImageView wall_iv : Map.Walls_Imageviews_Array)
        {

            if( player_imageView.getX()+dir_x*50==wall_iv.getX() &&
                player_imageView.getY()+dir_y*50==wall_iv.getY()  )
            {
                return true ;
            }

        }
        return  false ;
    }
    
    /*
      * moveThePlayer method is used to moving the player to the desired Location
     */
     private static void moveThePlayer(int dir_x , int dir_y)
     { 
             int x = (int)player_imageView.getX()+dir_x*50 ;
             int y = (int)player_imageView.getY()+dir_y*50 ;
             
             player_imageView.setX(x);
             player_imageView.setY(y);  
     }
}
