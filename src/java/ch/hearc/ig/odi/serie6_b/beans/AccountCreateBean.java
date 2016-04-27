package ch.hearc.ig.odi.serie6_b.beans;

import ch.hearc.ig.odi.serie6_b.business.Account;
import ch.hearc.ig.odi.serie6_b.business.Customer;
import ch.hearc.ig.odi.serie6_b.exceptions.AccountAlreadyExistException;
import ch.hearc.ig.odi.serie6_b.exceptions.CustomerAlreadyExistException;
import ch.hearc.ig.odi.serie6_b.services.Services;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author boris.klett
 */
@Named
@SessionScoped
public class AccountCreateBean implements Serializable {

    private Customer customer;
    private String number;
    private String name;
    private double balance;
    private Double rate;

    @Inject
    Services services;

    public AccountCreateBean() {
    }

    public String saveAccount(Customer c) throws CustomerAlreadyExistException, AccountAlreadyExistException {
        Account a = new Account(this.number, this.name, this.balance, this.rate, c);
        services.saveAccount(a, this.customer);
        return "success";
    }

    public String processPageCreateAccount() {
        return "success";
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addCust(Customer customer) {
        this.customer = customer;
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
