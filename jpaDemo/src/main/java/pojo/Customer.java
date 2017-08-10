package pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by CHENCO7 on 8/9/2017.
 */

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(generator = "johnu")
    @GenericGenerator(strategy = "uuid", name = "johnu")
    private String id;
    // 实体完整性约束
    @Column(name = "c_name", nullable = true, length = 40, insertable = false, updatable = true, unique = false)
    private String name;
    //    @Transient // 不写入表
    private int age;

    @Column(columnDefinition = "char(2)") // 改变数据库字段存放的值
    private boolean sex;

    public Customer() {
    }

    public Customer(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
