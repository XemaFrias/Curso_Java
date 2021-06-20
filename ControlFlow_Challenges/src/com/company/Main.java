package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Find the sum of 5 numbers that are divisible by 5 and 3");
        System.out.println(ThreeAndFive());

        System.out.println("Sum all odd numbers from a beginning to and end point");
        System.out.println(sumOdd(4,768));

        System.out.println("Find the sum of the digits of a number");
        System.out.println(sumDigits(12345));
        System.out.println(sumDigits(-23));
        System.out.println(sumDigits(8));

        System.out.println("Find if a number is a palindrome");
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(17871));
        System.out.println(isPalindrome(11));
        System.out.println(isPalindrome(-78987));

        System.out.println("Find if 2 numbers share a Digit");
        System.out.println(hasSharedDigit(143,721));

       /* System.out.println("The user introduces 10 numbers and we add them");
        System.out.println("The result of the numbers is "+sum10());*/

        maxMinNumbers();

    }
    public static long ThreeAndFive(){
        int auxControl=0; //After 5 numbers have met the conditions inside the if in the loop
        long sum=0;
        for(int i=1;i<=1000;i++){
            if(i%3 ==0 && i%5 == 0){
                System.out.println("A Candidate NUmber is "+i);
                sum+=i;
                auxControl++;
            }
            if(auxControl==5){
                break;
            }
        }
        return sum;
    }

    public static boolean isOdd(long num){
        return num % 2 == 1;
    }

    public static long sumOdd(long begin, long end){
        if(begin>=end||begin<0){
            return -1;
        }
        long sum=0;
        for (long i=begin;i<=end;i++){
            if (isOdd(i)){
                sum+=i;
            }
        }
        return sum;
    }

    public static int sumDigits(int number){
        if (number<0){
            return -1;
        }
        //If number only has one digit we don't need to sum
        else if (number< 10){
            return number;
        }
        int sum=0;
        while (number>0){
            //Add least significant digit and pop it out
            sum+=number%10;
            number=number/10;
        }
        return sum;
    }

    public static boolean isPalindrome(int number){
        int reverse=0;
        int aux=number;
        while (aux!=0){
            reverse+=(aux%10);
            reverse*=10;
            aux=aux/10;
        }
        reverse/=10;
        return (reverse==number);
    }

    public static boolean hasSharedDigit (int num1, int num2){
        while (num1!=0){
            int digitsToCompare=num1%10;
            int auxNumber=num2;
            while(auxNumber!=0){
                if (digitsToCompare==auxNumber%10){
                    return true;
                }
                auxNumber/=10;
            }
            num1/=10;
        }
        return false;
    }

    public static int sum10(){
        Scanner scan= new Scanner(System.in);
        System.out.println("I'm going to ask you for 10 numbers");
        System.out.println(("If, at any time, one of your inputs is not a number, I will stop asking"));
        int result=0;
        int aux=0; //Useful for storing the numbers parse by the user
        boolean numChecker; //To check if the user is passing a number;
        for (int i=1; i<=10 ;i++){
            System.out.println("Enter number #"+i);
            numChecker= scan.hasNextInt();
            if (!numChecker){
                System.out.println("That last input wasn't a number. Exiting");
                return -1;
            }
            result+= scan.nextInt();
            scan.nextLine();
        }
        scan.close();
        return result;
    }

    public static void maxMinNumbers(){
        Scanner scan =new Scanner(System.in);
        int min=Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        int auxNum;
        while(true){
            System.out.println("Insert a New number");
            if(!scan.hasNextInt()){
                break;
            }
            auxNum=scan.nextInt();
            scan.nextLine();
            if(auxNum>max){
                max=auxNum;
            }
            if(auxNum<min){
                min=auxNum;
            }
        }
        scan.close();
        System.out.println("The maximum number was "+max+" and the minimum number was "+min);
    }

}
