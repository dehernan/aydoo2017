package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static ar.edu.untref.aydoo.Month.AUGUST;
import static ar.edu.untref.aydoo.Month.JANUARY;
import static ar.edu.untref.aydoo.Periodicity.BIWEEKLY;
import static ar.edu.untref.aydoo.Periodicity.DAILY;
import static ar.edu.untref.aydoo.Periodicity.WEEKLY;
import static ar.edu.untref.aydoo.SubscriptionType.ANUAL;
import static ar.edu.untref.aydoo.SubscriptionType.MONTHLY;

public class IntegrationTest{

    ChargeCalculator calculator;

    @Before
    public void createCalculator(){

        calculator = new ChargeCalculator();

    }
    @Test
    public void shouldCalculateAmountOfOneBook(){
        Book firstBook = new Book("El psicoanalista", 30.0);
        Customer horacio = new Customer("Horacio", "Remedios de Escalada 1234", "San Martin");

        horacio.addPurchase(firstBook, JANUARY);

        Assert.assertEquals(30.0, calculator.calculateAmountToBeCharged(JANUARY, horacio),0.0);
    }

    @Test
    public void shouldCalculateAmountOfTwoBooks(){
        Book firstBook = new Book("El psicoanalista", 30.0);
        Book secondBook = new Book("Martin Fierro", 50.5);
        Customer horacio = new Customer("Horacio", "Remedios de Escalada 1234", "San Martin");

        horacio.addPurchase(firstBook, JANUARY);
        horacio.addPurchase(secondBook, JANUARY);

        Assert.assertEquals(80.5, calculator.calculateAmountToBeCharged(JANUARY, horacio),0.0);
    }

    @Test
    public void shouldCalculateAmountOfTwoBooksAndAMagazine(){
        Book firstBook = new Book("El psicoanalista", 30.0);
        Book secondBook = new Book("Martin Fierro", 50.5);
        Magazine firstMagazine = new Magazine("Gente", 5.0, DAILY);
        Customer horacio = new Customer("Horacio", "Remedios de Escalada 1234", "San Martin");

        horacio.addPurchase(firstBook, JANUARY);
        horacio.addPurchase(secondBook, JANUARY);
        horacio.addPurchase(firstMagazine, JANUARY);

        Assert.assertEquals(85.5, calculator.calculateAmountToBeCharged(JANUARY, horacio),0.0);
    }

    @Test
    public void shouldCalculateAmountOfTwoBooksAndTwoMagazines(){
        Book firstBook = new Book("El psicoanalista", 30.0);
        Book secondBook = new Book("Martin Fierro", 50.5);
        Magazine firstMagazine = new Magazine("Gente", 5.0, DAILY);
        Magazine secondMagazine = new Magazine("El grafico", 8.0, WEEKLY);
        Customer horacio = new Customer("Horacio", "Remedios de Escalada 1234", "San Martin");

        horacio.addPurchase(firstBook, JANUARY);
        horacio.addPurchase(secondBook, JANUARY);
        horacio.addPurchase(firstMagazine, JANUARY);
        horacio.addPurchase(secondMagazine, JANUARY);

        Assert.assertEquals(93.5, calculator.calculateAmountToBeCharged(JANUARY, horacio),0.0);
    }

    @Test
    public void shouldCalculateAmountOfOneBookstoreItem(){

        BookstoreItem bookstoreItem = new BookstoreItem("Lapicera", 5.0);
        Customer horacio = new Customer("Horacio", "Remedios de Escalada 1234", "San Martin");

        horacio.addPurchase(bookstoreItem, JANUARY);

        Assert.assertEquals(6.05, calculator.calculateAmountToBeCharged(JANUARY, horacio), 0.0);

    }

    @Test
    public void shouldCalculateAmountOfTwoBookstoreItem(){

        BookstoreItem firstBookstoreItem = new BookstoreItem("Lapicera", 5.0);
        BookstoreItem secondBookstoreItem = new BookstoreItem("Cuaderno", 8.0);
        Customer horacio = new Customer("Horacio", "Remedios de Escalada 1234", "San Martin");

        horacio.addPurchase(firstBookstoreItem, JANUARY);
        horacio.addPurchase(secondBookstoreItem, JANUARY);

        Assert.assertEquals(15.73, calculator.calculateAmountToBeCharged(JANUARY, horacio), 0.0);

    }

    @Test
    public void shouldCalculateAmountOfAMonthlySubscription(){

        Magazine magazine = new Magazine("Gente", 5, DAILY);
        Customer horacio = new Customer("Horacio", "Remedios de Escalada 1234", "San Martin");
        horacio.addMonthlySubscription(magazine, JANUARY);
        Assert.assertEquals(155, calculator.calculateAmountOfMonthlySubscriptionsByMonth(JANUARY, horacio), 0.0);

    }

    @Test
    public void shouldCalculateAmountOfAnAnualSubscription(){

        Magazine magazine = new Magazine("Gente", 5, DAILY);
        Customer horacio = new Customer("Horacio", "Remedios de Escalada 1234", "San Martin");
        horacio.addAnualSubscription(magazine);
        Assert.assertEquals(124, calculator.calculateAmountToBeCharged(JANUARY, horacio),0.0);

    }

    @Test
    public void shouldCalculateAmountOfAMonthlyAndAnAnualSubscription(){

        Magazine gente = new Magazine("Gente", 5, DAILY);
        Magazine elgrafico = new Magazine("El Grafico", 8, WEEKLY);
        Customer horacio = new Customer("Horacio", "Remedios de Escalada 1234", "San Martin");
        horacio.addMonthlySubscription(gente, JANUARY);
        horacio.addAnualSubscription(elgrafico);
        Assert.assertEquals(180.6, calculator.calculateAmountToBeCharged(JANUARY, horacio), 0.0);

    }

    @Test
    public void shouldCalculateAmountOfAMonthlyAndAnAnualSubscription2(){

        Magazine barcelona = new Magazine("Barcelona", 20, BIWEEKLY);
        Magazine elgrafico = new Magazine("El Grafico", 30, Periodicity.MONTHLY);
        Book elhobbit = new Book("El Hobbit", 50);
        BookstoreItem lapicera = new BookstoreItem("Lapicera", 5);
        Newspaper pagina12 = new Newspaper("Pagina 12", 12, DAILY);
        Newspaper clarin = new Newspaper("Clarin", 13, DAILY);
        Customer juan = new Customer("Juan", "Remedios de Escalada 1234", "San Martin");
        juan.addPurchase(elhobbit, AUGUST);
        juan.addPurchase(lapicera, AUGUST);
        juan.addPurchase(lapicera, AUGUST);
        juan.addPurchase(elgrafico, AUGUST);

        Assert.assertEquals(92.1, calculator.calculateAmountToBeCharged(AUGUST, juan), 0.0);

    }



}
