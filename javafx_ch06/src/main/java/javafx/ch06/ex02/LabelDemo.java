package javafx.ch06.ex02;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LabelDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Button button = new Button("Dialog");
		button.setPrefSize(100, 20);
		Label label = new Label("This label has serveral characters");
		label.setFont(Font.font("Tahoma", 20));
		label.setUnderline(true);
		label.setWrapText(true);
		
		// Node Graph
		HBox contentBox = new HBox(10, button, label);
		contentBox.setAlignment(Pos.CENTER);

		// Content pane
		StackPane stackPane = new StackPane(contentBox);
		stackPane.setStyle("-fx-background-color: lightgreen");

		// Create a scene
		Scene scene = new Scene(stackPane, 500, 200, Color.GREEN);
		
		Scene secondScene = new Scene(new Group(), 500, 200, Color.AQUA);
		
		button.setOnAction(event -> {
			MessageBox.show("Hello", "Hello Message");
			primaryStage.setScene(secondScene);
		});
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Demo Label");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
