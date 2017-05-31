package ar.edu.untref.aydoo;

public class ComparadorDePrecios {

    private static String nombreProductoMayorValor;
    private static double precioProductoMayorValor;
    private static String nombreProductoMenorValor;
    private static double precioProductoMenorValor;

    public static String obtenerProductoMayorValor(String nombreProducto1, double valorCompra1, String nombreProducto2, double valorCompra2) {
        if(valorCompra1 > valorCompra2){
            nombreProductoMayorValor = nombreProducto1;
        } else{
            nombreProductoMayorValor = nombreProducto2;
        }
        return nombreProductoMayorValor;
    }

    public static Double obtenerPrecioProductoMayorValor(double valorCompra1, double valorCompra2) {
        if(valorCompra1 > valorCompra2){
            precioProductoMayorValor = valorCompra1;
        } else{
            precioProductoMayorValor = valorCompra2;
        }
        return precioProductoMayorValor;
    }

    public static String obtenerProductoMenorValor(String nombreProducto1, double valorCompra1, String nombreProducto2, double valorCompra2) {
        if(valorCompra1 < valorCompra2){
            nombreProductoMenorValor = nombreProducto1;
        } else{
            nombreProductoMenorValor = nombreProducto2;
        }
        return nombreProductoMenorValor;
    }

    public static Double obtenerPrecioProductoMenorValor(double valorCompra1, double valorCompra2) {
        if(valorCompra1 < valorCompra2){
            precioProductoMenorValor = valorCompra1;
        } else{
            precioProductoMenorValor = valorCompra2;
        }
        return precioProductoMenorValor;
    }
}
