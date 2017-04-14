package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer{

    private String name;
    private String adress;
    private String locality;
    private List<Purchase> purchaseList = new ArrayList<Purchase>();
    List<Subscription> subscriptionsList = new ArrayList<Subscription>();

    public Customer(String name, String adress, String locality){
        this.name = name;
        this.adress = adress;
        this.locality = locality;
    }

    public List<Purchase> getPurchasesByMonth(Month month) {
        List<Purchase> purchasesOnTheMonth = new ArrayList<Purchase>();
        Iterator<Purchase> iterator = purchaseList.iterator();
        while (iterator.hasNext()){
            Purchase actualPurchase = iterator.next();
            if(actualPurchase.getMonth() == month){
                purchasesOnTheMonth.add(actualPurchase);
            }
        }
        return purchasesOnTheMonth;
    }

    public List<Subscription> getMonthlySubscriptionsByMonth(Month month){
        List<Subscription> subscriptionsOnTheMonth = new ArrayList<Subscription>();
        Iterator<Subscription> iterator = subscriptionsList.iterator();
        while(iterator.hasNext()){
            Subscription actualSubscription = iterator.next();
            if(actualSubscription instanceof MonthlySubscription){
                subscriptionsOnTheMonth.add(actualSubscription);
            }
        }
        return subscriptionsOnTheMonth;
    }

    public List<Subscription> getAnualSubscriptionsByMonth(Month month){
        List<Subscription> subscriptionsOnTheMonth = new ArrayList<Subscription>();
        Iterator<Subscription> iterator = subscriptionsList.iterator();
        while(iterator.hasNext()){
            Subscription actualSubscription = iterator.next();
            if(actualSubscription instanceof AnualSubscription){
                subscriptionsOnTheMonth.add(actualSubscription);
            }
        }
        return subscriptionsOnTheMonth;
    }

    public double calculateTotalAmountToBeChargedByMonth(Month month) {
        double amount = 0;
        amount += calculateAmountOfPurchasesByMonth(month);
        amount += calculateAmountOfMonthlySubscriptionsByMonth(month);
        amount += calculateAmountOfAnualSubsctiptionsByMonth(month);

        return amount;
    }

    public double calculateAmountOfPurchasesByMonth(Month month){
        double amount = 0;
        List<Purchase> purchasesOnTheMonth = this.getPurchasesByMonth(month);
        Iterator <Purchase> iterator = purchasesOnTheMonth.iterator();
        while (iterator.hasNext()) {
            amount += iterator.next().getPrice();
        }
        return amount;
    }

    public double calculateAmountOfMonthlySubscriptionsByMonth(Month month){
        double amount = 0;
        List<Subscription> monthlySubscriptionsOnTheMonth = this.getMonthlySubscriptionsByMonth(month);
        Iterator <Subscription> iterator = monthlySubscriptionsOnTheMonth.iterator();
        while (iterator.hasNext()) {
            amount += iterator.next().getPriceByMonth(month);
        }
        return amount;
    }

    public double calculateAmountOfAnualSubsctiptionsByMonth(Month month){
        double amount = 0;
        List<Subscription> anualSubscriptionsOnTheMonth = this.getAnualSubscriptionsByMonth(month);
        Iterator <Subscription> iterator = anualSubscriptionsOnTheMonth.iterator();
        while (iterator.hasNext()) {
           amount += iterator.next().getPriceByMonth(month);
        }
        return amount;
    }

    public void addPurchase (Item item, Month month){
        this.purchaseList.add(new Purchase(item, month));
    }


    public void addMonthlySubscription(PeriodicItem item, Month month){
        this.subscriptionsList.add(new MonthlySubscription(item, month));
    }

    public void addAnualSubscription(PeriodicItem item){
        this.subscriptionsList.add(new AnualSubscription(item));
    }

}
