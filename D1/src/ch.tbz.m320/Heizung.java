package src.ch.tbz.m320;

public class Heizung {
    private int temperature;
    private int min;
    private int max;
    private int increment;


    public Heizung(int temperature, int increment) {
        this.temperature = temperature;
        this.increment = increment;
        this.min = 0;
        this.max = 100;
    }

    public Heizung(int temperature, int min, int max, int increment) {
        this.temperature = temperature;
        this.min = min;
        this.max = max;
        this.increment = increment;
    }

    public Heizung() {
        this.temperature = 15;
        this.min = 0;
        this.max = 30;
        this.increment = 1;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        if (temperature >= min && temperature <= max) {
            this.temperature = temperature;
        } else {
            System.out.println("Temperature out of bounds!");
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

    public void increaseTemperature() {
        if (temperature + increment <= max) {
            temperature += increment;
        } else {
            System.out.println("Cannot increase: Temperature would exceed the maximum limit!");
        }
    }

    public void decreaseTemperature() {
        if (temperature - increment >= min) {
            temperature -= increment;
        } else {
            System.out.println("Cannot decrease: Temperature would drop below the minimum limit!");
        }
    }
}
