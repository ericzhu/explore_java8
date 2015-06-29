package learn.javafx.ch01.intro;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImprovedHelloFXApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Label nameLbl = new Label("Enter your name:");
		TextField nameFld = new TextField();

		Label msg = new Label();
		msg.setStyle("-fx-text-fill:blue");

		// Create buttons
		Button sayHelloButton = new Button("Say Hello");
		Button exitButton = new Button("Exit");
		
		sayHelloButton.setOnAction(e -> {
			String name = nameFld.getText();
			if(name.trim().length() > 0) {
				msg.setText("Hello " + name);
			} else {
				msg.setText("Hello there");
			}
		});
		
		exitButton.setOnAction(e -> Platform.exit());

		// Create the root node
		VBox root = new VBox();

		// Set vertical spacing between children to 5px
		root.setSpacing(5);
		
		root.getChildren().addAll(nameLbl, nameFld, msg, sayHelloButton, exitButton);
		
		Scene scene = new Scene(root, 350, 150);
		stage.setScene(scene);
		stage.setTitle("Improved Hello JavaFX Application");
		stage.show();
	}

}
