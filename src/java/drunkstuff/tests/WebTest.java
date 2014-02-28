package drunkstuff.tests;

import drunkstuff.calculator.Person;
import drunkstuff.controller.Calculator_Controller;


/**
 *
 * @author jensb
 */
public class WebTest {
    private Person person;
    private String gender;
    private double BAC;
    private int age;
    private double weight;
    private double drinks;
    private double hours; 
    private String results;
    
    public WebTest() {
        person = new Person();
        Calculator_Controller controller = new Calculator_Controller(person);
        updatePerson();
    }
    
    private void updatePerson() {
        this.gender = person.getGender();
        this.BAC = person.getBAC();
        this.age = person.getAge();
        this.weight = person.getWeight();
        this.drinks = person.getNumberOfDrinks();
        this.hours = person.getHoursSinceFirstDrink();
        this.setResults(person.toString());
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender; 
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        person = new Person(
                gender, 
                this.weight, 
                this.age, 
                this.drinks, 
                this.hours);
        updatePerson();
    }

    /**
     * @return the BAC
     */
    public double getBAC() {
        return BAC;
    }

    /**
     * @param BAC the BAC to set
     */
    public void setBAC(double BAC) {
        this.BAC = BAC;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        person = new Person(
                this.gender, 
                this.weight, 
                age, 
                this.drinks, 
                this.hours);
        updatePerson();
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        person = new Person(
                this.gender, 
                weight, 
                this.age, 
                this.drinks, 
                this.hours);
        updatePerson();
    }

    /**
     * @return the drinks
     */
    public double getDrinks() {
        return drinks;
    }

    /**
     * @param drinks the drinks to set
     */
    public void setDrinks(double drinks) {
        person = new Person(
                this.gender, 
                this.weight, 
                this.age, 
                drinks, 
                this.hours);
        updatePerson();
    }

    /**
     * @return the hours
     */
    public double getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(double hours) {
        person = new Person(
                this.gender, 
                this.weight, 
                this.age, 
                this.drinks, 
                hours);
        updatePerson();
    }

    /**
     * @return the results
     */
    public String getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(String results) {
        this.results = results;
    }
}