package ar.edu.untref.aydoo;

public class Beneficio {

    protected Cliente cliente;

    protected Double valor;

    public Beneficio(Cliente cliente, Double valor) {
        this.cliente = cliente;
        this.valor = valor;
    }

    public Cliente obtenerCliente() {
        return this.cliente;
    }

    public Double obtenerValor() {
        return this.valor;
    }

}
