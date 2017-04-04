package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hernan on 04/04/17.
 */
public class Customer{

    private String name;
    private String adress;
    private String locality;
    private List<Purchase> purchaseList = new ArrayList<Purchase>();


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

    public void addPurchase(Purchase purchase) {

        this.purchaseList.add(purchase);

    }
}
