package oop;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Car Example");
		System.out.println(Car.createdCars);
		Car tesla = new Car();
		tesla.printDetails();
		
		tesla.setBrand("Tesla");
		tesla.setDoors(4);
		tesla.setSpeed(1000);
		
		tesla.printDetails();
		
		Car porsche = new Car();
		porsche.setBrand("Porsche");
		porsche.setDoors(2);
		
		//porsche.printDetails();
		
		porsche.accelerate(30);
		
		//porsche.printDetails();
		//tesla.printDetails();
		System.out.println(Car.createdCars);
		
	}

}
