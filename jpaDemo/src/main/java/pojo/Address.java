package pojo;

import javax.persistence.*;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
@Entity
@SequenceGenerator(name="johnq02",sequenceName="john_seq02",initialValue=1,allocationSize=1)
public class Address {
    @Id
    @GeneratedValue(generator="johnq02",strategy= GenerationType.SEQUENCE)
    private Integer id;
    private String city;
    private String zipcode;

    // address 指向 customer
    // cascade = CascadeType.PERSIST address 和 Customer 一起持久化
    // cascade = CascadeType.REMOVE 指的是一起 xxx ({cascade = CascadeType.REFRESH, cascade = CascadeType.DETACH})
    // CascadeType.ALL 相当于 值类型了， 实体类就没什么用了
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "c_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
