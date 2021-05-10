package com.company;

public class HighScore implements Comparable<HighScore> {
  private String name;
  private int streak;

  public HighScore(String name, int streak) {
    this.name = name;
    this.streak = streak;
  }

  @Override
  public String toString() {
    return name + " " + streak;
  }

  public int getStreak() {
    return streak;
  }

  @Override
  public int compareTo(HighScore o) {
    int value;
    if (o.getStreak() > streak)
     value = 1;
    else if (o.getStreak() < streak)
      value = -1;
    else
      value = 0;
    return value;
  }
}
