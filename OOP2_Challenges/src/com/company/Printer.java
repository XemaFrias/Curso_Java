package com.company;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean isDuplexPrinter=false;

    public Printer(int tonerLevel, int pagesPrinted, boolean isDuplexPrinter) {
        this.tonerLevel = tonerLevel;
        this.pagesPrinted = pagesPrinted;
        this.isDuplexPrinter = isDuplexPrinter;
    }

    public Printer() {
        this(100,0,false);
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplexPrinter() {
        return isDuplexPrinter;
    }



    public void fillToner (int quantity){
        this.tonerLevel+=quantity;
        if (this.tonerLevel>=100){
            this.tonerLevel=100;
            System.out.println("Printer is full");
        }
    }

    public void print (int numPages){
        if (this.isDuplexPrinter){
            numPages= numPages/2;
        }
        if (this.tonerLevel-numPages>=0){
            this.tonerLevel-=numPages;
            this.pagesPrinted+=numPages;
            System.out.println(numPages+ " pages have been printed");
        }
        else{
            System.out.println("Not enough ink");
        }
    }

}
