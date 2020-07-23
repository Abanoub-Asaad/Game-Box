package Sokoban;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class rank {

    static int max_nPlayers = 4;
    // it refers to the max number of players that can be stored in hashmap and displayed in Score board 
    static Integer level_number;// refer to level number in file 
    //----------------------------------------------//
    public static FlowPane show_score_pane = new FlowPane(Orientation.HORIZONTAL, 250, 20);
    // creating a small pane inside the finish scene to display the rank between players 
    //---------------------------------------------//

    static Map<Integer, LinkedHashMap<String, Float>> For_Whole_Levels = new LinkedHashMap<Integer, LinkedHashMap<String, Float>>() {
    };

    static Map<String, Float> mapFromFile;
    static Map<String, Float> Get_Sorted_Map;
    //---------------------------------------------------//

    static Text player_name_in_board;
    static Text player_score_in_board;

    public static Map<String, Float> ReadFromFile() throws FileNotFoundException, IOException {
        // creating LinkedHashMap for each level
        LinkedHashMap<String, Float> For_One_Level_Map = new LinkedHashMap<String, Float>() {
            @Override
            protected boolean removeEldestEntry(final Map.Entry eldest) {
                return size() > max_nPlayers;
            }
        };

        String name = null;

        Float value;
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(score.file));

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(":");
                level_number = Integer.valueOf(parts[1].trim());
                For_Whole_Levels.put(level_number, For_One_Level_Map);

                name = parts[0].trim();
                value = Float.valueOf(parts[2].trim());

                For_Whole_Levels.get(level_number).put(name, value);

            }

        } catch (IOException e) {
            //	e.printStackTrace();
        } finally {

            // close the BufferedReader
            if (br.readLine() == null) {
                try {
                    br.close();
                } catch (Exception e) {
                    System.out.println(" no   close");
                }
            }
        }

        return For_Whole_Levels.get(level_number);

    }

    public static Map<String, Float> sort_mapForEachLevel() throws FileNotFoundException, IOException {

        mapFromFile = ReadFromFile();

        return mapFromFile.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Float>comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }

    public static void Display_Rank() throws IOException {

        //  int x=350;
        // int y=250;
        show_score_pane.getChildren().clear();

        Get_Sorted_Map = sort_mapForEachLevel();

        Get_Sorted_Map.entrySet().stream().map((lhmap) -> {
            player_name_in_board = new Text();
            return lhmap;
        }).map((lhmap) -> {
            player_score_in_board = new Text();
            return lhmap;
        }).map((lhmap) -> {

            player_name_in_board.setId("text");
            return lhmap;
        }).map((lhmap) -> {
            player_score_in_board.setId("text");
            return lhmap;
        }).map((lhmap) -> {
            player_name_in_board.setText(lhmap.getKey());
            return lhmap;
        }).map((lhmap) -> {
            player_score_in_board.setText(lhmap.getValue().toString());
            return lhmap;
        }).map((lhmap) -> {
            //  y=y+70;
            show_score_pane.getChildren().addAll(player_name_in_board, player_score_in_board);
            return lhmap;
        }).forEach((lhmap) -> {
            // print it in console to check if it store data correctly or not 
            System.out.println("Key : " + lhmap.getKey()
                    + "\t\t" + "Value : " + lhmap.getValue());
        });

    }

}
