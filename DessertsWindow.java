package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class DessertsWindow {
	
	@FXML
	private Button addFoodButton;
	@FXML
	private Button closeButton;
	@FXML
	private RadioButton cakeRadioButton;
	@FXML
	private RadioButton iceCreamRadioButton;
	@FXML
	private RadioButton fruitSaladRadioButton;
	@FXML
	private RadioButton puddingRadioButton;
	@FXML
	private RadioButton vegetablesSaladRadioButton;
	@FXML
	private CheckBox creamBox;
	@FXML
	private CheckBox strawberryBox;
	@FXML
	private CheckBox chocolateBox;
	@FXML
	private CheckBox appleBox;
	@FXML
	private CheckBox vanillaBox;
	@FXML
	private CheckBox chesseBox;
	@FXML
	private ToggleGroup toggleGroup = new ToggleGroup();
	@FXML
	private ToggleGroup checkToggleGroup = new ToggleGroup() ;
	private Desserts desserts;
	private String foodName = " ";
	private double foodPrice;
	private OrderList orderList;
	
	
	
	public void initData (OrderList oL) {
		orderList = oL;
	}
	
	@FXML
	private void initialize() {
		initAddFoodButton();
		initCloseButton();
		initRadioButtons();
		initCheckBox();
		
		
		
	}
	
	public void initCheckBox() {
		appleBox.setOnAction((eventBox)->{
			chocolateBox.setSelected(false);
			chesseBox.setSelected(false);
		});
		chocolateBox.setOnAction((eventBox)->{
			appleBox.setSelected(false);
			chesseBox.setSelected(false);
		});
		chesseBox.setOnAction((eventBox)->{
			chocolateBox.setSelected(false);
			appleBox.setSelected(false);
		});
		creamBox.setOnAction((eventBox)->{
			vanillaBox.setSelected(false);
			strawberryBox.setSelected(false);
		});
		vanillaBox.setOnAction((eventBox)->{
			creamBox.setSelected(false);
			strawberryBox.setSelected(false);
		});
		strawberryBox.setOnAction((eventBox)->{
			creamBox.setSelected(false);
			vanillaBox.setSelected(false);
		});
	}
	
	public void initAddFoodButton() {
		addFoodButton.setOnAction((event) ->{
			if (!foodName.equals(" ")) {
				Order order = new Order(foodName, foodPrice);
				orderList.addOrder(order);
				Stage stage = (Stage) closeButton.getScene().getWindow();
				stage.close();	
			} else {
				iceCreamRadioButton.setSelected(false);
				cakeRadioButton.setSelected(false);
			}
			
		});
	}
	public void initCloseButton() {
		closeButton.setOnAction((event) ->{
			Stage stage = (Stage) closeButton.getScene().getWindow();
			stage.close();
		});
	}
	public void initRadioButtons() {
		cakeRadioButton.setToggleGroup(toggleGroup);
		iceCreamRadioButton.setToggleGroup(toggleGroup);
		fruitSaladRadioButton.setToggleGroup(toggleGroup);
		puddingRadioButton.setToggleGroup(toggleGroup);
		vegetablesSaladRadioButton.setToggleGroup(toggleGroup);
		
		cakeRadioButton.setOnAction((event)->{
			
			if (appleBox.isSelected() && !chocolateBox.isSelected() && !chesseBox.isSelected()) {
				foodName = desserts.APPLE_CAKE.getName();
				foodPrice = desserts.APPLE_CAKE.getPrice();	
			} else if (!appleBox.isSelected() && chocolateBox.isSelected() && !chesseBox.isSelected()) {
				foodName = desserts.CHOCOLATE_CAKE.getName();
				foodPrice = desserts.CHOCOLATE_CAKE.getPrice();	
			}else if (!appleBox.isSelected() && !chocolateBox.isSelected() && chesseBox.isSelected()) {
				foodName = desserts.CHESSE_CAKE.getName();
				foodPrice = desserts.CHESSE_CAKE.getPrice();	
			} 
		});
		iceCreamRadioButton.setOnAction((event)->{
			if (creamBox.isSelected() && !strawberryBox.isSelected() && !vanillaBox.isSelected()) {
				foodName = desserts.ICE_CREAM.getName();
				foodPrice = desserts.ICE_CREAM.getPrice();
			} else if (!creamBox.isSelected() && strawberryBox.isSelected() && !vanillaBox.isSelected()) {
				foodName = desserts.ICE_CREAM_STRAWBERRY.getName();
				foodPrice = desserts.ICE_CREAM_STRAWBERRY.getPrice();	
			}else if (!creamBox.isSelected() && !strawberryBox.isSelected() && vanillaBox.isSelected()) {
				foodName = desserts.ICE_CREAM_VANILLA.getName();
				foodPrice = desserts.ICE_CREAM_VANILLA.getPrice();	
			} 
			
		});
		fruitSaladRadioButton.setOnAction((event)->{
			foodName = desserts.FRUIT_SALAD.getName();
			foodPrice = desserts.FRUIT_SALAD.getPrice();
		});
		puddingRadioButton.setOnAction((event)->{
			foodName = desserts.PUDDING.getName();
			foodPrice = desserts.PUDDING.getPrice();
		});
		vegetablesSaladRadioButton.setOnAction((event)->{
			foodName = desserts.VEGETABLES_SALAD.getName();
			foodPrice = desserts.VEGETABLES_SALAD.getPrice();
		});
		
		
	}
	

}
