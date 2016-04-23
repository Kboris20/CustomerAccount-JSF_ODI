package ch.hearc.ig.odi.serie6_b.beans;

import ch.hearc.ig.odi.serie6_b.exceptions.AccountAlreadyExistException;
import ch.hearc.ig.odi.serie6_b.exceptions.CustomerAlreadyExistException;
import ch.hearc.ig.odi.serie6_b.services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author boris.klett
 */
@Named
@RequestScoped
public class CustomerCreateBean implements Serializable {

    private Integer number;
    private String lastName;
    private String firstName;

    @Inject
    Services services;

    public CustomerCreateBean() {
    }

    public String saveCustomer() throws CustomerAlreadyExistException, AccountAlreadyExistException {

        services.saveCustomer(this.number, this.firstName, this.lastName);
        return "success";
    }

    public String processPageCreateCustomer() {
        return "success";
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

}
