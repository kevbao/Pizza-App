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
	private Label lab1;
	private Button accept;
	private Button reject;
	private ChefView chefView;
	private ToggleGroup allOrders;
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
		accept = new Button("Accept");
		accept.setOnAction(new ButtonHandler());
		reject = new Button("Reject");
		reject.setOnAction(new ButtonHandler());
		HBox leftBox = new HBox(accept);
		HBox rightBox = new HBox(reject);
		HBox bottom = new HBox(leftBox, rightBox);
		bottom.setPadding(new Insets(10));
		
		
		borderPane.setTop(lab1);
		borderPane.setCenter(scrollPane);
		borderPane.setBottom(bottom);
		borderPane.setPrefSize(300, 420);
		BorderPane.setMargin(scrollPane, new Insets(10, 0, 10, 0));
		borderPane.setPadding(new Insets(0, 0, 0, 30));
		//*************************************
		//*************************************
		control.getChildren().addAll(borderPane);
		
		this.getChildren().addAll(header1, title, header2, control);
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
			

				//chefView.updateOrders(temp);
	

				//studentList.remove(temp);
				if(event.getSource() == reject) {
					orders.getChildren().remove(0);
				}
				
				if(event.getSource() == accept) {
					chefView.updateOrders(temp);
					orders.getChildren().remove(0);
				}
			
		}
	}
}
