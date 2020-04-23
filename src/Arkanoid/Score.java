/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkanoid;

import GameLoop.BaseClass;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author egypt
 */
public class Score {

//    HashMap<String, Integer> map = new HashMap<>();
    private List<Map.Entry<String, Integer>> list;
    private HashMap<String, Integer> hm = new HashMap<String, Integer>();

    private Scanner scanner;
    private Iterator iterator;

    private Scene ScoreBorad_scene;
    private Pane pane_scoreBoard;

    public int current_score = 0;
    private Text score_text = new Text();
    private Text score = new Text();
    private Text level = new Text();
    private Text level_text = new Text();

    private Text name_infile = new Text();
    private Text score_infile = new Text();
    private Text lives_txt = new Text();
    private String string;
     
    public Score() {
        SetScoreText();
        ArkanoidMain.root.getChildren().addAll(score_text, level_text, score, level);
    }

    private void SetScoreText() {

        level.setX(350);
        level.setY(40);
        level.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 25));
        level.setFill(Color.RED);// setting colour of the text to blue   
        level.setStroke(Color.CYAN); // setting the stroke for the text    
        level.setText("LEVEL :  ");

        level_text.setX(450);
        level_text.setY(40);
        level_text.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 25));
        level_text.setFill(Color.RED);// setting colour of the text to blue   
        level_text.setStroke(Color.CYAN); // setting the stroke for the text    
        level_text.setText(Integer.toString(Arkanoid_Map.level));

        score.setX(70);
        score.setY(40);
        score.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 25));
        score.setFill(Color.RED);// setting colour of the text to blue   
        score.setStroke(Color.CYAN); // setting the stroke for the text    
        score.setText("SCORE : ");

        score_text.setX(170);
        score_text.setY(40);
        score_text.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 25));
        score_text.setFill(Color.RED);// setting colour of the text to blue   
        score_text.setStroke(Color.CYAN); // setting the stroke for the text    
        score_text.setText(Integer.toString(current_score));

        lives_txt.setX(940);
        lives_txt.setY(40);
        lives_txt.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 25));
        lives_txt.setFill(Color.RED);// setting colour of the text to blue   
        lives_txt.setStroke(Color.CYAN); // setting the stroke for the text    
        lives_txt.setText("LIVES : ");

    }

    public void SetScore(int value) {

        switch (value) {
            case 1:
                current_score += 20;
                break;
            case 2:
                current_score += 70;
                break;
            case 3:
                current_score += 120;
                break;
            case 4:
                current_score += 220;
                break;
            case 5:
                current_score += 500;
                break;
            default:
                current_score = 0;
                break;
        }
        score_text.setText(Integer.toString(current_score));
    }

    public void score(Stage Arkanoid_stage) throws IOException {
        pane_scoreBoard = new Pane();
        ScoreBorad_scene = new Scene(pane_scoreBoard);

        Image ScoreBoardBack_img = new Image("Resources/Arkanoid/bscore.jpg", 1400, 780, false, true);
        ImageView ScoreBoardBack_iv = new ImageView(ScoreBoardBack_img);
        pane_scoreBoard.getChildren().add(ScoreBoardBack_iv);

        ReadFromFile();

        BaseClass.check_Escape(ScoreBorad_scene, Arkanoid_stage, Menu.sceneButtons);
        
        Arkanoid_stage.setTitle("Arkanoid");
        Arkanoid_stage.setScene(ScoreBorad_scene);

    }

    public void ReadFromFile() throws FileNotFoundException, IOException {
        
        BufferedReader br = new BufferedReader(new FileReader(PlayerNameFile.getFile()));

        int i = 1;

        while ((string = br.readLine()) != null) {
            name_infile = new Text();
            score_infile = new Text();
            if (i % 2 != 0) {
                name_infile.setX(350);
                name_infile.setY(200 + ((i + 1) / 2) * 40);
                name_infile.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 35));
                name_infile.setFill(Color.CHOCOLATE);// setting colour of the text to blue    
                name_infile.setText(string);
                pane_scoreBoard.getChildren().add(name_infile);
            } else {
                score_infile.setX(960);
                score_infile.setY(200 + (i / 2) * 40);
                score_infile.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 35));
                score_infile.setFill(Color.CHOCOLATE);// setting colour of the text to blue    
                score_infile.setText(string);
                pane_scoreBoard.getChildren().add(score_infile);
            }

            ++i;
            System.out.println(string);
        }
    }

    public void WriteScoreInFile() throws IOException {
        
        FileWriter filewriter = new FileWriter(PlayerNameFile.getFile(), true);
        BufferedWriter bufferwriter = new BufferedWriter(filewriter);

        try {
            bufferwriter.write(current_score + "\n");
            bufferwriter.close();
            System.out.println("Success");
        } catch (IOException ex) {
            System.out.println("NOT Success");
        }

        scanner = new Scanner(PlayerNameFile.getFile());
        while (scanner.hasNext()) {
            String name = scanner.next();
            System.out.print("name" + name + "\n");
            int score = scanner.nextInt();
            System.out.print("score " + score + "\n");
            hm.put(name, score);
        }
        Map<String, Integer> hm1 = sortByValue(hm);

        try {
            filewriter = new FileWriter(PlayerNameFile.getFile());
            bufferwriter = new BufferedWriter(filewriter);
            bufferwriter.write(" ");
            bufferwriter.close();
            filewriter = new FileWriter(PlayerNameFile.getFile());
            bufferwriter = new BufferedWriter(filewriter);
            for (Map.Entry<String, Integer> en : hm1.entrySet()) {
                bufferwriter.write(en.getKey()
                        + "\n" + en.getValue() + "\n");
            }
            bufferwriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer>> list
                = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                    Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}
