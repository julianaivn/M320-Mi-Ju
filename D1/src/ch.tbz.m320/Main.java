package src.ch.tbz.m320;

public class Main { public static void main(String[] args) {

    Heizung heizung1 = new Heizung(20, 2);
    heizung1.increaseTemperature();
    System.out.println("Temperature (Task a): " + heizung1.getTemperature());

    Heizung heizung2 = new Heizung(15, 10, 25, 3);
    heizung2.increaseTemperature();
    System.out.println("Temperature (Task b): " + heizung2.getTemperature());

    Heizung heizung3 = new Heizung();
    System.out.println("Default temperature (Task c): " + heizung3.getTemperature());
    heizung3.setTemperature(28);
    System.out.println("Set temperature (Task c): " + heizung3.getTemperature());
    heizung3.decreaseTemperature();
    System.out.println("Decreased temperature (Task c): " + heizung3.getTemperature());
}
}
