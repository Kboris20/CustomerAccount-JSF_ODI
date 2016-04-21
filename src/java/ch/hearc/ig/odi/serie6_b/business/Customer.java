package ch.hearc.ig.odi.serie6_b.business;

import ch.hearc.ig.odi.serie6_b.exceptions.AccountAlreadyExistException;
import ch.hearc.ig.odi.serie6_b.exceptions.UnknownAccountException;
import java.util.HashMap;

public class Customer{

    private String lastName;
    private String firstName;

    private Integer number;
    HashMap<String, Account> accounts = new HashMap<>();

    public Customer() {

    }

    public Customer(Integer id, String firstName, String lastName) {
        this.number = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     *
     * @param number
     */
    public Customer(Integer number) {
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

    public Integer getNumber() {
        return this.number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     *
     * @param number
     * @return Account
     * @throws ch.hearc.ig.odi.serie3.exceptions.UnknownAccountException
     */
    public Account getAccountByNumber(String number) throws UnknownAccountException {
        if (this.accounts.get(number) != null) {
            return this.accounts.get(number);
        } else {
            throw new UnknownAccountException(number);
        }
    }

    public void addAccount(Account account) throws AccountAlreadyExistException {
        if (this.accounts.get(account.getNumber()) == null) {
            this.accounts.put(account.getNumber(), account);
        } else {
            throw new AccountAlreadyExistException();
        }
    }

    public HashMap<String, Account> getAccounts() {
        return this.accounts;
    }

    @Override
    public String toString() {
        return this.number + "";
    }

}
