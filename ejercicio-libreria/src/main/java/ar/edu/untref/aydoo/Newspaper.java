package ar.edu.untref.aydoo;

/*Tipo de objeto: Entidad*/
public class Newspaper extends PeriodicItem{

    public Newspaper(String name, double price, Periodicity periodicity){
        super(name, price, periodicity);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
