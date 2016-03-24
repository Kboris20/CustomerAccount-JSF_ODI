package ch.hearc.ig.odi.serie3.business;

import ch.hearc.ig.odi.serie3.exceptions.AccountAlreadyExistException;
import ch.hearc.ig.odi.serie3.exceptions.UnknownAccountException;
import java.util.HashMap;

public class Customer {

    private Integer number;
    HashMap<String, Account> accounts = new HashMap<>();

    public Customer() {
        
    }

    /**
     *
     * @param number
     */
    public Customer(Integer number) {
        this.number = number;
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
