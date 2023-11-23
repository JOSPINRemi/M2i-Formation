package org.example.poo.datastructure;

public class Demo {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.setCouleur("bleu");
        electricCar.setNbreRoue(5);

        MotorCycle motorCycle = new MotorCycle();
        motorCycle.setCouleur("rouge");
        motorCycle.setNbreRoue(2);

        PetrolCar petrolCar = new PetrolCar();
        petrolCar.setCouleur("gris");
        petrolCar.setNbreRoue(4);

        SuperCar superCar = new SuperCar();

        Engine[] engines = {electricCar, motorCycle, petrolCar};
        /*for (Engine engine : engines){
            moveVehicule(engine);
        }*/

        Vehicule[] vehicules = {superCar, electricCar, motorCycle, petrolCar};
        for (Vehicule vehicule : vehicules){
            moveVehicule(vehicule);
        }
    }

    public static void moveVehicule(Engine engine){
        if (engine instanceof ElectricCar){
            System.out.println("electriccar");
            ((ElectricCar) engine).drive();
        }else if (engine instanceof MotorCycle){
            System.out.println("motorcycle");
            ((MotorCycle) engine).drive();
        }else if (engine instanceof PetrolCar){
            System.out.println("petrolcar");
            ((PetrolCar) engine).drive();
        }
    }
    public static void moveVehicule(Vehicule vehicule){
        if (vehicule instanceof ElectricCar){
            System.out.println("electriccar");
            ((ElectricCar) vehicule).drive();
        }else if (vehicule instanceof MotorCycle){
            System.out.println("motorcycle");
            ((MotorCycle) vehicule).drive();
        }else if (vehicule instanceof PetrolCar){
            System.out.println("petrolcar");
            ((PetrolCar) vehicule).drive();
        } else if (vehicule instanceof SuperCar) {
            System.out.println("supercar");
            vehicule.drive();
        }
    }
}
