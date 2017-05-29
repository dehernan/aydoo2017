package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.exceptions.InvalidFileException;
import ar.edu.untref.aydoo.exceptions.InvalidFormatException;
import ar.edu.untref.aydoo.exceptions.InvalidOrderException;

import java.util.Collections;
import java.util.List;

public class PrimeNumberCalculator{

    public static FactorsCalculator factorsCalculator = new FactorsCalculator();
    public static PrimeNumberPrinter primeNumberPrinter = new PrimeNumberPrinter();
    public static List<Integer> factors;
    public static String output;
    public static String format;
    public static String order;
    public static String path;
    public static boolean writeOutputFile;

    public static final void main(String arg[]){
        format = "pretty";
        order = "asc";
        path = "";

        int number = Integer.parseInt(arg[0]);

        output = "Factores primos "+number+": ";
        parametersToLowerCase(arg);
        obtainFactors(number);
        evaluateParameters(arg);
        applyParameters();
        printOutputs();
    }

    private static void applyParameters() {
        try {
            orderFactors(order);
            formatOutput(format);
        } catch (Exception e) {
            output=e.getMessage();
        }
    }

    private static void printOutputs() {
        if(writeOutputFile){
            try {
                printFile(path, output);
            } catch (InvalidFileException e) {
                output = e.getMessage();
            }
        }
        else{
            System.out.println(output);
        }
    }

    private static void obtainFactors(Integer number){
        factors = factorsCalculator.calculateFactors(number);
    }

    private static void evaluateParameters(String[] arg) {
        for(String i: arg) {
            if (i.startsWith("--format=")) {
                format = i.substring(9, i.length());
            }
            if (i.startsWith("--sort=")) {
                order = i.substring(7, i.length());
                output = "";
            }
            if (i.startsWith("--output-file=")) {
                path = i.substring(14, i.length());
                writeOutputFile = true;
            }
            else{
                writeOutputFile = false;
            }
        }
    }

    public static void formatOutput(String format) throws InvalidFormatException {
        switch(format){
            case "":
            case "pretty":
                for(int i = 0; i < factors.size(); i++){
                    output = output.concat(factors.get(i)+" ");
                }
                break;
            case "quiet":
                for(int i = 0; i<factors.size(); i++){
                    output = output.concat(factors.get(i)+"\n");
                }
                break;
            default:
                throw new InvalidFormatException();
        }
    }

    public static void orderFactors(String order) throws InvalidOrderException {
        switch(order){
            case "":
            case "asc":
                Collections.sort(factors);
                break;
            case "desc":
                Collections.sort(factors, Collections.reverseOrder());
                break;
            default:
                throw new InvalidOrderException();
        }
    }

    public static void printFile(String path, String output) throws InvalidFileException {
        primeNumberPrinter.printFile(path, output);
    }

    public static void parametersToLowerCase(String[] args){
        for(int i = 0; i < args.length; i++){
            args[i]=args[i].toLowerCase();
        }
    }
}