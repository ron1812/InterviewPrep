package com.practice.designpatterns.behavioural.chainofresponsibility;

public class File {

    private String fileType;
    private String filePath;

    public File(String fileType, String filePath) {
        this.fileType = fileType;
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
