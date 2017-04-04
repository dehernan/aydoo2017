package ar.edu.untref.aydoo;

/**
 * Created by hernan on 04/04/17.
 */
public class MonthlySubscription extends Subscription{

    Month month;

    public MonthlySubscription(PeriodicItem item, Month month){

        super(item);
        this.month=month;

    }

    public Month getMonth(){

        return this.month;

    }

}
