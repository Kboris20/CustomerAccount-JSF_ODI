package ch.hearc.ig.odi.serie6_b.beans;

import ch.hearc.ig.odi.serie6_b.business.Account;
import ch.hearc.ig.odi.serie6_b.business.Customer;
import ch.hearc.ig.odi.serie6_b.exceptions.UnknownCustomerException;
import ch.hearc.ig.odi.serie6_b.services.Services;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class CustomerDisplayBean implements Serializable {

    private Integer number;
    private String lastName;
    private String firstName;

    @Inject
    Services services;

    public CustomerDisplayBean() {
    }

    public String getCustomer(Customer cust) throws UnknownCustomerException {
        Customer c = services.getCustomer(cust.getNumber());
        this.number = c.getNumber();
        this.lastName = c.getLastName();
        this.firstName = c.getFirstName();
        return "success";
    }

    public List<Account> getCustomerAccountsList() {
        return services.getAccountsByCust(this.number);
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

}
