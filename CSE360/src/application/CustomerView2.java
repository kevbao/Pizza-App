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
import javafx.scene.control.ProgressIndicator;
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
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class CustomerView2 extends VBox {
	private ChefView chv;
	private Text status1, status2, status3, status4;
	
	public CustomerView2(ChefView chv) {
		// TODO Auto-generated constructor stub
		
		this.chv = chv;
		
		Rectangle header1 = new Rectangle(0, 0, 900, 45);
		header1.setFill(Color.GOLD);
		Text title = new Text("SunDevil Pizza");
		title.setFont(Font.font("Impact", 38));
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFill(Color.MAROON);
		title.setStroke(Color.GOLD);
		Rectangle header2 = new Rectangle(0, 0, 900, 45);
		header2.setFill(Color.GOLD);
		
		HBox status = new HBox();
		
		status1 = new Text("Preparing...");
		status1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		status2 = new Text("In the Oven...");
		status2.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		status3 = new Text("Quality Check...");
		status3.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		status4 = new Text("Ready for pickup!");
		status4.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		
		ProgressIndicator pi1 = new ProgressIndicator();
		ProgressIndicator pi2 = new ProgressIndicator();
		ProgressIndicator pi3 = new ProgressIndicator();
		ProgressIndicator pi4 = new ProgressIndicator();
		
		VBox progress = new VBox();
		
	
		pi1.setProgress(0);
		pi2.setProgress(0);
		pi3.setProgress(0);
		pi4.setProgress(0);
		
		progress.getChildren().addAll(status1, pi1, status2, pi2, status3, pi3, status4, pi4);
		progress.setSpacing(20);
		progress.setPrefWidth(270);
		progress.setPadding(new Insets(0, 0, 0, 30));
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(10);
		ColumnConstraints halfWidth = new ColumnConstraints();
		halfWidth.setPercentWidth(50);
		gridPane.getColumnConstraints().addAll(halfWidth, halfWidth);
		gridPane.setPadding(new Insets(0, 0, 0, 130));
		
		status.getChildren().addAll(progress, gridPane);
		
		this.getChildren().addAll(header1, title, header2, status);
		this.setSpacing(25);


	}
	
	
	
}
