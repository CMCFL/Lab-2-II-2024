package cl.ucn.vista;

import cl.ucn.modelo.Clima;
import cl.ucn.modelo.ConsultasClimaImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {

    public static void main(String[] args){

        Clima clima = new Clima();
        ConsultasClimaImpl consultas = new ConsultasClimaImpl();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Consultar año 2014
        // Como es un conjunto de mediciones por año
        // El resultado de la query solo trae una entidad Clima
        List<Clima> lista = consultas.findByAnho(2014);
        System.out.println("************** Query 1 *******************");
        System.out.println("Para el año ingresado: " + lista.get(0).getAnho());
        System.out.println("Cantidad lluvia promedio: " + lista.get(0).getLluvia());
        System.out.println("Velocidad viento promedio: "+ lista.get(0).getVelocidadViento());
        System.out.println("************** Query 2 *******************");
        lista.clear();
        lista = consultas.findByVelocidadVientoGreaterThan(12);
        for (Clima cl: lista)
            System.out.println("Para el año: "+ cl.getAnho() + " la velocidad fue de "+ cl.getVelocidadViento());
        System.out.println("************** Query 3 *******************");
        lista.clear();
        lista = consultas.findByLluviaBetween(1,2);
        for (Clima cl: lista)
            System.out.println("Para el año: "+ cl.getAnho() + " la cantidad de lluvia fue de "+ cl.getLluvia());
    }
}
