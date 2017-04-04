package ar.edu.untref.aydoo;

/**
 * Created by hernan on 04/04/17.
 */
public abstract class Item {

    String name;
    double price;

    public Item(String name, double price){

        this.name = name;
        this.price = price;

    }

    public double getPrice() {
        return price;
    }
}
