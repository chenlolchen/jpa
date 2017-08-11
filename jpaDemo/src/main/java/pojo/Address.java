package pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="johnq03",sequenceName="john_seq03",initialValue=1,allocationSize=1)
public class Address {
    @Id
    @GeneratedValue(generator="johnq03",strategy=GenerationType.SEQUENCE)
    private Integer id;
    private String city;
    private String zipcode;
    @ManyToOne
    @JoinColumn(name="c_id")
    private Customer customer;

    public Address() {
    }

    public Address(Integer id, String city, String zipcode) {
        this.id = id;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
