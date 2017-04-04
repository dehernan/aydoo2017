package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static ar.edu.untref.aydoo.SubscriptionType.ANUAL;
import static ar.edu.untref.aydoo.SubscriptionType.MONTHLY;

/**
 * Created by hernan on 04/04/17.
 */
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

            if(actualSubscription.getSubscriptionType()==MONTHLY){

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

            if(actualSubscription.getSubscriptionType()==ANUAL){

                subscriptionsOnTheMonth.add(actualSubscription);

            }

        }

        return subscriptionsOnTheMonth;
    }

    public void addPurchase (Item item, Month month){

        this.purchaseList.add(new Purchase(item, month));

    }


    public void addMonthlySubscription(PeriodicItem item, Month month){

        this.subscriptionsList.add(new Subscription(item, MONTHLY, month));

    }

    public void addAnualSubscription(PeriodicItem item){

        this.subscriptionsList.add(new Subscription(item, ANUAL));

    }

}
