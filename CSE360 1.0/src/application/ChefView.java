package application;

import java.util.ArrayList;

//import application.OrderProcessorView.SelectionHandler;
//import application.OrderProcessorView.SelectionHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

//Right Side needs to be implemented and
//Buttonhandler needs to be created for selected orders and chef

public class ChefView extends VBox {
	
	ArrayList<Student> studentList;
	private static VBox orders;
	private static VBox orderInfo;
	private Label lab1;
	private Label lab2, lab3, lab4, lab5;
	private ToggleGroup aorders;
	private static VBox chef;
	private Button startOrder;
	private Button preparing, intheoven, qualitycheck, readyforpickup;
	private Student temp;
	private String selChef;
	private CustomerView custView;
	private HBox control;
	//double progress1;
	//private SunDevilPizza sdp;
	Progress progress1, progress2, progress3, progress4;
	
	public ChefView(ArrayList<Student> list, Progress progress1, Progress progress2, Progress progress3, Progress progress4) {
		this.studentList = list;
		this.progress1 = progress1;
		this.progress2 = progress2;
		this.progress3 = progress3;
		this.progress4 = progress4;
		//progress1 = 0.0;
		
		aorders = new ToggleGroup();
		
		Rectangle header1 = new Rectangle(0, 0, 900, 45);
		header1.setFill(Color.GOLD);
		Text title = new Text("SunDevil Pizza");
		title.setFont(Font.font("Impact", 38));
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFill(Color.MAROON);
		title.setStroke(Color.GOLD);
		Rectangle header2 = new Rectangle(0, 0, 900, 45);
		header2.setFill(Color.GOLD);

		control = new HBox();
		
		//************************************
		//************ Left Side *************
		orders = new VBox();
		orders.setSpacing(20);
		BorderPane borderPane = new BorderPane();
		ScrollPane scrollPane = new ScrollPane(orders);
		lab1 = new Label("Orders");
		lab1.setFont(Font.font("Impact", 18));
		lab1.setTextFill(Color.MAROON);
		borderPane.setTop(lab1);
		borderPane.setCenter(scrollPane);
		borderPane.setPrefSize(400, 350);
		BorderPane.setMargin(scrollPane, new Insets(10, 0, 10, 0));
		borderPane.setPadding(new Insets(0, 0, 0, 30));
		//*************************************
		//*************************************
		
		//Chef radiobutton
		RadioButton rbutton1 = new RadioButton("Chef 1");
		RadioButton rbutton2 = new RadioButton("Chef 2");
		RadioButton rbutton3 = new RadioButton("Chef 3");
		RadioButton rbutton4 = new RadioButton("Chef 4");
		
		rbutton1.setPadding(new Insets(10, 0, 0, 10));
		rbutton2.setPadding(new Insets(0, 0, 0, 10));
		rbutton3.setPadding(new Insets(0, 0, 0, 10));
		rbutton4.setPadding(new Insets(0, 0, 0, 10));
		
		ToggleGroup group = new ToggleGroup();
				
		rbutton1.setToggleGroup(group);
		rbutton2.setToggleGroup(group);
		rbutton3.setToggleGroup(group);
		rbutton4.setToggleGroup(group);
		
		//Right Side (Chef number)
		chef = new VBox();
		chef.setSpacing(20);
		BorderPane borderPane2 = new BorderPane();
		ScrollPane scrollPane2 = new ScrollPane(chef);
		lab2 = new Label("Chef #");
		lab2 = new Label("Orders");
		lab2.setFont(Font.font("Impact", 18));
		lab2.setTextFill(Color.MAROON);
		borderPane2.setTop(lab2);
		borderPane2.setCenter(scrollPane2);
		borderPane2.setPrefSize(300, 300);
		BorderPane.setMargin(scrollPane2, new Insets(10, 0, 10, 0));
		borderPane2.setPadding(new Insets(0, 0, 0, 30));
		
		//start order button
		startOrder = new Button("Start Order");
		startOrder.setFont(Font.font("Impact", 20));
		startOrder.setTextFill(Color.MAROON);
		borderPane2.setBottom(startOrder);
		//startOrder.setOnAction(new ButtonHandler()); 
		
		EventHandler<ActionEvent> startTheOrder = new EventHandler<ActionEvent>() 
		{
			
			public void handle(ActionEvent e) 
			{
				Alert error = new Alert(AlertType.NONE);
				if (aorders.getSelectedToggle() == null) {
					error.setAlertType(AlertType.ERROR);
					error.setContentText("No order selected");
					error.show();
				}
				else if (group.getSelectedToggle() == null) {
					error.setAlertType(AlertType.ERROR);
					error.setContentText("No chef selected");
					error.show();
				}
				else {
				control.getChildren().clear();
				
				lab4 = new Label(temp.getOrder().toString());
				lab4.setPadding(new Insets(10, 0, 0, 10));
				
				orders = new VBox();
				orders.setSpacing(20);
				BorderPane borderPane = new BorderPane();
				ScrollPane scrollPane = new ScrollPane(lab4);
				lab1 = new Label("Order:");
				lab1.setFont(Font.font("Impact", 18));
				lab1.setTextFill(Color.MAROON);
				borderPane.setTop(lab1);
				borderPane.setCenter(scrollPane);
				borderPane.setPrefSize(300, 320);
				BorderPane.setMargin(scrollPane, new Insets(10, 0, 10, 0));
				borderPane.setPadding(new Insets(0, 0, 0, 30));
				
				
				//******************************************
				//*************** Right Side ***************
				//Right Side (Tracker)
				
				/*chef = new VBox();
				chef.setSpacing(20);
				BorderPane borderPane2 = new BorderPane();
				ScrollPane scrollPane2 = new ScrollPane(chef);
				lab2 = new Label("Chef");
				borderPane2.setTop(lab2);
				borderPane2.setCenter(scrollPane2);
				borderPane2.setPrefSize(300, 320);
				BorderPane.setMargin(scrollPane2, new Insets(10, 0, 10, 0));
				borderPane2.setPadding(new Insets(0, 0, 0, 30)); */
				
				//Order Prep
				
				VBox preperation = new VBox();
				preperation.setSpacing(20);
				BorderPane borderPane3 = new BorderPane();
				VBox tracker = new VBox(preperation);
				lab3 = new Label("Tracker");
				lab3.setFont(Font.font("Impact", 18));
				lab3.setTextFill(Color.MAROON);
				preparing = new Button("Preparing");
				preparing.setFont(Font.font("Impact", 20));
				preparing.setTextFill(Color.MAROON);
				preparing.setOnAction(new PreparingHandler());
				intheoven = new Button("In The Oven");
				intheoven.setFont(Font.font("Impact", 20));
				intheoven.setTextFill(Color.MAROON);
				intheoven.setOnAction(new PreparingHandler1());
				qualitycheck = new Button("Quality Check");
				qualitycheck.setFont(Font.font("Impact", 20));
				qualitycheck.setTextFill(Color.MAROON);
				qualitycheck.setOnAction(new PreparingHandler2());
				readyforpickup = new Button("Ready for pickup");
				readyforpickup.setFont(Font.font("Impact", 20));
				readyforpickup.setTextFill(Color.MAROON);
				readyforpickup.setOnAction(new PreparingHandler3());
				
				
				borderPane3.setTop(lab3);
				borderPane3.setCenter(tracker);
				borderPane3.setPrefSize(300, 200);
				BorderPane.setMargin(tracker, new Insets(10, 0, 10, 0));
				borderPane3.setPadding(new Insets(0, 0, 0, 30));
				
				
				preperation.getChildren().addAll(preparing, intheoven, qualitycheck, readyforpickup);
				
				
				
				//Update button
				//startOrder = new Button("Update");
				//borderPane3.setBottom(startOrder);
				//startOrder.setOnAction(new ButtonHandler());
				
				control.getChildren().addAll(borderPane , borderPane3);
				}
				
			}
			
		};
		
		startOrder.setOnAction(startTheOrder);

		
		chef.getChildren().addAll(rbutton1, rbutton2, rbutton3, rbutton4);
		
		control.getChildren().addAll(borderPane);
		control.getChildren().addAll(borderPane2);
		
		this.getChildren().addAll(header1, title, header2, control);
		this.setSpacing(25);
	}
	
