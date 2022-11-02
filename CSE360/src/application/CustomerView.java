package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
		
		Rectangle header = new Rectangle(0, 0, 900, 100);
		header.setFill(Color.GOLD);

		HBox menu = new HBox();
		
		//******************************************
		//************* Left Side ******************
		lab5 = new Label("Select Your Pizza Type");
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
		lab2 = new Label("Name:");
		lab3 = new Label("ASURITE ID:");
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
		
		this.getChildren().addAll(header, menu);
		this.setSpacing(25);
	}
	
	private class NewOrderHandler implements EventHandler<ActionEvent>
	{
		//the newOrderHandler will take all user inputs and make a new student object
		//this is then sent to the OP view
		public void handle(ActionEvent event)
		{
			Student order = new Student();
			//Decide Type
			if (pizzaTypes.getValue().equals("Pepperoni"))
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
			
			order.setTime(txt1.getText());
			order.setName(txt2.getText());
			order.setId(Integer.parseInt(txt3.getText()));
			
			studentList.add(order);
			opv.updateOrders(order);
		}
	}
}
