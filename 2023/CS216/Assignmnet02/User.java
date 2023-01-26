package CS216.Assignmnet02;

public class User {
    @Override
    public String toString() {
        return "User [age=" + age + ", height=" + height + ", weight=" + weight + ", gender=" + gender
                + ", activityType=" + activityType + ", mph=" + mph + ", minutes=" + minutes + ", BMI=" + BMI + ", Base Calorie need=" + BCN + ", BMI classification=" + BMIclass + "]";
    }

    private int age;
    private int height;
    private int weight;
    private String gender;
    private String activityType;
    private double mph;
    private int minutes;
    private double BMI;
    private double BCN;
    private String BMIclass;
    private double calories;
    private double minTHR;
    private double maxTHR;

    public User(int age, int height, int weight, String gender, String activityType, double mph, int minutes) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.activityType = activityType;
        this.mph = mph;
        this.minutes = minutes;
        this.BMI = calculateBMI();
        this.BCN = calculateBCN();
        this.BMIclass = findBMIclass();
        this.calories = calorieSpent();
        this.minTHR = findTargetMinHR();
        this.maxTHR = findTargetMaxHR();
    }

    private double calculateBMI() {
        double denom = Math.pow(this.height,2);
        double numer = (this.weight * 703);
        double bmi = numer / denom;
        return bmi;
    }

    private double calculateBCN(){
        
        double weightinKG = (this.weight * 0.45359237);
        double heightinCM = (this.height / 2.54);
        double bnc = 0;

        if (this.gender.equalsIgnoreCase("m")){
            bnc = (66.5 + (13.75 * weightinKG) + (5.003 * heightinCM) - (6.775 * this.age));
        }
        else if(this.gender.equalsIgnoreCase("f")){
            bnc = (655.1 + (9.563 * weightinKG) + (1.850 * heightinCM) - (4.676 * this.age));
        }else;
        
        return bnc;
    }

    private String findBMIclass() {
        String classBMI = "";

        if (this.BMI < 18.5){
            classBMI = "Underweight";
        }
        else if (this.BMI > 18.5 && this.BMI < 25.0 ){
            classBMI = "Normal";
        }
        else if (this.BMI > 24.99 && this.BMI < 30.0 ){
            classBMI = "Overweight";
        }
        else if (this.BMI > 29.99 ){
            classBMI = "Obese";
        }else;

        return classBMI;
    }

    private double calorieSpent(){
        
        double cal = 0;

        if (this.activityType.equalsIgnoreCase("running")){
            cal = ((this.weight) * (0.75) * (this.mph * this.minutes));
        }else if (this.activityType.equalsIgnoreCase("walking")){
            cal = ((this.weight) * (0.53) * (this.mph * this.minutes));
        }else;

        return cal;
    }

    private double findTargetMinHR(){
        double maxHr = (217 - (0.85 * this.age));

        double minTHR = (0.60 * maxHr);
        return minTHR;
    }
    private double findTargetMaxHR(){
        double maxHr = (217 - (0.85 * this.age));

        double maxTHR = (0.80 * maxHr);
        return maxTHR;
    }

    public void printUser() {
        System.out.println("Age: " + this.age);
        System.out.println("Height: " + this.height + " inches");
        System.out.println("Weight: " + this.weight + " pounds");
        System.out.println("Gender: " + this.gender);
        System.out.println("Activity Type: " + this.activityType);
        System.out.println("MPH: " + this.mph);
        System.out.println("Minutes: " + this.minutes);
        System.out.println("------------------------------------");
        System.out.println("Base Calorie needed: \t \t" + String.format("%.2f",this.BCN));
        System.out.println("BMI: \t \t \t \t" + String.format("%.2f",this.BMI));
        System.out.println("BMI classification: \t \t" + this.BMIclass);
        System.out.println("Calories Burned: \t \t" + String.format("%.2f",this.calories));
        System.out.println("Minimum Target Heart Rate: \t" + String.format("%.2f",this.minTHR));
        System.out.println("Maximum Target Heart Rate: \t" + String.format("%.2f",this.maxTHR));
    }
}
