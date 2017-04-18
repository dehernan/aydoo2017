package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

    protected String nombre;

    protected String direccion;

    protected Establecimiento establecimiento;

    protected List<Beneficio> beneficiosOtorgados;

    public Sucursal(String nombre, String direccion, Establecimiento establecimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.establecimiento = establecimiento;
        this.establecimiento.adherirSucursal(this);
        this.beneficiosOtorgados = new ArrayList<>();
    }

    public Establecimiento obtenerEstablecimiento() {
        return this.establecimiento;
    }

    public List<Beneficio> obtenerBeneficiosOtorgados() {
        return this.beneficiosOtorgados;
    }

    public void registrarBeneficio(Cliente cliente, double valorCompra) {
        Double descuento = this.obtenerDescuentoSegunTarjeta(cliente.obtenerTarjetaBeneficio());
        Double valorBeneficio = this.computarValorBeneficio(descuento, valorCompra);
        Beneficio beneficioOtorgado = new Beneficio(cliente, valorBeneficio);
        this.obtenerBeneficiosOtorgados().add(beneficioOtorgado);
        cliente.registrarBeneficio(beneficioOtorgado);
    }

    private Double computarValorBeneficio(Double descuento, double valorCompra) {
        return valorCompra * ( descuento / 100);
    }

    protected Double obtenerDescuentoSegunTarjeta(TarjetaBeneficio tarjetaBeneficio) {
        return this.obtenerEstablecimiento().obtenerTipoBeneficios().get(tarjetaBeneficio);
    }

    public Integer obtenerCantidadDeBeneficiosOtorgados() {
        return this.obtenerBeneficiosOtorgados().size();
    }

}
