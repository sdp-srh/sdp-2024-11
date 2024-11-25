package automotive;

public abstract class Vehicle {
	private int productionYear;
	
	public void setProductionYear(int year) {
		this.productionYear = year;
	}

	public int getProductionYear() {
		return this.productionYear;
	}
		
	public abstract int getFuelPricePer100KiloMeters();
}
