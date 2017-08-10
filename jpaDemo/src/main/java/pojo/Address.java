package pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
@Embeddable
public class Address {
    @Column(unique = true)
    private String city;
    private String zipcode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return city != null ? city.equals(address.city) : address.city == null;

    }

    @Override
    public int hashCode() {
        return city != null ? city.hashCode() : 0;
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
