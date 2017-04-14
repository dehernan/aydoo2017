package ar.edu.untref.aydoo;

public class BookstoreItem extends Item{

    public BookstoreItem(String name, double price){
        super(name, price);
    }

    @Override
    public double getPrice(){

        return price*1.21;

    }

}
