package ar.edu.untref.aydoo;

/*Tipo de objeto: Entidad*/
public class Book extends Item{

    public Book(String name, double price){
        super(name, price);
    }

    @Override
    public double getPrice() {
        return price;
    }

}
