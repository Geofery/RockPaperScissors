package com.company;

import java.util.Random;

public class AiPlayer implements Player {
  private int points;
  private String name = "Jarvis";

  @Override
  public String takeTurn() {
    String[] rps = {"Rock", "Paper", "Scissors" };
    String computerMove = rps[new Random().nextInt(rps.length)];
    return computerMove;
  }

  @Override
  public int resetScore() {
    return points = 0;
  }

  @Override
  public int getPoints() {
    return points;
  }

  @Override
  public int setPoints() {
    return points++;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName() {
    this.name = "Jarvis";
  }
}
