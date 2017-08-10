package pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
@Entity
@SequenceGenerator(name="johnq04",sequenceName="john_seq04",initialValue=1,allocationSize=1)
public class Address {
    @Id
    @GeneratedValue(generator="johnq04",strategy= GenerationType.SEQUENCE)
    private Integer id;
    private String city;
    private String zipcode;

    @ManyToMany
    @JoinTable(name = "a_c", joinColumns = {@JoinColumn(name = "a_id")}, inverseJoinColumns = {@JoinColumn(name = "c_id")})
    private Set<Customer> customerSet = new HashSet<Customer>();

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
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

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
