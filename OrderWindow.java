package application;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OrderWindow {

	@FXML
	private Button polishFoodButton;
	@FXML
	private Button italianFoodButton;
	@FXML
	private Button mexicanFoodButton;
	@FXML
	private Button dessertsButton;
	@FXML
	private Button drinksButton;
	@FXML
	private Button removeOrderButton;
	@FXML
	private Button printOrderButton;
	@FXML
	private Button clearOrderListButton;
	@FXML
	private Label printOrderLabel;
	@FXML
	private TextArea totalBillArea;
	@FXML
	private Spinner<Integer> tableSpinner;
	@FXML
	private TableView<Order> orderTableView = new TableView<>();
	@FXML
	private TableColumn<Order, String> foodNameColumn = new TableColumn<>();
	@FXML
	private TableColumn<Order, Double> priceColumn = new TableColumn<>();
	@FXML
	private ObservableList<Order> orderListViewData = FXCollections.observableArrayList();
	private OrderList orderList;
	private double totalBill;
    private Order currentOrder;
	private int currentOrderIndex;

	public OrderWindow() {
		orderList = new OrderList();
	}

	@FXML
	private void initialize() {
		initPolishFoodButton();
		initItalianFoodButton();
		initMexicanFoodButton();
		initDessertshButton();
		initDrinksButton();
		initRemoveOrderButton();
		initPrintOrderButton();
		initClearOrderListButton();
		//initadd();
		initColumns();
		initListSelect();
		initOrderTableView();
		initTableSpinner();

	}
	//Test orders
	public void initadd() {
		/*
		 * Order o1 = new Order("Kebab", 13.30); 
		 * orderList.addOrder(o1); 
		 * Order o2 = new
		 * Order("Hamburger", 3.70); 
		 * orderList.addOrder(o2); 
		 * Order o3 = new Order("Pizza",17.60); 
		 * orderList.addOrder(o3);
		 */
	}
	//
	public void initPolishFoodButton() {
		polishFoodButton.setOnAction((event) -> {
			try {
				showPolishWindow();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
	}

	public void initRemoveOrderButton() {
		removeOrderButton.setOnAction((event) -> {
			orderList.removeOrder(currentOrderIndex);
			initOrderTableView();
		});
	}
	
	public void initPrintOrderButton() {
		printOrderButton.setOnAction((event) -> {
			orderPrinter();
			printOrderLabel.setText("The order has been accepted");
		});
	}
	
	public void initItalianFoodButton() {
		italianFoodButton.setOnAction((event) -> {
			try {
				showItalianWindow();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public void initMexicanFoodButton() {
		mexicanFoodButton.setOnAction((event) -> {
			try {
				showMexicanWindow();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public void initDessertshButton() {
		dessertsButton.setOnAction((event) -> {
			try {
				showDessertsWindow();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public void initDrinksButton() {
		drinksButton.setOnAction((event) -> {
			try {
				showDrinksWindow();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public void initClearOrderListButton() {
		clearOrderListButton.setOnAction((event) -> {
			orderList = new OrderList();
			initOrderTableView();
			printOrderLabel.setText("");
		});
	}
	// number of tables in the restaurant
	public void initTableSpinner() {	
		tableSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15));
	}
	
	public void initColumns() {
		
		foodNameColumn.setCellValueFactory(new PropertyValueFactory<>("foodName"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		foodNameColumn.setStyle("-fx-alignment: CENTER-LEFT;");
		priceColumn.setStyle("-fx-alignment: CENTER-LEFT;");
		
	}
	
	public void initListSelect() {
		orderTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldOrder, newOrder)->{
			if(newOrder != null) {
				currentOrder = newOrder;
			}
			currentOrderIndex = orderTableView.getSelectionModel().getSelectedIndex();
		});
	}
	
	public void initOrderTableView() {
		orderTableView.setItems(orderListViewData);
		orderTableView.getItems().clear();
		totalBill = 0.00;
		for (Order ord : orderList.getOrderList()) {
			orderListViewData.addAll(ord);
			totalBill += ord.getPrice();
		}
		totalBillArea.setText(String.format("%.2f", totalBill));
		
	}

	public Stage showPolishWindow() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("PolishWindow.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Polish Food");
		Scene scene = new Scene(loader.load());
		stage.setScene(scene);
		PolishWindow controller = loader.<PolishWindow>getController();
		controller.initData(orderList);
		stage.show();
		stage.setOnHiding((event) -> {
			initOrderTableView();
		});
		return stage;
	}
	
	public Stage showItalianWindow() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("ItalianWindow.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Italian Food");
		Scene scene = new Scene(loader.load());
		stage.setScene(scene);
		ItalianWindow controller = loader.<ItalianWindow>getController();
		controller.initData(orderList);
		stage.show();
		stage.setOnHiding((event) -> {
			initOrderTableView();
		});
		return stage;
	}
	
	public Stage showMexicanWindow() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("MexicanWindow.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Italian Food");
		Scene scene = new Scene(loader.load());
		stage.setScene(scene);
		MexicanWindow controller = loader.<MexicanWindow>getController();
		controller.initData(orderList);
		stage.show();
		stage.setOnHiding((event) -> {
			initOrderTableView();
		});
		return stage;
	}
	
	public Stage showDessertsWindow() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("DessertsWindow.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Desserts");
		Scene scene = new Scene(loader.load());
		stage.setScene(scene);
		DessertsWindow controller = loader.<DessertsWindow>getController();
		controller.initData(orderList);
		stage.show();
		stage.setOnHiding((event) -> {
			initOrderTableView();
		});
		return stage;
	}
	
	public Stage showDrinksWindow() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("DrinksWindow.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Drinks");
		Scene scene = new Scene(loader.load());
		stage.setScene(scene);
		DrinksWindow controller = loader.<DrinksWindow>getController();
		controller.initData(orderList);
		stage.show();
		stage.setOnHiding((event) -> {
			initOrderTableView();
		});
		return stage;
	}
	
	public void orderPrinter() {
		int tableNumber = tableSpinner.getValue();
		try {
			PrintWriter pw = new PrintWriter(new File(String.format("Order for table %d.txt", tableNumber)));
			pw.println(String.format("Table number: %d", tableNumber));
			for(Order ord : orderList.getOrderList()) {
				pw.println(ord.getFoodName());	
			}
			pw.close();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
		}
	}

}
