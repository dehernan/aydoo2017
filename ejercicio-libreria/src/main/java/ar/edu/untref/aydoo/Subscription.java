package ar.edu.untref.aydoo;

public abstract class Subscription {

    private PeriodicItem item;

    public Subscription(PeriodicItem item) {
        this.item = item;
    }

    public  PeriodicItem getItem(){
        return this.item;
    }


}
