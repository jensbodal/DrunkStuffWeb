/*
 * Calculator_Controller.java
 */
package drunkstuff.controller;

import drunkstuff.calculator.Person;
import drunkstuff.view.JPanelView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens Bodal
 */
public class Calculator_Controller {

    private JPanelView view;
    private Person person;

    public Calculator_Controller(JPanelView view, Person person) {
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

    private void logException(String s1, String s2, Exception e) {
        String exceptionType[] = e.toString().split(": ");
        String message = String.format(
                "Invalid input [%s: %s], using default value for [%s: %s]: %s",
                exceptionType[1], exceptionType[2], s1, s2, exceptionType[0]);
        Logger.getLogger(Calculator_Controller.class.getName())
                .log(Level.INFO, message);

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
                } catch (NumberFormatException e) {
                    logException("age", String.valueOf(age), e);
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
                } catch (NumberFormatException e) {
                    logException("weight", String.valueOf(weight), e);
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
                } catch (NumberFormatException e) {
                    logException("drinks", String.valueOf(drinks), e);
                }
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
                } catch (NumberFormatException e) {
                    logException("hours", String.valueOf(hours), e);
                }
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
