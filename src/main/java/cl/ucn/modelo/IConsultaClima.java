package cl.ucn.modelo;

import java.util.List;

public interface IConsultaClima {

    List<Clima> findByAnho(int anho);

    List<Clima> findByVelocidadVientoGreaterThan(double velocidad);

    List<Clima> findByLluviaBetween(double minLLuvia, double maxLluvia);

}
