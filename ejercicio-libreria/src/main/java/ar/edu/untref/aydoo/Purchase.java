package ar.edu.untref.aydoo;

/**
 * Created by hernan on 04/04/17.
 */
public class Purchase {

    private Month month;
    private Customer customer;
    private Item item;

    public Purchase(Customer customer, Item item, Month month) {

        this.customer = customer;
        this.month = month;
        this.item = item;

        customer.addPurchase(this);

    }

    public Month getMonth() {
        return month;
    }

    public Customer getCustomer (){
        return customer;
    }

    public double getPrice() {
        return item.getPrice();
    }

    public Item getItem() {
        return item;
    }
}
