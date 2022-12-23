package com.practice.designpatterns.structural.facade;

public interface StartServer {

    void startBooting();
    void readSystemConfigFile();
    void init();
    void initializeContext();
    void initializeListeners();
    void createSystemObjects();
}
