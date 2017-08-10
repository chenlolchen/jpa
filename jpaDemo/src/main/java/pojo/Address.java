package pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
@Embeddable
public class Address {
    private String city;

    @Column(name = "code")
    private String zipcode;

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
