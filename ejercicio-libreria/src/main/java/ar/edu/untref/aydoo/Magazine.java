package ar.edu.untref.aydoo;

/*Tipo de objeto: Entidad*/
public class Magazine extends PeriodicItem{

    public Magazine(String name, double price, Periodicity periodicity){
        super(name, price, periodicity);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
