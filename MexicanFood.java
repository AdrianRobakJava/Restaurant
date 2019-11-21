package application;

public enum MexicanFood {
	
	CHIMICHANGA("Chimichanga", 32.0),
	TAMPIQUE("Tampique", 28.5),
	QUESADILLAS("Quesadillas", 33.0),
	TACOS("Tacos", 21.5),
	BURITO("Burito", 23.70);
	
	
	private double price;
	private String name;
	
	private MexicanFood(String name, double price) {
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
