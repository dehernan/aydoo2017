package ar.edu.untref.aydoo;

import java.util.*;

public class ClubDeDescuento {

    protected Set<Establecimiento> establecimientos;

    protected Set<Cliente> clientes;

    public ClubDeDescuento() {
        this.establecimientos = new HashSet<>();
        this.clientes = new HashSet<>();
    }

    protected Set<Establecimiento> obtenerEstablecimientos() {
        return this.establecimientos;
    }

    public void adherirEstablecimiento(Establecimiento establecimiento) {
        this.obtenerEstablecimientos().add(establecimiento);
    }

    public Cliente adherirCliente(String nombreCliente, String mailCliente, TarjetaBeneficio tarjetaBeneficio) {
        Cliente nuevoCliente = new Cliente(nombreCliente, mailCliente, tarjetaBeneficio);
        this.obtenerClientes().add(nuevoCliente);
        return nuevoCliente;
    }

    protected Set<Cliente> obtenerClientes() {
        return this.clientes;
    }

    public Establecimiento obtenerEstablecimientoConMasBeneficiosOtorgados() {
        Establecimiento establecimientoConMasCantidadDeBeneficios = null;
        Integer cantidadMayorDeBeneficios = 0;
        for (Establecimiento establecimiento: this.obtenerEstablecimientos()) {
            Integer cantidadDeBeneficios = establecimiento.obtenerCantidadDeBeneficiosOtorgados();
            if (cantidadDeBeneficios > cantidadMayorDeBeneficios) {
                cantidadMayorDeBeneficios = cantidadDeBeneficios;
                establecimientoConMasCantidadDeBeneficios = establecimiento;
            }
        }
        return establecimientoConMasCantidadDeBeneficios;
    }

    public Sucursal obtenerSucursalConMasBeneficiosOtorgados() {
        Sucursal sucursalConMasBeneficiosOtorgados = null;
        Integer cantidadMayorDeBeneficios = 0;
        for (Establecimiento establecimiento: this.obtenerEstablecimientos()) {
            Sucursal sucursalConMasBeneficiosOtorgadosEnEstablecimiento = establecimiento.obtenerSucursalConMasBeneficiosOtorgados();
            Integer cantidadDeBeneficios = sucursalConMasBeneficiosOtorgadosEnEstablecimiento.obtenerCantidadDeBeneficiosOtorgados();
            if (cantidadDeBeneficios > cantidadMayorDeBeneficios) {
                sucursalConMasBeneficiosOtorgados = sucursalConMasBeneficiosOtorgadosEnEstablecimiento;
                cantidadMayorDeBeneficios = cantidadDeBeneficios;
            }
        }
        return sucursalConMasBeneficiosOtorgados;
    }

    public Map<Cliente, Double> obtenerTotalDeAhorroPorCliente() {

        Map<Cliente, Double> clienteYMontoObtenido = new HashMap<>();
        for(Cliente cliente: this.obtenerClientes()){
            clienteYMontoObtenido.put(cliente, cliente.obtenerMontoAhorrado());
        }
        return clienteYMontoObtenido;
    }

    public Map<Cliente, Mail> obtenerReporteMensualPorCliente(){
        Map <Cliente, Mail> reporteMensual= new HashMap<>();
        for(Cliente cliente: this.obtenerClientes()){
            if(cliente.obtenerMontoAhorrado()>0){
                List<Beneficio> beneficiosDelCliente = cliente.obtenerBeneficiosObtenidos();
                Iterator<Beneficio> iterador = beneficiosDelCliente.iterator();
                while(iterador.hasNext()) {
                    Beneficio beneficioActual = iterador.next();
                    Mail mailAEnviar = new Mail(beneficioActual.obtenerEstablecimiento(),  beneficioActual.obtenerProducto(),
                            beneficioActual.obtenerValorSinBeneficio(), beneficioActual.obtenerValorSinBeneficio()-beneficioActual.obtenerValorConBeneficio());
                    reporteMensual.put(cliente, mailAEnviar);
                }
            }
        }
        return reporteMensual;
    }
}
