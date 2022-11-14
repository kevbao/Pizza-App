package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

public class SunDevilPizza extends Application {
	
	private TabPane tabPane;
	private CustomerView custView;
	private OrderProcessorView opView;
	private ChefView chefView;
	private ArrayList<Student> studentList;
	private Progress progress1, progress2, progress3, progress4;
	
	public void start(Stage stage) {
		StackPane root = new StackPane();
		studentList = new ArrayList<Student>();
		progress1 = new Progress();
		progress2 = new Progress();
		progress3 = new Progress();
		progress4 = new Progress();
		
		chefView = new ChefView(studentList, progress1, progress2, progress3, progress4);
		opView = new OrderProcessorView(studentList, chefView);
		custView = new CustomerView(studentList, opView, progress1, progress2, progress3, progress4);
		
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
