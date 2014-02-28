package drunkstuff.calculator;

/**
 *
 * @author jensb
 */
public class Person implements abs {
    
    public static final String FEMALE = "Female";
    public static final String MALE = "Male";
    public static final int MINIMUM_AGE = 12;
    public static final double DEFAULT_WEIGHT = 150;
    public static final int DEFAULT_AGE = 21;
    public static final double DEFAULT_DRINKS = 4;
    public static final double DEFAULT_HOURS = 2;
    private double numberOfDrinks;
    private double weight;
    private double hours; // likely moved 
    private String gender;
    private int age;
    private Legality legality;
    private double legalBAC;
    private double BAC;
    private BAC_Calculator calc;
    
    public Person() {
        this(MALE, DEFAULT_WEIGHT, DEFAULT_AGE, DEFAULT_DRINKS, DEFAULT_HOURS);
    }   
    
   
    public Person(String gender, double weight, int age, 
            double drinks, double hours) {
        setGender(gender);
        setWeight(weight);
        setAge(age);
        setNumberOfDrinks(drinks);
        setHoursSinceLastDrink(hours);
        calc = new BAC_Calculator(this);
        BAC = calc.getBAC();
        setBAC(calc.getBAC());
    }
    
    public String[] getGenders() {
        String[] genders = {MALE, FEMALE};
        return genders;
    }
    
    private void setGender(String gender) {
        if (gender.equals(FEMALE)) {
            this.gender = FEMALE;
        }
        if (gender.equals(MALE)) {
            this.gender = MALE;
        }
    }
    
    private void setNumberOfDrinks(double drinks) {
        if (drinks < 0) {
            drinks = 0;
        }
        this.numberOfDrinks = drinks;
    }
    
    private void setHoursSinceLastDrink(double hours) {
        if (hours < 0) {
            hours = 0;
        }
        this.hours = hours;
    }
    
    private void setWeight(double weight) {
        if (weight < 0) {
            weight = DEFAULT_WEIGHT;
        }
        this.weight = weight;
    }
    
    private void setAge(int age) {
        if (age < MINIMUM_AGE) {
            age = MINIMUM_AGE;
        }
        this.age = age;
        if (age <= Legality.MINOR.AGE) {
            this.legality = Legality.MINOR;
        }
        else {
            this.legality = Legality.ADULT;
        }
    }
    
    public String AmIDrunk() {
        if (BAC >= legality.getLegalBAC()) {
            return "Drunk";
        }
        else {
            return "Sober";
        }
    }
    
    private void setBAC(double BAC) {
        this.BAC = BAC;
    }
    
    public double getNumberOfDrinks() {
        return numberOfDrinks;
    }
    
    @Override
    public double missing() {
        return 0;
    }
    
    @Override
    public double getBAC() {
        return this.BAC;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public String getGender() {
        return gender;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getLegalBAC() {
        return legalBAC;
    }
    
    public double getHoursSinceFirstDrink() {
        return hours;
    }
    
    private enum Legality {
        MINOR (20, 0.02),
        ADULT (21, 0.08);
        
        private final int AGE;
        private final double LEGAL_BAC;
        
        Legality(int AGE, double LEGAL_BAC) {
            this.AGE = AGE;
            this.LEGAL_BAC = LEGAL_BAC;
        }
        
        public double getLegalBAC() {
            return LEGAL_BAC;
        }
    }

    @Override
    public String toString() {
        return String.format("Your BAC is %.4f, you are legally %s", 
                getBAC(), AmIDrunk());
    }
}
