package com.company;

public class Hamburguer {
    private String bread;
    private String meat;
    private Ingredient [] additions= new Ingredient[4];
    private int price;
    private int numIngredients=0;

    public Hamburguer(String bread, String meat, int price) {
        this.bread = bread;
        this.meat = meat;
        this.price = price;
    }
    public Hamburguer(String bread, String meat, int price,Ingredient extra1,Ingredient extra2) {
        this.bread = bread;
        this.meat = meat;
        this.price = price;
        this.additions[0]=extra1;
        this.additions[1]=extra2;
    }
    public void showPrice(){
        System.out.println("Base price for the Hamburger is: "+ this.price);
        int priceAdditions=0;
        for (int i=0; i< additions.length;i++){
            if(additions[i]!=null){
                System.out.println("Charge Extra "+additions[i].getPrice()+" for "+ additions[i].getName() );
                priceAdditions+=additions[i].getPrice();
            }
        }
        System.out.println("The total extras cost "+ priceAdditions);
        System.out.println("The total cost is "+(priceAdditions+this.price));
    }
    public void addIngredient (Ingredient extra){
            for (int i=0; i< additions.length;i++){
                if(additions[i]==null){
                    this.additions[i]=extra;
                    this.numIngredients++;
                    System.out.println(extra.getName()+" added");
                    return;
                }
            }
            System.out.println("Impossible to add more Ingredients");
    }
}
