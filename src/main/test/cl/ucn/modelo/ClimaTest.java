package cl.ucn.modelo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClimaTest {

    Clima clima = null;

    @BeforeAll
    public void setUp(){
        clima = new Clima();
        clima.setId(1);
        clima.setAnho(2024);
        clima.setLluvia(46);
        clima.setVelocidadViento(7);
    }

    @Test
    public void testGetId(){
        assertEquals(1,clima.getId());
    }

    @Test
    public void testGetAnho(){
        assertEquals(2024,clima.getAnho());
    }

    @Test
    public void testGetLluvia(){
        assertEquals(46,clima.getLluvia());
    }

    @Test
    public void testGetVelocidadViento(){
        assertEquals(7,clima.getVelocidadViento());
    }

    @AfterAll
    public void tearDown(){
        clima = null;
    }
}
