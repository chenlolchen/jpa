package pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENCO7 on 8/9/2017.
 */

@Entity
@Table(name = "customers")
@SequenceGenerator(name="johnq",sequenceName="john_seq01",initialValue=1,allocationSize=1)
public class Customer {
    @Id
    @GeneratedValue(generator="johnq",strategy=GenerationType.SEQUENCE)
    private Integer id;
    // 实体完整性约束
    @Column(name = "c_name", nullable = true, length = 40, insertable = false, updatable = true, unique = false)
    private String name;
    //    @Transient // 不写入表
    private int age;

    @Column(columnDefinition = "char(2)") // 改变数据库字段存放的值
    private boolean sex;

    // 多对一, 外键在'多'上
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "tels", joinColumns = {@JoinColumn(name = "c_id")})
    @Column(name = "tel_num")
    private Set<String> tels = new HashSet<String>();

    public Set<String> getTels() {
        return tels;
    }

    public void setTels(Set<String> tels) {
        this.tels = tels;
    }

    public Customer() {
    }

    public Customer(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
