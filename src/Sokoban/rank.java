/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokoban;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.scene.text.Text;

/**
 *
 * @author Eng.Waleed
 */
public class rank {
    
public static  File file = new File("C:\\Users\\Eng.Waleed\\Desktop\\Game-Box-master (1)\\Game-Box-master\\src\\Resources\\Sokoban\\sokoban_player.txt");
  int x=350;
  int y=250;
   Map<String, Float> mapFromFile;
   Text player_name;
   Text player_score;
  
    public Map<String, Float> Read() throws FileNotFoundException, IOException{
        
      
        
        Map<String, Float> mapFileContents = new LinkedHashMap<>();
          String name = null;
       
          Float value ;
          BufferedReader br=null ;
          
		try  {
                     br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
                       
				  String [] parts = line.split(":");
                                  
                                    name = parts[0].trim();
                                   value = Float.valueOf(parts[1].trim());
                                   
                                      if( !name.equals("")&&!value.equals("") )
                                 mapFileContents.put(name, value);
                          
                        }
                     
		} 
                
                catch (IOException e) {
		//	e.printStackTrace();
		}
                
                
                 finally{
            
            // close the BufferedReader
            if(br.readLine() == null){
                try { 
                    br.close(); 
                }
                catch(Exception e){
                System.out.println(" no   close");}
            }
        }        
        
        return mapFileContents;
        
    }
    
    
    
    public  Map <String,Float>  sort() throws FileNotFoundException,IOException{
        
       mapFromFile=Read();
        
      Set<Map.Entry<String, Float>> companyFounderSet = 
                mapFromFile.entrySet();
    
  List<Map.Entry<String, Float>> companyFounderListEntry = 
                new ArrayList<Map.Entry<String, Float>>(
                        companyFounderSet);
  Collections.sort(companyFounderListEntry, 
                new Comparator<Map.Entry<String,Float>>() {
 
            @Override
            public int compare(Map.Entry<String, Float> es1, 
                    Map.Entry<String, Float> es2) {
                return es2.getValue().compareTo(es1.getValue());
            }

            
        });
  
   mapFromFile.clear();
   for(Map.Entry<String, Float> map : companyFounderListEntry){
            mapFromFile.put(map.getKey(), map.getValue());
        }
   
   
   
    for(Map.Entry<String, Float> lhmap : 
            mapFromFile.entrySet()){
        
                        player_name= new Text();
                        player_score= new Text();
                                  player_name.setX(x);
                                  player_name.setY(y);
                                  player_score.setX(x+400);
                                  player_score.setY(y);
                                  player_name.setId("text");
                                  player_score.setId("text");
                                  player_name.setText(lhmap.getKey());
                                  player_score.setText(lhmap.getValue().toString());
                                    y=y+70;
                                  finish_level.pane_finish.getChildren().addAll(player_name,player_score);
        // print it in console to check if it store data correctly or not 
            System.out.println("Key : "  + lhmap.getKey() 
                    + "\t\t" + "Value : "  + lhmap.getValue());
        }
    return mapFromFile;
      
    }
    
    
}
