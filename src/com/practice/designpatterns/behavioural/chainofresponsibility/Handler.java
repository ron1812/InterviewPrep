package com.practice.designpatterns.behavioural.chainofresponsibility;

public interface Handler {

    void setHandler(Handler handler);
    void process(File file);
    String getHandlerName();
}
