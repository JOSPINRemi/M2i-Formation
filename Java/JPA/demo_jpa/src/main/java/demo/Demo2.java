package demo;

import entity.Person;

import javax.persistence.*;
import java.util.List;

public class Demo2 {
    public static void main() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        transac.begin();
        /*Person person = null;
        try {
            person = em.getReference(Person.class, 1L);
//            System.out.println(person);
        } catch (EntityNotFoundException e) {
            System.out.println("Entity non trouvée");
        }

//        Récupération par Query
//        Single Result :
        Query query = em.createQuery("SELECT p FROM Person p WHERE p.nom = 'pesquet'", Person.class);
        Person person2 = (Person) query.getSingleResult();
        System.out.println(person2);

//        Result List
        Query query1 = em.createQuery("SELECT p FROM Person p WHERE p.id > 3");
        List<Person> personList = query1.getResultList();
        for (Person p : personList) {
            System.out.println("person : " + p.getNom());
        }

//        Paramètres nommés
        Query query2 = em.createQuery("SELECT p FROM Person p WHERE p.id > :id");
        query2.setParameter("id", 3L);
        List<Person> personList2 = query2.getResultList();
        for (Person p : personList2) {
            System.out.println("person trouvée avec parametre nommé : " + p.getNom());
        }

        System.out.println("Modifier une occurence :");
        Person person4 = em.find(Person.class, 4L);
        person4.setNom("Pesquet");
        person4.setPrenom("Romain");

        transac.commit();
        person4 = em.find(Person.class, 4L);
        System.out.println("Person : " + person4);*/

        System.out.println("RollBack :");
        Person person6 = new Person("Jim", "Paul");
        em.persist(person6);
        if (person6.getId() == 11L){
            System.out.println("person rollback " + person6.getId());
            transac.rollback();
        }
        else {
            em.getTransaction().commit();
            System.out.println("person " + person6.getId());
        }

        System.out.println("NativeQuery :");
        List<Person> personList = em.createNativeQuery("SELECT * FROM person", Person.class).getResultList();
        for (Person p : personList){
            System.out.println("p : " + p);
        }
        em.close();
        emf.close();
    }
}
