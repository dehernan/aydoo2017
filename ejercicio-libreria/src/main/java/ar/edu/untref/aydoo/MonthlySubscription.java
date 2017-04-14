package ar.edu.untref.aydoo;

public class MonthlySubscription extends Subscription{

    Month month;

    public MonthlySubscription(PeriodicItem item, Month month){
        super(item);
        this.month=month;
    }

    @Override
    public Double getPriceByMonth(Month month) {
        double amount = 0;
        switch(this.getItem().getPeriodicity()) {
            case DAILY:
                amount += this.getItem().getMonthlySubscriptionPrice() * month.getDaysOfTheMonth();
                break;
            case WEEKLY:
                amount += this.getItem().getMonthlySubscriptionPrice() * 4;
                break;
            case BIWEEKLY:
                amount += this.getItem().getMonthlySubscriptionPrice() * 2;
                break;
            case MONTHLY:
                amount += this.getItem().getMonthlySubscriptionPrice();
                break;
            default:
                break;
        }
        return amount;
    }
}
