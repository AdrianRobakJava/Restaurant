package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class PolishWindow {

	@FXML
	private Button addFoodButton;
	@FXML
	private Button closeButton;
	@FXML
	private RadioButton porkRadioButton;
	@FXML
	private RadioButton chickenRadioButton;
	@FXML
	private RadioButton cabbageRadioButton;
	@FXML
	private RadioButton dumplingsRadioButton;
	@FXML
	private RadioButton meatballsRadioButton;
	@FXML
	private ToggleGroup toggleGroup = new ToggleGroup();
	private PolishFood polishFood;
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
		porkRadioButton.setToggleGroup(toggleGroup);
		chickenRadioButton.setToggleGroup(toggleGroup);
		cabbageRadioButton.setToggleGroup(toggleGroup);
		dumplingsRadioButton.setToggleGroup(toggleGroup);
		meatballsRadioButton.setToggleGroup(toggleGroup);
		
		porkRadioButton.setOnAction((event) -> {
			foodName = polishFood.PORK_CUTLET.getName();
			foodPrice = polishFood.PORK_CUTLET.getPrice();
		});
		chickenRadioButton.setOnAction((event) -> {
			foodName = polishFood.CHICKEN_BREAST.getName();
			foodPrice = polishFood.CHICKEN_BREAST.getPrice();
		});
		cabbageRadioButton.setOnAction((event) -> {
			foodName = polishFood.CABBAGE_ROLS.getName();
			foodPrice = polishFood.CABBAGE_ROLS.getPrice();
		});
		dumplingsRadioButton.setOnAction((event) -> {
			foodName = polishFood.DUMPLINGS.getName();
			foodPrice = polishFood.DUMPLINGS.getPrice();
		});
		meatballsRadioButton.setOnAction((event) -> {
			foodName = polishFood.MEATBALLS.getName();
			foodPrice = polishFood.MEATBALLS.getPrice();
		});

	}

}
