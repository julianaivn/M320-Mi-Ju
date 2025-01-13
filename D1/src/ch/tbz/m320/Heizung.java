package ch.tbz.m320;

public class Heizung {

    private int temperature;
    private int min;
    private int max;
    private int increment;

    // Constructor for Task a)
    public Heizung(int temperature, int increment) {
        this.temperature = temperature;
        this.increment = increment;
    }

    // Constructor for Task b)
    public Heizung(int temperature, int min, int max) {
        this.temperature = temperature;
        this.min = min;
        this.max = max;
        this.increment = 1; // Default increment
    }

    // Constructor for Task c)
    public Heizung() {
        this.temperature = 15; // Default temperature
        this.min = 5;         // Default min
        this.max = 30;        // Default max
        this.increment = 1;   // Default increment
    }

    // Getters and Setters
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        if (temperature >= min && temperature <= max) {
            this.temperature = temperature;
        } else {
            System.out.println("Temperature must be between " + min + " and " + max);
        }
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    // Method to increase temperature
    public void increaseTemperature() {
        if (temperature + increment <= max) {
            temperature += increment;
        } else {
            System.out.println("Cannot increase. Maximum limit reached.");
        }
    }

    // Method to decrease temperature
    public void decreaseTemperature() {
        if (temperature - increment >= min) {
            temperature -= increment;
        } else {
            System.out.println("Cannot decrease. Minimum limit reached.");
        }
    }
}
