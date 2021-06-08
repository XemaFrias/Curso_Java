package com.company;

import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	// How do you print duplicate characters from a string?
        String myStr= "Test String";
        //printDuplicateChar(myStr);

        // check if two strings are anagrams of each other
        myStr= "I am Lord Voldemort";
        String myStr2 = "Tom Marvolo Riddle";
        int control = checkAnagram(myStr,myStr2);

        //find all permutations of a string
        myStr="ABCD";
        //printAllPermutations(myStr);

        //Check if string is palindrome
        myStr="aabbaa";
        //control= checkPalindrome(myStr);

        //Check if string contains only digits
        myStr="17485745 ";
        control=checkDigits(myStr);

        //Reverse words in a sentence
        myStr="Reverse words in a sentence";
        System.out.println(myStr);
        control=reverseWords(myStr);
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

    public static int checkDigits(String myStr){
        //We try to convert it to a double. If possible, we know it is a number
        try {
            double d = Double.parseDouble(myStr);
        } catch (NumberFormatException nfe) {
            System.out.println("String contains non digits");
            return -1;
        }
        System.out.println("String is a number");
        return 1;
    }

    public static int reverseWords(String myStr){
        char [] myCharStr=myStr.toCharArray();
        if (myCharStr.length<2){
            System.out.println("Not enough letters to reverse");
            return -1;
        }
        for (int i=0;i< myCharStr.length/2;i++) {
            swap(myCharStr, i, myCharStr.length - 1 - i);//Swap left to right to invert the whole sentence. Similar to what was used for checking palindrome
        }
        System.out.print("If we want full reversion: ");
        System.out.println(myCharStr);
        //We now reverse individual words
        int finishWord=0;
        for (int i=0;i< myCharStr.length;i++){
            //Each time we reach a blank space we reach the end of a word
            if(myCharStr[i]==' '){
                //We calculate the centre of the word
                int aux=(i-finishWord)/2;
                for (int j=finishWord;j<(i-aux);j++){
                    //We have to add finishWord to the top limit to take into account only that segment
                    swap(myCharStr,j, i-1-j+finishWord);
                }
                finishWord=i+1;
            }
        }
        //We also have to reverse the last word
        int aux=(myCharStr.length-finishWord)/2;
        for (int j=finishWord;j<(myCharStr.length-aux);j++){
            //We have to add finishWord to the top limit to take into account only that segment
            swap(myCharStr,j, myCharStr.length-1-j+finishWord);
        }
        System.out.print("If we only want to reverse the order of words: ");
        System.out.println(myCharStr);
        return 1;
    }
}
