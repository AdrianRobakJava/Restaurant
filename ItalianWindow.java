package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ItalianWindow {

	@FXML
	private Button addFoodButton;
	@FXML
	private Button closeButton;
	@FXML
	private RadioButton pizzaRadioButton;
	@FXML
	private RadioButton pappardelleRadioButton;
	@FXML
	private RadioButton pastaRadioButton;
	@FXML
	private RadioButton spaghettiRadioButton;
	@FXML
	private RadioButton tortelliniRadioButton;
	@FXML
	private ToggleGroup toggleGroup = new ToggleGroup();
	private ItalianFood italianFood;
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
		pizzaRadioButton.setToggleGroup(toggleGroup);
		pappardelleRadioButton.setToggleGroup(toggleGroup);
		pastaRadioButton.setToggleGroup(toggleGroup);
		spaghettiRadioButton.setToggleGroup(toggleGroup);
		tortelliniRadioButton.setToggleGroup(toggleGroup);

		pizzaRadioButton.setOnAction((event) -> {
			foodName = italianFood.PIZZA.getName();
			foodPrice = italianFood.PIZZA.getPrice();
		});
		pappardelleRadioButton.setOnAction((event) -> {
			foodName = italianFood.PAPPARDELLE_BOLOGNESE.getName();
			foodPrice = italianFood.PAPPARDELLE_BOLOGNESE.getPrice();
		});
		pastaRadioButton.setOnAction((event) -> {
			foodName = italianFood.PASTA_AND_MEATBALLS.getName();
			foodPrice = italianFood.PASTA_AND_MEATBALLS.getPrice();
		});
		spaghettiRadioButton.setOnAction((event) -> {
			foodName = italianFood.SPAGHETTI_CARBONARA.getName();
			foodPrice = italianFood.SPAGHETTI_CARBONARA.getPrice();
		});
		tortelliniRadioButton.setOnAction((event) -> {
			foodName = italianFood.TORTELLINI.getName();
			foodPrice = italianFood.TORTELLINI.getPrice();
		});

	}

}
