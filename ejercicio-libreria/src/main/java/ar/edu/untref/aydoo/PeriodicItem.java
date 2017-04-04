package ar.edu.untref.aydoo;

/**
 * Created by hernan on 04/04/17.
 */
public abstract class PeriodicItem extends Item{

    Periodicity periodicity;

    public PeriodicItem(String name, double price, Periodicity periodicity) {
        super(name, price);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity(){

        return periodicity;

    }
}
