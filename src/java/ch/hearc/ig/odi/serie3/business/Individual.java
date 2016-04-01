package ch.hearc.ig.odi.serie3.business;



import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author boris.klett
 */

@Named (value = "homebean")
@RequestScoped
public class Individual extends Customer {

    String firstName;
    String lastName;
    Date birthdate;
    String email;
    
    public Individual(int number, String firstName, String lastName, Date p_birthdate, String p_email) {
        super(number);
        this.birthdate = p_birthdate;
        this.email = p_email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
    
}
