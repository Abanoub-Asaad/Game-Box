/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatmap;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class map extends JPanel {
      private int[][] map;
      private BufferedImage image;
      public static final int icone_width =63 ;
      public static final int icone_height =63 ;


//    public map(int [][] map) throws IOException {
//        this.map = new int[map.length][map[0].length];
//        for (int i = 0; i < map.length; i++) {
//            System.arraycopy(map[i], 0, this.map[i], 0, this.map[i].length);
//        }
//
//        image = ImageIO.read(new File ("sheet.jpg"));
//
//    }   
//    
    public map(int width, int height) {
        map = new int[height][width];

    }
    public void split_image_sheet(Graphics g) 
    {
        for (int i = 0; i < map.length; i++) 
        {
            for (int j = 0; j < map[i].length; j++) 
            {
                int index = map[i][j];
                int yoffset = 0;
                while (index > (image.getWidth() / icone_width - 1)) {
                    yoffset++;
                    index = index - (321 / icone_width);
                }
                g.drawImage( image ,
                        j * icone_width , i * icone_height,
                        (j * icone_width) + icone_width,
                        (i * icone_height) + icone_height,
                        index * icone_width,
                        yoffset * icone_height,
                        (index * icone_width) + icone_width,
                        (yoffset * icone_height) + icone_height, null);
            }
        }

    }

    public static map fromfile(String filename) throws IOException {
        
        map map_op = null;
        
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {

            String curentline , score ;
            score = br.readLine();
            while ((curentline = br.readLine()) != null)
            {
                if (curentline.isEmpty())
                    continue;
        
                ArrayList<Integer> row = new ArrayList<>();
                char [] values = curentline.toCharArray();
                for (int i = 0 ; i< values.length ; i++)
                {
                        switch(values[i]){
                            case '#':
                                row.add(1);
                                break ;
                            case '@':
                                row.add(2);
                                break;
                            case ' ':
                            case '!':
                                row.add(13);
                                break;
                            case '.' :
                                row.add(4);
                                    break ;
                        
                    }
                }
                
                data.add(row);
            }
        } catch (IOException ex) {
            Logger.getLogger(map.class.getName()).log(Level.SEVERE, null, ex);
        }
        int width = data.get(0).size();
        
        int height = data.size();

        map_op = new map(width, height);

        for (int i = 0; i < height; i++) 
        {
            for (int j = 0; j < width; j++)
            {
                map_op.map[i][j] = data.get(i).get(j);
            }
        }
          map_op.image =ImageIO.read(new File ("sheet.jpg")); 
        
        
        return map_op;
        
    }
 @Override public void paintComponent (Graphics g){
    super.paintComponent(g);
                split_image_sheet(g);
    }
}
