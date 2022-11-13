package application;

import java.util.ArrayList;

import javafx.application.Application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

//errors to be handled:
//no pizza type selected
//Empty inputs for all text fields
//String is input for ID instead of an int


public class CustomerView extends VBox{
	
	ArrayList<Student> studentList;
	private TextField txt1, txt2, txt3; 
	private Label lab1, lab2, lab3, lab4, lab5;
	private ComboBox<String> pizzaTypes;
	private Button submit;
	private OrderProcessorView opv;
	private CheckBox mushrooms, onions, olives, xcheese;
	
	public CustomerView(ArrayList<Student> list, OrderProcessorView opv)
	{
		this.studentList = list;
		this.opv = opv;
		
		Rectangle header1 = new Rectangle(0, 0, 900, 45);
		header1.setFill(Color.GOLD);
		Text title = new Text("SunDevil Pizza");
		title.setFont(Font.font("Impact", 38));
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFill(Color.MAROON);
		title.setStroke(Color.GOLD);
		Rectangle header2 = new Rectangle(0, 0, 900, 45);
		header2.setFill(Color.GOLD);

		HBox menu = new HBox();
		
		//******************************************
		//************* Left Side ******************
		lab5 = new Label("Select Your Pizza Type");
		lab5.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		VBox types = new VBox();
		pizzaTypes = new ComboBox<String>();
		pizzaTypes.getItems().add("Pepperoni");
		pizzaTypes.getItems().add("Vegetable");
		pizzaTypes.getItems().add("Cheese");
		types.getChildren().addAll(lab5, pizzaTypes);
		types.setSpacing(20);
		types.setPrefWidth(270);
		types.setPadding(new Insets(0, 0, 0, 30));
		//******************************************
		//************** Middle ********************
		lab4 = new Label("Add Toppings");
		lab4.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		VBox toppings = new VBox();
		mushrooms = new CheckBox("Mushrooms");
		onions = new CheckBox("Onions");
		olives = new CheckBox("Olives");
		xcheese = new CheckBox("Extra Cheese");
		toppings.getChildren().addAll(lab4, mushrooms, onions, olives, xcheese);
		toppings.setSpacing(20);
		toppings.setPrefWidth(270);
		toppings.setPadding(new Insets(0, 0, 0, 100));
		//******************************************
		//*************** Right Side ***************		
		submit = new Button("Submit");
		lab1 = new Label("Pickup Time:");
		lab1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		lab2 = new Label("Name:");
		lab2.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		lab3 = new Label("ASURITE ID:");
		lab3.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		txt1 = new TextField();
		txt2 = new TextField();
		txt3 = new TextField();
		
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(10);
		ColumnConstraints halfWidth = new ColumnConstraints();
		halfWidth.setPercentWidth(50);
		gridPane.getColumnConstraints().addAll(halfWidth, halfWidth);
		gridPane.setPadding(new Insets(0, 0, 0, 130));
		
		gridPane.add(lab1, 0, 0);
		gridPane.add(txt1, 0, 1);
		gridPane.add(lab2, 0, 4);
		gridPane.add(txt2, 0, 5);
		gridPane.add(lab3, 0, 8);
		gridPane.add(txt3, 0, 9);
		gridPane.add(submit, 1, 15);
		
		submit.setOnAction(new NewOrderHandler());
		//******************************************
		//******************************************
		menu.getChildren().addAll(types, toppings, gridPane);
		
		this.getChildren().addAll(header1, title, header2, menu);
		this.setSpacing(25);
		
		
		
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
			if(txt3.getText().contains("a") || txt3.getText().contains("b") || txt3.getText().contains("c") || txt3.getText().contains("d") || txt3.getText().contains("e") || txt3.getText().contains("f") || txt3.getText().contains("g") || txt3.getText().contains("h") || txt3.getText().contains("i") || txt3.getText().contains("j") || txt3.getText().contains("k") || txt3.getText().contains("l") || txt3.getText().contains("m") || txt3.getText().contains("n") || txt3.getText().contains("o") || txt3.getText().contains("p") || txt3.getText().contains("q") || txt3.getText().contains("r") || txt3.getText().contains("s") || txt3.getText().contains("t") || txt3.getText().contains("u") || txt3.getText().contains("v") || txt3.getText().contains("w") || txt3.getText().contains("x") || txt3.getText().contains("y") || txt3.getText().contains("z")) {
				error.setAlertType(AlertType.ERROR);
				error.setContentText("Numbers Only (0-9)");
				error.show();
				errorMessage = true;
			}
			if(txt3.getText().contains("A") || txt3.getText().contains("B") || txt3.getText().contains("C") || txt3.getText().contains("D") || txt3.getText().contains("E") || txt3.getText().contains("F") || txt3.getText().contains("G") || txt3.getText().contains("H") || txt3.getText().contains("I") || txt3.getText().contains("J") || txt3.getText().contains("K") || txt3.getText().contains("L") || txt3.getText().contains("M") || txt3.getText().contains("N") || txt3.getText().contains("O") || txt3.getText().contains("P") || txt3.getText().contains("Q") || txt3.getText().contains("R") || txt3.getText().contains("S") || txt3.getText().contains("T") || txt3.getText().contains("U") || txt3.getText().contains("V") || txt3.getText().contains("W") || txt3.getText().contains("X") || txt3.getText().contains("Y") || txt3.getText().contains("Z")) {
				error.setAlertType(AlertType.ERROR);
				error.setContentText("Numbers Only (0-9)");
				error.show();
				errorMessage = true;
			}
			
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
			if(!mushrooms.isSelected() && !onions.isSelected() && !olives.isSelected() && !xcheese.isSelected()) {
				error.setAlertType(AlertType.ERROR);
				error.setContentText("Please choose toppings");
				error.show();
				errorMessage = true;
			}
			
			//Setting necessary parameters to accept order
			order.setTime(txt1.getText());
			order.setName(txt2.getText());
			order.setId(Integer.parseInt(txt3.getText()));
			
			if (errorMessage == false) {
			//Pushing successful order to next process
			studentList.add(order);
			opv.updateOrders(order);
			//Successful order message
			String content = "Order Confirmed!";
			Alert success = new Alert(Alert.AlertType.INFORMATION, content, ButtonType.OK);
			success.show();
			}
		}
	}
}
