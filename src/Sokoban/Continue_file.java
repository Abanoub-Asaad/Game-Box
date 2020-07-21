/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokoban;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author egypt
 */
public class Continue_file {

    private static FileWriter writer;
    public static BufferedWriter bufferedWriter;
    private static String fileName = "C:\\Game-Box\\src\\Resources\\Sokoban\\continue_player.txt";
    private static FileReader filereader;
    private static BufferedReader bufferedReader;
    public static String thehieghtestlevel;

    public static void writenewlevel() throws IOException {
        if (Buttons.checknewgame) {
            System.err.println("new game mode ");
            if (Map.tmp_Level > Integer.parseInt(thehieghtestlevel)) {
                writer = new FileWriter(fileName);
                bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("");
                bufferedWriter.close();
                writer = new FileWriter(fileName, true);
                bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(start_level.PlayerName_string + "\n");
                for (int i = 1; i <= Map.tmp_Level; i++) {
                    bufferedWriter.write(i + "\n");
                }
                  bufferedWriter.close();

            }
        } else {
            if (Map.tmp_Level > Integer.parseInt(thehieghtestlevel)) {
                writer = new FileWriter(fileName, true);
                bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(String.valueOf(Map.tmp_Level + "\n"));
                bufferedWriter.close();
            }
        }
    }

    public static void getthehieghtestlevel() throws IOException {
        filereader = new FileReader(fileName);
        bufferedReader = new BufferedReader(filereader);
        String CLine;
        while ((CLine = bufferedReader.readLine()) != null) {
            thehieghtestlevel = CLine;
        }
                    System.err.println("new getthehieghtestlevel mode ");

    }
}
