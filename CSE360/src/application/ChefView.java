package application;

import java.util.ArrayList;

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
	private ToggleGroup allOrders;
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
		control.getChildren().addAll(borderPane);
		
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
}
