/*
 * Calculator_View.java
 */ 

package drunkstuff.view;

import drunkstuff.calculator.Person;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jens Bodal
 */
public class Calculator_View extends JPanel {
    /*
     * Storing these values here to be called upon for tests if default
     * values are wanted
     */
    private static final int v_WIDTH = 525;
    private static final int v_HEIGHT = 180;
    private static final int X = 10;
    private static final int Y = 10;
    public final static Rectangle bounds = 
            new Rectangle(X, Y, v_WIDTH, v_HEIGHT);
    private final Dimension fieldDimensions = new Dimension(50, 20);
    private FlowLayout panelLayout = new FlowLayout(FlowLayout.LEFT);
    // Gender
    private JComboBox genderChooser;
    private String gender_Label = "Choose Gender:";
    // BAC
    private JTextField BAC_Field;
    private String BAC_Label = "BAC:";
    // Age
    private JTextField age_Field;
    private String age_Label = "Age:";
    // Weight
    private JTextField weight_Field;
    private String weight_Label = "Weight:";
    // Number of Drinks
    private JTextField drinks_Field;
    private String drinks_Label = "Number of Drinks";
    // Hours since first drink
    private JTextField hours_Field;
    private String hours_Label = "Hours since first drink:";
    // Results Field
    private JLabel results_Field;
    
    private Person person;
    
    public Calculator_View(Person person) {
        this.person = person;
        startup();
    }
    
    public void updatePerson(Person person) {
        this.person = person;
        setBAC_Field(person.getBAC());
        setAge_Field(person.getAge());
        setWeight_Field(person.getWeight());
        setDrinks_Field(person.getNumberOfDrinks());
        setHours_Field(person.getHoursSinceFirstDrink());
        setResults_Field(person.toString());
    }
    
    /*
     * This should only be called once on initialization
     */
    private void startup() {
        // Initialize all fields
        initGenderChooser();
        initBAC_Field();
        initAge_Field();
        initWeight_Field();
        initDrinks_Field();
        initHours_Field();
        initResults_Field();
        this.add(mainPanel());
    }
    
    private JPanel mainPanel() {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(6, 2);
        panel.setLayout(layout);
        panel.setBounds(X, Y, v_WIDTH, v_HEIGHT);
        panel.add(genderPanel());
        panel.add(bacPanel());
        panel.add(agePanel());
        panel.add(weightPanel());
        panel.add(drinkPanel());
        panel.add(hoursPanel());
        panel.add(resultsPanel());
        return panel;
    }
    
    private JPanel genderPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(panelLayout);
        JLabel label = new JLabel();
        label.setText(gender_Label);
        panel.add(label);
        panel.add(genderChooser);
        return panel;
    }
    
    private JPanel bacPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(panelLayout);
        JLabel label = new JLabel();
        label.setText(BAC_Label);
        panel.add(label);
        panel.add(BAC_Field);
        return panel;
    }
    
    private JPanel agePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(panelLayout);
        JLabel label = new JLabel();
        label.setText(age_Label);
        panel.add(label);
        panel.add(age_Field);
        return panel;
    }
    
    private JPanel weightPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(panelLayout);
        JLabel label = new JLabel();
        label.setText(weight_Label);
        panel.add(label);
        panel.add(weight_Field);
        return panel;
    }
    
    private JPanel drinkPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(panelLayout);
        JLabel label = new JLabel();
        label.setText(drinks_Label);
        panel.add(label);
        panel.add(drinks_Field);
        return panel;
    }
    
    private JPanel hoursPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(panelLayout);
        JLabel label = new JLabel();
        label.setText(hours_Label);
        panel.add(label);
        panel.add(hours_Field);
        return panel;
    }
    
    private JPanel resultsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(panelLayout);
        panel.add(results_Field);
        return panel;
    }
    
    private void initGenderChooser() {
        String[] sexes = person.getGenders();
        genderChooser = new JComboBox(sexes);
    }
    
    public String getSelectedGender() {
        return genderChooser.getSelectedItem().toString();
    }
    
    public JComboBox getGenderChooser() {
        return genderChooser;
    }
    
    private void initBAC_Field() {
        BAC_Field = new JTextField();
        BAC_Field.setPreferredSize(fieldDimensions);
        BAC_Field.setText(String.valueOf(this.person.getBAC()));
        BAC_Field.setEditable(false);
    }
    
    private void setBAC_Field(double BAC) {
        String stringBAC = String.valueOf(BAC);
        BAC_Field.setText(stringBAC);
    }
    
    private void initAge_Field() {
        age_Field = new JTextField();
        age_Field.setPreferredSize(fieldDimensions);
        age_Field.setText(String.valueOf(this.person.getAge()));
    }
    
    private void setAge_Field(int age) {
        age_Field.setText(String.valueOf(age));
    }
    
    public JTextField getAge_Field() {
        return age_Field;
    }
    
    private void initWeight_Field() {
        weight_Field = new JTextField();
        weight_Field.setPreferredSize(fieldDimensions);
        weight_Field.setText(String.valueOf(this.person.getWeight()));
    }
    
    private void setWeight_Field(double weight) {
        weight_Field.setText(String.valueOf(weight));
    }
    
    public JTextField getWeight_Field() {
        return weight_Field;
    }
    
    private void initDrinks_Field() {
        drinks_Field = new JTextField();
        drinks_Field.setPreferredSize(fieldDimensions);
        drinks_Field.setText(String.valueOf(this.person.getNumberOfDrinks()));
    }
    
    private void setDrinks_Field(double drinks) {
        drinks_Field.setText(String.valueOf(drinks));
    }
    
    public JTextField getDrinks_Field() {
        return drinks_Field;
    }
    
    private void initHours_Field() {
        hours_Field = new JTextField();
        hours_Field.setPreferredSize(fieldDimensions);
        hours_Field.setText(String.valueOf
                (this.person.getHoursSinceFirstDrink()));
    }
    
    private void setHours_Field(double hours) {
        hours_Field.setText(String.valueOf(hours));
    }
    
    public JTextField getHours_Field() {
        return hours_Field;
    }
    
    private void initResults_Field() {
        results_Field = new JLabel();
        results_Field.setText(person.toString());
    }
    
    private void setResults_Field(String results) {
        results_Field.setText(results);
    }
}
