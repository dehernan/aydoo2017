package ar.edu.untref.aydoo;

public class Book extends Item{

    public Book(String name, double price){
        super(name, price);
    }

    @Override
    public double getPrice() {
        return price;
    }

}
