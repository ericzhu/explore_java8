package learn.javafx.ch10.pane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxAlignment extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button okButton = new Button("OK");
		Button cancelButton = new Button("Cancel");

		VBox root = new VBox(10);
		root.setPrefSize(200, 100);
		root.setAlignment(Pos.BOTTOM_RIGHT);

		root.setStyle("-fx-padding: 10;" + //
				"-fx-border-style: solid inside;" + //
				"-fx-border-width: 2;" + //
				"-fx-border-insets: 5;" + //
				"-fx-border-radius: 5;" + //
				"-fx-border-color: blue;");

		root.getChildren().addAll(okButton, cancelButton);

		Scene scene = new Scene(root);

		primaryStage.setTitle("VBox Alignment Demo");
		primaryStage.setScene(scene);

		primaryStage.show();

	}

}