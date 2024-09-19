// Behavioral Design Patterns =Observer Pattern: Weather Station

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(float temperature, float humidity, float pressure);
}

// Concrete Observer
class Display implements Observer {
    private String name;

    public Display(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println(name + " - Temperature: " + temperature 
                           + "°C, Humidity: " + humidity 
                           + "%, Pressure: " + pressure + " hPa");
    }
}

// Subject
class WeatherStation {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    // Method to register an observer
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // Method to remove an observer
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Method to notify all observers of state changes
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    // Method to update measurements and notify observers
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}

// Main Class to Demonstrate the Observer Pattern
public class weather_station {
    public static void main(String[] args) {
        // Create the Subject
        WeatherStation weatherStation = new WeatherStation();
        
        // Create Observers
        Display display1 = new Display("Display1");
        Display display2 = new Display("Display2");

        // Register Observers
        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);

        // Simulate new measurements
        weatherStation.setMeasurements(25.0f, 65.0f, 1013.0f);
        weatherStation.setMeasurements(28.0f, 70.0f, 1012.0f);

        // Optionally, remove an observer
        weatherStation.removeObserver(display1);

        // Simulate another set of measurements
        weatherStation.setMeasurements(22.0f, 90.0f, 1011.0f);
    }
}
