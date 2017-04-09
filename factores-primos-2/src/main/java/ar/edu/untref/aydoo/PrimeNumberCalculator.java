package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberCalculator{

    public static List<Integer> factors;
    public static String output = "";
    public static String format = "pretty";

    public static final void main(String arg[]){
        factors = new ArrayList<>();
        format = "pretty";
        int number = Integer.parseInt(arg[0]);
        for(int i = 0; i < arg.length; i++){
            arg[i]=arg[i].toLowerCase();
        }

        output ="Factores primos "+number+": ";

        calculateFactors(number);
        evaluateParameters(arg);
        formatOutput(format);
        System.out.println(output);

    }

    private static void evaluateParameters(String[] arg) {
        for(String i: arg) {
            if (i.startsWith("--format=")) {
                format = i.substring(9, i.length());
            } else {
                format=("pretty");
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
                for(int i = (factors.size()-1); i >= 0; i--){
                    output = output.concat(factors.get(i)+"\n");
                }
                break;
            default:
                output = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
        }
    }

}