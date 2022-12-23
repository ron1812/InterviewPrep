package com.practice.exception;

import java.io.IOException;

public class TrickyException {

    public static void main(String[] args) throws Exception {
        try{
            System.out.println("Before Exception");
            throw new IOException();
            //System.out.println("After Exception");
        }
        catch (Exception e){
            System.out.println("Inside Exception");
            throw new Exception();
        }
//        catch (IOException x){
//            System.out.println("Inside IOException");
//        }
        finally {
            System.out.println("Finally");
        }
        //System.out.println("Outer Code");
    }
}
