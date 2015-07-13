package learn.javafx.ch10.pane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxVGrow extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label descLabel = new Label("Description:");
		TextArea descTextArea = new TextArea();

		VBox root = new VBox(10);
		root.getChildren().addAll(descLabel, descTextArea);

		VBox.setVgrow(descTextArea, Priority.ALWAYS);
		
		root.setStyle("-fx-padding: 10;" + //
				"-fx-border-style: solid inside;" + //
				"-fx-border-width: 2;" + //
				"-fx-border-insets: 5;" + //
				"-fx-border-radius: 5;" + //
				"-fx-border-color: blue;");

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Using Vertical Grow Priority in a VBox");
		primaryStage.show();

	}

}