	public void updateOrders(Student order) {
		//Invoked when the OP hits accept on an order
		//Creates a new radiobutton for the chef to select from.
		RadioButton newOrder = new RadioButton(order.getOrder().toString());
		newOrder.setPadding(new Insets(10, 0, 0, 10));
		newOrder.setOnAction(new SelectionHandler(order));
		newOrder.setToggleGroup(aorders);
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
	private class PreparingHandler implements EventHandler<ActionEvent> {
		//ButtonHandler manages the Accept button, when clicked, it adds 
		//the selected order to the chef UI
		public void handle(ActionEvent event) {
			progress1.setProgress1(1.0);
			progress2.setProgress1(0.0);
			progress3.setProgress1(0.0);
			progress4.setProgress1(0.0);
		}
	}
	private class PreparingHandler1 implements EventHandler<ActionEvent> {
		//ButtonHandler manages the Accept button, when clicked, it adds 
		//the selected order to the chef UI
		public void handle(ActionEvent event) {
			progress1.setProgress1(1.0);
			progress2.setProgress1(1.0);
			progress3.setProgress1(0.0);
			progress4.setProgress1(0.0);
		}
	}
	private class PreparingHandler2 implements EventHandler<ActionEvent> {
		//ButtonHandler manages the Accept button, when clicked, it adds 
		//the selected order to the chef UI
		public void handle(ActionEvent event) {
			progress1.setProgress1(1.0);
			progress2.setProgress1(1.0);
			progress3.setProgress1(1.0);
			progress4.setProgress1(0.0);
		}
	}
	private class PreparingHandler3 implements EventHandler<ActionEvent> {
		//ButtonHandler manages the Accept button, when clicked, it adds 
		//the selected order to the chef UI
		public void handle(ActionEvent event) {
			progress1.setProgress1(1.0);
			progress2.setProgress1(1.0);
			progress3.setProgress1(1.0);
			progress4.setProgress1(1.0);
		}
	}
}
