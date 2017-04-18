import ar.edu.untref.aydoo.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestIntegracion {

    @Test
    public void testObtenerEstablecimientoConMasBeneficiosOtorgados(){
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        // Tarjetas ofrecidas
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        // Estableclimiento Heladeria A , sucursales y tipos de beneficio segun tarjeta
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@restaurantB.edu.ar");
        heladeriaA.adherirTipoBeneficio(10.0, tarjetaBeneficioClassic);
        heladeriaA.adherirTipoBeneficio(20.0, tarjetaBeneficioPremium);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", heladeriaA);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", heladeriaA);
        // Establecimiento Restaurant B, sucursales y tipo de beneficios segun tarjeta
        Establecimiento restaurantB = new Establecimiento("Restaurant B", "establecimiento@restaurantB.edu.ar");
        restaurantB.adherirTipoBeneficio(20.0, tarjetaBeneficioClassic);
        restaurantB.adherirTipoBeneficio(20.0, tarjetaBeneficioPremium);
        Sucursal s3 = new Sucursal("s3", "Direccion s3", restaurantB);
        // Registro de establecimiento al club de descuento
        clubDeDescuento.adherirEstablecimiento(heladeriaA);
        clubDeDescuento.adherirEstablecimiento(restaurantB);
        // Clientes que realizaran las operaciones
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente juan = clubDeDescuento.adherirCliente("Juan", "juan@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clientePremium = clubDeDescuento.adherirCliente("Cliente Anonimo Premium", "premium@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clienteClassic = clubDeDescuento.adherirCliente("Cliente Anonimo Classic", "classic@aydoo.edu.ar", tarjetaBeneficioPremium);

        s1.registrarBeneficio(carlos, 1000.0);
        s1.registrarBeneficio(clienteClassic, 1000.0);
        s1.registrarBeneficio(clienteClassic, 1000.0);
        s1.registrarBeneficio(clienteClassic, 1000.0);
        s1.registrarBeneficio(juan, 1000.0);
        s1.registrarBeneficio(clientePremium, 1000.0);
        s1.registrarBeneficio(clientePremium, 1000.0);
        s3.registrarBeneficio(carlos, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);

        Establecimiento establecimientoConMasBeneficiosOtorgados = clubDeDescuento.obtenerEstablecimientoConMasBeneficiosOtorgados();

        Assert.assertEquals(heladeriaA, establecimientoConMasBeneficiosOtorgados);
    }

    @Test
    public void testObtenerSucursalConMasBeneficiosOtorgados() {
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        // Tarjetas ofrecidas
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        // Estableclimiento Heladeria A , sucursales y tipos de beneficio segun tarjeta
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@restaurantB.edu.ar");
        heladeriaA.adherirTipoBeneficio(10.0, tarjetaBeneficioClassic);
        heladeriaA.adherirTipoBeneficio(20.0, tarjetaBeneficioPremium);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", heladeriaA);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", heladeriaA);
        // Establecimiento Restaurant B, sucursales y tipo de beneficios segun tarjeta
        Establecimiento restaurantB = new Establecimiento("Restaurant B", "establecimiento@restaurantB.edu.ar");
        restaurantB.adherirTipoBeneficio(20.0, tarjetaBeneficioClassic);
        restaurantB.adherirTipoBeneficio(20.0, tarjetaBeneficioPremium);
        Sucursal s3 = new Sucursal("s3", "Direccion s3", restaurantB);
        // Registro de establecimiento al club de descuento
        clubDeDescuento.adherirEstablecimiento(heladeriaA);
        clubDeDescuento.adherirEstablecimiento(restaurantB);
        // Clientes que realizaran las operaciones
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente juan = clubDeDescuento.adherirCliente("Juan", "juan@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clientePremium = clubDeDescuento.adherirCliente("Cliente Anonimo Premium", "premium@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clienteClassic = clubDeDescuento.adherirCliente("Cliente Anonimo Classic", "classic@aydoo.edu.ar", tarjetaBeneficioPremium);

        s1.registrarBeneficio(carlos, 1000.0);
        s1.registrarBeneficio(clienteClassic, 1000.0);
        s1.registrarBeneficio(clienteClassic, 1000.0);
        s1.registrarBeneficio(clienteClassic, 1000.0);
        s1.registrarBeneficio(juan, 1000.0);
        s1.registrarBeneficio(clientePremium, 1000.0);
        s1.registrarBeneficio(clientePremium, 1000.0);
        s3.registrarBeneficio(carlos, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);

        Sucursal sucursalConMasBeneficiosOtorgados = clubDeDescuento.obtenerSucursalConMasBeneficiosOtorgados();

        Assert.assertEquals(s1, sucursalConMasBeneficiosOtorgados);
    }

    @Test
    public void testObtenerTotalDeAhorroPorCliente() {
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        // Tarjetas ofrecidas
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        // Estableclimiento Heladeria A , sucursales y tipos de beneficio segun tarjeta
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@restaurantB.edu.ar");
        heladeriaA.adherirTipoBeneficio(10.0, tarjetaBeneficioClassic);
        heladeriaA.adherirTipoBeneficio(20.0, tarjetaBeneficioPremium);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", heladeriaA);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", heladeriaA);
        // Establecimiento Restaurant B, sucursales y tipo de beneficios segun tarjeta
        Establecimiento restaurantB = new Establecimiento("Restaurant B", "establecimiento@restaurantB.edu.ar");
        restaurantB.adherirTipoBeneficio(20.0, tarjetaBeneficioClassic);
        restaurantB.adherirTipoBeneficio(20.0, tarjetaBeneficioPremium);
        Sucursal s3 = new Sucursal("s3", "Direccion s3", restaurantB);
        // Registro de establecimiento al club de descuento
        clubDeDescuento.adherirEstablecimiento(heladeriaA);
        clubDeDescuento.adherirEstablecimiento(restaurantB);
        // Clientes que realizaran las operaciones
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente juan = clubDeDescuento.adherirCliente("Juan", "juan@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clientePremium = clubDeDescuento.adherirCliente("Cliente Anonimo Premium", "premium@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clienteClassic = clubDeDescuento.adherirCliente("Cliente Anonimo Classic", "classic@aydoo.edu.ar", tarjetaBeneficioPremium);

        s1.registrarBeneficio(carlos, 1000.0);
        s1.registrarBeneficio(clienteClassic, 1000.0);
        s1.registrarBeneficio(clienteClassic, 1000.0);
        s1.registrarBeneficio(clienteClassic, 1000.0);
        s1.registrarBeneficio(juan, 1000.0);
        s1.registrarBeneficio(clientePremium, 1000.0);
        s1.registrarBeneficio(clientePremium, 1000.0);
        s3.registrarBeneficio(carlos, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);
        s3.registrarBeneficio(clienteClassic, 1000.0);

        Map<Cliente, Double> totalDeAhorroPorClienteEsperado = new HashMap<>();
        totalDeAhorroPorClienteEsperado.put(juan, 200.0);
        totalDeAhorroPorClienteEsperado.put(carlos, 300.0);
        totalDeAhorroPorClienteEsperado.put(clienteClassic, 1600.0);
        totalDeAhorroPorClienteEsperado.put(clientePremium, 400.0);
        Map<Cliente, Double> totalDeAhorroPorCliente = clubDeDescuento.obtenerTotalDeAhorroPorCliente();

        Assert.assertEquals(totalDeAhorroPorClienteEsperado, totalDeAhorroPorCliente);
    }

}
