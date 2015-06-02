package javafx.ch06.ex02;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MessageBox {
	
	public static void show(String title, String message) {
		
		Stage stage = new Stage();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.setTitle(title);
		stage.initStyle(StageStyle.TRANSPARENT);
		
		Label lbl = new Label();
		lbl.setText(message);
		
		Button btnOK = new Button();
		btnOK.setText("OK");
		
		btnOK.setOnAction(event -> stage.close());
		
		
		VBox pane = new VBox(20);
		pane.getChildren().addAll(lbl, btnOK);
		pane.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(pane, 300, 150);
		stage.setScene(scene);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.showAndWait();
	}
}
