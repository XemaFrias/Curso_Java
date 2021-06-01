package com.company;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arrayBase ={1,2,3,4,5};
	// How do you find the missing number in a given integer array of 1 to 100?
       int missing= findMissingNumber(arrayBase);
                //Test With missing number
       arrayBase= new int[]{1, 2, 3, 5, 6};
       missing=findMissingNumber(arrayBase);
                //Test with 0
        arrayBase= new int[]{};
        missing=findMissingNumber(arrayBase);

    //Remove duplicate Number on a given array
        arrayBase = new int[]{4, 5, 3, 4, 1, 2};
        int [] nonDuplicate=findDuplicateNumber(arrayBase);

    //Find Largest and Smallest number on unsorted array
        findSmallestLargestNumber(arrayBase);

    //Reverse an array in place
        System.out.println("We want to reverse the array:");
        printArray(arrayBase);
        reverseArray(arrayBase);


    }
    public static void printArray (int [] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("\n");
    }

    public static int findMissingNumber(int [] arrayBase){
        int arraySize= arrayBase.length;
        if (arraySize<=0){
            System.out.println("Array of size 0. Not valid");
            return -1;
        }
        for(int i=0;i<arraySize;i++){
            if(arrayBase[i]!=(i+1)){
                System.out.println("The missing number is "+(i+1));
                return (i+1);
            }
        }
        System.out.println("There are none missing numbers");
        return -1;
    }

    public static int [] findDuplicateNumber(int [] arrayBase){
        int arraySize= arrayBase.length;
        if (arraySize<=1) {
            System.out.println("Array of size 0. Not valid");
            return arrayBase;
        }
        //First we have to sort
        quicksort(arrayBase,0,arraySize-1); //Revisar implementación

        int auxArraySize=0; //We will use it as counter
        int []auxArray=new int [arraySize];

        for(int i=0;i<arraySize;i++){
            if(i==arraySize-1||arrayBase[i]!=arrayBase[i+1]){   //We copy only when they are different. The last one is always copied
                auxArray[auxArraySize]=arrayBase[i];
                auxArraySize++;
            }
        }
        arrayBase=new int[auxArraySize];
        System.out.print("The final array is ");
        for (int i=0;i<auxArraySize;i++){
            arrayBase[i]=auxArray[i];
        }
        printArray(arrayBase);
        return arrayBase;
    }
    public static void quicksort(int []A, int izq, int der) {

        int pivote=A[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i < j){                          // mientras no se crucen las búsquedas
            while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while(A[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux= A[i];                      // los intercambia
                A[i]=A[j];
                A[j]=aux;
            }
        }

        A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos
        A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            quicksort(A,izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quicksort(A,j+1,der);          // ordenamos subarray derecho

    }

    public static void findSmallestLargestNumber(int [] arr){
        int arraySize= arr.length;
        if (arraySize<=0){
            System.out.println("Array of size 0. Not valid");
        }
        else{
            int max=arr[0],min=arr[0];
            for (int i=0; i<arraySize;i++){
                if (arr[i]>max){
                        max=arr[i];
                    }
                if (arr[i]<min){
                    min=arr[i];
                }
            }
            System.out.print("For the array ");
            printArray(arr);
            System.out.println("The maximum number is "+max+" and the minimum number is "+min);
        }

    }

    public static void reverseArray(int []arr){
        int arraySize= arr.length;
        if (arraySize<=0){
            System.out.println("Array of size 0. Not valid");
        }
        else{
            int swap=0;
            int topBound=arraySize-1;
            for (int i=0; i<arraySize/2;i++){
                swap=arr[i];
                arr[i]=arr[topBound-i];
                arr[topBound-i]=swap;
            }
            printArray(arr);
        }
    }
}
