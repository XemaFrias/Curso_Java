package com.company;


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
}
