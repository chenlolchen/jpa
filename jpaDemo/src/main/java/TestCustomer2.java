import pojo.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
public class TestCustomer2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("john");
        EntityManager manager = factory.createEntityManager();

        Customer customer = new Customer();
        customer.setId(3);
        customer.setName("cody3");
        customer.setAge(33);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        manager.persist(customer);

        tx.commit();

        manager.close();
        factory.close();
    }
}
