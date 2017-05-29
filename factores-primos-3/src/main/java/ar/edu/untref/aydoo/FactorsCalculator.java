package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class FactorsCalculator {

    private List<Integer> factors;

    public List<Integer> calculateFactors(int number){

        factors = new ArrayList<>();

        if(number == 1){
            factors.add(number);
        }
        for(int i = 2; i<=number; i++){
            while(number%i==0) {
                number = number/i;
                factors.add(i);
            }
        }
        return factors;
    }

}
