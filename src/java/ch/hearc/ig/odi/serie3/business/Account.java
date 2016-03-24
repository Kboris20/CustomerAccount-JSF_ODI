package ch.hearc.ig.odi.serie3.business;

import ch.hearc.ig.odi.serie3.exceptions.InsufficientBalanceException;
import ch.hearc.ig.odi.serie3.exceptions.NegativeAmmountException;

/**
 *
 * @author boris.klett
 *
 */
public class Account {

    private Customer customer;
    private String number;
    private String name;
    private double balance = 0;
    private Double rate;

    public Account() {

    }

    /**
     *
     * @param number
     * @param name
     * @param rate
     * @param customer
     */
    public Account(String number, String name, double rate, Customer customer) {
        this.customer = customer;
        this.number = number;
        this.name = name;
        this.rate = rate;
    }

    public String getNumber() {
        return this.number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    /**
     *
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Double getRate() {
        return this.rate;
    }

    /**
     *
     * @param rate
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     *
     * @param amount
     * @throws ch.hearc.ig.odi.serie3.exceptions.NegativeAmmountException
     */
    public void credit(double amount) throws NegativeAmmountException {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new NegativeAmmountException();
        }
    }

    /**
     *
     * @param amount
     * @throws ch.hearc.ig.odi.serie3.exceptions.NegativeAmmountException
     * @throws ch.hearc.ig.odi.serie3.exceptions.InsufficientBalanceException
     */
    public void debit(double amount) throws NegativeAmmountException, InsufficientBalanceException {
        if (this.balance > amount && amount > 0) {
            this.balance -= amount;
        } else if (amount < 0) {
            throw new NegativeAmmountException();
        } else {
            throw new InsufficientBalanceException();
        }
    }

    /**
     *
     * @param amount
     * @param source
     * @param target
     * @throws ch.hearc.ig.odi.serie3.exceptions.NegativeAmmountException
     * @throws ch.hearc.ig.odi.serie3.exceptions.InsufficientBalanceException
     */
    public static void transfer(double amount, Account source, Account target) throws NegativeAmmountException, InsufficientBalanceException {
        if (source.getBalance() > amount && amount > 0) {
            source.debit(amount);
            target.credit(amount);
        } else if (amount < 0) {
            throw new NegativeAmmountException();
        } else {
            throw new InsufficientBalanceException();
        }
    }

    @Override
    public String toString() {
        return this.number + " - " + this.name + ", solde = " + this.balance + ", taux = " + this.rate;
    }

}
