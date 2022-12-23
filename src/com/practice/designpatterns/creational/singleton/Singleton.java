package com.practice.designpatterns.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

// Implemented using lazy loading
public class Singleton implements Cloneable, Serializable {

    private volatile static Singleton singleton = null;

    private Singleton(){
         if(singleton != null){
             throw new RuntimeException("Not Allowed");
         }
    }


    // synchronized is used because no 2 threads can try to create the Singleton resource at the same time
    // singleton == null check is placed before the synchronised block because after initial creation of object
    // every thread after that has to first take the lock and then get the object which is time consuming
    // After all this the approach is not full proof because creation of object is a 3 step process in any random order
    // Caution: Order is random
    // 1 --> Construct empty Singleton class with all variables as null
    // 2 --> Call the constructor and assign all variables their values
    // 3 --> Assign newly created object to singleton variable
    // if the 3rd step runs first then singleton variable is not null anymore
    // which mean the other threads will get an object which is empty with no initialization done
    // Hence to solve this problem we use volatile on Singleton instance variable. This will ensure all steps are run sequencially

    public static Singleton getInstance(){

        // This also called double check locking
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }

    public Object clone() throws CloneNotSupportedException
    {
        //return super.clone();
        throw new CloneNotSupportedException("");
    }

    // implement readResolve method
    protected Object readResolve()
    {
        return singleton;
    }
}

class Instance implements Runnable{

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());

//        for (int i=0 ; i<1000 ; i++){
//            Instance instance = new Instance();
//            Instance2 instance2 = new Instance2();
//            Thread t = new Thread(instance);
//            Thread t2 = new Thread(instance2);
//            t.start();
//            t2.start();
//        }

        //WAYS TO BREAK SINGLETON
        //1 ---- Cloning
        //override clone method and throw error

        if(false){

            Singleton clonedSingleton = (Singleton)singleton.clone();
            System.out.println("cloned singleton object hashcode "+clonedSingleton.hashCode());
        }

        //2 ---- Serialization
        /*
        Serialization is used to convert an object of byte stream and save in a file or send over a network.
        Suppose you serialize an object of a singleton class. Then if you de-serialize that object it
         will create a new instance and hence break the singleton pattern.
         */
         //Override read resolve method and return same instance
        ObjectOutput out
                = new ObjectOutputStream(new FileOutputStream("file.text"));
        out.writeObject(singleton1);
        out.close();

        // deserialize from file to object
        ObjectInput in
                = new ObjectInputStream(new FileInputStream("file.text"));
        Singleton instance2 = (Singleton) in.readObject();
        in.close();

        System.out.println("instance2 hashCode:- "
                + instance2.hashCode());

        /*
        Reflection: Reflection can be caused to destroy singleton property of singleton class, as shown in following example:

        to avoid this we should throw error from constructor
         */

        try
        {
            Constructor[] constructors =
                    Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors)
            {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instance2 = (Singleton) constructor.newInstance();
                break;
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Singleton singleton = Singleton.getInstance();
        System.out.println("Hash code of singleton class is "+singleton.hashCode()+" inside thread "+Thread.currentThread().getName());
    }
}

class Instance2 implements Runnable{

    @Override
    public void run() {
        Singleton singleton = Singleton.getInstance();
        System.out.println("Hash code of singleton class is "+singleton.hashCode()+" inside thread "+Thread.currentThread().getName());
    }
}