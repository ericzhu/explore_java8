package learn.javafx.ch10.pane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxAlignment extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Button okBtn = new Button("OK");
		Button cancelBtn = new Button("Cancel");

		HBox root = new HBox(10);
		root.setPrefSize(300, 100);
		root.setStyle("-fx-padding: 10;" //
				+ "-fx-border-style: solid inside;" //
				+ "-fx-border-insets: 5;" //
				+ "-fx-border-radius: 5;" //
				+ "-fx-border-color: blue;");

		root.getChildren().addAll(okBtn, cancelBtn);

		root.setAlignment(Pos.BOTTOM_RIGHT);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("HBox alignment");

		stage.show();
	}
}
