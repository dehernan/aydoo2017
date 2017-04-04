package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

import static ar.edu.untref.aydoo.Month.ENERO;

public class IntegrationTest{

    @Test
    public void createCustomerTest(){
        ChargeCalculator calculator = new ChargeCalculator();
        Book firstBook = new Book("El psicoanalista", 30.0);
        Customer horacio = new Customer("Horacio", "Remedios de Escalada 1234", "San Martin");
        Purchase horacioFirstPurchase = new Purchase(horacio, firstBook, ENERO);
        Assert.assertEquals(30.0, calculator.calculateAmountToBeCharged(ENERO, horacio),0.0);
    }
}
