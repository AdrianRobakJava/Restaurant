package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class DrinksWindow {

	@FXML
	private Button addFoodButton;
	@FXML
	private Button closeButton;
	@FXML
	private RadioButton beerRadioButton;
	@FXML
	private RadioButton coffeeRadioButton;
	@FXML
	private RadioButton orangeJuiceRadioButton;
	@FXML
	private RadioButton pepsiRadioButton;
	@FXML
	private RadioButton teaRadioButton;
	@FXML
	private RadioButton waterRadioButton;
	@FXML
	private RadioButton wineRadioButton;
	@FXML
	private CheckBox coffeeMilkBox;
	@FXML
	private CheckBox orangeIceBox;
	@FXML
	private CheckBox pepsiIceBox;
	@FXML
	private CheckBox pepsiLemonBox;
	@FXML
	private CheckBox teaLemonBox;
	@FXML
	private CheckBox teaMilkBox;
	@FXML
	private CheckBox waterSparklingBox;
	@FXML
	private CheckBox waterIceBox;
	@FXML
	private CheckBox waterLemonBox;
	@FXML
	private ToggleGroup toggleGroup = new ToggleGroup();
	private Drinks drinks;
	private String foodName = " ";
	private double foodPrice;
	private OrderList orderList;

	public void initData(OrderList oL) {
		orderList = oL;
	}

	@FXML
	private void initialize() {
		initAddFoodButton();
		initCloseButton();
		initRadioButtons();

	}

	public void initAddFoodButton() {
		addFoodButton.setOnAction((event) -> {
			if (!foodName.equals(" ")) {
				Order order = new Order(foodName, foodPrice);
				orderList.addOrder(order);
				Stage stage = (Stage) closeButton.getScene().getWindow();
				stage.close();
			}
		});
	}

	public void initCloseButton() {
		closeButton.setOnAction((event) -> {
			Stage stage = (Stage) closeButton.getScene().getWindow();
			stage.close();
		});
	}

	public void initRadioButtons() {
		beerRadioButton.setToggleGroup(toggleGroup);
		coffeeRadioButton.setToggleGroup(toggleGroup);
		orangeJuiceRadioButton.setToggleGroup(toggleGroup);
		pepsiRadioButton.setToggleGroup(toggleGroup);
		teaRadioButton.setToggleGroup(toggleGroup);
		waterRadioButton.setToggleGroup(toggleGroup);
		wineRadioButton.setToggleGroup(toggleGroup);

		beerRadioButton.setOnAction((event) -> {
			foodName = drinks.BEER.getName();
			foodPrice = drinks.BEER.getPrice();
		});
		coffeeRadioButton.setOnAction((event) -> {
			foodName = drinks.COFFEE.getName();
			foodPrice = drinks.COFFEE.getPrice();
			if (coffeeMilkBox.isSelected()) {
				Order order = new Order("Milk", 0.50);
				orderList.addOrder(order);
			}
		});
		orangeJuiceRadioButton.setOnAction((event) -> {
			foodName = drinks.ORANGE_JUICE.getName();
			foodPrice = drinks.ORANGE_JUICE.getPrice();
			if (orangeIceBox.isSelected()) {
				Order order = new Order("Ice cube", 0.50);
				orderList.addOrder(order);
			}
		});
		pepsiRadioButton.setOnAction((event) -> {
			foodName = drinks.PEPSI.getName();
			foodPrice = drinks.PEPSI.getPrice();
			if (pepsiLemonBox.isSelected()) {
				Order order = new Order("Lemon", 0.50);
				orderList.addOrder(order);
			}
			if (pepsiIceBox.isSelected()) {
				Order order = new Order("Ice cube", 0.50);
				orderList.addOrder(order);
			}
		});
		teaRadioButton.setOnAction((event) -> {
			foodName = drinks.TEA.getName();
			foodPrice = drinks.TEA.getPrice();
			if (teaLemonBox.isSelected()) {
				Order order = new Order("Lemon", 0.50);
				orderList.addOrder(order);
			}
			if (teaMilkBox.isSelected()) {
				Order order = new Order("Milk", 0.50);
				orderList.addOrder(order);
			}
		});
		waterRadioButton.setOnAction((event) -> {
			if (waterSparklingBox.isSelected()) {
				foodName = drinks.WATER_SPARKLING.getName();
				foodPrice = drinks.WATER_SPARKLING.getPrice();
				if (waterLemonBox.isSelected()) {
					Order order = new Order("Lemon", 0.50);
					orderList.addOrder(order);
				}
				if (waterIceBox.isSelected()) {
					Order order = new Order("Ice cube", 0.50);
					orderList.addOrder(order);
				}
			} else {
				foodName = drinks.WATER_STILL.getName();
				foodPrice = drinks.WATER_STILL.getPrice();
				if (waterLemonBox.isSelected()) {
					Order order = new Order("Lemon", 0.50);
					orderList.addOrder(order);
				}
				if (waterIceBox.isSelected()) {
					Order order = new Order("Ice cube", 0.50);
					orderList.addOrder(order);
				}
			}

		});
		wineRadioButton.setOnAction((event) -> {
			foodName = drinks.WINE.getName();
			foodPrice = drinks.WINE.getPrice();
		});

	}

}
