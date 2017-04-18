package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.exceptions.PreciosInvalidosParaPromocion2x1;

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

    public void registrarBeneficioDescuento(Cliente cliente, String nombreProducto, double valorCompra) {
        Double descuento = this.obtenerDescuentoSegunTarjeta(cliente.obtenerTarjetaBeneficio());
        Double valorBeneficio = this.computarValorBeneficioDescuento(descuento, valorCompra);
        Beneficio beneficioOtorgado = new Beneficio(cliente, this.establecimiento, this, nombreProducto, valorCompra, valorCompra-valorBeneficio);
        this.obtenerBeneficiosOtorgados().add(beneficioOtorgado);
        cliente.registrarBeneficio(beneficioOtorgado);
    }


    public void registrarBeneficioPromocion2x1(Cliente cliente, String nombreProducto1, double valorCompra1, String nombreProducto2, double valorCompra2) throws PreciosInvalidosParaPromocion2x1 {
        if (!esAplicablePromocion2x1(valorCompra1, valorCompra2)) {
            throw new PreciosInvalidosParaPromocion2x1();

        } else {
            Double valorBeneficio;
            String nombreProductoConBeneficio;
            if (valorCompra1 > valorCompra2) {
                valorBeneficio = valorCompra2;
                nombreProductoConBeneficio = nombreProducto2;
            } else {
                valorBeneficio = valorCompra1;
                nombreProductoConBeneficio = nombreProducto1;
            }

            Beneficio beneficioOtorgado = new Beneficio(cliente, this.establecimiento, this, nombreProductoConBeneficio, valorBeneficio, 0.0);
            this.obtenerBeneficiosOtorgados().add(beneficioOtorgado);
            cliente.registrarBeneficio(beneficioOtorgado);
        }
    }

    private Double computarValorBeneficioDescuento(Double descuento, double valorCompra) {
        return valorCompra * ( descuento / 100);
    }

    protected boolean esAplicablePromocion2x1(Double valorCompra1, double valorCompra2){

        if(valorCompra1<100 && valorCompra2<100){
            return false;
        }
        else{
            return true;
        }

    }

    protected Double obtenerDescuentoSegunTarjeta(TarjetaBeneficio tarjetaBeneficio) {
        return this.obtenerEstablecimiento().obtenerBeneficiosDescuento().get(tarjetaBeneficio);
    }

    public Integer obtenerCantidadDeBeneficiosOtorgados() {
        return this.obtenerBeneficiosOtorgados().size();
    }

}
