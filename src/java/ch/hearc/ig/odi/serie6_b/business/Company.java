/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.serie6_b.business;

/**
 *
 * @author julien.plumez
 */
public class Company extends Customer{

    private String companyName;
    private String phone;
    private String fax;
    
    public Company(){
        this(null, null, null, null);
    }
    
    public Company(Integer number, String companyName, String phone, String fax) {
        super();
        
        this.phone = phone;
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    
}
