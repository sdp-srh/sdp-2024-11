package oop;

public class Car {
	private String brand;
	private int doors;
	private int speed = 0;
	public static int createdCars = 0;
	
	public Car() {
		System.out.println("new car is created");
		this.brand="Unknown";
		this.doors = 0;
		this.speed = 0;
		// static counter
		Car.createdCars++;
	}
	
	public void drive() {
		System.out.println("Brumm");
	}
	
	public void printDetails() {
		System.out.println("Brand: "+brand+", Doors:"+doors+", Speed: "+speed);
	}
	
	public void accelerate(int difference) {
		speed = speed + difference;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed < 0) {
			this.speed = 0;
		}
		else {
			this.speed = speed;	
		}
		
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}
	
	
}
