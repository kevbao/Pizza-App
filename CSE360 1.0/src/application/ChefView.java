package application;

import java.util.ArrayList;

//import application.OrderProcessorView.SelectionHandler;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

//Right Side needs to be implemented and
//Buttonhandler needs to be created for selected orders and chef

public class ChefView extends VBox {
	
	private ArrayList<Student> studentList;
	private static VBox orders;
	private static VBox orderInfo;
	private Label lab1;
	private Label lab2, lab3;
	private ToggleGroup aorders;
	private static VBox chef;
	private Button startOrder;
	private CheckBox preparing, intheoven, qualitycheck, readyforpickup;
	private Student temp;
	public ChefView(ArrayList<Student> list) {
		this.studentList = list;
		
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
		RadioButton rbutton1 = new RadioButton("Chef 1");
		RadioButton rbutton2 = new RadioButton("Chef 2");
		RadioButton rbutton3 = new RadioButton("Chef 3");
		RadioButton rbutton4 = new RadioButton("Chef 4");
		
		rbutton1.setPadding(new Insets(0, 0, 0, 10));
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
		borderPane2.setTop(lab2);
		borderPane2.setCenter(scrollPane2);
		borderPane2.setPrefSize(300, 320);
		BorderPane.setMargin(scrollPane2, new Insets(10, 0, 10, 0));
		borderPane2.setPadding(new Insets(0, 0, 0, 30));
		
		//start order button
		startOrder = new Button("Start Order");
		borderPane2.setBottom(startOrder);
		//startOrder.setOnAction(new ButtonHandler()); 
		
		EventHandler<ActionEvent> startTheOrder = new EventHandler<ActionEvent>() 
		{
			
			public void handle(ActionEvent e) 
			{
				
				control.getChildren().clear();
				
				orders = new VBox();
				orders.setSpacing(20);
				BorderPane borderPane = new BorderPane();
				ScrollPane scrollPane = new ScrollPane(orders);
				lab1 = new Label("Order:");
				borderPane.setTop(lab1);
				borderPane.setCenter(scrollPane);
				borderPane.setPrefSize(300, 320);
				BorderPane.setMargin(scrollPane, new Insets(10, 0, 10, 0));
				borderPane.setPadding(new Insets(0, 0, 0, 30));
				
				
				//******************************************
				//*************** Right Side ***************
				//Right Side (Tracker)
				
				chef = new VBox();
				chef.setSpacing(20);
				BorderPane borderPane2 = new BorderPane();
				ScrollPane scrollPane2 = new ScrollPane(chef);
				lab2 = new Label("Chef");
				borderPane2.setTop(lab2);
				borderPane2.setCenter(scrollPane2);
				borderPane2.setPrefSize(300, 320);
				BorderPane.setMargin(scrollPane2, new Insets(10, 0, 10, 0));
				borderPane2.setPadding(new Insets(0, 0, 0, 30));
				
				//Order Prep
				
				VBox preperation = new VBox();
				preperation.setSpacing(20);
				BorderPane borderPane3 = new BorderPane();
				ScrollPane scrollPane3 = new ScrollPane(preperation);
				lab3 = new Label("Tracker");
				preparing = new CheckBox("Preparing");
				intheoven = new CheckBox("In The Oven");
				qualitycheck = new CheckBox("Quality Check");
				readyforpickup = new CheckBox("Ready for pickup");
				
				borderPane3.setTop(lab3);
				borderPane3.setCenter(scrollPane3);
				borderPane3.setPrefSize(300, 200);
				BorderPane.setMargin(scrollPane3, new Insets(10, 0, 10, 0));
				borderPane3.setPadding(new Insets(0, 0, 0, 30));
				
				
				preperation.getChildren().addAll(preparing, intheoven, qualitycheck, readyforpickup);
				
				
				
				//Update button
				startOrder = new Button("Update");
				borderPane3.setBottom(startOrder);
				//startOrder.setOnAction(new ButtonHandler());
				
				control.getChildren().addAll(borderPane ,borderPane2, borderPane3);
				
				
				
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
		newOrder.setPadding(new Insets(0, 0, 0, 10));
		newOrder.setToggleGroup(aorders);
		orders.getChildren().add(newOrder);
	}
	
}
