import ar.edu.untref.aydoo.*;
import ar.edu.untref.aydoo.exceptions.PorcentajeDescuentoInvalido;
import ar.edu.untref.aydoo.exceptions.PreciosInvalidosParaPromocion2x1;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TestIntegracion {

    @Test(expected=PorcentajeDescuentoInvalido.class)
    public void retornarExcepcionPorDescuentoMenorA5PorCiento() throws PorcentajeDescuentoInvalido{
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@restaurantB.edu.ar");

        heladeriaA.adherirBeneficioDescuento(3.0, tarjetaBeneficioClassic);

    }

    @Test(expected=PorcentajeDescuentoInvalido.class)
    public void retornarExcepcionPorDescuentoMayorA100PorCiento() throws PorcentajeDescuentoInvalido{
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@restaurantB.edu.ar");

        heladeriaA.adherirBeneficioDescuento(120.0, tarjetaBeneficioClassic);

    }

    @Test(expected=PreciosInvalidosParaPromocion2x1.class)
    public void retornarExcepcionPorPrecioInvalidoEnPromocion2x1() throws PreciosInvalidosParaPromocion2x1{
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@restaurantB.edu.ar");
        heladeriaA.adherirBeneficioPromocion2x1(tarjetaBeneficioClassic);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", heladeriaA);
        clubDeDescuento.adherirEstablecimiento(heladeriaA);
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);

        s1.registrarBeneficioPromocion2x1(carlos, "1/4 kg helado", 50.0, "1/2 kh helado", 80.0);

    }

    @Test
    public void testAdherirBeneficioDescuento() throws PorcentajeDescuentoInvalido {

        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento libreriaElAltillo = new Establecimiento("El Altillo", "elaltillo@elaltillo.com.ar");
        libreriaElAltillo.adherirBeneficioDescuento(20, tarjetaBeneficioClassic);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", libreriaElAltillo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAltillo);
        Cliente mateo = clubDeDescuento.adherirCliente("Mateo", "mateo@aydoo.edu.ar", tarjetaBeneficioClassic);

        s1.registrarBeneficioDescuento(mateo, "Martin Fierro",100.0);

        Map<Cliente, Double> totalDeAhorroPorClienteEsperado = new HashMap<>();
        totalDeAhorroPorClienteEsperado.put(mateo, 20.0);
        Map<Cliente, Double> totalDeAhorroPorCliente = clubDeDescuento.obtenerTotalDeAhorroPorCliente();

        Assert.assertEquals(totalDeAhorroPorClienteEsperado, totalDeAhorroPorCliente);

    }

    @Test
    public void testAdherirBeneficioPromocion2x1() throws PorcentajeDescuentoInvalido, PreciosInvalidosParaPromocion2x1 {

        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento libreriaElAltillo = new Establecimiento("El Altillo", "elaltillo@elaltillo.com.ar");
        libreriaElAltillo.adherirBeneficioDescuento(10.0, tarjetaBeneficioClassic);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", libreriaElAltillo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAltillo);
        Cliente mateo = clubDeDescuento.adherirCliente("Mateo", "mateo@aydoo.edu.ar", tarjetaBeneficioClassic);

        s1.registrarBeneficioPromocion2x1(mateo, "Martin Fierro",100.0, "El cantar del Cid", 80.0);

        Map<Cliente, Double> totalDeAhorroPorClienteEsperado = new HashMap<>();
        totalDeAhorroPorClienteEsperado.put(mateo, 80.0);
        Map<Cliente, Double> totalDeAhorroPorCliente = clubDeDescuento.obtenerTotalDeAhorroPorCliente();

        Assert.assertEquals(totalDeAhorroPorClienteEsperado, totalDeAhorroPorCliente);

    }

    @Test
    public void testAdherirBeneficioDescuentoYPromocion2x1ParaElMismoEstablecimiento() throws PreciosInvalidosParaPromocion2x1, PorcentajeDescuentoInvalido{
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento libreriaElAltillo = new Establecimiento("El Altillo", "elaltillo@elaltillo.com.ar");
        libreriaElAltillo.adherirBeneficioDescuento(50.0, tarjetaBeneficioClassic);
        libreriaElAltillo.adherirBeneficioPromocion2x1(tarjetaBeneficioClassic);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", libreriaElAltillo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAltillo);
        Cliente mateo = clubDeDescuento.adherirCliente("Mateo", "mateo@aydoo.edu.ar", tarjetaBeneficioClassic);

        s1.registrarBeneficioPromocion2x1(mateo, "Martin Fierro",100.0, "El cantar del Cid", 80.0);
        s1.registrarBeneficioDescuento(mateo, "El psicoanalista", 80.0);

        Map<Cliente, Double> totalDeAhorroPorClienteEsperado = new HashMap<>();
        totalDeAhorroPorClienteEsperado.put(mateo, 120.0);
        Map<Cliente, Double> totalDeAhorroPorCliente = clubDeDescuento.obtenerTotalDeAhorroPorCliente();

        Assert.assertEquals(totalDeAhorroPorClienteEsperado, totalDeAhorroPorCliente);
    }

    @Test
    public void testObtenerEstablecimientoConMasBeneficiosOtorgados() throws PorcentajeDescuentoInvalido {
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@restaurantB.edu.ar");
        heladeriaA.adherirBeneficioDescuento(10.0, tarjetaBeneficioClassic);
        heladeriaA.adherirBeneficioDescuento(20.0, tarjetaBeneficioPremium);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", heladeriaA);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", heladeriaA);
        Establecimiento restaurantB = new Establecimiento("Restaurant B", "establecimiento@restaurantB.edu.ar");
        restaurantB.adherirBeneficioDescuento(20.0, tarjetaBeneficioClassic);
        restaurantB.adherirBeneficioDescuento(20.0, tarjetaBeneficioPremium);
        Sucursal s3 = new Sucursal("s3", "Direccion s3", restaurantB);
        clubDeDescuento.adherirEstablecimiento(heladeriaA);
        clubDeDescuento.adherirEstablecimiento(restaurantB);
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente juan = clubDeDescuento.adherirCliente("Juan", "juan@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clientePremium = clubDeDescuento.adherirCliente("Cliente Anonimo Premium", "premium@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clienteClassic = clubDeDescuento.adherirCliente("Cliente Anonimo Classic", "classic@aydoo.edu.ar", tarjetaBeneficioPremium);

        s1.registrarBeneficioDescuento(carlos, "Helado", 1000.0);
        s1.registrarBeneficioDescuento(clienteClassic, "Helado", 1000.0);
        s1.registrarBeneficioDescuento(clienteClassic, "Helado", 1000.0);
        s1.registrarBeneficioDescuento(clienteClassic, "Helado", 1000.0);
        s1.registrarBeneficioDescuento(juan, "Helado", 1000.0);
        s1.registrarBeneficioDescuento(clientePremium, "Helado",1000.0);
        s1.registrarBeneficioDescuento(clientePremium, "Helado", 1000.0);
        s3.registrarBeneficioDescuento(carlos, "Almuerzo", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "Almuerzo", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "Cena", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "Almuerzo", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "Cena",1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "Cena", 1000.0);

        Establecimiento establecimientoConMasBeneficiosOtorgados = clubDeDescuento.obtenerEstablecimientoConMasBeneficiosOtorgados();

        Assert.assertEquals(heladeriaA, establecimientoConMasBeneficiosOtorgados);
    }

    @Test
    public void testObtenerEstablecimientoConMasBeneficiosOtorgados2() throws PorcentajeDescuentoInvalido, PreciosInvalidosParaPromocion2x1 {
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento libreriaElAltillo = new Establecimiento("El Altillo", "elaltillo@elaltillo.com.ar");
        libreriaElAltillo.adherirBeneficioDescuento(20.0, tarjetaBeneficioClassic);
        libreriaElAltillo.adherirBeneficioPromocion2x1(tarjetaBeneficioPremium);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", libreriaElAltillo);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", libreriaElAltillo);
        Establecimiento libreriaElAteneo = new Establecimiento("El Ateneo", "elateneo@elateneo.com.ar");
        libreriaElAteneo.adherirBeneficioDescuento(30, tarjetaBeneficioClassic);
        libreriaElAteneo.adherirBeneficioPromocion2x1(tarjetaBeneficioPremium);
        Sucursal s3 = new Sucursal("s3", "Direccion s3", libreriaElAteneo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAltillo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAteneo);
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente juan = clubDeDescuento.adherirCliente("Juan", "juan@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clientePremium = clubDeDescuento.adherirCliente("Cliente Anonimo Premium", "premium@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clienteClassic = clubDeDescuento.adherirCliente("Cliente Anonimo Classic", "classic@aydoo.edu.ar", tarjetaBeneficioClassic);

        s1.registrarBeneficioDescuento(carlos, "Harry Potter",200.0);
        s1.registrarBeneficioDescuento(carlos, "Cruce Peligroso", 100.0);
        s1.registrarBeneficioDescuento(carlos, "La lechuza", 100.0);
        s1.registrarBeneficioDescuento(clienteClassic, "Ingenieria de Software", 500.0);
        s1.registrarBeneficioDescuento(clienteClassic, "Martin Fierro", 100.0);
        s2.registrarBeneficioDescuento(clienteClassic, "El caballero de la armadura oxidada", 100.0);
        s2.registrarBeneficioDescuento(clienteClassic, "El psicoanalista", 200.0);
        s2.registrarBeneficioDescuento(clienteClassic, "Los Silicon Boys", 1000.0);
        s2.registrarBeneficioDescuento(clienteClassic, ".NET", 1000.0);
        s2.registrarBeneficioDescuento(clienteClassic, "SQL Server", 1000.0);
        s2.registrarBeneficioPromocion2x1(juan, "Juegos de Ingenio", 100.0, "El emperador", 200);
        s3.registrarBeneficioPromocion2x1(clientePremium, "Martin Fierro", 100.0, "El cantar del Cid", 80.0);
        s3.registrarBeneficioPromocion2x1(clientePremium, "Harry Potter",200.0, "Harry Potter 2", 250);

        Sucursal sucursalConMasBeneficiosOtorgados = clubDeDescuento.obtenerSucursalConMasBeneficiosOtorgados();

        Assert.assertEquals(libreriaElAltillo, clubDeDescuento.obtenerEstablecimientoConMasBeneficiosOtorgados());

    }

    @Test
    public void testObtenerEstablecimientoConMasBeneficiosOtorgados3() throws PorcentajeDescuentoInvalido, PreciosInvalidosParaPromocion2x1 {
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento libreriaElAltillo = new Establecimiento("El Altillo", "elaltillo@elaltillo.com.ar");
        libreriaElAltillo.adherirBeneficioDescuento(20.0, tarjetaBeneficioClassic);
        libreriaElAltillo.adherirBeneficioPromocion2x1(tarjetaBeneficioPremium);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", libreriaElAltillo);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", libreriaElAltillo);
        Establecimiento libreriaElAteneo = new Establecimiento("El Ateneo", "elateneo@elateneo.com.ar");
        libreriaElAteneo.adherirBeneficioDescuento(30, tarjetaBeneficioClassic);
        libreriaElAteneo.adherirBeneficioPromocion2x1(tarjetaBeneficioPremium);
        Sucursal s3 = new Sucursal("s3", "Direccion s3", libreriaElAteneo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAltillo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAteneo);
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente juan = clubDeDescuento.adherirCliente("Juan", "juan@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clientePremium = clubDeDescuento.adherirCliente("Cliente Anonimo Premium", "premium@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clienteClassic = clubDeDescuento.adherirCliente("Cliente Anonimo Classic", "classic@aydoo.edu.ar", tarjetaBeneficioClassic);

        s1.registrarBeneficioDescuento(carlos, "Harry Potter",200.0);
        s1.registrarBeneficioDescuento(carlos, "Cruce Peligroso", 100.0);
        s1.registrarBeneficioDescuento(carlos, "La lechuza", 100.0);
        s2.registrarBeneficioDescuento(clienteClassic, "Ingenieria de Software", 500.0);
        s2.registrarBeneficioDescuento(clienteClassic, "Martin Fierro", 100.0);
        s3.registrarBeneficioDescuento(clienteClassic, "El caballero de la armadura oxidada", 100.0);
        s3.registrarBeneficioDescuento(clienteClassic, "El psicoanalista", 200.0);
        s3.registrarBeneficioDescuento(clienteClassic, "Los Silicon Boys", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, ".NET", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "SQL Server", 1000.0);
        s3.registrarBeneficioPromocion2x1(juan, "Juegos de Ingenio", 100.0, "El emperador", 200);
        s3.registrarBeneficioPromocion2x1(clientePremium, "Martin Fierro", 100.0, "El cantar del Cid", 80.0);
        s3.registrarBeneficioPromocion2x1(clientePremium, "Harry Potter",200.0, "Harry Potter 2", 250);

        Sucursal sucursalConMasBeneficiosOtorgados = clubDeDescuento.obtenerSucursalConMasBeneficiosOtorgados();

        Assert.assertEquals(libreriaElAteneo, clubDeDescuento.obtenerEstablecimientoConMasBeneficiosOtorgados());

    }

    @Test
    public void testObtenerSucursalConMasBeneficiosOtorgados() throws PorcentajeDescuentoInvalido {
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@restaurantB.edu.ar");
        heladeriaA.adherirBeneficioDescuento(10.0, tarjetaBeneficioClassic);
        heladeriaA.adherirBeneficioDescuento(20.0, tarjetaBeneficioPremium);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", heladeriaA);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", heladeriaA);
        Establecimiento restaurantB = new Establecimiento("Restaurant B", "establecimiento@restaurantB.edu.ar");
        restaurantB.adherirBeneficioDescuento(20.0, tarjetaBeneficioClassic);
        restaurantB.adherirBeneficioDescuento(20.0, tarjetaBeneficioPremium);
        Sucursal s3 = new Sucursal("s3", "Direccion s3", restaurantB);
        clubDeDescuento.adherirEstablecimiento(heladeriaA);
        clubDeDescuento.adherirEstablecimiento(restaurantB);
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente juan = clubDeDescuento.adherirCliente("Juan", "juan@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clientePremium = clubDeDescuento.adherirCliente("Cliente Anonimo Premium", "premium@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clienteClassic = clubDeDescuento.adherirCliente("Cliente Anonimo Classic", "classic@aydoo.edu.ar", tarjetaBeneficioPremium);

        s1.registrarBeneficioDescuento(carlos, "Helado",1000.0);
        s1.registrarBeneficioDescuento(clienteClassic, "Hlado", 1000.0);
        s1.registrarBeneficioDescuento(clienteClassic, "Helado", 1000.0);
        s1.registrarBeneficioDescuento(clienteClassic, "Helado", 1000.0);
        s1.registrarBeneficioDescuento(juan, "Helado", 1000.0);
        s1.registrarBeneficioDescuento(clientePremium, "Helado", 1000.0);
        s1.registrarBeneficioDescuento(clientePremium, "Helado", 1000.0);
        s3.registrarBeneficioDescuento(carlos, "Cena", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "Almuerzo", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "Cena", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "Cena", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "Almuerzo",1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "Almuerzo", 1000.0);

        Sucursal sucursalConMasBeneficiosOtorgados = clubDeDescuento.obtenerSucursalConMasBeneficiosOtorgados();

        Assert.assertEquals(s1, sucursalConMasBeneficiosOtorgados);

    }

    @Test
    public void testObtenerSucursalConMasBeneficiosOtorgados2() throws PorcentajeDescuentoInvalido, PreciosInvalidosParaPromocion2x1 {
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento libreriaElAltillo = new Establecimiento("El Altillo", "elaltillo@elaltillo.com.ar");
        libreriaElAltillo.adherirBeneficioDescuento(20.0, tarjetaBeneficioClassic);
        libreriaElAltillo.adherirBeneficioPromocion2x1(tarjetaBeneficioPremium);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", libreriaElAltillo);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", libreriaElAltillo);
        Establecimiento libreriaElAteneo = new Establecimiento("El Ateneo", "elateneo@elateneo.com.ar");
        libreriaElAteneo.adherirBeneficioDescuento(30, tarjetaBeneficioClassic);
        libreriaElAteneo.adherirBeneficioPromocion2x1(tarjetaBeneficioPremium);
        Sucursal s3 = new Sucursal("s3", "Direccion s3", libreriaElAteneo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAltillo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAteneo);
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente juan = clubDeDescuento.adherirCliente("Juan", "juan@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clientePremium = clubDeDescuento.adherirCliente("Cliente Anonimo Premium", "premium@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clienteClassic = clubDeDescuento.adherirCliente("Cliente Anonimo Classic", "classic@aydoo.edu.ar", tarjetaBeneficioClassic);

        s1.registrarBeneficioDescuento(carlos, "Harry Potter",200.0);
        s1.registrarBeneficioDescuento(carlos, "Cruce Peligroso", 100.0);
        s1.registrarBeneficioDescuento(carlos, "La lechuza", 100.0);
        s1.registrarBeneficioDescuento(clienteClassic, "Ingenieria de Software", 500.0);
        s1.registrarBeneficioDescuento(clienteClassic, "Martin Fierro", 100.0);
        s1.registrarBeneficioDescuento(clienteClassic, "El caballero de la armadura oxidada", 100.0);
        s3.registrarBeneficioDescuento(clienteClassic, "El psicoanalista", 200.0);
        s3.registrarBeneficioDescuento(clienteClassic, "Los Silicon Boys", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, ".NET", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "SQL Server", 1000.0);
        s3.registrarBeneficioPromocion2x1(juan, "Juegos de Ingenio", 100.0, "El emperador", 200);
        s3.registrarBeneficioPromocion2x1(clientePremium, "Martin Fierro", 100.0, "El cantar del Cid", 80.0);
        s3.registrarBeneficioPromocion2x1(clientePremium, "Harry Potter",200.0, "Harry Potter 2", 250);

        Sucursal sucursalConMasBeneficiosOtorgados = clubDeDescuento.obtenerSucursalConMasBeneficiosOtorgados();

        Assert.assertEquals(s3, sucursalConMasBeneficiosOtorgados);

    }

    @Test
    public void testObtenerSucursalConMasBeneficiosOtorgados3() throws PorcentajeDescuentoInvalido, PreciosInvalidosParaPromocion2x1 {
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento libreriaElAltillo = new Establecimiento("El Altillo", "elaltillo@elaltillo.com.ar");
        libreriaElAltillo.adherirBeneficioDescuento(20.0, tarjetaBeneficioClassic);
        libreriaElAltillo.adherirBeneficioPromocion2x1(tarjetaBeneficioPremium);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", libreriaElAltillo);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", libreriaElAltillo);
        Establecimiento libreriaElAteneo = new Establecimiento("El Ateneo", "elateneo@elateneo.com.ar");
        libreriaElAteneo.adherirBeneficioDescuento(30, tarjetaBeneficioClassic);
        libreriaElAteneo.adherirBeneficioPromocion2x1(tarjetaBeneficioPremium);
        Sucursal s3 = new Sucursal("s3", "Direccion s3", libreriaElAteneo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAltillo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAteneo);
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente juan = clubDeDescuento.adherirCliente("Juan", "juan@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clientePremium = clubDeDescuento.adherirCliente("Cliente Anonimo Premium", "premium@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente clienteClassic = clubDeDescuento.adherirCliente("Cliente Anonimo Classic", "classic@aydoo.edu.ar", tarjetaBeneficioClassic);

        s1.registrarBeneficioDescuento(carlos, "Harry Potter",200.0);
        s1.registrarBeneficioDescuento(carlos, "Cruce Peligroso", 100.0);
        s1.registrarBeneficioDescuento(carlos, "La lechuza", 100.0);
        s1.registrarBeneficioDescuento(clienteClassic, "Ingenieria de Software", 500.0);
        s2.registrarBeneficioDescuento(clienteClassic, "Martin Fierro", 100.0);
        s2.registrarBeneficioDescuento(clienteClassic, "El caballero de la armadura oxidada", 100.0);
        s2.registrarBeneficioDescuento(clienteClassic, "El psicoanalista", 200.0);
        s2.registrarBeneficioDescuento(clienteClassic, "Los Silicon Boys", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, ".NET", 1000.0);
        s3.registrarBeneficioDescuento(clienteClassic, "SQL Server", 1000.0);
        s3.registrarBeneficioPromocion2x1(juan, "Juegos de Ingenio", 100.0, "El emperador", 200);
        s3.registrarBeneficioPromocion2x1(clientePremium, "Martin Fierro", 100.0, "El cantar del Cid", 80.0);
        s3.registrarBeneficioPromocion2x1(clientePremium, "Harry Potter",200.0, "Harry Potter 2", 250);

        Sucursal sucursalConMasBeneficiosOtorgados = clubDeDescuento.obtenerSucursalConMasBeneficiosOtorgados();

        Assert.assertEquals(s3, sucursalConMasBeneficiosOtorgados);

    }

    @Test
    public void testGeneracionDeReporte() throws PorcentajeDescuentoInvalido, PreciosInvalidosParaPromocion2x1 {
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        Establecimiento libreriaElAltillo = new Establecimiento("El Altillo", "elaltillo@elaltillo.com.ar");
        libreriaElAltillo.adherirBeneficioDescuento(50.0, tarjetaBeneficioClassic);
        libreriaElAltillo.adherirBeneficioPromocion2x1(tarjetaBeneficioClassic);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", libreriaElAltillo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAltillo);
        Cliente mateo = clubDeDescuento.adherirCliente("Mateo", "mateo@aydoo.edu.ar", tarjetaBeneficioClassic);

        s1.registrarBeneficioPromocion2x1(mateo, "Martin Fierro",100.0, "El cantar del Cid", 80.0);
        s1.registrarBeneficioDescuento(mateo, "El psicoanalista", 80.0);

        Map<Cliente, Mail> reporteMensual = new HashMap<>();
        Mail primerMailAMateo = new Mail(libreriaElAltillo, "El cantar del Cid", 80.0, 80.0);
        Mail segundoMailAMateo = new Mail(libreriaElAltillo, "El psicoanalista", 80.0, 40.0);
        reporteMensual.put(mateo, primerMailAMateo);
        reporteMensual.put(mateo, segundoMailAMateo);
        Map<Cliente, Mail> mailsPorCliente = clubDeDescuento.obtenerReporteMensualPorCliente();

        Assert.assertEquals(mailsPorCliente, reporteMensual);

    }

    @Test
    public void testGeneracionDeReporte2() throws PorcentajeDescuentoInvalido, PreciosInvalidosParaPromocion2x1 {
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento libreriaElAltillo = new Establecimiento("El Altillo", "elaltillo@elaltillo.com.ar");
        libreriaElAltillo.adherirBeneficioDescuento(50.0, tarjetaBeneficioClassic);
        libreriaElAltillo.adherirBeneficioPromocion2x1(tarjetaBeneficioPremium);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", libreriaElAltillo);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", libreriaElAltillo);
        Establecimiento libreriaElAteneo = new Establecimiento("El Ateneo", "elateneo@elateneo.com.ar");
        libreriaElAteneo.adherirBeneficioDescuento(50, tarjetaBeneficioClassic);
        libreriaElAteneo.adherirBeneficioPromocion2x1(tarjetaBeneficioPremium);
        Sucursal s3 = new Sucursal("s3", "Direccion s3", libreriaElAteneo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAltillo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAteneo);
        Cliente mateo = clubDeDescuento.adherirCliente("Mateo", "mateo@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);

        s1.registrarBeneficioPromocion2x1(mateo, "Martin Fierro",100.0, "El cantar del Cid", 80.0);
        s1.registrarBeneficioDescuento(mateo, "El psicoanalista", 80.0);
        s3.registrarBeneficioPromocion2x1(carlos, "El emperador", 80.0, "Martin Fierro", 100.0);
        s3.registrarBeneficioDescuento(carlos, "El cantar del Cid", 80.0);

        Map<Cliente, Mail> reporteMensual = new HashMap<>();
        Mail primerMailAMateo = new Mail(libreriaElAltillo, "El cantar del Cid", 80.0, 80.0);
        Mail segundoMailAMateo = new Mail(libreriaElAltillo, "El psicoanalista", 80.0, 40.0);
        Mail primerMailACarlos = new Mail(libreriaElAteneo, "El emperador", 80.0, 80.0);
        Mail segundoMailACarlos = new Mail(libreriaElAteneo, "El cantar del Cid", 80.0, 40.0);
        reporteMensual.put(mateo, primerMailAMateo);
        reporteMensual.put(mateo, segundoMailAMateo);
        reporteMensual.put(carlos, primerMailACarlos);
        reporteMensual.put(carlos, segundoMailACarlos);
        Map<Cliente, Mail> mailsPorCliente = clubDeDescuento.obtenerReporteMensualPorCliente();

        Assert.assertEquals(mailsPorCliente, reporteMensual);

    }

    @Test
    public void testGeneracionDeReporteNoDeberiaEnviarleMailAClienteQueNoUtilizoLaTarjeta() throws PorcentajeDescuentoInvalido, PreciosInvalidosParaPromocion2x1 {
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento libreriaElAltillo = new Establecimiento("El Altillo", "elaltillo@elaltillo.com.ar");
        libreriaElAltillo.adherirBeneficioDescuento(50.0, tarjetaBeneficioClassic);
        libreriaElAltillo.adherirBeneficioPromocion2x1(tarjetaBeneficioPremium);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", libreriaElAltillo);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", libreriaElAltillo);
        Establecimiento libreriaElAteneo = new Establecimiento("El Ateneo", "elateneo@elateneo.com.ar");
        libreriaElAteneo.adherirBeneficioDescuento(50, tarjetaBeneficioClassic);
        libreriaElAteneo.adherirBeneficioPromocion2x1(tarjetaBeneficioPremium);
        Sucursal s3 = new Sucursal("s3", "Direccion s3", libreriaElAteneo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAltillo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAteneo);
        Cliente mateo = clubDeDescuento.adherirCliente("Mateo", "mateo@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente noUtilizoTarjeta = clubDeDescuento.adherirCliente("Matias", "matias@aydoo.edu.ar", tarjetaBeneficioClassic);

        s1.registrarBeneficioPromocion2x1(mateo, "Martin Fierro",100.0, "El cantar del Cid", 80.0);
        s1.registrarBeneficioDescuento(mateo, "El psicoanalista", 80.0);
        s3.registrarBeneficioPromocion2x1(carlos, "El emperador", 80.0, "Martin Fierro", 100.0);
        s3.registrarBeneficioDescuento(carlos, "El cantar del Cid", 80.0);

        Map<Cliente, Mail> reporteMensual = new HashMap<>();
        Mail primerMailAMateo = new Mail(libreriaElAltillo, "El cantar del Cid", 80.0, 80.0);
        Mail segundoMailAMateo = new Mail(libreriaElAltillo, "El psicoanalista", 80.0, 40.0);
        Mail primerMailACarlos = new Mail(libreriaElAteneo, "El emperador", 80.0, 80.0);
        Mail segundoMailACarlos = new Mail(libreriaElAteneo, "El cantar del Cid", 80.0, 40.0);
        reporteMensual.put(mateo, primerMailAMateo);
        reporteMensual.put(mateo, segundoMailAMateo);
        reporteMensual.put(carlos, primerMailACarlos);
        reporteMensual.put(carlos, segundoMailACarlos);
        Map<Cliente, Mail> mailsPorCliente = clubDeDescuento.obtenerReporteMensualPorCliente();

        Assert.assertEquals(reporteMensual, mailsPorCliente);

    }

    @Test
    public void testEjemplo1Enunciado() throws PorcentajeDescuentoInvalido, PreciosInvalidosParaPromocion2x1 {
        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioPremium = new TarjetaBeneficioPremium();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento heladeriaA = new Establecimiento("Heladeria A", "heladeria@heladeria.com.ar");
        heladeriaA.adherirBeneficioDescuento(10.0, tarjetaBeneficioClassic);
        heladeriaA.adherirBeneficioDescuento(20.0, tarjetaBeneficioPremium);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", heladeriaA);
        Sucursal s2 = new Sucursal("s2", "Direccion s2", heladeriaA);
        Establecimiento restaurantB = new Establecimiento("Restaurant B", "restaurant@restaurant.com.ar");
        restaurantB.adherirBeneficioDescuento(20, tarjetaBeneficioClassic);
        restaurantB.adherirBeneficioDescuento(20.0, tarjetaBeneficioPremium);
        Sucursal s3 = new Sucursal("s3", "Direccion s3", restaurantB);
        clubDeDescuento.adherirEstablecimiento(heladeriaA);
        clubDeDescuento.adherirEstablecimiento(restaurantB);
        Cliente juan = clubDeDescuento.adherirCliente("Juan", "juan@aydoo.edu.ar", tarjetaBeneficioPremium);
        Cliente carlos = clubDeDescuento.adherirCliente("Carlos", "carlos@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente otroClienteClassic = clubDeDescuento.adherirCliente("OtroClienteClassic", "clienteclassic@aydoo.edu.ar", tarjetaBeneficioClassic);
        Cliente otroClientePremium = clubDeDescuento.adherirCliente("OtroClientePremium", "clientePremium@aydoo.edu.ar", tarjetaBeneficioPremium);

        s1.registrarBeneficioDescuento(juan, "Helado", 100);
        s1.registrarBeneficioDescuento(carlos, "Helado", 100);
        s1.registrarBeneficioDescuento(otroClienteClassic, "Helado", 100);
        s1.registrarBeneficioDescuento(otroClienteClassic, "Helado", 100);
        s1.registrarBeneficioDescuento(otroClienteClassic, "Helado", 100);
        s1.registrarBeneficioDescuento(otroClientePremium, "Helado", 100);
        s1.registrarBeneficioDescuento(otroClientePremium, "Helado", 100);
        s3.registrarBeneficioDescuento(carlos, "Cena", 500);
        s3.registrarBeneficioDescuento(otroClienteClassic, "Cena", 500);
        s3.registrarBeneficioDescuento(otroClienteClassic, "Cena", 500);
        s3.registrarBeneficioDescuento(otroClienteClassic, "Cena", 500);
        s3.registrarBeneficioDescuento(otroClienteClassic, "Cena", 500);
        s3.registrarBeneficioDescuento(otroClienteClassic, "Cena", 500);

        Map<Cliente, Mail> reporteMensual = new HashMap<>();
        Mail mailAJuan= new Mail(heladeriaA, "Helado", 100, 20.0);
        Mail primerMailACarlos = new Mail(heladeriaA, "Helado", 100, 10.0);
        Mail segundoMailACarlos = new Mail(restaurantB, "Cena", 500, 100.0);
        Mail otroMail1 = new Mail(heladeriaA, "Helado", 100, 10.0);
        Mail otroMail2 = new Mail(heladeriaA, "Helado", 100, 10.0);
        Mail otroMail3 = new Mail(heladeriaA, "Helado", 100, 10.0);
        Mail otroMail4 = new Mail(heladeriaA, "Helado", 100, 20.0);
        Mail otroMail5 = new Mail(heladeriaA, "Helado", 100, 20.0);
        Mail otroMail6 = new Mail(restaurantB, "Cena", 500, 100.0);
        Mail otroMail7 = new Mail(restaurantB, "Cena", 500, 100.0);
        Mail otroMail8 = new Mail(restaurantB, "Cena", 500, 100.0);
        Mail otroMail9 = new Mail(restaurantB, "Cena", 500, 100.0);
        Mail otroMail10 = new Mail(restaurantB, "Cena", 500, 100.0);

        reporteMensual.put(juan, mailAJuan);
        reporteMensual.put(carlos, primerMailACarlos);
        reporteMensual.put(carlos, segundoMailACarlos);
        reporteMensual.put(otroClientePremium, otroMail4);
        reporteMensual.put(otroClientePremium, otroMail5);
        reporteMensual.put(otroClienteClassic, otroMail1);
        reporteMensual.put(otroClienteClassic, otroMail2);
        reporteMensual.put(otroClienteClassic, otroMail3);
        reporteMensual.put(otroClienteClassic, otroMail6);
        reporteMensual.put(otroClienteClassic, otroMail7);
        reporteMensual.put(otroClienteClassic, otroMail8);
        reporteMensual.put(otroClienteClassic, otroMail9);
        reporteMensual.put(otroClienteClassic, otroMail10);
        Map<Cliente, Mail> mailsPorCliente = clubDeDescuento.obtenerReporteMensualPorCliente();

        Assert.assertEquals(heladeriaA, clubDeDescuento.obtenerEstablecimientoConMasBeneficiosOtorgados());
        Assert.assertEquals(s1, clubDeDescuento.obtenerSucursalConMasBeneficiosOtorgados());
        Assert.assertEquals(reporteMensual, mailsPorCliente);
    }

    @Test
    public void testEjemplo2Enunciado() throws PorcentajeDescuentoInvalido, PreciosInvalidosParaPromocion2x1 {

        ClubDeDescuento clubDeDescuento = new ClubDeDescuento();
        TarjetaBeneficio tarjetaBeneficioClassic = new TarjetaBeneficioClassic();
        Establecimiento libreriaElAltillo = new Establecimiento("El Altillo", "elaltillo@elaltillo.com.ar");
        libreriaElAltillo.adherirBeneficioDescuento(10.0, tarjetaBeneficioClassic);
        Sucursal s1 = new Sucursal("s1", "Direccion s1", libreriaElAltillo);
        clubDeDescuento.adherirEstablecimiento(libreriaElAltillo);
        Cliente mateo = clubDeDescuento.adherirCliente("Mateo", "mateo@aydoo.edu.ar", tarjetaBeneficioClassic);

        s1.registrarBeneficioPromocion2x1(mateo, "Martin Fierro",100.0, "El cantar del Cid", 80.0);

        Map<Cliente, Double> totalDeAhorroPorClienteEsperado = new HashMap<>();
        totalDeAhorroPorClienteEsperado.put(mateo, 80.0);
        Map<Cliente, Double> totalDeAhorroPorCliente = clubDeDescuento.obtenerTotalDeAhorroPorCliente();

        Assert.assertEquals(totalDeAhorroPorClienteEsperado, totalDeAhorroPorCliente);

    }

}
