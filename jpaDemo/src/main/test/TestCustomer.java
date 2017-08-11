import org.junit.*;
import pojo.Address;
import pojo.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
public class TestCustomer {
    private static EntityManagerFactory factory;
    private EntityManager manager;

    @BeforeClass
    public static void init() {
        factory = Persistence.createEntityManagerFactory("john");
    }

    @AfterClass
    public static void destory() {
        factory.close();
    }

    @Before
    public void start() {
        manager = factory.createEntityManager();
    }

    @After
    public void end() {
        manager.close();
    }

    @Test
    public void testSave() {
        Customer c1 = new Customer();
        c1.setName("john");
        c1.setAge(100);
        Customer c2 = new Customer();
        c2.setName("tom");
        c2.setAge(30);
        Customer c3 = new Customer();
        c3.setName("alice");
        c3.setSex(true);
        c3.setAge(50);
        Customer c4 = new Customer();
        c4.setName("mike");
        c4.setAge(70);


        Address a1 = new Address(null, "bj", "1000");
        Address a2 = new Address(null, "sh", "1001");
        Address a3 = new Address(null, "tj", "1002");
        Address a4 = new Address(null, "cz", "1003");

        c1.getAddrs().add(a1);
        c1.getAddrs().add(a2);
        a1.setCustomer(c1);
        a2.setCustomer(c1);
        c2.getAddrs().add(a3);
        a3.setCustomer(c2);
        c3.getAddrs().add(a4);
        a4.setCustomer(c3);


        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(a1);
        manager.persist(a2);
        manager.persist(a3);
        manager.persist(a4);
        manager.persist(c1);
        manager.persist(c2);
        manager.persist(c3);
        manager.persist(c4);
        tx.commit();
    }

    @Test
    public void test1() {
        String ql = "select c from pojo.Customer c where c.name =:name";
//        List<Customer> list = manager.createQuery(ql).getResultList();
//
//        for (Customer c1 : list) {
//            System.out.println(c1);
//        }

        Query q = manager.createQuery(ql);
        q.setParameter("name", "john");
        Customer customer = (Customer) q.getSingleResult();
        System.out.println(customer);
    }

    @Test
    public void test9() {
        Address a = new Address();
        a.setId(1);
        String ql = "select c from pojo.Customer c where :a member of c.addrs";


        List<Customer> list = manager.createQuery(ql)
                .setParameter("a", a)
                .getResultList();
        ;

        for (Customer c1 : list) {
            System.out.println(c1);
        }
        //q.getSingleResult();
    }

    @Test
    public void test6() {
        String ql = "select c from pojo.Customer c where c.addrs.size=0";
        List<Customer> list = manager.createQuery(ql)
                //.setParameter("cname", "john")
                .getResultList();
        ;

        for (Customer c1 : list) {
            System.out.println(c1);
        }
        //q.getSingleResult();
    }

    @Test
    public void test7() {
        String ql = "select c from pojo.Customer c where c.age in :ags";
        List<Integer> ags = new ArrayList<Integer>();
        ags.add(50);
        ags.add(70);
        List<Customer> list = manager.createQuery(ql)
                .setParameter("ags", ags)
                .getResultList();
        ;

        for (Customer c1 : list) {
            System.out.println(c1);
        }
        //q.getSingleResult();
    }

    @Test
    public void test8() {
        String ql = "select c from pojo.Customer c";
        List<Customer> list = manager.createQuery(ql)
                .setFirstResult(2)
                .setMaxResults(2)
                .getResultList();
        ;

        for (Customer c1 : list) {
            System.out.println(c1);
        }
        //q.getSingleResult();
    }

    @Test
    public void test5() {
        String ql = "select distinct c from pojo.Customer c left join fetch c.addrs where c.addrs is empty order by c.age asc";
        List<Customer> list = manager.createQuery(ql)
                //.setParameter("cname", "john")
                .getResultList();
        ;

        for (Customer c1 : list) {
            System.out.println(c1);
        }
        //q.getSingleResult();
    }

    @Test
    public void test2() {
        String ql = "select max(c.age),c.sex from pojo.Customer c group by c.sex";
        List<Object[]> list = manager.createQuery(ql).getResultList();
        ;

        for (Object[] c1 : list) {
            System.out.print(c1[0] + "\t" + c1[1]);
        }
        //q.getSingleResult();
    }

    @Test
    public void test3() {
        String ql = "select new Customer(c.name,c.age) from pojo.Customer c";
        List<Customer> list = manager.createQuery(ql).getResultList();
        ;

        for (Customer c1 : list) {
            System.out.println(c1);
        }
        //q.getSingleResult();
    }

    @Test
    public void test4() {
        String ql = "select c from pojo.Customer c where c.age>=:age";
        List<Customer> list = manager.createQuery(ql)
                .setParameter("age", 50)
                .getResultList();
        ;

        for (Customer c1 : list) {
            System.out.println(c1);
        }
        //q.getSingleResult();
    }

}
