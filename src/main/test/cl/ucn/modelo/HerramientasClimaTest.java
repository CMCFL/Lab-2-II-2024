package cl.ucn.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class HerramientasClimaTest {


    @Test
    public void testConsejoClimaticoCancelar() {
        assertEquals("CANCELAR", HerramientasClima.consejoClimatico(70.1,0.0));
    }

    @Test
    public void testConsejoClimaticoAdvertencia1() {
        assertEquals("ADVERTENCIA", HerramientasClima.consejoClimatico(46,0.0));
    }

    @Test
    public void testConsejoClimaticoAdvertencia2() {
        assertEquals("ADVERTENCIA", HerramientasClima.consejoClimatico(0,5));
    }

    @Test
    public void testConsejoClimaticoError1() {
        Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
            HerramientasClima.consejoClimatico(-1,0.0);
        });
    }

    @Test
    public void testConsejoClimaticoError2() {
        Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
            HerramientasClima.consejoClimatico(0,-1);
        });
    }

}
