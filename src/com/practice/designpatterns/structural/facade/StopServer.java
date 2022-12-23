package com.practice.designpatterns.structural.facade;

public interface StopServer {

    void releaseProcesses();
    void destory();
    void destroySystemObjects();
    void destoryListeners();
    void destoryContext();
    void shutdown();
}
