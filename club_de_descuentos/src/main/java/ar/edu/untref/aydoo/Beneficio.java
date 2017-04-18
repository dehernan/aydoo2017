package ar.edu.untref.aydoo;

public class Beneficio {

    protected Cliente cliente;
    protected String nombreProducto;
    protected Double valorSinBeneficio;
    protected Double valorConBeneficio;

    public Beneficio(Cliente cliente, String nombreProducto, double valorSinBeneficio, double valorConBeneficio) {
        this.cliente = cliente;
        this.nombreProducto = nombreProducto;
        this.valorSinBeneficio = valorSinBeneficio;
        this.valorConBeneficio = valorConBeneficio;
    }

    public Cliente obtenerCliente() {
        return this.cliente;
    }

    public Double obtenerValorConBeneficio() {
        return this.valorConBeneficio;
    }

    public Double obtenerValorSinBeneficio(){
        return this.valorSinBeneficio;
    }

}
