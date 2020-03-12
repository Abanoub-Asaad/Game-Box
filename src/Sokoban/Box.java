package Sokoban;

import static Sokoban.Player.player_imageView;
import java.util.ArrayList;
import javafx.scene.image.ImageView;

public class Box {

    private static int index = 0;
    protected static boolean isBox = false ;
    private static ImageView Box_imageView ;
            
    /*
     * Array of boxes' imageviews 
    */
    protected static ArrayList<ImageView> Boxes_Imageviews_Array = new ArrayList<>() ;
    
    protected static void checkBoxes(int x_direction , int y_direction)
    {
        
        
        for (int i = 0; i < Boxes_Imageviews_Array.size(); i++)
        {
            
            if (player_imageView.getX()== Boxes_Imageviews_Array.get(i).getX()
                    && player_imageView.getY() == Boxes_Imageviews_Array.get(i).getY()) 
            {
                
                isBox = true;
                index = i ;
                break;
            }
        }
        
        checkWallsForBox(x_direction , y_direction );
        
        if (isBox && !Player.isWall)
        { 
            setBoxPosition(x_direction, y_direction);
            isBox = false ;
        }
    }
    
    
    
   
    
    private static void checkWallsForBox(int direction_on_x, int direction_on_y)
    {
        
        for (int i = 0; i < Map.Walls_Imageviews_Array.size(); i++)
        {
            
            if (Boxes_Imageviews_Array.get(index).getX() + direction_on_x*50 == Map.Walls_Imageviews_Array.get(i).getX()
                    && Boxes_Imageviews_Array.get(index).getY() + direction_on_y*50 == Map.Walls_Imageviews_Array.get(i).getY()) 
            {
                
                Player.isWall = true;
                break;
            }
        }
       
    }
    
     private static void setBoxPosition(int x_direction, int y_direction)
    { 
        
        Boxes_Imageviews_Array.get(index).setX(Boxes_Imageviews_Array.get(index).getX() + x_direction*50);
        Boxes_Imageviews_Array.get(index).setY(Boxes_Imageviews_Array.get(index).getY() + y_direction*50);
        
    }
     
//    protected static void checkBoxInTarget()
//    {
//        for(int i=0 ; i<Boxes_Imageviews_Array.size() ; i++)
//        {
//            if(Boxes_Imageviews_Array.get(i).getX()== Map.StorageLocation_Imageviews_Array.get(i).getX()
//                    && Boxes_Imageviews_Array.get(i).getY()== Map.StorageLocation_Imageviews_Array.get(i).getY())
//            {
//                 Map.StorageLocation_Imageviews_Array.get(i).setImage(Map.boxOnTarget);
//                 
//            }
//        }
//    }
}
