package ch.hearc.ig.odi.serie6_b.beans;

import ch.hearc.ig.odi.serie6_b.business.Account;
import ch.hearc.ig.odi.serie6_b.business.Customer;
import ch.hearc.ig.odi.serie6_b.exceptions.UnknownCustomerException;
import ch.hearc.ig.odi.serie6_b.services.Services;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CustomerDisplayBean implements Serializable {

    private String id_from_setProperties;
    private Integer id_setProperties;
    private Integer number;
    private String lastName;
    private String firstName;

    @Inject
    Services services;

    public CustomerDisplayBean() {
    }

    public String getCustomer() throws UnknownCustomerException {
        this.id_setProperties = Integer.parseInt(this.id_from_setProperties);
        Customer c = services.getCustomer(this.id_setProperties);
        this.number = c.getNumber();
        this.lastName = c.getLastName();
        this.firstName = c.getFirstName();
        return "success";
    }

    public List<Account> getCustomerAccountsList() {
        return services.getAccountsByCust(this.id_setProperties);
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

    public String getId_from_setProperties() {
        return id_from_setProperties;
    }

    public void setId_from_setProperties(String id_from_setProperties) {
        this.id_from_setProperties = id_from_setProperties;
    }

}
