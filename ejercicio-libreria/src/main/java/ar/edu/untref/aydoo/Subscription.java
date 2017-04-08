package ar.edu.untref.aydoo;

/**
 * Created by hernan on 04/04/17.
 */
public abstract class Subscription {

    private PeriodicItem item;

    public Subscription(PeriodicItem item) {
        this.item = item;
    }

    public  PeriodicItem getItem(){
        return this.item;
    }


}
