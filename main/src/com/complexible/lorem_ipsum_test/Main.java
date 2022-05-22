package com.complexible.lorem_ipsum_test;

import com.complexible.pinto.RDFMapper;
import org.openrdf.model.Graph;

import java.awt.*;

public class Main {

    public static void main(String args[]){
        Graph aGraph = null;

        long startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
            aGraph = RDFMapper.create().writeValue(new Person());
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        //System.err.println("Zero attribute: " + estimatedTime);

        startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
             aGraph = RDFMapper.create().writeValue(new Person("Michael Grove"));
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        //System.err.println("One attribute: " + estimatedTime);

        startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
            aGraph = RDFMapper.create().writeValue(new Person("Michael Grove", "Tokyo"));
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        // System.err.println("Two attribute: " + estimatedTime);

        startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
            aGraph = RDFMapper.create().writeValue(new Person("Michael Grove", "Tokyo", "0630303"));
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        //System.err.println("Three attribute: " + estimatedTime);

        startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
            aGraph = RDFMapper.create().writeValue(new Person("Michael Grove", "Tokyo", "06372443", new Car("Ford")));
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        //System.err.println("Three attribute + object with on attribute: " + estimatedTime);

        startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
            aGraph = RDFMapper.create().writeValue(new Person("Michael Grove", "Tokyo", "063030723", new Car("Ford", "JMU-020")));
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        // System.err.println("Three attribute + object with two attribute: " + estimatedTime);

        startTime = System.currentTimeMillis();
        //Measuring time below
        for(int i = 0; i < 1000000; i++) {
            aGraph = RDFMapper.create().writeValue(new Person("Michael Grove", "Tokyo", "0630307", new Car("Ford", "JMU-020", Color.RED)));
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        //Print out measured time
        // System.err.println("Three attribute + object with three attribute: " + estimatedTime);

    }
}
