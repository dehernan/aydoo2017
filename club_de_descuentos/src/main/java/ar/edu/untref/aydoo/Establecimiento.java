package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.exceptions.PorcentajeDescuentoInvalido;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Establecimiento {

    protected String nombre;

    protected String mail;

    protected Map<TarjetaBeneficio, Double> beneficiosDescuento;

    protected Map<TarjetaBeneficio, Boolean> beneficioPromocion2x1;

    protected Set<Sucursal> sucursales;

    public Establecimiento(String nombre, String mail) {
        this.nombre = nombre;
        this.mail = mail;
        this.beneficiosDescuento = new HashMap<>();
        this.beneficioPromocion2x1 = new HashMap<>();
        this.sucursales = new HashSet<>();
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public String obtenerMail() {
        return this.mail;
    }

    public Map<TarjetaBeneficio, Double> obtenerBeneficiosDescuento() {
        return this.beneficiosDescuento;
    }

    public Map<TarjetaBeneficio, Boolean> obtenerBeneficiosPromocion2x1() {
        return this.beneficioPromocion2x1;
    }

    public void adherirBeneficioDescuento(double descuento, TarjetaBeneficio tarjetaBeneficio) throws PorcentajeDescuentoInvalido{
        //El descuento no puede ser menor al 5%
        if(descuento<5 || descuento>100){
            throw new PorcentajeDescuentoInvalido();
        }
        else {
            this.obtenerBeneficiosDescuento().put(tarjetaBeneficio, descuento);
        }
    }

    public void adherirBeneficioPromocion2x1(TarjetaBeneficio tarjetaBeneficio){

        this.obtenerBeneficiosPromocion2x1().put(tarjetaBeneficio, true);

    }

    public Integer obtenerCantidadDeBeneficiosOtorgados() {
        Integer cantidadBeneficiosOtorgados = 0;
        for (Sucursal sucursales: this.obtenerSucursales()) {
            cantidadBeneficiosOtorgados += sucursales.obtenerCantidadDeBeneficiosOtorgados();
        }
        return cantidadBeneficiosOtorgados;
    }

    private Set<Sucursal> obtenerSucursales() {
        return this.sucursales;
    }

    public void adherirSucursal(Sucursal sucursal) {
        this.obtenerSucursales().add(sucursal);
    }

    public Sucursal obtenerSucursalConMasBeneficiosOtorgados() {
        Sucursal sucursalConMasBeneficiosOtorgados = null;
        Integer cantidadMayorBeneficiosOtorgados = 0;
        for (Sucursal sucursal: this.obtenerSucursales()) {
            Integer cantidadBeneficiosOtorgados = sucursal.obtenerCantidadDeBeneficiosOtorgados();
            if (cantidadBeneficiosOtorgados > cantidadMayorBeneficiosOtorgados) {
                sucursalConMasBeneficiosOtorgados = sucursal;
                cantidadMayorBeneficiosOtorgados = cantidadBeneficiosOtorgados;
            }
        }
        return sucursalConMasBeneficiosOtorgados;
    }
}
