package learn.javafx.ch10.pane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackPaneHBoxHGrow extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Insets margin = new Insets(10, 2, 10, 2);
		
		Label nameLbl = new Label("Name");
		TextField nameFld = new TextField();
		Button okBtn = new Button("OK");
		Button cancelBtn = new Button("Cancel");

		HBox back = new HBox();
		back.getChildren().addAll(nameLbl, nameFld, okBtn, cancelBtn);
		back.setStyle("-fx-padding: 10;" //
				+ "-fx-border-style: solid inside;" //
				+ "-fx-border-width: 2;" //
				+ "-fx-border-color: blue;" //
				+ "-fx-border-insets: 5;" //
				+ "-fx-border-radius: 5;");
		
		
		Label nameLblFront = new Label("Name Front");
		TextField nameFldFront = new TextField();
		
		HBox front = new HBox();
		
		HBox.setMargin(nameLblFront, margin);
		HBox.setMargin(nameFldFront, margin);
		HBox.setHgrow(nameFldFront, Priority.ALWAYS);
		
		front.getChildren().addAll(nameLblFront, nameFldFront);
		front.setStyle("-fx-padding: 10;" //
				+ "-fx-border-style: solid inside;" //
				+ "-fx-border-width: 2;" //
				+ "-fx-border-color: blue;" //
				+ "-fx-border-insets: 5;" //
				+ "-fx-border-radius: 5;");
		
		
		
		
		
		HBox.setHgrow(nameFld, Priority.ALWAYS);
		
		HBox.setMargin(nameLbl, margin);
		HBox.setMargin(nameFld, margin);
		HBox.setMargin(okBtn, margin);
		HBox.setMargin(cancelBtn, margin);


		
		
		StackPane root = new StackPane();
		root.getChildren().addAll(back, front);

		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.setTitle("HBox Demo");
		stage.show();
	}
}
