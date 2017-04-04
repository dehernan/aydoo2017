package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static ar.edu.untref.aydoo.Month.ENERO;

public class IntegrationTest{

    ChargeCalculator calculator;

    @Before
    public void createCalculator(){

        calculator = new ChargeCalculator();

    }
    @Test
    public void shouldCalculateAmountOfOneItem(){
        Book firstBook = new Book("El psicoanalista", 30.0);
        Customer horacio = new Customer("Horacio", "Remedios de Escalada 1234", "San Martin");
        Purchase horacioFirstPurchase = new Purchase(horacio, firstBook, ENERO);
        Assert.assertEquals(30.0, calculator.calculateAmountToBeCharged(ENERO, horacio),0.0);
    }

    @Test
    public void shouldCalculateAmountOfTwoItems(){
        Book firstBook = new Book("El psicoanalista", 30.0);
        Book secondBook = new Book("Martin Fierro", 50.5);
        Customer horacio = new Customer("Horacio", "Remedios de Escalada 1234", "San Martin");
        Purchase horacioFirstPurchase = new Purchase(horacio, firstBook, ENERO);
        Purchase horacioSecondPurchase = new Purchase(horacio, secondBook, ENERO);
        Assert.assertEquals(80.5, calculator.calculateAmountToBeCharged(ENERO, horacio),0.0);
    }


}
