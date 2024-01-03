package demo;

import entity.Person;
import entity.oneToOne.Address;
import entity.oneToOne.House;
import entity.oneToOne.Type;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo4 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
    public static void main(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Address address = new Address();

        address.setNumero(46);
        address.setCodePostal("59170");
        address.setVille("rue des fleurs");
        address.setNomRue("Londres");

        House house = new House();
        house.setTaille(500);
        house.setType(Type.OLD);
        house.setAddress(address);

        em.persist(house);
        em.persist(address);
        em.getTransaction().commit();

        House house1 = em.find(House.class, house.getId());
        System.out.println("House : " + house1);

        em.close();
        emf.close();
    }
}
