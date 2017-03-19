package ar.edu.untref.aydoo;

public class Program{

    public static final void main(String arg[]){
        int number = Integer.parseInt(arg[0]);

        System.out.print("Factores primos "+number+": ");

        factors(number);

    }

    public static void factors(int number){

        if(number == 1){

            System.out.print(number);

        }

        for(int i = 2; i<=number; i++){

            while(number%i==0) {

                number = number/i;

                System.out.print(i+" ");

            }

        }

        System.out.println();

    }

}