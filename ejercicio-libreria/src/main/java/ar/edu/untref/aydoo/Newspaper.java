package ar.edu.untref.aydoo;

/**
 * Created by hernan on 04/04/17.
 */
public class Newspaper extends Item{

    public Newspaper(String name, double price, Periodicity periodicity){

        super(name, price);
        this.periodicity = periodicity;

    }

    public Periodicity getPeriodicity(){

        return this.periodicity;

    }

}