package application;

import javafx.event.ActionEvent;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

//Errors to be handled: Clicking accept when nothing is selected
//Need to add right side of the UI where the OP enters in an over-the-phone order
//Need to figure out how to disable button after already sent to chef

public class OrderProcessorView extends VBox {
		
	private ArrayList <Student> studentList;
	private Student temp;
	private static VBox orders;
	private Label lab1, lab2;
	private Label lab3;
	private Label lab4;
	private Label lab5;
	private Label lab6;
	private Button accept;
	private Button reject;
	private Button submit;
	private ChefView chefView;
	private ToggleGroup allOrders;
	private CheckBox mushrooms, onions, olives, xcheese;
	private TextField txt1, txt2, txt3; 
	private ComboBox<String> pizzaTypes;
	//private CustomerView custView;
	
	public OrderProcessorView(ArrayList<Student> list, ChefView chefView) {
		
		this.studentList = list;
		this.chefView = chefView;
		//this.custView = custView;
		
		allOrders = new ToggleGroup();
		
		Rectangle header1 = new Rectangle(0, 0, 900, 45);
		header1.setFill(Color.GOLD);
		Text title = new Text("SunDevil Pizza");
		title.setFont(Font.font("Impact", 38));
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFill(Color.MAROON);
		title.setStroke(Color.GOLD);
		Rectangle header2 = new Rectangle(0, 0, 900, 45);
		header2.setFill(Color.GOLD);

		HBox control = new HBox(); 
		
		//************************************
		//************ Left Side *************
		orders = new VBox();
		BorderPane borderPane = new BorderPane();
		ScrollPane scrollPane = new ScrollPane(orders);
		lab1 = new Label("Orders");
		lab1.setFont(Font.font("Impact", 18));
		lab1.setTextFill(Color.MAROON);
		accept = new Button("Accept");
		accept.setFont(Font.font("Impact", 16));
		accept.setTextFill(Color.MAROON);
		accept.setOnAction(new ButtonHandler());
		reject = new Button("Reject");
		reject.setFont(Font.font("Impact", 16));
		reject.setTextFill(Color.MAROON);
		reject.setOnAction(new ButtonHandler());
		HBox leftBox = new HBox(accept);
		HBox rightBox = new HBox(reject);
		rightBox.setPadding(new Insets(0, 0 ,0, 115));
		HBox bottom = new HBox(leftBox, rightBox);
		//bottom.setPadding(new Insets(10));
		
		
		borderPane.setTop(lab1);
		borderPane.setCenter(scrollPane);
		borderPane.setBottom(bottom);
		borderPane.setPrefSize(350, 100);
		BorderPane.setMargin(scrollPane, new Insets(10, 0, 10, 0));
		borderPane.setPadding(new Insets(0, 0, 0, 30));
		//*************************************
		//*************************************
		control.getChildren().addAll(borderPane);
		
		this.getChildren().addAll(header1, title, header2, control);
		this.setSpacing(25);
		lab5 = new Label("Pizza Type");
		lab5.setFont(Font.font("Impact", 14));
		lab5.setTextFill(Color.MAROON);
		VBox types = new VBox();
		pizzaTypes = new ComboBox<String>();
		pizzaTypes.getItems().add("Pepperoni");
		pizzaTypes.getItems().add("Vegetable");
		pizzaTypes.getItems().add("Cheese");
		types.getChildren().addAll(lab5, pizzaTypes);
		types.setSpacing(20);
		types.setPrefWidth(120);
		types.setPadding(new Insets(0, 0, 0, 20));
		types.setPrefWidth(200);
		//******************************************
		//************** Middle ********************
		lab4 = new Label("Add Toppings");
		lab4.setFont(Font.font("Impact", 14));
		lab4.setTextFill(Color.MAROON);
		VBox toppings = new VBox();
		mushrooms = new CheckBox("Mushrooms");
		onions = new CheckBox("Onions");
		olives = new CheckBox("Olives");
		xcheese = new CheckBox("Extra Cheese");
		toppings.getChildren().addAll(lab4, mushrooms, onions, olives, xcheese);
		toppings.setSpacing(20);
		toppings.setPrefWidth(270);
		toppings.setPadding(new Insets(0, 0, 0, 50));
		//******************************************
		//*************** Right Side ***************		
		submit = new Button("Submit");
		submit.setFont(Font.font("Impact", 20));
		submit.setTextFill(Color.MAROON);
		lab1 = new Label("Pickup Time:");
		lab1.setFont(Font.font("Impact", 14));
		lab1.setTextFill(Color.MAROON);
		lab2 = new Label("Name:");
		lab2.setFont(Font.font("Impact", 14));
		lab2.setTextFill(Color.MAROON);
		lab3 = new Label("ASURITE ID:");
		lab3.setFont(Font.font("Impact", 14));
		lab3.setTextFill(Color.MAROON);
		txt1 = new TextField();
		txt2 = new TextField();
		txt3 = new TextField();
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(10);
		ColumnConstraints halfWidth = new ColumnConstraints();
		halfWidth.setPercentWidth(50);
		gridPane.getColumnConstraints().addAll(halfWidth, halfWidth);
		gridPane.setPadding(new Insets(0, 0, 0, 50));
		
		gridPane.add(lab1, 0, 0);
		gridPane.add(txt1, 0, 1);
		gridPane.add(lab2, 0, 4);
		gridPane.add(txt2, 0, 5);
		gridPane.add(lab3, 0, 8);
		gridPane.add(txt3, 0, 9);
		gridPane.add(submit, 1, 15);
		
		submit.setOnAction(new NewOrderHandler());
		
		control.getChildren().addAll(types, toppings, gridPane);
	}
	
