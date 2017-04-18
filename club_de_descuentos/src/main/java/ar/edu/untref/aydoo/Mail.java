package ar.edu.untref.aydoo;

public class Mail {
    Establecimiento establecimiento;
    String productoComprado;
    Double precioHabitual;
    Double beneficioObtenido;

    public Mail(Establecimiento establecimiento, String productoComprado, double precioHabitual, Double beneficioObtenido){
        this.establecimiento = establecimiento;
        this.productoComprado = productoComprado;
        this.precioHabitual = precioHabitual;
        this.beneficioObtenido = beneficioObtenido;
    }
}
