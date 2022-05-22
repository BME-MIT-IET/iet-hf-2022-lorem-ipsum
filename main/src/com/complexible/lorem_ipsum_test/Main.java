package com.complexible.lorem_ipsum_test;

import com.complexible.pinto.RDFMapper;
import org.openrdf.model.Graph;

import java.awt.*;

@java.lang.SuppressWarnings("all")
public class Main {

    public static void main(String args[]){
        Graph aGraph = null;

        String phoneNumber =
        long startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
            aGraph = RDFMapper.create().writeValue(new Person());
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        System.out.println("Zero attribute: " + estimatedTime);

        startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
             aGraph = RDFMapper.create().writeValue(new Person("Michael Grove"));
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        System.out.println("One attribute: " + estimatedTime);

        startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
            aGraph = RDFMapper.create().writeValue(new Person("Michael Grove", "Tokyo"));
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        System.out.println("Two attribute: " + estimatedTime);

        startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
            aGraph = RDFMapper.create().writeValue(new Person("Michael Grove", "Tokyo", "06303072443"));
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        System.out.println("Three attribute: " + estimatedTime);

        startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
            aGraph = RDFMapper.create().writeValue(new Person("Michael Grove", "Tokyo", "06303072443", new Car("Ford")));
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        System.out.println("Three attribute + object with on attribute: " + estimatedTime);

        startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
            aGraph = RDFMapper.create().writeValue(new Person("Michael Grove", "Tokyo", "06303072443", new Car("Ford", "JMU-020")));
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        System.out.println("Three attribute + object with two attribute: " + estimatedTime);

        startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
            aGraph = RDFMapper.create().writeValue(new Person("Michael Grove", "Tokyo", "06303072443", new Car("Ford", "JMU-020", Color.RED)));
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        System.out.println("Three attribute + object with three attribute: " + estimatedTime);
    }
}
