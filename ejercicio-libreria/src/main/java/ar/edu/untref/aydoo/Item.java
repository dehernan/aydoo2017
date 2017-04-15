package ar.edu.untref.aydoo;

/*Tipo de objeto: Entidad*/
public abstract class Item {

    String name;
    double price;


    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    abstract public double getPrice();

}
