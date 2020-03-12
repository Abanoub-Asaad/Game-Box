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
    protected static boolean isWall = false ;
    
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
                Box.isBox = false ;
                
                if (e.getCode() == KeyCode.LEFT) {
                    checkWallsForPlayer(-1, 0);
                    Box.checkBoxes(-1,0);          
                }
                    
                if (e.getCode() == KeyCode.RIGHT) {
                    checkWallsForPlayer(1, 0);
                    Box.checkBoxes(1,0);
                }
                    
                
                if (e.getCode() == KeyCode.UP) {
                    checkWallsForPlayer(0, -1);
                    Box.checkBoxes(0,-1);
                }
                    
                
                if (e.getCode() == KeyCode.DOWN) {
                    checkWallsForPlayer(0, 1);
                    Box.checkBoxes(0 , 1);
                }
                    
                System.out.println(player_imageView.getX()+" "+player_imageView.getY());

            }
        });

    }

    /*
     * This Method is used to check if the desired position have a wall so the player can't go
     * or not , so he can move 
     * Parameters : direction_on_x & direction_on_y are represent directions that the player will move 
     * the for loop , loops on all walls' imageviews location
    */
    private void checkWallsForPlayer(int direction_on_x, int direction_on_y)
    {
        
        for (int i = 0; i < Map.Walls_Imageviews_Array.size(); i++)
        {
            
            if (player_imageView.getX() + direction_on_x*50 == Map.Walls_Imageviews_Array.get(i).getX()
                    && player_imageView.getY() + direction_on_y*50 == Map.Walls_Imageviews_Array.get(i).getY()) 
            {
                
                isWall = true;
                break;
            }
        }
        
        if (!isWall)
        {
            setPlayerPosition(direction_on_x*50 , direction_on_y*50);
        }
    
    }

    
        static void setPlayerPosition(int x, int y)
    {
        player_imageView.setX(player_imageView.getX() +x);
        player_imageView.setY(player_imageView.getY() +y);
    }
    
}
