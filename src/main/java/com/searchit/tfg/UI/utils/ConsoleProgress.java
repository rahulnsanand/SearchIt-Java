package com.searchit.tfg.UI.utils;

public class ConsoleProgress {

    int stop = 100;
    int start = 0;
    String title = "";
    String extraInfo = "";
    String progressBar;

    public ConsoleProgress(int start, int stop, String title){
        this.start=start;
        this.stop=stop;
        this.title=title;

    }
    public void start(){
        progressBar = title+"\t|";
        System.out.print(progressBar);
        System.out.print('\r');
    }

    public void addStep(){
        progressBar += "=";
        System.out.print(progressBar);
        System.out.print('\r');
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        progressBar += "|";
        System.out.println(progressBar);
    }
}
