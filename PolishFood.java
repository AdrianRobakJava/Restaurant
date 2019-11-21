package application;

public enum PolishFood {
	
	PORK_CUTLET("Pork cutlet", 22.50),
	CHICKEN_BREAST("Chicken breast", 17.00),
	CABBAGE_ROLS("Cabbage rols", 15.75),
	MEATBALLS("Meatballs", 16.50),
	DUMPLINGS("Dumplings", 19.90);
	
	
	private double price;
	private String name;
	
	private PolishFood(String name, double price) {
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
