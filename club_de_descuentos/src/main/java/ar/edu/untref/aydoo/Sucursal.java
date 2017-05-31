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

    public void registrarVentaConDescuento(Cliente cliente, String nombreProducto, double valorCompra) {
        Double descuento = this.obtenerDescuentoSegunTarjeta(cliente.obtenerTarjetaBeneficio());
        Double valorBeneficio = this.computarValorBeneficioDescuento(descuento, valorCompra);
        Beneficio beneficioOtorgado = new Beneficio(cliente, this.establecimiento, this, nombreProducto, valorCompra, valorCompra-valorBeneficio);
        this.obtenerBeneficiosOtorgados().add(beneficioOtorgado);
        cliente.registrarBeneficio(beneficioOtorgado);
    }


    public void registrarVentaConPromocion2x1(Cliente cliente, String nombreProducto1, double valorCompra1, String nombreProducto2, double valorCompra2) throws PreciosInvalidosParaPromocion2x1 {
        String nombreProductoMayorValor = ComparadorDePrecios.obtenerProductoMayorValor(nombreProducto1, valorCompra1, nombreProducto2, valorCompra2);
        Double precioProductoMayorValor = ComparadorDePrecios.obtenerPrecioProductoMayorValor(valorCompra1, valorCompra2);
        String nombreProductoMenorValor = ComparadorDePrecios.obtenerProductoMenorValor(nombreProducto1, valorCompra1, nombreProducto2, valorCompra2);
        Double precioProductoMenorValor = ComparadorDePrecios.obtenerPrecioProductoMenorValor(valorCompra1, valorCompra2);
        PoliticaPromocion.comprobarValorMinimo2x1(precioProductoMayorValor);

        Beneficio beneficioOtorgado = new Beneficio(cliente, this.establecimiento, this, nombreProductoMenorValor, precioProductoMenorValor, 0.0);
        this.obtenerBeneficiosOtorgados().add(beneficioOtorgado);
        cliente.registrarBeneficio(beneficioOtorgado);
    }

    public Double computarValorBeneficioDescuento(Double descuento, double valorCompra) {
        return valorCompra * ( descuento / 100);
    }

    public Double obtenerDescuentoSegunTarjeta(TarjetaBeneficio tarjetaBeneficio) {
        return this.obtenerEstablecimiento().obtenerBeneficiosDescuento().get(tarjetaBeneficio);
    }

    public int obtenerCantidadDeBeneficiosOtorgados() {
        return this.obtenerBeneficiosOtorgados().size();
    }

}
