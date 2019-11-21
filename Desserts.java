package application;

public enum Desserts {
	
	ICE_CREAM("Ice cream", 7.5),
	ICE_CREAM_STRAWBERRY("Strawberry ice cream", 7.5),
	ICE_CREAM_VANILLA("Vanilla ice cream", 7.5),
	FRUIT_SALAD("Fruit salad", 12.0),
	VEGETABLES_SALAD("Vegetables salad", 9.90),
	PUDDING("Pudding", 14.0),
	APPLE_CAKE("Apple cake", 5.5),
	CHOCOLATE_CAKE("Chocolate cake", 6.5),
	CHESSE_CAKE("Chesse cake", 4.5);
	
	
	private double price;
	private String name;
	
	private Desserts(String name, double price) {
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
