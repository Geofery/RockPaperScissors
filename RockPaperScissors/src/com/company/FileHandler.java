package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileHandler {
  Ui ui = new Ui();
  File file = new File("Leaderboard.txt");
  private String name;
  private int score;
  private ArrayList<Human> scores;

  public void saveScore(String name, int points) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(file, true);
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("test");
    }
    BufferedWriter bw = new BufferedWriter(fw);
    try {
      bw.write(name.replaceAll("\\[", "").replaceAll("]", "")
       .replaceAll(",", "") + " " + points );
      bw.newLine();
      bw.close();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("test2");
    }
  }

  public void loadScores()  {
    ArrayList<HighScore> scores = new ArrayList<>();
    Scanner fileReader = null;
    try {
      fileReader = new Scanner(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ui.displayGreen("Name   Win streak ");
    ui.display("______________________");


    while (fileReader.hasNext()) {
      name = fileReader.next();
      score = fileReader.nextInt();
      HighScore highScore = new HighScore(name, score);
      scores.add(highScore);
    }
    if (scores.size() == 0){
      ui.errorRed("Leaderboard is empty!");
    }else{
      Collections.sort(scores);
      for (int i = 0; i < scores.size(); i++) {
        ui.displayGreen(scores.get(i).toString());
      }
    }
    ui.display("______________________");
  }
}