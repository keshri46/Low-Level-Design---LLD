package patterns.strategy.question.solidprinciples;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

class BeforeLiskovSubstitution{
    static class Vehicle{
        Integer getNoOfWheels(){
            return 2;
        }

        Boolean hasEngine(){
            return true;
        }
    }
    static class Car extends Vehicle {
        Integer getNoOfWheels(){
            return 4;
        }
    }
    static class MotorCycle extends Vehicle {    }
    static class BiCycle extends Vehicle {
        Boolean hasEngine(){
            return null;
        }
    }

    public static void run() {
        List<Vehicle> vehicles=new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new MotorCycle());
        vehicles.add(new BiCycle());
        for (Vehicle vehicle:vehicles)
            System.out.println(vehicle.hasEngine().toString());
    }

}

class AfterLiskovSubstitution{
    static class Vehicle{
        Integer getNoOfWheels(){
            return 2;
        }
    }

    static class EngineVehicle extends Vehicle {
        Boolean hasEngine(){
            return true;
        }
    }
    static class Car extends EngineVehicle {
        Integer getNoOfWheels(){
            return 4;
        }
    }
    static class MotorCycle extends EngineVehicle {    }
    static class BiCycle extends Vehicle {    }

    public static void run() {
        List<Vehicle> vehicles=new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new MotorCycle());
        vehicles.add(new BiCycle());
        for (Vehicle vehicle:vehicles) {
            System.out.println("Vehicle name : "+vehicle.getClass()+vehicle.getNoOfWheels().toString());
            if(vehicle instanceof EngineVehicle)
                System.out.println("Has Engine : "+((EngineVehicle) vehicle).hasEngine().toString());
        }

    }

}
public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
//        BeforeLiskovSubstitution.run();
        AfterLiskovSubstitution.run();
    }

}
