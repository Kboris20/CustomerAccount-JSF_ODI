package ch.hearc.ig.odi.serie6_b.business;

import ch.hearc.ig.odi.serie6_b.exceptions.AccountAlreadyExistException;
import ch.hearc.ig.odi.serie6_b.exceptions.CustomerAlreadyExistException;
import ch.hearc.ig.odi.serie6_b.exceptions.UnknownAccountException;
import ch.hearc.ig.odi.serie6_b.exceptions.UnknownCustomerException;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Jérémy
 */
public class Bank {

    private int number;
    private String name;
    private HashMap<String, Account> accounts = new HashMap<>();
    private HashMap<Integer, Customer> customers = new HashMap<>();
    private HashMap<Integer, Individual> individuals = new HashMap<>();

    public Bank(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public HashMap<Integer, Customer> getCustomers() {
        return this.customers;
    }

    public HashMap<String, Account> getAccounts() {
        return this.accounts;
    }

    public Account getAccountByNumber(String number) throws UnknownAccountException {
        if (this.accounts.get(number) != null) {
            return this.accounts.get(number);
        } else {
            throw new UnknownAccountException(number);
        }
    }

    public Customer getCustomerByNumber(int number) throws UnknownCustomerException {
        if (this.customers.get(number) != null) {
            return this.customers.get(number);
        } else {
            throw new UnknownCustomerException(number);
        }
    }

    public Individual addIndividual(int number, String firstName, String lastName, Date p_birthdate, String p_email) throws CustomerAlreadyExistException {
        Individual i = new Individual(number, firstName, lastName, p_birthdate, p_email);
        if (this.individuals.get(number) == null) {
            this.individuals.put(number, i);
        } else {
            throw new CustomerAlreadyExistException();
        }
        
        return i;
    }

    
    public Company addCompany(int number, String companyName, String phone, String fax) throws CustomerAlreadyExistException {
        if (this.customers.get(number) == null) {
            Company comp = new Company(number, companyName, phone, fax);
            this.customers.put(number, comp);
            return comp;
        } else {
            throw new CustomerAlreadyExistException();
        }
    }

    public void addAccount(Account account, Customer customer) throws AccountAlreadyExistException {
        if (this.accounts.get(account.getNumber()) == null) {
            this.accounts.put(account.getNumber(), account);
            this.customers.get(customer.getNumber()).addAccount(account);
        } else {
            throw new AccountAlreadyExistException();
        }
    }

    public void addAccount(String number, String name, double rate, Customer customer) throws AccountAlreadyExistException {
        this.addAccount(new Account(number, name, rate, customer), customer);
    }
}
