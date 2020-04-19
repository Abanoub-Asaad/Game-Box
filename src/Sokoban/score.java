
package Sokoban;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.text.Text;


public class score {
    
      static Text score_text = new Text();
      static float  score =0f;
      static  File file = new File("C:\\Game-Box\\src\\Resources\\Sokoban\\sokoban_player.txt");
  
    static  FileWriter filewriter ;
    static  BufferedWriter bufferwriter ;
      
     public static void calculate_score() throws IOException {
      
     score = 100*(float ) Time.moves / Time.seconds ;
     score = (int )score;
        
     score_text.setText("Score:  "+ score);
          
            WriteInFile();
     
 }
   
   public static void show_score_number( Integer score ){
       
       score_text.setText("Score:  "+ score.toString());
       
   }
   
       public  static void WriteInFile( ) throws IOException 
               
     {
           filewriter = new FileWriter(file, true);
        bufferwriter = new BufferedWriter(filewriter);
         
       
                if( start_level.PlayerName_string.length()>0 && !start_level.PlayerName_string.contains(" ") ) //Validation
                {
                    
                    bufferwriter.write( start_level.PlayerName_string+":"+finish_level.nLevel_in_score_file+":"+score);
                    bufferwriter.newLine();
                    bufferwriter.close();
                    filewriter.close();
                    
                }
          
     }
       
       
       
}
