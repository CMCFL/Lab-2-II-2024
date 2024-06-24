package cl.ucn.modelo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConsultasTest {

    IConsultaClima cci;

    @BeforeAll
    public void setUp(){

        cci = new ConsultasClimaImpl();
    }

    @Test
    public void testFindByAnho(){

        List<Clima> lst= cci.findByAnho(2014);
        assertEquals(2014, lst.get(0).getAnho());
    }

    @Test
    public void testFindByVelocidadVientoGreaterThan(){

        List<Clima> lst= cci.findByVelocidadVientoGreaterThan(12);
        for (Clima cl : lst)
            assertTrue(12 < cl.getVelocidadViento());
    }

    @Test
    public void testFindByLluviaBetween(){

        List<Clima> lst= cci.findByLluviaBetween(1,2);
        for (Clima cl : lst)
            assertTrue(1 <= cl.getLluvia() && 2 >= cl.getLluvia() );
    }

    @AfterAll
    public void tearDown(){

        cci = null;

    }


}
