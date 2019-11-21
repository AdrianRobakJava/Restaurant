package application;

public enum ItalianFood {
	
	SPAGHETTI_CARBONARA("Spaghetti carbonara", 27.50),
	PASTA_AND_MEATBALLS("Pasta and meatballs", 22.00),
	PAPPARDELLE_BOLOGNESE("Pappardelle with bolognese sauce", 25.50),
	TORTELLINI("Tortellini with shrimps", 36.00),
	PIZZA("Pizza", 18.00);
	
	
	private double price;
	private String name;
	
	private ItalianFood(String name, double price) {
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
