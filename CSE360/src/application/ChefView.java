package application;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//Right Side needs to be implemented and
//Buttonhandler needs to be created for selected orders and chef

public class ChefView extends VBox {
	
	private ArrayList<Student> studentList;
	private static VBox orders;
	private Label lab1;
	private Label lab2;
	private ToggleGroup allOrders;
	private static VBox chef;
	private Button startOrder;
	public ChefView(ArrayList<Student> list) {
		this.studentList = list;
		
		allOrders = new ToggleGroup();
		
		Rectangle header = new Rectangle(0, 0, 900, 100);
		header.setFill(Color.GOLD);

		HBox control = new HBox();
		
		//************************************
		//************ Left Side *************
		orders = new VBox();
		orders.setSpacing(20);
		BorderPane borderPane = new BorderPane();
		ScrollPane scrollPane = new ScrollPane(orders);
		lab1 = new Label("Orders");
		borderPane.setTop(lab1);
		borderPane.setCenter(scrollPane);
		borderPane.setPrefSize(400, 420);
		BorderPane.setMargin(scrollPane, new Insets(10, 0, 10, 0));
		borderPane.setPadding(new Insets(0, 0, 0, 30));
		//*************************************
		//*************************************
		
		//Chef radiobutton
		RadioButton button1 = new RadioButton("Chef 1");
		RadioButton button2 = new RadioButton("Chef 2");
		RadioButton button3 = new RadioButton("Chef 3");
		RadioButton button4 = new RadioButton("Chef 4");
		
		button1.setPadding(new Insets(0, 0, 0, 10));
		button2.setPadding(new Insets(0, 0, 0, 10));
		button3.setPadding(new Insets(0, 0, 0, 10));
		button4.setPadding(new Insets(0, 0, 0, 10));
		
		ToggleGroup group = new ToggleGroup();
				
		button1.setToggleGroup(group);
		button2.setToggleGroup(group);
		button3.setToggleGroup(group);
		button4.setToggleGroup(group);
		
		//Right Side (Chef number)
		chef = new VBox();
		chef.setSpacing(20);
		BorderPane borderPane2 = new BorderPane();
		ScrollPane scrollPane2 = new ScrollPane(chef);
		lab2 = new Label("Chef #");
		borderPane2.setTop(lab2);
		borderPane2.setCenter(scrollPane2);
		borderPane2.setPrefSize(300, 320);
		BorderPane.setMargin(scrollPane2, new Insets(10, 0, 10, 0));
		borderPane2.setPadding(new Insets(0, 0, 0, 30));
		
		//start order button
		startOrder = new Button("Start Order");
		borderPane2.setBottom(startOrder);
		startOrder.setOnAction(new ButtonHandler());

		
		chef.getChildren().addAll(button1, button2, button3, button4);
		
		control.getChildren().addAll(borderPane);
		control.getChildren().addAll(borderPane2);
		
		this.getChildren().addAll(header, control);
		this.setSpacing(25);
	}
	public void updateOrders(Student order) {
		//Invoked when the OP hits accept on an order
		//Creates a new radiobutton for the chef to select from.
		RadioButton newOrder = new RadioButton(order.getOrder().toString());
		newOrder.setPadding(new Insets(0, 0, 0, 10));
		newOrder.setToggleGroup(allOrders);
		orders.getChildren().add(newOrder);
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent event) {
			
			
		}
	}
}
