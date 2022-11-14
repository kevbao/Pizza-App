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
import javafx.scene.control.ProgressBar;
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
	private Button submit, refresh;
	private OrderProcessorView opv;
	private CheckBox mushrooms, onions, olives, xcheese;
	private HBox menu, bars;
	private Text status1, status2, status3, status4;
	public ProgressBar pb1, pb2, pb3, pb4;
	Progress progress1, progress2, progress3, progress4;
	
	public CustomerView(ArrayList<Student> list, OrderProcessorView opv, Progress progress1, Progress progress2, Progress progress3, Progress progress4)
	{
		this.studentList = list;
		this.opv = opv;
		this.progress1 = progress1;
		this.progress2 = progress2;
		this.progress3 = progress3;
		this.progress4 = progress4;
		

		
		Rectangle header1 = new Rectangle(0, 0, 900, 45);
		header1.setFill(Color.GOLD);
		Text title = new Text("SunDevil Pizza");
		title.setFont(Font.font("Impact", 38));
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFill(Color.MAROON);
		title.setStroke(Color.GOLD);
		Rectangle header2 = new Rectangle(0, 0, 900, 45);
		header2.setFill(Color.GOLD);

		menu = new HBox();
		
		//******************************************
		//************* Left Side ******************
		lab5 = new Label("Select Your Pizza Type");
		lab5.setFont(Font.font("Impact", 18));
		lab5.setTextFill(Color.MAROON);
		
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
		lab4.setFont(Font.font("Impact", 18));
		lab4.setTextFill(Color.MAROON);
		
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
		submit.setFont(Font.font("Impact", 20));
		submit.setTextFill(Color.MAROON);
		
		lab1 = new Label("Pickup Time:");
		lab1.setFont(Font.font("Impact", 18));
		lab1.setTextFill(Color.MAROON);
		lab2 = new Label("Name:");
		lab2.setFont(Font.font("Impact", 18));
		lab2.setTextFill(Color.MAROON);
		lab3 = new Label("ASURITE ID:");
		lab3.setFont(Font.font("Impact", 18));
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
			opv.updateOrders(order);
			//Successful order message
			String content = "Order Confirmed!";
			Alert success = new Alert(Alert.AlertType.INFORMATION, content, ButtonType.OK);
			success.show();
			
			menu.getChildren().clear();
			
			
			//Customer 2 view
			
			status1 = new Text("Preparing...");
			status1.setFont(Font.font("Impact", 18));
			status1.setFill(Color.MAROON);
			status2 = new Text("In the Oven...");
			status2.setFont(Font.font("Impact", 18));
			status2.setFill(Color.MAROON);
			status3 = new Text("Quality Check...");
			status3.setFont(Font.font("Impact", 18));
			status3.setFill(Color.MAROON);
			status4 = new Text("Ready for pickup!");
			status4.setFont(Font.font("Impact", 18));
			status4.setFill(Color.MAROON);
			pb1 = new ProgressBar(0);
			pb1.setStyle("-fx-accent: gold;");
			pb2 = new ProgressBar(0);
			pb2.setStyle("-fx-accent: gold;");
			pb3 = new ProgressBar(0);
			pb3.setStyle("-fx-accent: gold;");
			pb4 = new ProgressBar(0);
			pb4.setStyle("-fx-accent: gold;");
			bars = new HBox();
			bars.getChildren().addAll(pb1, pb2, pb3, pb4);
			bars.setSpacing(120);
			
			refresh = new Button("Refresh");
			refresh.setOnAction(new RefreshHandler());
			refresh.setFont(Font.font("Impact", 20));
			refresh.setTextFill(Color.MAROON);
			
			VBox progress = new VBox();
			HBox labels = new HBox();
			

			labels.getChildren().addAll(status1, status2, status3, status4);
			labels.setSpacing(120);
			
			progress.getChildren().addAll(labels, bars, refresh);
			progress.setSpacing(30);
			progress.setPrefWidth(270);
			progress.setPadding(new Insets(50, 0, 0, 30));
			
			GridPane gridPane = new GridPane();
			gridPane.setAlignment(Pos.CENTER);
			gridPane.setVgap(10);
			ColumnConstraints halfWidth = new ColumnConstraints();
			halfWidth.setPercentWidth(50);
			gridPane.getColumnConstraints().addAll(halfWidth, halfWidth);
			gridPane.setPadding(new Insets(0, 0, 0, 130));
			
			menu.getChildren().addAll(progress, gridPane);
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

	public class RefreshHandler implements EventHandler<ActionEvent> {
		//Button handler for refresh button to see progress of pizza
		public void handle(ActionEvent event) {
			pb1.setProgress(progress1.getProgress1());
			pb2.setProgress(progress2.getProgress1());
			pb3.setProgress(progress3.getProgress1());
			pb4.setProgress(progress4.getProgress1());
		}
	}
}
