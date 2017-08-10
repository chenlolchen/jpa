package pojo;

import javax.persistence.*;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
@Entity
@SequenceGenerator(name="johnq03",sequenceName="john_seq03",initialValue=1,allocationSize=1)
public class Address {
    @Id
    @GeneratedValue(generator="johnq03",strategy= GenerationType.SEQUENCE)
    private Integer id;
    private String city;
    private String zipcode;

    // many : address, one : customer
    @ManyToOne
    @JoinColumn(name = "c_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address() {
    }

    public Address(String city, String zipcode) {
        this.city = city;
        this.zipcode = zipcode;
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
