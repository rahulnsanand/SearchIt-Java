package com.searchit.tfg.UI.utils;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class ConsoleProgress {


    String title = "";
    String progressBar;
    int startingLoopVal = 0;
    int loopLen = 0;
    static int outputLength = 25;

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
        this.startingLoopVal=startingLoopVal;
        progressBar = title+"\t[          ]";
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

        progressBar = title+"\t["+progress+progressLeft+"]\t["+currentVal+"/"+loopLen+"]\t[PROCESSING]";
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
        progressBar = title+"\t["+progress+progressLeft+"]\t["+currentVal+"/"+loopLen+"]\t["+extraInfo+"]";
        progressLeft="";
        System.out.print(progressBar);
        System.out.print('\r');
    }

    public void stop(){
        progressBar += "\n[COMPLETED]";
        System.out.println(progressBar);
    }

    public static int getCurrentStep(int toConvert, int loopLen){
        return (int) Math.floor(((double) toConvert / (double) loopLen)*outputLength);
    }
}
