package com.company;

public class Healthy_Burguer extends Hamburguer {
    private Ingredient [] additions= new Ingredient[6];

    public Healthy_Burguer(String meat, int price) {
        super("Brown Rye Bread Roll", meat, price);
    }

    @Override
    public void addIngredient(Ingredient extra) {
            for (int i=0; i< this.additions.length;i++){
                if(this.additions[i]==null){
                    this.additions[i]=extra;
                    System.out.println(extra.getName()+" added");
                    return;
                }
            }
            System.out.println("Impossible to add more Ingredients");
    }
}
