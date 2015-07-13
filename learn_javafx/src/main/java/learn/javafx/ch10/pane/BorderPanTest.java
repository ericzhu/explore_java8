package learn.javafx.ch10.pane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPanTest extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Set the top and left child nodes to null
		Node top = null;
		Node left = null;

		VBox center = getCenter();

		// Create right child node
		Button okButton = new Button("OK");
		Button cancelButton = new Button("Cancel");

		// Make the OK and cancel buttons the same size
		okButton.setMaxWidth(Double.MAX_VALUE);
		cancelButton.setMaxWidth(Double.MAX_VALUE);
		VBox right = new VBox(5, okButton, cancelButton);
		right.setStyle("-fx-padding: 10;");

		// Create the bottom child node
		Label statusLabel = new Label("Status: Ready");
		HBox bottom = new HBox(statusLabel);
		BorderPane.setMargin(bottom, new Insets(10, 0, 0, 0));
		bottom.setStyle("-fx-background-color: lavender;" + //
				"-fx-font-size: 7pt;" + //
				"-fx-padding: 10 0 0 0;");
		
		BorderPane root = new BorderPane(center, top, right, bottom, left);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Using a BorderPane");
		primaryStage.show();
		

	}

	private VBox getCenter() {
		
		VBox center = new VBox();
		
		// A Label and TextField in a HBox
		Label nameLabel = new Label("Name: ");
		TextField nameField = new TextField();
		HBox nameFields = new HBox(nameLabel, nameField);
		HBox.setHgrow(nameField, Priority.ALWAYS);
		
		// A Label and a TextArea
		Label descLabel = new Label("Description:");
		TextArea descText = new TextArea();
		center.getChildren().addAll(nameFields, descLabel, descText);
		VBox.setVgrow(descText, Priority.ALWAYS);
		
		return center;
	}

}
