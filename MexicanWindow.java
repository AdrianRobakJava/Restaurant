package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class MexicanWindow {

	@FXML
	private Button addFoodButton;
	@FXML
	private Button closeButton;
	@FXML
	private RadioButton buritoRadioButton;
	@FXML
	private RadioButton chimichangaRadioButton;
	@FXML
	private RadioButton quesadillasRadioButton;
	@FXML
	private RadioButton tacosRadioButton;
	@FXML
	private RadioButton tampiqueRadioButton;
	@FXML
	private ToggleGroup toggleGroup = new ToggleGroup();
	private MexicanFood mexicanFood;
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
		buritoRadioButton.setToggleGroup(toggleGroup);
		chimichangaRadioButton.setToggleGroup(toggleGroup);
		quesadillasRadioButton.setToggleGroup(toggleGroup);
		tacosRadioButton.setToggleGroup(toggleGroup);
		tampiqueRadioButton.setToggleGroup(toggleGroup);

		buritoRadioButton.setOnAction((event) -> {
			foodName = mexicanFood.BURITO.getName();
			foodPrice = mexicanFood.BURITO.getPrice();
		});
		chimichangaRadioButton.setOnAction((event) -> {
			foodName = mexicanFood.CHIMICHANGA.getName();
			foodPrice = mexicanFood.CHIMICHANGA.getPrice();
		});
		quesadillasRadioButton.setOnAction((event) -> {
			foodName = mexicanFood.QUESADILLAS.getName();
			foodPrice = mexicanFood.QUESADILLAS.getPrice();
		});
		tacosRadioButton.setOnAction((event) -> {
			foodName = mexicanFood.TACOS.getName();
			foodPrice = mexicanFood.TACOS.getPrice();
		});
		tampiqueRadioButton.setOnAction((event) -> {
			foodName = mexicanFood.TAMPIQUE.getName();
			foodPrice = mexicanFood.TAMPIQUE.getPrice();
		});

	}

}
