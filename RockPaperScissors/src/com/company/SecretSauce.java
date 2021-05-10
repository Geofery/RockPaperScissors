package com.company;
import java.util.Timer;
import java.util.TimerTask;

public class SecretSauce {
  Timer timer;
  Ui ui = new Ui();

    public SecretSauce(int seconds) {
      timer = new Timer();
      timer.schedule(new RemindTask(), seconds*1000);
    }

    class RemindTask extends TimerTask {
      public void run() {


        timer.cancel();

      }
    }
  }
