package ch.hearc.ig.odi.serie6_b.business;

import ch.hearc.ig.odi.serie6_b.exceptions.AccountAlreadyExistException;
import ch.hearc.ig.odi.serie6_b.exceptions.CustomerAlreadyExistException;
import ch.hearc.ig.odi.serie6_b.exceptions.UnknownAccountException;
import ch.hearc.ig.odi.serie6_b.exceptions.UnknownCustomerException;
import ch.hearc.ig.odi.serie6_b.services.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;

/**
 *
 * @author Jérémy
 */
public class Bank implements Serializable {

    private List<Account> listAccount;
    private int number;
    private String name;
    private HashMap<String, Account> accounts = new HashMap<String, Account>();
    private HashMap<Integer, Customer> customers = new HashMap<>();
    private HashMap<Integer, Individual> individuals = new HashMap<>();

    public Bank() {
    }

    @Inject
    Services services;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Individual> getIndividuals() {
        return individuals;
    }

    public void setIndividuals(HashMap<Integer, Individual> individuals) {
        this.individuals = individuals;
    }

    public HashMap getCustomerList() {
        return this.customers;
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

    public Customer addCustomer(int number, String firstName, String lastName) throws CustomerAlreadyExistException {
        Customer c = new Customer(number, firstName, lastName);
        if (this.customers.get(number) == null) {
            this.customers.put(number, c);
        } else {
            throw new CustomerAlreadyExistException();
        }

        return c;
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

    public void addAccount(String number, String name, double balance, double rate, Customer customer) throws AccountAlreadyExistException {
        this.addAccount(new Account(number, name, balance, rate, customer), customer);
    }

    public void addAccount(String number, String name, double rate, Customer customer) throws AccountAlreadyExistException {
        this.addAccount(new Account(number, name, rate, customer), customer);
    }

    public List<Account> getAccountsByCust(Integer cust_id) {
        listAccount = new ArrayList<Account>();
        for (Entry<String, Account> entry : this.accounts.entrySet()) {
            Account account = entry.getValue();
            if (account.getCustomer().getNumber() == cust_id) {
                listAccount.add(account);
            }
        }

        return listAccount;
    }

    public Account getAccountById(Integer id_account) {
        return this.accounts.get(String.valueOf(id_account));
    }

}
