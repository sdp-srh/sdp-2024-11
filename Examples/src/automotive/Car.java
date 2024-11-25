package automotive;

public class Car extends Vehicle {
	public static int amountofCreatedCars = 0;
	private String color;
	private int weight;
	private String brand;
	private String model;
	private int doors;
	private int seats;
	private Motor motor;
	int speed;
	
	public Car() {
		super();
		amountofCreatedCars++;
		this.color = "";
		this.weight = 0;
		this.brand = "?";
		this.model = "?";
		this.doors = 0;
		this.seats = 0;
		this.motor = new Motor();
		this.speed = 0;
		this.setProductionYear(2023);
	}
	
	
	public Car(String brand, String model, int doors, int seats, String color, int weight, Motor motor) {
		super();
		amountofCreatedCars++;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.weight = weight;
		this.doors = doors;
		this.seats = seats;
		this.motor = motor;
		this.speed = 0;
		this.setProductionYear(2022);
	}
	
	public void accelerate(int difference) {
		this.speed += difference;
	}
	
	public void brake(int difference) {
		this.speed = this.speed - difference;
		if ( this.speed < 0 ) {
			this.speed = 0;
		}
	}
	
    public void printBrand() {
    	System.out.println("This car is a "+this.brand);
    }
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getDoors() {
		return doors;
	}
	public void setDoors(int doors) {
		this.doors = doors;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}


	public String getColor() {
		return this.color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}


	@Override
	public int getFuelPricePer100KiloMeters() {
		if (this.getMotor().getType().equals(Motor.ELECTRIC)) {
			// todo calculate the price by electricity price and the consumption of the motor
			return 10;
		}
		if (this.getMotor().getType().equals(Motor.BENZIN)){
			// todo calculate the price by benzin price and the consumption of the motor
			return 20;
		}
		// return 0 (e.g. non-motor bike)
		return 0;
	}
	
}
