package ar.edu.untref.aydoo.exceptions;

/**
 * Created by hernan on 18/04/17.
 */
public class PreciosInvalidosParaPromocion2x1 extends Exception{
    public PreciosInvalidosParaPromocion2x1(){
        super();
    }
    @Override
    public String getMessage(){
        return "El precio de uno de los productos debe ser mayor o igual a $100";
    }
}
