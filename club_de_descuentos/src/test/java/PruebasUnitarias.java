import ar.edu.untref.aydoo.*;
import ar.edu.untref.aydoo.exceptions.PorcentajeDescuentoInvalido;
import ar.edu.untref.aydoo.exceptions.PreciosInvalidosParaPromocion2x1;
import org.junit.Assert;
import org.junit.Test;

public class PruebasUnitarias {

    @Test(expected = PorcentajeDescuentoInvalido.class)
    public void retornarExcepcionPorDescuentoMenorA5PorCiento() throws PorcentajeDescuentoInvalido {
        PoliticaPromocion.comprobarPorcentajeDescuento(3.0);
    }

    @Test(expected = PorcentajeDescuentoInvalido.class)
    public void retornarExcepcionPorDescuentoMayorA100PorCiento() throws PorcentajeDescuentoInvalido {
        PoliticaPromocion.comprobarPorcentajeDescuento(110.0);
    }

    @Test(expected = PreciosInvalidosParaPromocion2x1.class)
    public void retornarExcepcionPorPrecioInvalidoEnPromocion2x1() throws PreciosInvalidosParaPromocion2x1 {
        PoliticaPromocion.comprobarValorMinimo2x1(40.0);
    }

    @Test
    public void crearSucursalYObtenerEstablecimiento() {
        Establecimiento establecimiento = new Establecimiento("Establecimiento 1", "establecimiento@tesing.com");
        Sucursal sucursalTest = new Sucursal("Sucursal 1", "Testing Street 1234", establecimiento);

        Assert.assertEquals(establecimiento, sucursalTest.obtenerEstablecimiento());
    }

    @Test
    public void seComputaCorrectamenteElDescuentoAAplicar() throws PorcentajeDescuentoInvalido {
        Establecimiento establecimiento = new Establecimiento("Establecimiento 1", "establecimiento@tesing.com");
        Sucursal sucursalTest = new Sucursal("Sucursal 1", "Testing Street 1234", establecimiento);

        Assert.assertEquals(10.0, sucursalTest.computarValorBeneficioDescuento(10.0, 100.0), 0.0);
    }

    @Test
    public void seRetornaLaCantidadCorrectaDeBeneficiosOtorgados() throws PorcentajeDescuentoInvalido {
        Establecimiento establecimiento = new Establecimiento("Establecimiento 1", "establecimiento@tesing.com");
        Sucursal sucursalTest = new Sucursal("Sucursal 1", "Testing Street 1234", establecimiento);
        TarjetaBeneficio tarjetaBeneficioClassic = TarjetaBeneficio.CLASSIC;
        Cliente juan = new Cliente("Juan", "juan@testing.com", tarjetaBeneficioClassic);
        establecimiento.adherirBeneficioDescuento(10, tarjetaBeneficioClassic);

        sucursalTest.registrarVentaConDescuento(juan, "producto comprado", 120.0);

        Assert.assertEquals(1, sucursalTest.obtenerCantidadDeBeneficiosOtorgados());
    }

    @Test
    public void sePruebaElComparadorDePreciosCuandoSeSolicitaElNombreDelProductoMasCaro() {
        Assert.assertEquals("Producto1", ComparadorDePrecios.obtenerProductoMayorValor("Producto1", 150, "Producto2", 80));
    }

    @Test
    public void sePruebaElComparadorDePreciosCuandoSeSolicitaElPrecioDelProductoMasCaro() {
        Assert.assertEquals(150.0, ComparadorDePrecios.obtenerPrecioProductoMayorValor(150, 80), 0.0);
    }
}


