/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.serie6_b.beans;

import ch.hearc.ig.odi.serie6_b.business.Customer;
import ch.hearc.ig.odi.serie6_b.exceptions.AccountAlreadyExistException;
import ch.hearc.ig.odi.serie6_b.exceptions.CustomerAlreadyExistException;
import ch.hearc.ig.odi.serie6_b.services.Services;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author boris.klett
 */
@Named
@RequestScoped
public class CustomerBean implements Serializable {
    @Inject
    Services services;

    public CustomerBean() {
    }

    public List<Customer> getCustomerList() throws CustomerAlreadyExistException, AccountAlreadyExistException {
        return services.getCustomersList();
    }
    
    public String processPageListCustomers() {
        return "success";
    }

}
