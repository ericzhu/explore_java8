package learn.javafx.ch10.pane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class HBoxHGrow extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Label nameLbl = new Label("Name");
		TextField nameFld = new TextField();
		Button okBtn = new Button("OK");
		Button cancelBtn = new Button("Cancel");

		HBox root = new HBox();
		root.getChildren().addAll(nameLbl, nameFld, okBtn, cancelBtn);
		
		Insets margin = new Insets(10, 2, 10, 2);
		
		HBox.setHgrow(nameFld, Priority.ALWAYS);
		
		HBox.setMargin(nameLbl, margin);
		HBox.setMargin(nameFld, margin);
		HBox.setMargin(okBtn, margin);
		HBox.setMargin(cancelBtn, margin);

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
