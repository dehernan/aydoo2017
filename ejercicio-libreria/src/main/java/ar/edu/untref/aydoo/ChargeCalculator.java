package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static ar.edu.untref.aydoo.Periodicity.*;

public class ChargeCalculator {

    public double calculateAmountToBeCharged(Month month, Customer customer) {

        double amount = 0;
        amount += calculateAmountOfPurchases(month, customer);
        amount += calculateAmountOfMonthlySubscriptionsByMonth(month, customer);
        amount += calculateAmountOfAnualSubsctiptionsByMonth(month, customer);

        return amount;

    }

    public double calculateAmountOfPurchases(Month month, Customer customer){

        double amount = 0;

        List<Purchase> purchasesOnTheMonth = customer.getPurchasesByMonth(month);
        Iterator <Purchase> iterator = purchasesOnTheMonth.iterator();


        while (iterator.hasNext()) {

            Purchase actualPurchase = iterator.next();
            if(actualPurchase.getItem() instanceof BookstoreItem){
                amount += (actualPurchase.getPrice()*1.21);

            }else{

                amount += actualPurchase.getPrice();

            }


        }

        return amount;

    }

    public double calculateAmountOfMonthlySubscriptionsByMonth(Month month, Customer customer){

        double amount = 0;

        List<Subscription> monthlySubscriptionsOnTheMonth = customer.getMonthlySubscriptionsByMonth(month);
        Iterator <Subscription> iterator = monthlySubscriptionsOnTheMonth.iterator();

        while (iterator.hasNext()) {

            Subscription actualSubscription = iterator.next();
            switch(actualSubscription.getItem().getPeriodicity()) {

                case DAILY:
                    amount += actualSubscription.getItem().getPrice() * (this.getDaysOfAMonth(month));
                    break;
                case WEEKLY:
                    amount += actualSubscription.getItem().getPrice() * 4;
                    break;
                case BIWEEKLY:
                    amount += actualSubscription.getItem().getPrice() * 2;
                    break;
                case MONTHLY:
                    amount += actualSubscription.getItem().getPrice();
                    break;
                default:
                    break;
            }

        }

        return amount;

    }

    private int getDaysOfAMonth(Month month) {

        switch (month){

            case JANUARY:
                return 31;
            case FEBRUARY:
                return 28;
            case MARCH:
                return 31;
            case APRIL:
                return 30;
            case MAY:
                return 31;
            case JUNE:
                return 30;
            case JULY:
                return 31;
            case AUGUST:
                return 31;
            case SEPTEMBER:
                return 30;
            case OCTOBER:
                return 31;
            case NOVEMBER:
                return 30;
            case DECEMBER:
                return 31;
            default:
                return 0;

        }

    }

    public double calculateAmountOfAnualSubsctiptionsByMonth(Month month, Customer customer){

        double amount = 0;

        List<Subscription> anualSubscriptionsOnTheMonth = customer.getAnualSubscriptionsByMonth(month);
        Iterator <Subscription> iterator = anualSubscriptionsOnTheMonth.iterator();

        while (iterator.hasNext()) {

            Subscription actualSubscription = iterator.next();

            switch(actualSubscription.getItem().getPeriodicity()) {


                case DAILY:
                    amount += actualSubscription.getItem().getPrice()*0.8 * (this.getDaysOfAMonth(month));
                    break;
                case WEEKLY:
                    amount += actualSubscription.getItem().getPrice()*0.8 * 4;
                    break;
                case BIWEEKLY:
                    amount += actualSubscription.getItem().getPrice()*0.8 * 2;
                    break;
                case MONTHLY:
                    amount += actualSubscription.getItem().getPrice()*0.8;
                    break;
                default:
                    break;

            }
        }

        return amount;
    }
}