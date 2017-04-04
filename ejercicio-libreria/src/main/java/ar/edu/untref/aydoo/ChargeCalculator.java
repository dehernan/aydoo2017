package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChargeCalculator {

    public double calculateAmountToBeCharged(Month month, Customer customer) {

        double amount = 0;

        List<Purchase> purchasesOnTheMonth = customer.getPurchasesByMonth(month);
        Iterator<Purchase> iterator = purchasesOnTheMonth.iterator();

        while (iterator.hasNext()) {

            amount += iterator.next().getPrice();

        }

        return amount;

    }
}