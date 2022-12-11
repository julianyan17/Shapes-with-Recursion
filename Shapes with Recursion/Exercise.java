/**
 * Author: Julian Wai San Yan
 * Date: 1/26/19
 * File: Exercise.java
 */

/** 
 * Included below are methods that sum an
 * entire Integer list, finds the average of an Interget list and converts a 
 * String into a Character list.
 */

import java.util.*;

/**
 * The Exercise class includes 3 methods that all utilize recursion. There is
 * a method to add up all the numbers in an Integer list, find the average of
 * numbers in an Integer list and convert a String into a Character list.
 */

public class Exercise {

    /** 
     * Adds up all the numbers in an Integer list
     *
     * @param list list of Integers
     * @return     the sum of the Integers in the list
     */

    public static Integer sumList(ArrayList<Integer> list){
        if(list == null || list.isEmpty() == true) {
            return null;
        }

        // base case: return the Integer if length of list is 1
        if(list.size() == 1) {
            return list.get(0);
        }

        // recursion: add the first element in Integer list and create a
        //            subList without the first element
        int sum = list.get(0) + sumList(new ArrayList<Integer>(list.subList(1, 
                  list.size())));
        Integer finalSum = sum;
        return finalSum;
    }
    
    /**
     * Finds the average of an Integer list
     *
     * @param list list of Integers
     * @return     the average of the Integers in the list
     */

    public static Double findAverage(ArrayList<Integer> list){

        if(list == null || list.isEmpty() == true) {
            return null;
        }
        
        // base case: return the Integer as a Double if length of list is 1
        if(list.size() == 1) {
            Integer last = list.get(0);
            Double lastDouble = last.doubleValue();
            return lastDouble;
        }
        
        // recursion: find the average using the formula (n*m + x)/(n-1) with
        //            n = size of list, m = average of list n, x = next value
        //            in list
        double sum = (double)(list.size() - 1) * 
                      findAverage(new ArrayList<Integer>
                      (list.subList(1, list.size()))) 
                       + (list.get(0)).doubleValue();
        double average = sum/(list.size());

        Double finalAverage = average;
        return finalAverage;
    }
    
    /** 
     * Converts a String into a Character list
     *
     * @param word string to convert into a Character list
     * @return     list of the String with every letter as one Character
     */

    public static ArrayList<Character> strToList(String word){

        ArrayList<Character> stringList = new ArrayList<Character>();

        if(word == null) {
            return null;
        }

        if(word.isEmpty() == true) {
            return stringList; 
        }
        
        // base case: if length of String is 1, return the String as a char
        if(word.length() == 1) {
            stringList.add(word.charAt(0));
            return stringList;
        }
        
        // recursion: create a substring of the word starting with the first
        //            letter and ending at the 2nd to last letter
        stringList = strToList(word.substring(0, word.length() - 1));
        // add the last letter from the String to the Character list
        stringList.add(word.charAt(word.length() - 1));        
        return stringList;
    } 
}
