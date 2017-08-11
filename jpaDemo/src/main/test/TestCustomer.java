import org.junit.*;
import pojo.Customer;
import pojo.Customer_;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
public class TestCustomer {
    private static EntityManagerFactory factory;
    private EntityManager manager;

    @BeforeClass
    public static void init(){
        factory = Persistence.createEntityManagerFactory("john");
    }

    @AfterClass
    public static void destory(){
        factory.close();
    }

    @Before
    public void start(){
        manager = factory.createEntityManager();
    }

    @After
    public void end(){
        manager.close();
    }

    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setName("cody3");
        customer.setAge(33);
        customer.setSex(true);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        manager.persist(customer);

        tx.commit();
    }

    @Test
    public void testLoad(){
        CriteriaBuilder qb = manager.getCriteriaBuilder();
        CriteriaQuery<Customer> c = qb.createQuery(Customer.class);
        Root<Customer> p = c.from(Customer.class);
        Predicate condition = qb.equal(p.get(Customer_.name), "cody3");
        c.where(condition);
        TypedQuery<Customer> q = manager.createQuery(c);
        List<Customer> result = q.getResultList();
        System.out.println(result.get(0));
    }

    @Test
    public void testUpdate(){
        Customer customer = manager.find(Customer.class, 1);
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        customer.setAge(111);
        customer.setAge(69);
        tx.commit();
    }

    @Test
    public void testDelete(){
        Customer customer = manager.find(Customer.class, 1);
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.remove(customer);
        tx.commit();
        // 删除后，对象仍然存在
        System.out.println(customer);
    }

}
