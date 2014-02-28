/*
 * Calculator_Controller.java
 */ 

package drunkstuff.controller;

import drunkstuff.calculator.Person;
import drunkstuff.view.Calculator_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jens Bodal
 */
public class Calculator_Controller {
    private Calculator_View view;
    private Person person;
    
    public Calculator_Controller(Calculator_View view, Person person) {
        this.person = person;
        this.view = view;
        this.addActionListeners();
    }
    
    public Calculator_Controller(Person person) {
        this.person = person;
    }
    
    public void updateUI() {
        view.setVisible(true);
        
    }
    
    private void addActionListeners() {
        view.getGenderChooser().addActionListener(L_Sex());
        view.getAge_Field().addActionListener(L_Age());
        view.getWeight_Field().addActionListener(L_Weight());
        view.getDrinks_Field().addActionListener(L_Drinks());
        view.getHours_Field().addActionListener(L_Hours());
    }
    
    private ActionListener L_Sex() {
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String sex = view.getSelectedGender();
                person = new Person(
                        sex, 
                        person.getWeight(), 
                        person.getAge(),
                        person.getNumberOfDrinks(), 
                        person.getHoursSinceFirstDrink());
                view.updatePerson(person);
            }
        };
    }
    
    private ActionListener L_Age() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int age = Person.DEFAULT_AGE;
                try { 
                    age = Integer.parseInt(ae.getActionCommand());
                }
                catch (NumberFormatException e) {
                    //e.printstack
                }
                person = new Person(
                        person.getGender(),
                        person.getWeight(), 
                        age,
                        person.getNumberOfDrinks(), 
                        person.getHoursSinceFirstDrink());
                view.updatePerson(person);
            }
            
        };
    }
    
    private ActionListener L_Weight() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                double weight = Person.DEFAULT_WEIGHT;
                try {
                    weight = Double.parseDouble(ae.getActionCommand());
                }
                catch (Exception e) {
                    //e.printStackTrace();
                }
                person = new Person(
                        person.getGender(),
                        weight, 
                        person.getAge(),
                        person.getNumberOfDrinks(), 
                        person.getHoursSinceFirstDrink());
                view.updatePerson(person);
            }
            
        };
    }
    
    private ActionListener L_Drinks() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                double drinks = Person.DEFAULT_DRINKS;
                try {
                    drinks = Double.parseDouble(ae.getActionCommand());
                }
                catch (Exception e) {};
                person = new Person(
                        person.getGender(), 
                        person.getWeight(),
                        person.getAge(),
                        drinks, 
                        person.getHoursSinceFirstDrink());
                view.updatePerson(person);
            }
            
        };
    }
    
    private ActionListener L_Hours() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                double hours = Person.DEFAULT_HOURS;
                try {
                    hours = Double.parseDouble(ae.getActionCommand());
                }
                catch (Exception e) {};
                person = new Person(
                        person.getGender(), 
                        person.getWeight(),
                        person.getAge(),
                        person.getNumberOfDrinks(), 
                        hours);
                view.updatePerson(person);
            }
            
        };
    }

        
    
    
}
