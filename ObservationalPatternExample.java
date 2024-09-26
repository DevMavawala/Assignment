// src/main/DeviceObserver.java
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class DeviceObserver {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// src/main/Thermostat.java
class Thermostat implements Observer {
    private int temperature;

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Thermostat set to: " + temp + " degrees.");
    }

    @Override
    public void update(String message) {
        System.out.println("Thermostat received update: " + message);
    }
}
