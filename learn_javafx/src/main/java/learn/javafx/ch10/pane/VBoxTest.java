package learn.javafx.ch10.pane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxTest extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label nameLabel = new Label("Name");
		TextField nameTextField = new TextField();
		Button okButton = new Button("OK");
		Button cancelButton = new Button("Cancel");

		VBox root = new VBox(10);
		root.getChildren().addAll(nameLabel, nameTextField, okButton, cancelButton);

		root.setStyle("-fx-padding: 10;" + //
				"-fx-border-style: solid inside;" + //
				"-fx-border-width: 2;" + //
				"-fx-border-insets: 5;" + //
				"-fx-border-radius: 5;" + //
				"-fx-border-color: blue;");

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("VBox Demo");
		primaryStage.show();
	}
}