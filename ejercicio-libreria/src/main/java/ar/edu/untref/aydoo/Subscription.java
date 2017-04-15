package ar.edu.untref.aydoo;

/*Tipo de objeto: Entidad*/
public abstract class Subscription {

    private PeriodicItem item;

    public Subscription(PeriodicItem item) {
        this.item = item;
    }

    public PeriodicItem getItem() {
        return this.item;
    }

    abstract public Double getPriceByMonth(Month month);

}