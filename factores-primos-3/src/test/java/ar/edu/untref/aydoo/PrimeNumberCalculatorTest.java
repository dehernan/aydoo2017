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
    public void number1WithoutFormatTest() {

        String[] args = new String[1];
        args[0] = "1";

        calculator.main(args);

        Assert.assertEquals("Factores primos 1: 1 ", calculator.output);
    }

    @Test
    public void number360WithoutFormatTest() {

        String[] args = new String[1];
        args[0] = "360";


        calculator.main(args);

        Assert.assertEquals("Factores primos 360: 2 2 2 3 3 5 ", calculator.output);
    }

    @Test
    public void number360WithQuietFormatTest() {

        String[] args = new String[2];
        args[0] = "360";
        args[1] = "--format=quIet";

        calculator.main(args);

        Assert.assertEquals("Factores primos 360: 2\n2\n2\n3\n3\n5\n", calculator.output);
    }

    @Test
    public void number360WithQuietFormatAndAscOrderTest() {

        String[] args = new String[3];
        args[0] = "360";
        args[1] = "--format=quIet";
        args[2] = "--sort=asc";

        calculator.main(args);

        Assert.assertEquals("2\n2\n2\n3\n3\n5\n", calculator.output);
    }

    @Test
    public void number360WithQuietFormatAndWrongOrderTest() {

        String[] args = new String[3];
        args[0] = "360";
        args[1] = "--format=quIet";
        args[2] = "--sort=ascendente";

        calculator.main(args);

        Assert.assertEquals("Orden no aceptado. Las opciones posibles son: asc o desc.", calculator.output);
    }

    @Test
    public void number360WithQuietFormatAndAscOrderAndOutputFileTest() {

        PrimeNumberCalculator otra = new PrimeNumberCalculator();
        String[] args = new String[4];
        args[0] = "360";
        args[1] = "--format=quIet";
        args[2] = "--sort=asc";
        args[3] = "--output-file=number360WithQuietFormatAndAscOrderAndOutputFileTest.txt";

        otra.main(args);

        Assert.assertEquals("2\n2\n2\n3\n3\n5\n", otra.output);
    }

    @Test
    public void number360WithQuietFormatAndDescOrderAndOutputFileTest() {

        String[] args = new String[4];
        args[0] = "360";
        args[1] = "--format=quIet";
        args[2] = "--sort=desc";
        args[3] = "--output-file=number360WithQuietFormatAndDescOrderAndOutputFileTest.txt";

        calculator.main(args);

        Assert.assertEquals("5\n3\n3\n2\n2\n2\n", calculator.output);
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
    public void number360WithPrettyFormatAndDescOrderTest() {

        String[] args = new String[3];
        args[0] = "360";
        args[1] = "--format=pretty";
        args[2] = "--sort=desc";

        calculator.main(args);

        Assert.assertEquals("5 3 3 2 2 2 ", calculator.output);
    }

    @Test
    public void number360WithPrettyFormatAndDescOrderAndOutputFileTest() {

        String[] args = new String[4];
        args[0] = "360";
        args[1] = "--format=pretty";
        args[2] = "--sort=desc";
        args[3] = "--output-file=number360WithPrettyFormatAndDescOrderAndOutputFileTest.txt";

        calculator.main(args);

        Assert.assertEquals("5 3 3 2 2 2 ", calculator.output);
    }

    @Test
    public void number360WithPrettyFormatAndEmptyOrderParameterShouldReturnAscOrder() {

        String[] args = new String[4];
        args[0] = "360";
        args[1] = "--format=pretty";
        args[2] = "--sort=";
        args[3] = "--output-file=number360WithPrettyFormatAndDescOrderAndOutputFileTest.txt";

        calculator.main(args);

        Assert.assertEquals("2 2 2 3 3 5 ", calculator.output);
    }

    @Test
    public void number360WithEmptyFormatParameterShouldReturnPrettyFormat() {

        String[] args = new String[2];
        args[0] = "360";
        args[1] = "--format=";

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
    public void number360WithWrongFormatParameterShouldReturnPrettyFormat() {

        String[] args = new String[2];
        args[0] = "360";
        args[1] = "-format=quiet";

        calculator.main(args);

        Assert.assertEquals("Factores primos 360: 2 2 2 3 3 5 ", calculator.output);
    }

    @Test
    public void number360WithWrongOutputFileParameterTest() {

        String[] args = new String[3];
        args[0] = "360";
        args[1] = "--format=quiet";
        args[2] = "--output-file=number360WithWrongOutputFileParameterTest.tx";

        calculator.main(args);

        Assert.assertEquals("El archivo debe ser especificado con formato .txt", calculator.output);
    }




}
