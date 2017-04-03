package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


public class PrimeNumberCalculatorTest{
    @Test
    public void number360WithoutFormatTest() {

        String[] args = new String[2];
        args[0] = "360";
        PrimeNumberCalculator calculator = new PrimeNumberCalculator();
        calculator.main(args);

    }
}
