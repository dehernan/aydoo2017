package ar.edu.untref.aydoo;

/**
 * Created by hernan on 04/04/17.
 */
public class Purchase {

    private Month month;
    private Item item;

    public Purchase(Item item, Month month) {

        this.month = month;
        this.item = item;

    }

    public Month getMonth() {
        return month;
    }

    public double getPrice() {
        return item.getPrice();
    }

    public Item getItem() {
        return item;
    }
}