	public void updateOrders(Student order) {
		//Is invoked when the CUSTOMER hits the submit button; it
		//creates a new radioButton for OP to select.
		RadioButton newOrder = new RadioButton(order.toString());
		newOrder.setPadding(new Insets(0, 0, 0, 10));
		newOrder.setOnAction(new SelectionHandler(order));
		newOrder.setToggleGroup(allOrders);
		orders.getChildren().add(newOrder);
	}
	
	private class SelectionHandler implements EventHandler<ActionEvent> {
		//SelectionHandler scans the selected order choice into a temp object
		//and will only transfer to ChefView when submit button is clicked.
		private Student order;
		
		public SelectionHandler(Student order) {
			this.order = order;
		}
		public void handle(ActionEvent event) {
			
			boolean selected = ((RadioButton)event.getSource()).isSelected();
			
			if (selected) {
				temp = order;
			} 
			
		} 
	
	}
	private class ButtonHandler implements EventHandler<ActionEvent> {
		//ButtonHandler manages the Accept button, when clicked, it adds 
		//the selected order to the chef UI
		public void handle(ActionEvent event) {
			
			Alert error = new Alert(AlertType.NONE);
				//chefView.updateOrders(temp);
			
			
				//studentList.remove(temp);
			if(event.getSource() == reject) {
				if (allOrders.getSelectedToggle() == null) {
					error.setAlertType(AlertType.ERROR);
					error.setContentText("No order selected");
					error.show();
				}
				else {
					orders.getChildren().remove(0);
				}
			}
				
			if(event.getSource() == accept) {
				if (allOrders.getSelectedToggle() == null) {
					error.setAlertType(AlertType.ERROR);
					error.setContentText("No order selected");
					error.show();
				}
				else {
					chefView.updateOrders(temp);
					orders.getChildren().remove(0);
				}

			}
			
		}
	}
	private class NewOrderHandler implements EventHandler<ActionEvent>
	{
		
		
		//the newOrderHandler will take all user inputs and make a new student object
		//this is then sent to the OP view
		public void handle(ActionEvent event)
		{
			Student order = new Student();
			Alert error = new Alert(AlertType.NONE);
			boolean errorMessage = false;
			
			//Error Handling: if pickup time is empty
			if(txt1.getText().isEmpty()) {
				error.setAlertType(AlertType.ERROR);
				error.setContentText("Please enter a pickup time");
				error.show();
				errorMessage = true;
			}  
			//Error Handling: if name is empty 
			else if(txt2.getText().isEmpty()) {
				error.setAlertType(AlertType.ERROR);
				error.setContentText("Please enter your name");
				error.show();
				errorMessage = true;
			} 
			
			//Error Handling: if ASURITE ID is empty
			else if(txt3.getText().isEmpty()) {
				error.setAlertType(AlertType.ERROR);
				error.setContentText("Please enter your ASURITE ID");
				error.show();
				errorMessage = true;
			}
			else {
			try {
			//Decide Pizza Type
			if (pizzaTypes.getSelectionModel().getSelectedItem() == null) {
				//Error Handling: if pizza type is not chosen
				error.setAlertType(AlertType.ERROR);
				error.setContentText("Please choose your pizza type");
				error.show();
				errorMessage = true;
			}
			else if (pizzaTypes.getValue().equals("Pepperoni"))
			{
				order.getOrder().setType("Pepperoni");
			} 
			else if (pizzaTypes.getValue().equals("Vegetable"))
			{
				order.getOrder().setType("Vegetable");
			}
			else if (pizzaTypes.getValue().equals("Cheese"))
			{
				order.getOrder().setType("Cheese");
			}
			
			
			//Decide Toppings
			if (mushrooms.isSelected()) 
			{
				order.getOrder().getToppings().add("Mushrooms");
			}
			if (onions.isSelected()) 
			{
				order.getOrder().getToppings().add("Onions");
			}
			if (olives.isSelected()) 
			{
				order.getOrder().getToppings().add("Olives");
			}
			if (xcheese.isSelected()) 
			{
				order.getOrder().getToppings().add("Extra Cheese");
			}
			//Error Handling: if toppings are not selected
			/*if(!mushrooms.isSelected() && !onions.isSelected() && !olives.isSelected() && !xcheese.isSelected()) {
				error.setAlertType(AlertType.ERROR);
				error.setContentText("Please choose toppings");
				error.show();
				errorMessage = true;
			}*/
			//Setting necessary parameters to accept order
			order.setTime(txt1.getText());
			order.setName(txt2.getText());
			order.setId(Integer.parseInt(txt3.getText()));
			
			//Pushing successful order to next process
			studentList.add(order);
			updateOrders(order);
			//Successful order message
			//String content = "Order Confirmed!";
			//Alert success = new Alert(Alert.AlertType.INFORMATION, content, ButtonType.OK);
			//success.show();
			}
			catch (NumberFormatException e) {
				if(txt3.getText().contains("a") || txt3.getText().contains("b") || txt3.getText().contains("c") || 
					txt3.getText().contains("d") || txt3.getText().contains("e") || txt3.getText().contains("f") || 
					txt3.getText().contains("g") || txt3.getText().contains("h") || txt3.getText().contains("i") || 
					txt3.getText().contains("j") || txt3.getText().contains("k") || txt3.getText().contains("l") || 
					txt3.getText().contains("m") || txt3.getText().contains("n") || txt3.getText().contains("o") || 
					txt3.getText().contains("p") || txt3.getText().contains("q") || txt3.getText().contains("r") || 
					txt3.getText().contains("s") || txt3.getText().contains("t") || txt3.getText().contains("u") || 
					txt3.getText().contains("v") || txt3.getText().contains("w") || txt3.getText().contains("x") || 
					txt3.getText().contains("y") || txt3.getText().contains("z")) 
				{
				error.setAlertType(AlertType.ERROR);
				error.setContentText("Numbers Only (0-9)");
				error.show();
				errorMessage = true;
				}
			}
			}
		}
	}
}
