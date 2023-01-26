package CS216.Assignmnet02;

public class User {
    @Override
    public String toString() {
        return "User [age=" + age + ", height=" + height + ", weight=" + weight + ", gender=" + gender
                + ", activityType=" + activityType + ", mph=" + mph + ", minutes=" + minutes + ", BMI=" + BMI + "]";
    }

    private int age;
    private int height;
    private int weight;
    private String gender;
    private String activityType;
    private double mph;
    private int minutes;
    private double BMI;

    public User(int age, int height, int weight, String gender, String activityType, double mph, int minutes) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.activityType = activityType;
        this.mph = mph;
        this.minutes = minutes;
        this.BMI = calculateBMI();
    }

    private double calculateBMI() {
        double heightInMeters = this.height * 0.0254;
        double weightInKg = this.weight * 0.453592;
        return weightInKg / (heightInMeters * heightInMeters);
    }

    public void printUser() {
        System.out.println("Age: " + this.age);
        System.out.println("Height: " + this.height + " inches");
        System.out.println("Weight: " + this.weight + " pounds");
        System.out.println("Gender: " + this.gender);
        System.out.println("Activity Type: " + this.activityType);
        System.out.println("MPH: " + this.mph);
        System.out.println("Minutes: " + this.minutes);
        System.out.println("BMI: " + this.BMI);
    }
}
