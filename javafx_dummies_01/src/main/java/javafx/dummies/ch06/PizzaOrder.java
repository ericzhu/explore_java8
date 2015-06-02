package javafx.dummies.ch06;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PizzaOrder extends Application {

	Stage stage;

	// Customer name, phone and address
	TextField txtName;
	TextField txtPhone;
	TextField txtAddress;

	// Size radio buttons
	RadioButton rdoSmall;
	RadioButton rdoMedium;
	RadioButton rdoLarge;

	// Crust style
	RadioButton rdoThin;
	RadioButton rdoThick;

	// Topping radio buttons
	CheckBox chkPepperoni;
	CheckBox chkSausage;
	CheckBox chkLinguica;
	CheckBox chkOlives;
	CheckBox chkMushrooms;
	CheckBox chkTomatoes;
	CheckBox chkAnchovies;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;

		// ----- Create the top pane -----
		Text textHeading = new Text("Order Your Pizza Now!");
		textHeading.setFont(Font.font(20));
		HBox paneTop = new HBox(textHeading);
		paneTop.setStyle("-fx-background-color: lightgreen");
		paneTop.setPadding(new Insets(20, 10, 20, 10));

		// ----- Create the customer pane -----

		// Create the name label and text field
		Label lblName = new Label("Name:");
		lblName.setPrefWidth(100);

		txtName = new TextField();
		txtName.setPrefColumnCount(20);
		txtName.setPromptText("Enter the customer's name here");
		txtName.setMaxWidth(Double.MAX_VALUE);
		HBox paneName = new HBox(lblName, txtName);

		// Create the phone number and text field
		Label lblPhone = new Label("Phone Number:");
		lblPhone.setPrefWidth(100);
		txtPhone = new TextField();
		txtPhone.setPrefColumnCount(20);
		txtPhone.setPromptText("Enter the customer's phone number here");
		HBox panePhone = new HBox(lblPhone, txtPhone);

		// Create the address label and text field
		Label lblAddress = new Label("Address:");
		lblAddress.setPrefWidth(100);
		txtAddress = new TextField();
		txtAddress.setPrefColumnCount(20);
		txtAddress.setPromptText("Enter the customer's address here");
		HBox paneAddress = new HBox(lblAddress, txtAddress);

		// Create the customer pane
		VBox paneCustomer = new VBox(10, paneName, panePhone, paneAddress);
		paneCustomer.setPadding(new Insets(10));

		// ----- Create the order pane ------
		
		VBox paneCenter = new VBox(20, paneCustomer);
		paneCenter.setPadding(new Insets(0,10, 0, 10));

		// ----- Create a bottom pane ------

		// ----- Finish the scene -----
		BorderPane paneMain = new BorderPane();
		paneMain.setTop(paneTop);
		paneMain.setCenter(paneCenter);
		
		Scene scene = new Scene(paneMain);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Order Pizza");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
