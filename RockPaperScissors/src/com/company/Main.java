package com.company;

public class Main {

    public static void main(String[] args)  {
	      new Main().run();
        //Controller contol = new Controller(new AiPlayer(), new AiPlayer());
        //contol.demo();
    }

    private void run() {
        Controller contol = new Controller(new AiPlayer(), new Human());
        contol.run();
    }
}

