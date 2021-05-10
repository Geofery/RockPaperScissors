package com.company;

public class Human implements Player {
  private Ui ui = new Ui();
  private int points;
  private String name;

  @Override
  public String takeTurn() {
    String playerChoice;
    int playerMove = ui.getScanInt();
    playerChoice = "7";
    if (playerMove == 1) {
      playerChoice = gameChoice.Rock.toString();
    } else if (playerMove == 2) {
      playerChoice = gameChoice.Paper.toString();
    } else if (playerMove == 3) {
      playerChoice = gameChoice.Scissors.toString();
    } else if (playerMove == 4) {
      playerChoice = "4";
    } else if (playerMove == 9) {
      playerChoice = "9";
    } else
      ui.errorRed("");
    return playerChoice;
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
    this.name = ui.getString();
  }
}
