package com.practice.designpatterns.behavioural.chainofresponsibility;

public class AudioFileHandler implements Handler {

    private Handler nextHandler;
    private String handlerName;

    public AudioFileHandler(String handlerName){
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void process(File file) {
        if("audio".equalsIgnoreCase(file.getFileType())){
            System.out.println("Process and saving audio file... by "+handlerName);
        }else if (nextHandler != null){
            System.out.println(handlerName+" fowards request to "+nextHandler.getHandlerName());
            nextHandler.process(file);
        } else {
            System.out.println("File not supported");
        }
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}