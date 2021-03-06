package ch.hearc.ig.odi.serie6_b.beans;

import ch.hearc.ig.odi.serie6_b.business.Account;
import ch.hearc.ig.odi.serie6_b.business.Customer;
import ch.hearc.ig.odi.serie6_b.exceptions.UnknownCustomerException;
import ch.hearc.ig.odi.serie6_b.services.Services;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class AccountDisplayBean implements Serializable {

    private Customer customer;
    private String number;
    private String name;
    private double balance = 0;
    private Double rate;

    @Inject
    Services services;

    public AccountDisplayBean() {
    }

    public String getAccount(Account account) throws UnknownCustomerException {
        Account c = services.getAccount(Integer.valueOf(account.getNumber()));

        this.number = c.getNumber();
        this.name = c.getName();
        this.balance = c.getBalance();
        this.rate = c.getRate();
        this.customer = c.getCustomer();
        return "success";
    }
    
    public Integer getIdCustomer(){
        return this.customer.getNumber();
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

}
