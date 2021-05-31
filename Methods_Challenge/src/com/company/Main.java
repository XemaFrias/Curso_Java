package com.company;

public class Main {

    public static void main(String[] args) {
	boolean GameOver=true;
	int score=800;
	int levelCompleted=5;
	int bonus=100;

	int HighScore= calculateScore(GameOver,score,levelCompleted,bonus);
	System.out.println("The Score was "+HighScore);

	score=10000;
	levelCompleted=8;
	bonus=200;
    HighScore= calculateScore(GameOver,score,levelCompleted,bonus);
    System.out.println("The Score was "+HighScore);

    int HighScorePosition= calculateHighScorePosition(1500);
    displayHighPosition("Tim",HighScorePosition);

    }

    public static int calculateScore(boolean GameOver, int score, int levelCompleted, int bonus){
        if(GameOver){
        	return(score+ levelCompleted*bonus);
		}
        return -1;
    }

    public static void displayHighPosition(String Name,int position){
		System.out.println(Name+" managed to get in the position "+position+" in the highscore table");
	}
	public static int calculateHighScorePosition(int score){
    	int position=4;
    	if (score>=1000) position=  1;
    	else if (score>=500 ) position=   2;
    	else if (score >= 100) position=   3;
    	return position;
	}
	//Following methods for Challenge number 2 convert form Km/h to mi/h
	public static long toMilesPerHour(double kilometersPerHour){
		if(kilometersPerHour<0){
			return -1;
		}
		double miles=kilometersPerHour/1.609;
		return Math.round(miles);
	}
	public static void printConversion (double kilometersPerHour){
		if(kilometersPerHour<0) System.out.println("Invalid Value");
		else System.out.println(kilometersPerHour+" km/h = "+(toMilesPerHour(kilometersPerHour))+ " mi/h");
		}
	//Challenge to print MegaBytes and KiloBytes
	public static void printMegaBytesAndKiloBytes(int kiloBytes){
    	if (kiloBytes<0) System.out.println("Invalid Value");
    	else System.out.println(kiloBytes+" KB = "+kiloBytes/1024+" MB and "+kiloBytes%1024+" KB");
	}

	//Challenge to know if year is leap year
	public static boolean isLeapYear (int year){
		if (year<1 || year> 9999)return false;
		else if (year%400==0)return true; 					//If year is divisible by 400 it is leap year
		else if (year%100==0 && year%400!=0)return false; //If year is divisible by 100 BUT NOT 400 is not leap Year
		else return (year % 4) == 0;					//If year is divisible by 4 and fulfills previous conditions, is leap year
	}

	//Challenge to compare 2 numbers up to 3 decimal places
	public static boolean areEqualByThreeDecimalPlaces(double num1,double num2){
    	int IntNum1=(int)(num1*1000);
		int IntNum2=(int)(num2*1000);
    	return  ((IntNum1-IntNum2)==0);
	}

	//Challenge to see if first 2 parameters equal the last one
	public static boolean hasEqualSum(int num1, int num2, int num3){
    	return (num1+num2)==num3;
	}
}
