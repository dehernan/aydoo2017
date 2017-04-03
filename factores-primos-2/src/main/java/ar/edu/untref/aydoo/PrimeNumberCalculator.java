package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberCalculator{

    public List<Integer> factors = new ArrayList<Integer>();
    public static String output = "";

    public final void main(String arg[]){
        int number = Integer.parseInt(arg[0]);
        String format = "";

        if(arg.length>1) {
            format = arg[1].toLowerCase();
        }


        output ="Factores primos "+number+": ";

        calculateFactors(number);
        formatOutput(format);
        System.out.println(output);

    }

    public void calculateFactors(int number){

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

    public void formatOutput(String format){

        switch(format){

            case "":
            case "--format=pretty":
                for(int i = 0; i < factors.size(); i++){

                    output = output.concat(factors.get(i)+" ");

                }
                break;
            case "--format=quiet":
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