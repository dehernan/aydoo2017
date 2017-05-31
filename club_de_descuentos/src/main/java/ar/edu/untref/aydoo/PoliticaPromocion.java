package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.exceptions.PorcentajeDescuentoInvalido;
import ar.edu.untref.aydoo.exceptions.PreciosInvalidosParaPromocion2x1;

public class PoliticaPromocion {

    protected static Double valorMinimo2x1 = 100.0;
    protected static Double porcentajeMinimoDescuento = 5.0;
    protected static Double porcentajeMaximoDescuento = 100.0;

    public static void comprobarValorMinimo2x1(Double valor) throws PreciosInvalidosParaPromocion2x1 {
        if (valor < valorMinimo2x1){
            throw new PreciosInvalidosParaPromocion2x1();
        }
    }

    public static void comprobarPorcentajeDescuento(Double porcentaje) throws PorcentajeDescuentoInvalido {
        if (porcentaje < porcentajeMinimoDescuento || porcentaje > porcentajeMaximoDescuento){
            throw new PorcentajeDescuentoInvalido();
        }
    }


}
