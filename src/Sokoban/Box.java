package Sokoban;

import javafx.scene.image.ImageView;

public class Box extends Piece{

    protected static boolean isBox = false ;
    private static boolean anotherBoxNextToTheCurrBox = false ;
    private static boolean isWallNextToTheBox = false ;
    private static int directionOnX ,  directionOnY;
    
    /*
    ** cur_Box_Index , to get the index of the box that the player wants to move 
    */  
    private static int cur_Box_Index = 0 ;
    
    /*
    ** Check if There's a box in the desired Location 
    */
    protected static void checkBox(int x , int y)
    {
        cur_Box_Index = 0 ;
        directionOnX = x ; directionOnY = y ;
        isBox = false ;  
         
        for(ImageView box_iv : Map.Boxes_Imageviews_Array)
        {
            
            if(Player.player_imageView.getX()+directionOnX*50 == box_iv.getX() &&
               Player.player_imageView.getY()+directionOnY*50 == box_iv.getY())
            {
                isBox = true ;
                break;
            }
            
            cur_Box_Index++;
            
        }
        
        checkForBox();
    }
            
    
    
     //============================= 
     private static void checkForBox()
     {
         if(isBox == true){
             
             checkIf_Thereis_A_boxNextToTheCurrBox() ;
             checkIf_Thereis_A_WallNextToTheCurrBox() ;
             moveTheBox() ;
         }
             
     }

     /*
      * to check if there are two boxes next to each other
     */
     private static void  checkIf_Thereis_A_boxNextToTheCurrBox()
     {
         anotherBoxNextToTheCurrBox = false ;
         
         for(ImageView box_iv : Map.Boxes_Imageviews_Array)
        {
            
            if( Map.Boxes_Imageviews_Array.get(cur_Box_Index).getX()+directionOnX*50==box_iv.getX() &&
                Map.Boxes_Imageviews_Array.get(cur_Box_Index).getY()+directionOnY*50==box_iv.getY()  )
            {
                anotherBoxNextToTheCurrBox = true ;
                break;
            }
            
        }
     }
     
     /*
      * This method is used to determine if there's a wall next to the current box
     */
     private static void  checkIf_Thereis_A_WallNextToTheCurrBox()
     {
         isWallNextToTheBox = false ;
         
         if(anotherBoxNextToTheCurrBox==false)
         {
               for(ImageView wall_iv : Map.Walls_Imageviews_Array)
               {

                   if( Map.Boxes_Imageviews_Array.get(cur_Box_Index).getX()+directionOnX*50==wall_iv.getX() &&
                       Map.Boxes_Imageviews_Array.get(cur_Box_Index).getY()+directionOnY*50==wall_iv.getY()  )
                   {
                       isWallNextToTheBox = true ;
                       break;
                   }

               }
         }
     } 
     
     
     
     /*
      * moveTheBox method is used to moving the box to the desired Location
     */
     private static void moveTheBox()
     {
         if( isBox && !anotherBoxNextToTheCurrBox && !isWallNextToTheBox )
         { 
             int x = (int)Map.Boxes_Imageviews_Array.get(cur_Box_Index).getX()+directionOnX*50 ;
             int y = (int)Map.Boxes_Imageviews_Array.get(cur_Box_Index).getY()+directionOnY*50 ;
             
             if(!Pipe.isPipe(x,y)){
                 Map.Boxes_Imageviews_Array.get(cur_Box_Index).setX(x);
                 Map.Boxes_Imageviews_Array.get(cur_Box_Index).setY(y);
             }
             
             
         }
     }
}
