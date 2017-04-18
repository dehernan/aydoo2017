package ar.edu.untref.aydoo;

public class Mail {
    Establecimiento establecimiento;
    String productoComprado;
    Double precioHabitual;
    Double beneficioObtenido;

    public Mail(Establecimiento establecimiento, String productoComprado, double precioHabitual, double beneficioObtenido){
        this.establecimiento = establecimiento;
        this.productoComprado = productoComprado;
        this.precioHabitual = precioHabitual;
        this.beneficioObtenido = beneficioObtenido;
    }

    public Establecimiento obtenerEstablecimiento(){
        return establecimiento;
    }
    public String obtenerProductoComprado(){
        return productoComprado;
    }
    public double obtenerPrecioHabitual(){
        return precioHabitual;
    }
    public double obtenerBeneficioObtenido(){
        return beneficioObtenido;
    }
    public boolean equals(Object a){

        if(a instanceof Mail) {
            Mail comparado = (Mail) a;
            if (this.obtenerEstablecimiento() == comparado.obtenerEstablecimiento() &&
                    this.obtenerProductoComprado() == comparado.obtenerProductoComprado() &&
                    this.obtenerPrecioHabitual() == comparado.obtenerPrecioHabitual() &&
                    this.obtenerBeneficioObtenido() == comparado.obtenerBeneficioObtenido()) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }
}
