package com.complexible.lorem_ipsum_test;

import com.complexible.pinto.RDFMapper;
import org.openrdf.model.Graph;

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
        System.out.println("Three attribute + object: " + estimatedTime);

        /*Iterator<Statement> it = aGraph.iterator();
        Statement element = it.next();

        System.out.print(StatementResult.getSubject(element) + " " + StatementResult.getPredicate(element) + " " + StatementResult.getObject(element));*/
    }
}
