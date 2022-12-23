package com.practice.designpatterns.behavioural.chainofresponsibility;

public class ChainOfResponsibiltyExample {

    public static void main(String[] args) {
        //File file = new File("text","/text");
        File file = new File("error","/error");

        AudioFileHandler audioFileHandler = new AudioFileHandler("audioFileHandler");
        TextHandler textHandler = new TextHandler("textHandler");

        audioFileHandler.setHandler(textHandler);

        audioFileHandler.process(file);
    }
}
