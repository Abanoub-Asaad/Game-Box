/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tetris;


import static Tetris.Tetris_Main.MESH;
import static Tetris.Controller.SIZE;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;



public class clear {

    public static int linesNo = 0;
    
    static  int n=0;

    public  static   void remove( Group pane) {
        
       List<Node> rects = new ArrayList<Node>();
           ArrayList<Node> r1 = new ArrayList<Node>();
          
		ArrayList<Integer> lines = new ArrayList<Integer>();
		List<Node> newrects = new ArrayList<Node>();
		int full = 0;
		for (int i = 0; i < MESH[0].length; i++) {
			for (int j = 0; j < MESH.length; j++) {
				if (MESH[j][i] == 1)
					full++;
			}
			if (full == MESH.length)
				lines.add(i + lines.size());
			full = 0;
		}
		if (lines.size() > 0)
			do {
                           
				for (Node node : pane.getChildren()) {
					if (node instanceof Rectangle)
						rects.add(node);
				}
                            
	/*
                                // trying split rects into 15 arraylist each one of them contains 20 node 
                                but using the same arraylist as a temp arraylist 
          int size = 20;
        for (int start = 0; start < rects.size(); start += size) {
        int end = Math.min(start + size, rects.size());
        List<Node> sublist = r1.subList(start, end);
         for(int i=0;i<r1.size();i++){
                                                  Rectangle a = (Rectangle) r1.get(i);
                                         if(r1.get(i) instanceof Rectangle){
                                            
						MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
						pane.getChildren().remove(r1.get(i));
                                                
                                               
                                         }
                                              }
       
                    }
                        */ 
                            
				linesNo++;

                               
                                  
                               
                                             
                            
				for (int i=0;i<rects.size();i++) {
                                    
					Rectangle a = (Rectangle) rects.get(i);
                                        
                                        if(rects.get(i) instanceof Rectangle){
                                            
						MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
						pane.getChildren().remove(rects.get(i));
                                                
                                               
					//if (a.getY() == lines.get(0) * SIZE) {
                                          
					//} else
					//	newrects.add(rects.get(i));
                                       // }
				}
                                }
/*
                         
				for (Node node : newrects) {
					Rectangle a = (Rectangle) node;
					if (a.getY() < lines.get(0) * SIZE) {
						MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
						a.setY(a.getY() + SIZE);
					}
				}
                                */
				lines.remove(0);
				rects.clear();
				
				for (Node node : pane.getChildren()) {
					if (node instanceof Rectangle)
						rects.add(node);
				}
				for (Node node : rects) {
					Rectangle a = (Rectangle) node;
					try {
						MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
				rects.clear();
                          
			} while (lines.size() > 0);        
                
    
    }
                        }


