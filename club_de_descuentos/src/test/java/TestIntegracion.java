import ar.edu.untref.aydoo.*;
import ar.edu.untref.aydoo.exceptions.PorcentajeDescuentoInvalido;
import ar.edu.untref.aydoo.exceptions.PreciosInvalidosParaPromocion2x1;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

}
