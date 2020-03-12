package Sokoban;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Player
{
    /*
     * player_imageView to access the location of the player 
     * It's accessed from function "setPosition" in class "Map"
    */
    protected static ImageView player_imageView = new ImageView();
    
    /*
     * isWall is used to determinnig if the wanted position have a wall or not 
    */
    private static boolean isWall = false ;
    
    /*
     * MoveThePlayer method is used for Accessing player's desired location 
    */
    public void MoveThePlayer(Scene Sokoban_Scene)
    {
        
        
        Sokoban_Scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent e)
            {
                
                isWall = false ;
                
                if (e.getCode() == KeyCode.LEFT) 
                    checkWalls(-50, 0);
                
                if (e.getCode() == KeyCode.RIGHT) 
                    checkWalls(50, 0);
                
                if (e.getCode() == KeyCode.UP) 
                    checkWalls(0, -50);
                
                if (e.getCode() == KeyCode.DOWN) 
                    checkWalls(0, 50);
                

            }
        });

    }

    /*
     * This Method is used to check if the desired position have a wall so the player can't go
     * or not , so he can move 
     * Parameters : x_value & y_value are the the values that the player will move and it also show the direction
     * the for loop , loops on all walls' imageviews location
    */
    private void checkWalls(int x_value, int y_value)
    {
        
        for (int i = 0; i < Map.Walls_Imageviews_Array.size(); i++)
        {
            
            if (player_imageView.getX() + x_value == Map.Walls_Imageviews_Array.get(i).getX()
                    && player_imageView.getY() + y_value == Map.Walls_Imageviews_Array.get(i).getY()) 
            {
                
                isWall = true;
                break;
            }
        }
        
        if (!isWall)
        {
            setPlayerPosition(x_value, y_value);
        }
    
    }

        private void setPlayerPosition(int x, int y)
    {
        player_imageView.setX(player_imageView.getX() + x);
        player_imageView.setY(player_imageView.getY() + y);
    }
    
}
