package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class PrimeNumberCalculatorTest{

    PrimeNumberCalculator calculator;

    @Before
    public void createCalculator(){

        calculator = new PrimeNumberCalculator();

    }

    @Test
    public void number360WithoutFormatTest() {

        String[] args = new String[2];
        args[0] = "360";
        args[1] = "";

        calculator.main(args);

        Assert.assertEquals("Factores primos 360: 2 2 2 3 3 5 ", calculator.output);
    }

    @Test
    public void number360WithQuietFormatTest() {

        String[] args = new String[2];
        args[0] = "360";
        args[1] = "--format=quIet";

        calculator.main(args);

        Assert.assertEquals("Factores primos 360: \n5\n3\n3\n2\n2\n2\n", calculator.output);
    }

    @Test
    public void number360WithPrettyFormatTest() {

        String[] args = new String[2];
        args[0] = "360";
        args[1] = "--format=pretty";

        calculator.main(args);

        Assert.assertEquals("Factores primos 360: 2 2 2 3 3 5 ", calculator.output);
    }


    @Test
    public void number360WithWrongFormatParameterTest() {

        String[] args = new String[2];
        args[0] = "360";
        args[1] = "--format=yerba";

        calculator.main(args);

        Assert.assertEquals("Formato no aceptado. Las opciones posibles son: pretty o quiet.", calculator.output);
    }


    @Test
    public void number360WithWrongParameterShouldReturnPrettyFormat() {

        String[] args = new String[2];
        args[0] = "360";
        args[1] = "-format=quiet";

        calculator.main(args);

        Assert.assertEquals("Factores primos 360: 2 2 2 3 3 5 ", calculator.output);
    }

}
