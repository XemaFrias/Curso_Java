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
}
