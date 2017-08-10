import org.junit.*;
import pojo.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.*;
import java.util.Date;

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
    public void testSave() throws Exception {
        InputStream in = new FileInputStream("11.jpg");
        byte[] buf = new byte[in.available()];
        in.read(buf);
        in.close();

        Customer customer = new Customer();
        customer.setName("cody3");
        customer.setAge(33);
        customer.setSex(true);
        customer.setBirth(new Date());
        customer.setImg(buf);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        manager.persist(customer);
//        manager.flush(); // 缓存清理， 将manager里的东西清理掉
//        manager.clear(); // 清空对象， 不执行
        tx.commit();
//        tx.commit();
    }

    @Test
    public void testLoad() throws IOException {
        Customer customer = manager.find(Customer.class, 1);
        manager.refresh(customer);
        System.out.println(customer);

        // load img
        OutputStream out = new FileOutputStream("xx.jpg");
        out.write(customer.getImg());
        out.close();
    }

    @Test
    public void testMerge(){
        Customer customer = manager.find(Customer.class, 4);
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.clear();
        Customer cc = manager.merge(customer);  // 这个方法会触发一次查询
        cc.setName("yyyy");
        tx.commit();
        System.out.println(customer);
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
