package learn.javafx.ch10.pane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxFillheight extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label descLabel = new Label("Description:");
		TextArea descTextArea = new TextArea();
		descTextArea.setPrefColumnCount(10);
		descTextArea.setPrefRowCount(3);

		CheckBox fillHeightCheckBox = new CheckBox("Fill Height");
		Button okButton = new Button("OK");
		Button cancelButton = new Button("Cancel");
		cancelButton.setMaxHeight(Double.MAX_VALUE);

		HBox root = new HBox(10);
		root.getChildren().addAll(descLabel, descTextArea, fillHeightCheckBox, okButton, cancelButton);
		root.setFillHeight(false);

		fillHeightCheckBox.setOnAction(e -> root.setFillHeight(fillHeightCheckBox.isSelected()));

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("HBox Alignment");
		primaryStage.show();
	}
}
