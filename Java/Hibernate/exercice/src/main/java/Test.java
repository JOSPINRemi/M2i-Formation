import model.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Transaction transaction = null;


        try (sessionFactory; Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
//            region Exercice 1
//            region Question 1 : Créer cinq produits
            /*List<String> marques = new ArrayList<>();
            marques.add("Adidas");
            marques.add("Nike");
            marques.add("Ferrari");
            marques.add("Porsche");
            marques.add("Bic");
            for (int i = 0; i < 5; i++) {
                Produit produit = new Produit();
                produit.setMarque(marques.get(i));
                produit.setReference(String.valueOf(i));
                produit.setDateAchat(new Date());
                produit.setPrix((double) ((i + 1) * 50));
                produit.setStock((i + 1) * 10);
                session.save(produit);
            }*/
//            endregion

//            region Question 2 : Afficher les informations du produit dont id = 2
            /*Produit produit = session.get(Produit.class, 2L);
            System.out.println("Produit : " + produit);*/
//            endregion

//            region Question 3 : Supprimer le produit dont id = 3
            /*Produit produit1 = session.get(Produit.class, 3L);
            session.delete(produit1);
            System.out.println("Produit supprimé\nDétails du produit supprimé : " + produit1);*/
//            endregion

//            region Question 4 : Modifier les informations du produit dont id = 1
            /*Produit produit2 = session.get(Produit.class, 1L);
            System.out.println("Produit avant mise à jour : " + produit2);
            produit2.setPrix(produit2.getPrix() * 100);
            session.update(produit2);
            System.out.println("Produit après mise à jour : " + produit2);*/
//            endregion
//            endregion


//            region Exercice 2
//            region Question 1 : Afficher la totalité des produits
            /*Query<Produit> produitsQuery = session.createQuery("FROM Produit");
            List<Produit> produits = produitsQuery.list();
            produits.forEach(System.out::println);*/
//            endregion

//            region Question 2 : Afficher la liste des produits dont le prix est supérieur à 100 euros
            /*Query<Produit> produitsQueryPrixSup100 = session.createQuery("FROM Produit WHERE prix > 100");
            List<Produit> produitsPrixSup100 = produitsQueryPrixSup100.list();
            produitsPrixSup100.forEach(System.out::println);*/
//            endregion

//            region Question 3 : Afficher la liste des produits achetés entre deux dates
            /*Query<Produit> produitsQueryEntre2Dates = session.createQuery("FROM Produit WHERE dateAchat BETWEEN '2024-01-08' AND  '2024-01-10'");
            List<Produit> produitsEntre2Dates = produitsQueryEntre2Dates.list();
            produitsEntre2Dates.forEach(System.out::println);*/
//            endregion
//            endregion
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }
}
