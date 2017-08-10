package pojo;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
@Embeddable
public class FullName implements Serializable {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FullName fullName = (FullName) o;

        if (firstName != null ? !firstName.equals(fullName.firstName) : fullName.firstName != null) return false;
        return lastName != null ? lastName.equals(fullName.lastName) : fullName.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
