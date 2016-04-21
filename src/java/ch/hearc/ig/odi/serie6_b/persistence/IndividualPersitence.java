/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.serie6_b.persistence;

import ch.hearc.ig.odi.serie6_b.business.Individual;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author boris.klett
 */
@Named(value = "individualsBean")
@RequestScoped
public class IndividualPersitence {

    private List<Individual> individuals = new ArrayList<Individual>();
    private Individual individual;

    public IndividualPersitence() {
    }

    public void persist() {
        if (individuals.isEmpty()) {
            individual = new Individual(1, "Boris", "Klett", new Date("15.11.1992"), "klettboris@gmail.com");
            individuals.add(individual);
            individual = new Individual(2, "Elga", "Klett", new Date("15.11.1994"), "klettelga@gmail.com");
            individuals.add(individual);
            individual = new Individual(3, "Stephan", "Klett", new Date("15.11.1999"), "klettstephan@gmail.com");
            individuals.add(individual);
            individual = new Individual(4, "Marcelle", "Klett", new Date("15.11.2002"), "klettmarcelle@gmail.com");
            individuals.add(individual);
        }
    }

    public void setIndividuals(List<Individual> individuals) {
        this.individuals = individuals;
    }
    
    

}
