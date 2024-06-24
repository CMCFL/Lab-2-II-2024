package cl.ucn.modelo;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ConsultasClimaImpl implements IConsultaClima{

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Clima> findByAnho(int anho){

        String query = "SELECT v FROM Clima v WHERE v.anho = :anho";
        TypedQuery<Clima> tq = entityManager.createQuery(query, Clima.class);
        tq.setParameter("anho", anho);
        List<Clima> listaClima = tq.getResultList();
       return listaClima;
    }

    public List<Clima> findByVelocidadVientoGreaterThan(double velocidad){

        String query = "SELECT v FROM Clima v WHERE v.velocidadViento > :velocidadViento";
        TypedQuery<Clima> tq = entityManager.createQuery(query, Clima.class);
        tq.setParameter("velocidadViento", velocidad);
        List<Clima> listaClima = tq.getResultList();
        return listaClima;
    }

    @Override
    public List<Clima> findByLluviaBetween(double minLLuvia, double maxLluvia) {

        String query = "SELECT v FROM Clima v WHERE v.lluvia BETWEEN :minLluvia AND :maxLluvia";
        TypedQuery<Clima> tq = entityManager.createQuery(query, Clima.class);
        tq.setParameter("minLluvia", minLLuvia);
        tq.setParameter("maxLluvia", maxLluvia);
        List<Clima> listaClima = tq.getResultList();
        return listaClima;
    }
}
