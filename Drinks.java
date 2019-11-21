package application;

public enum Drinks {
	
	PEPSI("Pepsi", 8.50),
	ORANGE_JUICE("Orange juice", 7.90),
	TEA("Tea", 5.90),
	COFFEE("Coffee", 10.00),
	WATER_SPARKLING("Water (sparkling)", 3.90),
	WATER_STILL("Water (still)", 3.90),
	WINE("Wine", 13.90),
	BEER("Beer", 9.90),
	ICE_CUBE("Ice", 0.00),
	LEMON("Lemon", 0.50),
	MILK("Milk", 0.50);
	
	
	private double price;
	private String name;
	
	private Drinks(String name, double price) {
		this.name = name;
		this.price = price;
		
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
	
	

}
