package com.company;

import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	// How do you print duplicate characters from a string?
        String myStr= "Test String";
        printDuplicateChar(myStr);

        // check if two strings are anagrams of each other
        myStr= "I am Lord Voldemort";
        String myStr2 = "Tom Marvolo Riddle";
        int control = checkAnagram(myStr,myStr2);

        //find all permutations of a string
        myStr="ABCD";
        printAllPermutations(myStr);

        //Check if string is palindrome
        myStr="aabbaa";
        control= checkPalindrome(myStr);
    }

    public static void printDuplicateChar(String myStr){
        myStr=myStr.toLowerCase(Locale.ROOT);
        char [] myCharString=myStr.toCharArray();
        for (int i=0;i< myCharString.length-1;i++){
            for(int j=i+1;j< myCharString.length;j++){
                if (myCharString[i]==myCharString[j]){
                    System.out.println("Character duplicated "+myCharString[i]);
                }
            }
        }
    }

    public static int checkAnagram(String myStr,String myStr2){
        myStr=myStr.toLowerCase(Locale.ROOT);
        myStr2=myStr2.toLowerCase(Locale.ROOT);
        //Remove whitespaces and spaces
        myStr=myStr.replaceAll("\\s+","");
        myStr2=myStr2.replaceAll("\\s+","");
        //Pass the strings to an array so it can be more manageable
        char [] myCharString=myStr.toCharArray();
        char [] myCharString2= myStr2.toCharArray();
        Arrays.sort(myCharString);
        Arrays.sort(myCharString2);
        //After sorting everything, both arrays  should be the same
        for (int i=0;i< myCharString.length;i++){
            if(myCharString[i]!=myCharString2[i]){
                System.out.println("They are not anagrams of each other");
                return -1;
            }
        }
        System.out.println("They are anagrams of each other");
        return 1;
    }

    public static void swap(char[] myStr,int x, int y){
        char aux=myStr[x];
        myStr[x]=myStr[y];
        myStr[y]=aux;
    }

    public static void permute(char [] myStr, int markerLeft,int markerRight){
        //Recursive version of Heaps algorithm
        //Done by continuous swapping which generates a tree with all possibility
        //In each level of the tree more characters are fixed while we continue swapping until reaching the end
        if (markerLeft==markerRight){
            System.out.println(myStr);
        }
        else{
            for (int i=markerLeft;i<markerRight;i++){
                swap(myStr,markerLeft,i);
                permute(myStr,markerLeft+1,markerRight);
                swap(myStr,markerLeft,i);

            }
        }

    }

    public static void printAllPermutations(String myStr){
        int markerRight=myStr.length();
        int markerLeft=0;
        char [] myCharStr=myStr.toCharArray();
        System.out.println("All the permutations are:");
        permute(myCharStr,markerLeft,markerRight);
    }

    public static int checkPalindrome(String myStr){
        char [] myCharStr= myStr.toCharArray();
        int j= myCharStr.length -1;
        for (int i=0;i< myCharStr.length/2;i++){
            if(myCharStr[i]!=myCharStr[j-i]){
                System.out.println("The string is not a palindrome");
                return -1;
            }
        }
        System.out.println("The String is a palindrome");
        return 1;
    }
}
