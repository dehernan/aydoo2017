package ar.edu.untref.aydoo.exceptions;

public class PorcentajeDescuentoInvalido extends Exception{
    public PorcentajeDescuentoInvalido() {
        super();
    }

    @Override
    public String getMessage(){
        return "El porcentaje del descuento debe ser mayor al 5% y menor o igual a 100";
    }

}
