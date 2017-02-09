/**
 * Created by jeremydunsmore on 1/19/2017.
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.AddressBook;
import com.BuddyInfo;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;

public class JPATest {

    @Test
    public void testBuddies() {

        // Creating objects representing some products
        BuddyInfo buddyInfo = new BuddyInfo();
        buddyInfo.setName("Matt");
        buddyInfo.setPhone("123-456-7890");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setName("Blanch");
        buddy2.setPhone("098-765-4321");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(buddyInfo);
        em.persist(buddy2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of Buddies\n----------------");

        assertEquals(2,results.size());
        for (BuddyInfo b : results) {

            System.out.println(b);
        }

        // Closing connection
        em.close();

        emf.close();
    }

    @Test
    public void testAddressBook(){
        // Creating objects representing some products
        BuddyInfo buddyInfo = new BuddyInfo();
        buddyInfo.setName("Matt");
        buddyInfo.setPhone("123-456-7890");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setName("Blanch");
        buddy2.setPhone("098-765-4321");

        AddressBook a = new AddressBook();
        a.addBuddy(buddyInfo);
        a.addBuddy(buddy2);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(buddyInfo);
        em.persist(buddy2);
        em.persist(a);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT a FROM AddressBook a");
        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        assertEquals(1,results.size());

        assertEquals(2,results.get(0).numBuddies());
        // Closing connection
        em.close();

        emf.close();
    }

    @Test
    public void testAddressBookCascade(){
        // Creating objects representing some products
        BuddyInfo buddyInfo = new BuddyInfo();
        buddyInfo.setName("Matt");
        buddyInfo.setPhone("123-456-7890");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setName("Blanch");
        buddy2.setPhone("098-765-4321");

        AddressBook a = new AddressBook();
        a.addBuddy(buddyInfo);
        a.addBuddy(buddy2);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(a);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT a FROM AddressBook a");
        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        assertEquals(1,results.size());

        assertEquals(2,results.get(0).numBuddies());


        // Closing connection
        em.close();

        emf.close();
    }
}
