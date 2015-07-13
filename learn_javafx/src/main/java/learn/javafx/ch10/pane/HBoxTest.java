package learn.javafx.ch10.pane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxTest extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Label nameLbl = new Label("Name");
		TextField nameFld = new TextField();
		Button okBtn = new Button("OK");
		Button cancelBtn = new Button("Cancel");

		HBox root = new HBox(10);
		root.getChildren().addAll(nameLbl, nameFld, okBtn, cancelBtn);

		root.setStyle("-fx-padding: 10;" //
				+ "-fx-border-style: solid inside;" //
				+ "-fx-border-width: 2;" //
				+ "-fx-border-color: blue;" //
				+ "-fx-border-insets: 5;" //
				+ "-fx-border-radius: 5;");

		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.setTitle("HBox Demo");
		stage.show();

	}

}
