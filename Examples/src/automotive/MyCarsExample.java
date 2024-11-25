package automotive;

public class MyCarsExample {

	public static void main(String[] args) {
		Truck t = new Truck();
		t.setCapacity(5);
		LoadingArea la = new Truck();
						
		System.out.println(Car.amountofCreatedCars);
		Car theTesla = createMyTesla();
		theTesla.getProductionYear();
		// call the print brand method
		// theTesla.printBrand();
		System.out.println(Car.amountofCreatedCars);
		
		Car tesla2 = createMyTesla();
		
		
		for (int i = 0; i < 1000; i++) {
			Car c = new Car();
			c.setModel("Random Car "+i);
		}
		
		int maximumOfCars = 5000;
		int countCars = 0;
		while (Car.amountofCreatedCars < maximumOfCars) {
			Car c = new Car();
		}
		
		// tesla2.setColor("White");
		System.out.println(Car.amountofCreatedCars);
		
		/*
		System.out.println(theTesla.getColor());
		System.out.println(tesla2.getColor());
		// display the speed and accelerate then
		
		System.out.println("Start Speed is " + theTesla.speed);
		theTesla.accelerate(45);
		System.out.println("New Speed is " + theTesla.getSpeed());
		theTesla.brake(20);
		System.out.println("Speed after first brake: "+theTesla.getSpeed());
		theTesla.brake(50);
		System.out.println("Speed after second brake: "+theTesla.getSpeed());
		
		
		// create a second car object with the constructor with different parameters
		Car theBeetle = new Car("VW", "Beetle", 2, 4, "Red", 800, new Motor("Gas", "Benzin", 150));
		System.out.println(theBeetle.getModel()+" needs "+theBeetle.getMotor().getFuel());
		System.out.println("KW: "+theBeetle.getMotor().getPower());
		System.out.println("HP: "+theBeetle.getMotor().getPowerInHP());
		theBeetle.accelerate(10);
		theBeetle.brake(5);
		System.out.println(theBeetle.getSpeed());
		*/
	}	
	
	public static Car createMyTesla() {
		// create a car object
		Car theTesla = new Car();
		// set values for the different attributes
		theTesla.setBrand("Tesla");
		theTesla.setModel("Model 3");
		theTesla.setDoors(4);
		theTesla.setColor("Blue");
		theTesla.setSeats(4);
		theTesla.setSpeed(0);
		// create an object of motor
		Motor electricMotor = new Motor(Motor.ELECTRIC, "electricity", 200);
		// set the motor object for the car
		theTesla.setMotor(electricMotor);
		return theTesla;
	}


}
