package ar.edu.untref.aydoo;

/*Tipo de objeto: Entidad*/
public class AnualSubscription extends Subscription{

    public AnualSubscription(PeriodicItem item){
        super(item);
    }

    @Override
    public Double getPriceByMonth(Month month){

        double amount = 0;
        switch(this.getItem().getPeriodicity()) {
            case DAILY:
                amount += this.getItem().getAnualSubscriptionPrice() * month.getDaysOfTheMonth();
                break;
            case WEEKLY:
                amount += this.getItem().getAnualSubscriptionPrice() * 4;
                break;
            case BIWEEKLY:
                amount += this.getItem().getAnualSubscriptionPrice() * 2;
                break;
            case MONTHLY:
                amount += this.getItem().getAnualSubscriptionPrice();
                break;
            default:
                break;
        }
        return amount;
    }

}
