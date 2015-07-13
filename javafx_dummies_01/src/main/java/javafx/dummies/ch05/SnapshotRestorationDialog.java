package javafx.dummies.ch05;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SnapshotRestorationDialog {
	
	public static void show(String message, String title) {
		Stage stage = new Stage();
		
		stage.initStyle(StageStyle.UTILITY);
		
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(500);
		
		VBox pane = new VBox(20);
		
		pane.setPadding(new Insets(10, 10, 50, 10));
		
		Label label1 = new Label("Snapshot 5 will be restored");
		Label label2 = new Label("Others working in this scenario may be affected.");
		Label label3 = new Label("The following users are in the scenario now.");
		TextArea messageTextArea = new TextArea();
		
		messageTextArea.setPrefWidth(50);
		messageTextArea.setPrefHeight(20);
		messageTextArea.setPrefRowCount(10);
		
		Label messageLengthCounter = new Label("104 of 500 characters (max)");
		
		Button btnRestore = new Button();
		btnRestore.setText("Restore");
		btnRestore.setOnAction(e -> stage.close());
		
		Button btnCancel = new Button();
		btnCancel.setText("Cancel");
		btnCancel.setOnAction(e -> stage.close());
		
		HBox buttonPane = new HBox(btnRestore, btnCancel);
		buttonPane.setAlignment(Pos.BASELINE_RIGHT);
		buttonPane.setSpacing(10);
		
		
		pane.getChildren().addAll(label1, label2, label3, messageTextArea, messageLengthCounter, buttonPane);
		pane.setAlignment(Pos.BASELINE_LEFT);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
		
	}
}
