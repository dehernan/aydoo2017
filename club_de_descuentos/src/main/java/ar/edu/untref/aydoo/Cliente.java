package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    protected String nombre;

    protected String mail;

    protected TarjetaBeneficio tarjetaBeneficio;

    protected List<Beneficio> beneficiosObtenidos;

    public Cliente(String nombre, String mail, TarjetaBeneficio tarjetaBeneficio) {
        this.nombre = nombre;
        this.mail = mail;
        this.tarjetaBeneficio = tarjetaBeneficio;
        this.beneficiosObtenidos = new ArrayList<>();
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerMail() {
        return mail;
    }

    public TarjetaBeneficio obtenerTarjetaBeneficio() {
        return tarjetaBeneficio;
    }

    public List<Beneficio> obtenerBeneficiosObtenidos() {
        return this.beneficiosObtenidos;
    }

    public void registrarBeneficio(Beneficio beneficio){
        this.obtenerBeneficiosObtenidos().add(beneficio);
    }

    public Double obtenerMontoAhorrado(){
        double montoAhorrado = 0;
        for(Beneficio beneficio: this.obtenerBeneficiosObtenidos()){
            montoAhorrado += beneficio.obtenerValor();
        }
        return montoAhorrado;
    }

}
