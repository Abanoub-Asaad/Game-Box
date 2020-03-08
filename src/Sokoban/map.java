package Sokoban;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class map
{

    private int[][] map; 
    private Image image;
    public static final int icone_width = 63;
    public static final int icone_height = 63;
    public GraphicsContext gc;
    Canvas canvas = new Canvas(650, 600);

    public map(int width, int height)
    {
        map = new int[height][width];
    }

    public void split_image_sheet() 
    {
        gc = canvas.getGraphicsContext2D();

        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                int index = map[i][j];
                int yoffset = 0;
                while (index > (image.getWidth() / icone_width - 1))
                {
                    yoffset++;
                    index = index - (321 / icone_width);
                }

                gc.drawImage(image, index * icone_width, yoffset * icone_height, icone_width, icone_height, j * icone_width, i * icone_height,
                        icone_width, icone_height);
            }
        }

    }

    public static map fromfile(String filename) throws IOException
    {

        map map_op = null;

        ArrayList<ArrayList<Integer>> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {

            String curentline, level;
            level = br.readLine();
            while ((curentline = br.readLine()) != null) 
            {
                if (curentline.isEmpty()) 
                {
                    continue;
                }

                ArrayList<Integer> row = new ArrayList<>();
                char[] values = curentline.toCharArray();
                for (int i = 0; i < values.length; i++)
                {
                    switch (values[i])
                    {
                        case '#':
                            row.add(1);
                            break;
                        case '@':
                            row.add(2);
                            break;
                        case ' ':
                        case '!':
                            row.add(13);
                            break;
                        case '.':
                            row.add(4);
                            break;

                    }
                }

                data.add(row);
            }
        }
        catch (IOException ex)
        {
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
        
        map_op.image = new Image(new FileInputStream("sheet.jpg"));
        
        return map_op;

    }
}
