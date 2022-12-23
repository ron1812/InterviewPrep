package com.practice.designpatterns.behavioural.chainofresponsibility;

public class TextHandler implements Handler{

    private Handler nextHandler;
    private String handlerName;

    public TextHandler(String handlerName){
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {

    }

    @Override
    public void process(File file) {
        if("text".equalsIgnoreCase(file.getFileType())){
            System.out.println("Process and saving text file... by "+handlerName);
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
