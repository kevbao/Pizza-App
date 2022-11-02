package application;

import javafx.event.ActionEvent;

import java.util.ArrayList;

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

//Errors to be handled: Clicking accept when nothing is selected
//Need to add right side of the UI where the OP enters in an over-the-phone order
//Need to figure out how to disable button after already sent to chef

public class OrderProcessorView extends VBox {
		
	private ArrayList <Student> studentList;
	private Student temp;
	private static VBox orders;
	private Label lab1;
	private Button accept;
	private ChefView chefView;
	private ToggleGroup allOrders;
	
	public OrderProcessorView(ArrayList<Student> list, ChefView chefView) {
		
		this.studentList = list;
		this.chefView = chefView;
		
		allOrders = new ToggleGroup();
		
		Rectangle header = new Rectangle(0, 0, 900, 100);
		header.setFill(Color.GOLD);

		HBox control = new HBox(); 
		
		//************************************
		//************ Left Side *************
		orders = new VBox();
		BorderPane borderPane = new BorderPane();
		ScrollPane scrollPane = new ScrollPane(orders);
		lab1 = new Label("Orders");
		accept = new Button("Accept");
		accept.setOnAction(new ButtonHandler());
		
		borderPane.setTop(lab1);
		borderPane.setCenter(scrollPane);
		borderPane.setBottom(accept);
		borderPane.setPrefSize(300, 420);
		BorderPane.setMargin(scrollPane, new Insets(10, 0, 10, 0));
		borderPane.setPadding(new Insets(0, 0, 0, 30));
		//*************************************
		//*************************************
		control.getChildren().addAll(borderPane);
		
		this.getChildren().addAll(header, control);
		this.setSpacing(25);
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
			chefView.updateOrders(temp);
		}
	}
}