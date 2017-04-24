package ar.edu.untref.aydoo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeNumberCalculator{

    public static List<Integer> factors;
    public static List<String> flagParameters;
    public static String output;
    public static String format;
    public static String order;
    public static String path;
    public static boolean writeOutputFile;

    public static final void main(String arg[]){
        factors = new ArrayList<>();
        flagParameters = new ArrayList<>();
        output = "";
        format = "pretty";
        order = "asc";
        path = "";
        writeOutputFile = false;

        int number = Integer.parseInt(arg[0]);
        for(int i = 0; i < arg.length; i++){
            arg[i]=arg[i].toLowerCase();
        }

        output ="Factores primos "+number+": ";
        calculateFactors(number);
        evaluateParameters(arg);
        orderFactors(order);
        formatOutput(format);
        System.out.println(output);
        if(writeOutputFile) {
            printFile(path);
        }

    }

    private static void evaluateParameters(String[] arg) {
        for(String i: arg) {
            if (i.startsWith("--format=")) {
                format = i.substring(9, i.length());
            }
            if (i.startsWith("--sort=")) {
                order = i.substring(7, i.length());
            }
            if (i.startsWith("--output-file=")) {
                path = i.substring(14, i.length());
                writeOutputFile = true;
            }
        }
    }

    public static void calculateFactors(int number){
        if(number == 1){
            factors.add(number);
        }
        for(int i = 2; i<=number; i++){
            while(number%i==0) {
                number = number/i;
                factors.add(i);
            }
        }
    }

    public static void formatOutput(String format){
        switch(format){
            case "":
            case "pretty":
                for(int i = 0; i < factors.size(); i++){
                    output = output.concat(factors.get(i)+" ");
                }
                break;
            case "quiet":
                output = output.concat("\n");
                for(int i = 0; i<factors.size(); i++){
                    output = output.concat(factors.get(i)+"\n");
                }
                break;
            default:
                output = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
        }
    }

    public static void orderFactors(String order){
        switch(order){
            case "":
            case "asc":
                Collections.sort(factors);
                break;
            case "desc":
                Collections.sort(factors, Collections.reverseOrder());
                break;
            default:
                output = "Orden no aceptado. Las opciones posibles son: asc o desc.";
        }
    }

    public static void printFile(String path){
        if(path.endsWith(".txt")) {
            String printed = output;
            try {
                PrintWriter writer = new PrintWriter(path, "UTF-8");
                writer.println(printed);
                writer.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
        else{
            output = "El archivo debe ser especificado con formato .txt";
        }
    }

}