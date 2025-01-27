package ch.tbz.m320;

public class Main {
    public static void main(String[] args) {
        // Task a)
        Heizung heizungA = new Heizung(20, 2);
        heizungA.increaseTemperature();
        System.out.println("Temperature after increase: " + heizungA.getTemperature());
        
        // Task b)
        Heizung heizungB = new Heizung(15, 10, 25);
        heizungB.setTemperature(20);
        heizungB.increaseTemperature();
        System.out.println("Temperature: " + heizungB.getTemperature());

        // Task c)
        Heizung heizungC = new Heizung();
        heizungC.decreaseTemperature();
        System.out.println("Temperature: " + heizungC.getTemperature());
    }
}
