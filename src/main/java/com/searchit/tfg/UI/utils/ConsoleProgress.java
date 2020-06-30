package com.searchit.tfg.UI.utils;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.text.SimpleDateFormat;

public class ConsoleProgress {


    String title = "";
    String progressBar;
    int startingLoopVal = 0;
    int loopLen = 0;
    int outputLength = 25;
    long startTime;
    long estdTime;
    private SimpleDateFormat hoursFormat = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat minutesFormat = new SimpleDateFormat("mm:ss");
    private SimpleDateFormat secondsFormat = new SimpleDateFormat("ss");


    public ConsoleProgress(String title, int outputLength){
        this.title=title;
        this.outputLength=outputLength;
    }
    public ConsoleProgress(){

    }

    public void start(int loopLen, int startingLoopVal){

        if(startingLoopVal==0){
            this.loopLen=loopLen-1;
        }
        String gap=" ";
        for(int i = 0; i < outputLength; i++){
            gap +=" ";
        }

        this.startingLoopVal=startingLoopVal;
        progressBar = title+"\t["+gap+"]";
        startTime = System.nanoTime();
        System.out.print(progressBar);
        System.out.print('\r');
    }

    public void addStep(int currentVal){
        int currentPosition = getCurrentStep(currentVal, loopLen);
        String progress = "";
        String progressLeft = "";
        int progressCounter = outputLength-currentPosition;
        for(int i=0;i<currentPosition;i++){
            progress += "=";
        }
        while(progressCounter>0){
            progressLeft += " ";
            progressCounter--;
        }
        long totalTime = (System.nanoTime() - startTime);
        progressBar = title+"\t["+progress+progressLeft+"]\t["+currentVal+"/"+loopLen+"]\t[PROCESSING]"+"\t[Estd :"+getElapsedTime(totalTime)+"/"+getEstdTime(totalTime,currentVal)+"]";
        progressLeft="";
        System.out.print(progressBar);
        System.out.print('\r');
    }

    public void addStep(int currentVal, String extraInfo){

        int currentPosition = getCurrentStep(currentVal, loopLen);
        String progress = "";
        String progressLeft = "";
        int progressCounter = outputLength-currentPosition;
        for(int i=0;i<currentPosition;i++){
            progress += "=";
        }
        while(progressCounter>0){
            progressLeft += " ";
            progressCounter--;
        }
        long totalTime = (System.nanoTime() - startTime);
        progressBar = title+"\t["+progress+progressLeft+"]\t["+currentVal+"/"+loopLen+"]\t[PROCESSING]"+"\t[Estd :"+getElapsedTime(totalTime)+"/"+getEstdTime(totalTime,currentVal)+"]\t["+extraInfo+"]";
        progressLeft="";
        System.out.print(progressBar);
        System.out.print('\r');
    }

    public void stop(){
        progressBar += "\n[COMPLETED]";
        System.out.println(progressBar);
    }

    public int getCurrentStep(int toConvert, int loopLen){
        return (int) Math.floor(((double) toConvert / (double) loopLen)*outputLength);
    }

    public String getElapsedTime(long difference){
        long microseconds = difference / 1000;
        long milliseconds = microseconds / 1000;
        long seconds = milliseconds / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        return getTimeFormat(hours,minutes,seconds,milliseconds);

    }

    public String getEstdTime(long difference, int currentLoopLen){
        long microseconds;
        if(currentLoopLen>0){
            microseconds = (difference*loopLen)/(currentLoopLen*1000);
        }
        else{
            microseconds = (difference*loopLen) / 1000;
        }

        long milliseconds = microseconds / 1000;
        long seconds = milliseconds / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        return getTimeFormat(hours,minutes,seconds,milliseconds);
    }

    public String getTimeFormat(long hours, long minutes, long seconds, long milliseconds){
        if(hours==0 && minutes >0){
            return minutesFormat.format(milliseconds);
        }
        if(hours>0){
            return hoursFormat.format(milliseconds);
        }
        if(minutes==0 && hours==0){
            return secondsFormat.format(milliseconds);
        }
        else{
            return hoursFormat.format(milliseconds);
        }
    }


}
