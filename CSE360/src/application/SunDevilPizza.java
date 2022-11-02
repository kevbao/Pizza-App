package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

//Hi, this is Kevin.

public class SunDevilPizza extends Application {
	
	private TabPane tabPane;
	private CustomerView custView;
	private OrderProcessorView opView;
	private ChefView chefView;
	private ArrayList<Student> studentList;
	
	public void start(Stage stage) {
		StackPane root = new StackPane();
		studentList = new ArrayList<Student>();
		
		chefView = new ChefView(studentList);
		opView = new OrderProcessorView(studentList, chefView);
		custView = new CustomerView(studentList, opView);
		
		tabPane = new TabPane();
		Tab tab1 = new Tab();
		tab1.setText("Customer View");
		tab1.setContent(custView);
		
		Tab tab2 = new Tab();
		tab2.setText("Order Processor View");
		tab2.setContent(opView);
		
		Tab tab3 = new Tab();
		tab3.setText("Chef View");
		tab3.setContent(chefView);
		
		tabPane.getSelectionModel().select(0);
		tabPane.getTabs().addAll(tab1, tab2, tab3);
		
		root.getChildren().add(tabPane);
		Scene scene = new Scene (root, 900, 600);
		stage.setTitle("SunDevil Pizza");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
