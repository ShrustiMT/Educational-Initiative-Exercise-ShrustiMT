// Creational Design Patterns  Factory Pattern: Vehicle Factory

// Abstract Product
abstract class Vehicle {
    abstract void drive();
}

// Concrete Products
class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}

class Truck extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a truck");
    }
}

class Motorcycle extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a motorcycle");
    }
}

// Factory Class
class VehicleFactory {
    // Static factory method to create the appropriate vehicle object
    public static Vehicle createVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("car")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("truck")) {
            return new Truck();
        } else if (vehicleType.equalsIgnoreCase("motorcycle")) {
            return new Motorcycle();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type: " + vehicleType);
        }
    }
}

// Main class to demonstrate the Factory Pattern
public class VehicleFactoryDemo {
    public static void main(String[] args) {
        try {
            // Creating different types of vehicles using the factory
            Vehicle car = VehicleFactory.createVehicle("car");
            car.drive();  // Output: Driving a car

            Vehicle truck = VehicleFactory.createVehicle("truck");
            truck.drive();  // Output: Driving a truck

            Vehicle motorcycle = VehicleFactory.createVehicle("motorcycle");
            motorcycle.drive();  // Output: Driving a motorcycle

            // Attempting to create an invalid vehicle type
            Vehicle unknown = VehicleFactory.createVehicle("bicycle");
            unknown.drive();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
