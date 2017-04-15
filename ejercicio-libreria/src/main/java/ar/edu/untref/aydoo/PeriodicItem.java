package ar.edu.untref.aydoo;

/*Tipo de objeto: Entidad*/
public abstract class PeriodicItem extends Item{

    Periodicity periodicity;

    public PeriodicItem(String name, double price, Periodicity periodicity) {
        super(name, price);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity(){
        return periodicity;
    }

    public Double getMonthlySubscriptionPrice(){
        return price;
    }

    public Double getAnualSubscriptionPrice(){
        return price*0.8;
    }

}
