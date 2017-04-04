package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hernan on 04/04/17.
 */
public class Customer extends ChargeCalculator {

    private List<Purchase> purchaseList = new ArrayList<Purchase>();

    public Customer(String horacio, String s, String s1) {
        super();
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

    public void addPurchase(Purchase purchase) {

        this.purchaseList.add(purchase);

    }
}
