package ar.edu.untref.aydoo;

/**
 * Created by hernan on 04/04/17.
 */
public class Subscription {

    private SubscriptionType subscriptionType;
    private Month month;
    private Item item;

    public Subscription(Item item, SubscriptionType subscriptionType){

        this.subscriptionType = subscriptionType;
        this.item = item;

    }

    public Subscription(Item item, SubscriptionType subscriptionType, Month month){

        this.subscriptionType = subscriptionType;
        this.item = item;
        this.month = month;

    }

    public SubscriptionType getSubscriptionType(){

        return this.subscriptionType;

    }

    public Month getMonth(){

        return this.month;

    }

    public Item getItem(){

        return this.item;

    }

}
