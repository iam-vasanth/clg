package EX2;
class Vehicle 
{
    String brand = "Generic Vehicle";
    void start() 
    {
        System.out.println("Vehicle is starting...");
    }
}
class Car extends Vehicle 
{
    String brand = "Car";
    @Override
    void start() 
    {
        System.out.println("Car is starting with a key...");
    }
    class Engine {
        void engineSound() {
            System.out.println("Engine is running smoothly!");
        }
    }
}
public class inpoly {
    public static void main(String[] args) {
        Vehicle myVehicle = new Car();
        System.out.println("Brand: " + myVehicle.brand); 
        myVehicle.start(); 
        Car myCar = new Car();
        Car.Engine myEngine = myCar.new Engine(); 
        myEngine.engineSound(); 
    }
}