package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMENTS = 100_000;

    private UseListsAndMaps() {
    }

    public static void main(final String... s) {
        final List<Integer> a = new ArrayList<>();
        for(int i = 1000; i < 2000; i++){
            a.add(i);
        }
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        final List<Integer> l = new LinkedList<>(a);
        System.out.println("Print linked list: " + l);
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        final int last = a.getLast();
        a.set(a.size() - 1, last);
        a.set(0, a.getFirst());  
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        StringBuilder sb = new StringBuilder("Print swapped list: [");
        for(final int i : a){
            sb.append(i).append(", ");       
        }
        sb.append("]");
        System.out.println(sb);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        long time1 = System.nanoTime();
        for(int i = 0; i < ELEMENTS; i++){
            a.addFirst(i);
        }
        time1 = System.nanoTime() - time1;
        final var millis1 = TimeUnit.NANOSECONDS.toMillis(time1);      
        System.out.println("Converting " + ELEMENTS + " elements into ArrayList in: " + time1 + "ns (" + millis1 + "ms)");   
        
        long time2 = System.nanoTime();
        for(int i = 0; i< ELEMENTS; i++){
            l.addFirst(i);
        }
        time2 = System.nanoTime() - time2;
        final var millis2 = TimeUnit.NANOSECONDS.toMillis(time2);      
        System.out.println("Converting " + ELEMENTS + " elements into LinkedList in: " + time2 + "ns (" + millis2 + "ms)");   
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        long time3 = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            a.get(a.size() / 2 );
        }
        time3 = System.nanoTime() - time3;
        final var millis3 = TimeUnit.NANOSECONDS.toMillis(time3);      
        System.out.println("Reading 1000 elements in the middle of ArrayList in: " + time3 + "ns (" + millis3 + "ms)");   
         
        long time4 = System.nanoTime();
        for(int i = 0; i< 1000; i++){
             l.get(l.size() / 2);
        }
        time4 = System.nanoTime() - time4;
        final var millis4 = TimeUnit.NANOSECONDS.toMillis(time4);      
        System.out.println("Reading 1000 elements in the middle of LinkedList in: " + time4 + "ns (" + millis4 + "ms)");   
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        final Map<String, Long> continentsPopulation = new HashMap<>();
        continentsPopulation.put("Africa ", 1_110_635_000L);
        continentsPopulation.put("Americas", 972_005_000L);
        continentsPopulation.put("Antartica", 0L);
        continentsPopulation.put("Asia", 4_298_723_000L);
        continentsPopulation.put("Europe", 742_452_000L);
        continentsPopulation.put("Oceania", 38_304_000L);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        long totalPopulation = 0;
        for(final long population : continentsPopulation.values()){
            totalPopulation = totalPopulation + population;
        }
        System.out.println("The world population is " + totalPopulation + " people");
        /*
         * 8) Compute the population of the world
         */
    }
}
