package ar.edu.untref.aydoo;

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
