package com.company;

public class Main {

    public static void main(String[] args) {
	double myDouble= 20.00;
	double myBigDouble=80.00;
	double DoubleTotal= 100.00*(myBigDouble+myDouble);
	DoubleTotal= DoubleTotal%40.00;
	boolean PerfectReminder= DoubleTotal == 0;
	System.out.println(PerfectReminder);
    if(!PerfectReminder){
        System.out.println("Got Some Reminder");
    }

    }
}
