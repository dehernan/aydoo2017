package ar.edu.untref.aydoo;

public class Beneficio {

    protected Cliente cliente;
    protected Establecimiento establecimiento;
    protected Sucursal sucursal;
    protected String nombreProducto;
    protected double valorSinBeneficio;
    protected double valorConBeneficio;

    public Beneficio(Cliente cliente, Establecimiento establecimiento, Sucursal sucursal, String nombreProducto, double valorSinBeneficio, double valorConBeneficio) {
        this.cliente = cliente;
        this.establecimiento = establecimiento;
        this.sucursal = sucursal;
        this.nombreProducto = nombreProducto;
        this.valorSinBeneficio = valorSinBeneficio;
        this.valorConBeneficio = valorConBeneficio;
    }

    public Cliente obtenerCliente() {
        return this.cliente;
    }
    public Establecimiento obtenerEstablecimiento(){
        return this.establecimiento;
    }
    public Sucursal obtenerSucursal(){
        return this.sucursal;
    }
    public String obtenerProducto(){
        return this.nombreProducto;
    }
    public Double obtenerValorSinBeneficio(){
        return this.valorSinBeneficio;
    }
    public Double obtenerValorConBeneficio(){
        return this.valorConBeneficio;
    }
}
