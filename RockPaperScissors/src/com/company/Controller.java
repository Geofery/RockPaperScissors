package com.company;

public class Controller {
  private Ui ui = new Ui();
  private FileHandler fileHandler = new FileHandler();
  private Player aiPlayer;
  private Player human;

  public Controller(Player aiPlayer, Player human) {
    this.aiPlayer = aiPlayer;
    this.human = human;
  }

  public String getComputerChoice() {
    String computerMove = aiPlayer.takeTurn();
    return computerMove;
  }

  public int getPlayerChoice() {
    String playerChoice1 = human.takeTurn();
    int choice = -1;
    if (playerChoice1.equals("Rock")) {
      choice = 1;
    } else if (playerChoice1.equals("Paper")) {
      choice = 2;
    } else if (playerChoice1.equals("Scissors")) {
      choice = 3;
    } else if (playerChoice1.equals("4")) {
      choice = 4;
    } else if (playerChoice1.equals("9")) {
      choice = 9;
    } else
      ui.errorRed("Invalid input");
    return choice;
  }

  public void run() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.showMainMenu();
      choice = ui.getScanInt();
      switch (choice) {
        case 1:
          newGame();
          break;
        case 2:
          showLeaderboard();
          break;
        case 9:
          ui.displayGreen("Saving your high score.....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("Still saving....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("System error!");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.errorRed("F40");
          ui.displayGreen("Thanks for playing! :D");


          keepRunning = false;
      }
    } while (keepRunning);
  }

  private void showLeaderboard() {
    fileHandler.loadScores();
  }

  public void newGame() {
    ui.display("Please write your name for the leaderboard");
    human.setName();
    ui.displayGreen("\nYour opponent today is, " + aiPlayer.getName() + " the AI\n");
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.showNewGameMenu();
      choice = getPlayerChoice();
      switch (choice) {
        case 1:
          rock();
          break;
        case 2:
          paper();
          break;
        case 3:
          scissors();
          break;
        case 4:
          showScore();
          break;
        case 9:
          ui.displayGreen("Thanks for playing!");
          ui.display("");
          fileHandler.saveScore(human.getName(), human.getPoints());
          keepRunning = false;
      }
    } while (keepRunning);
  }

  public void showScore() {
    ui.display("______________________");
    ui.displayGreen("        SCORE");
    ui.displayGreen("\nYour score: " + human.getPoints());
    ui.displayGreen("Jarvis score: " + aiPlayer.getPoints() + "\n");
    ui.display("______________________");
  }

  public void rock() {
    ui.display("______________________");
    ui.displayGreen(human.getName() + " chose: Rock");

    if (getComputerChoice().equals("Paper")) {
      ui.displayGreen(aiPlayer.getName() + " chose: Paper.");
      ui.errorRed("\nYou Loose!");
      aiPlayer.setPoints();
      human.resetScore();
      ui.display("______________________");
    } else if (getComputerChoice().equals("Rock")) {
      ui.displayGreen(aiPlayer.getName() + " chose: Rock.");
      ui.displayGreen("\nIts a tie!");
      ui.display("______________________");
    } else {
      ui.displayGreen(aiPlayer.getName() + " chose: Scissors.");
      ui.displayGreen("\nYou win!");
      human.setPoints();
      aiPlayer.resetScore();
      ui.display("______________________");
    }
  }

  public void paper() {
    ui.display("______________________");
    ui.displayGreen(human.getName() + " chose: Paper");

    if (getComputerChoice().equals("Paper")) {
      ui.displayGreen(aiPlayer.getName() + " chose: Paper.");
      ui.displayGreen("\nIts a tie!");
      ui.display("______________________");
    } else if (getComputerChoice().equals("Rock")) {
      ui.displayGreen(aiPlayer.getName() + " chose: Rock.");
      ui.displayGreen("\nYou win!");
      human.setPoints();
      aiPlayer.resetScore();
      ui.display("______________________");
    } else {
      ui.displayGreen(aiPlayer.getName() + " chose: Scissors.");
      ui.errorRed("\nYou Loose!");
      aiPlayer.setPoints();
      human.resetScore();
      ui.display("______________________");
    }
  }

  public void scissors() {
    ui.display("______________________");
    ui.displayGreen(human.getName() + " chose: Scissors");

    if (getComputerChoice().equals("Paper")) {
      ui.displayGreen(aiPlayer.getName() + " chose: Paper.");
      ui.displayGreen("\nYou win!");
      human.setPoints();
      aiPlayer.resetScore();
      ui.display("______________________");
    } else if (getComputerChoice().equals("Rock")) {
      ui.displayGreen(aiPlayer.getName() + " chose: Rock.");
      ui.errorRed("\nYou Loose!");
      aiPlayer.setPoints();
      human.resetScore();
      ui.display("______________________");
    } else {
      ui.displayGreen(aiPlayer.getName() + " chose: Scissors.");
      ui.displayGreen("\nIts a tie!");
      ui.display("______________________");
    }
  }
}