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
import java.util.stream.Collectors;
import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author Eng.Waleed
 */
public class rank {
    
  public static  File file = new File("C:\\Game-Box\\src\\Resources\\Sokoban\\sokoban_player.txt");
  public static int max=4;
  // it refers to the max number of players that can be stored in hashmap and displayed 
  static Integer l ;// refer to level number in file 
  //----------------------------------------------//
 public static   FlowPane inside = new FlowPane(Orientation.HORIZONTAL, 250, 20);
  //---------------------------------------------//
 
 final  static Map<Integer, LinkedHashMap<String, Float>> outer= new LinkedHashMap<Integer, LinkedHashMap<String, Float>>() {};
 
 static  Map<String, Float> mapFromFile;
 static  Map<String, Float> show;
 //---------------------------------------------------//
 
 
 //inner maps for each level
   static  LinkedHashMap<String, Float> map1=new LinkedHashMap<String, Float>(){
        @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > max;
        }
   };
   static  LinkedHashMap<String, Float> map2=new LinkedHashMap<String, Float>(){  @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > max;
        }
   };
   static  LinkedHashMap<String, Float> map3=new LinkedHashMap<String, Float>(){  @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > max;
        }
   };
   static  LinkedHashMap<String, Float> map4=new LinkedHashMap<String, Float>(){  @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > max;
        }
   };
   static  LinkedHashMap<String, Float> map5=new LinkedHashMap<String, Float>(){  @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > max;
        }
   };
   static  LinkedHashMap<String, Float> map6=new LinkedHashMap<String, Float>(){  @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > max;
        }
   };
   static  LinkedHashMap<String, Float> map7=new LinkedHashMap<String, Float>(){  @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > max;
        }
   };
   static  LinkedHashMap<String, Float> map8=new LinkedHashMap<String, Float>(){  @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > max;
        }
   };
   static  LinkedHashMap<String, Float> map9=new LinkedHashMap<String, Float>(){  @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > max;
        }
   };
   static  LinkedHashMap<String, Float> map10=new LinkedHashMap<String, Float>(){  @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > max;
        }
   };
   
   //------------------------------------------------------------------//
   
   
   
static   Text player_name;
static   Text player_score;
   
  public static  Map<Integer, LinkedHashMap<String, Float>>  intial(){
    
      outer.put(1, (LinkedHashMap<String, Float>) map1);
      outer.put(2, (LinkedHashMap<String, Float>) map2);
      outer.put(3, (LinkedHashMap<String, Float>) map3);
      outer.put(4, (LinkedHashMap<String, Float>) map4);
      outer.put(5, (LinkedHashMap<String, Float>) map5);
      outer.put(6, (LinkedHashMap<String, Float>) map6);
      outer.put(7, (LinkedHashMap<String, Float>) map7);
      outer.put(8, (LinkedHashMap<String, Float>) map8);
      outer.put(9, (LinkedHashMap<String, Float>) map9);
      outer.put(10, (LinkedHashMap<String, Float>) map10);
      
      return outer;
  }
   
    public  static   Map<String, Float> Read() throws FileNotFoundException, IOException  {
        
          String name = null;
       
          Float value ;
          BufferedReader br=null ;
          
		try  {
                     br = new BufferedReader(new FileReader(file));
			String line;
                        
			while ((line = br.readLine()) != null) {
                       
				  String [] parts = line.split(":");
                                  l=Integer.valueOf(parts[1].trim());
                                  
                                  if(!parts[0].trim().equals("")&&!parts[2].trim().equals("")){
                                     
                                          name = parts[0].trim();
                                      value = Float.valueOf(parts[2].trim());
                                  
                                      outer.get(l).put(name, value);
                                   
                                     }   
                                    
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
        
        return outer.get(l);
        
    }
    
   
    public  static   Map <String,Float>  sort() throws FileNotFoundException,IOException{
        
        
         mapFromFile = Read();
          
  return  mapFromFile.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Float>comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
         
    }
    
    
    public  static  void  show() throws IOException{
        
        
       //  int x=350;
        // int y=250;
         
         inside.getChildren().clear();
       
       show=sort();
        
       show.entrySet().stream().map((lhmap) -> {
           player_name= new Text();
          return lhmap;
      }).map((lhmap) -> {
          player_score= new Text();
          return lhmap;
      }).map((lhmap) -> {
          //    player_name.setX(x);
          //  player_name.setY(y);
          // player_score.setX(x+400);
          // player_score.setY(y);
          player_name.setId("text");
          return lhmap;
      }).map((lhmap) -> {
          player_score.setId("text");
          return lhmap;
      }).map((lhmap) -> {
          player_name.setText(lhmap.getKey());
          return lhmap;
      }).map((lhmap) -> {
          player_score.setText(lhmap.getValue().toString());
          return lhmap;
      }).map((lhmap) -> {
          //  y=y+70;
          inside.getChildren().addAll(player_name,player_score);
          return lhmap;
      }).forEach((lhmap) -> {
          // print it in console to check if it store data correctly or not 
          System.out.println("Key : "  + lhmap.getKey()
                  + "\t\t" + "Value : "  + lhmap.getValue());
      });
       
       
    }
    
}
