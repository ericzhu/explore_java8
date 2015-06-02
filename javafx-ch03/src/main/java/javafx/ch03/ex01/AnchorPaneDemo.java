package javafx.ch03.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Define a button
		Button button1 = new Button("Top-Left");
		button1.setPrefSize(100, 20);

		// Set the Top and Left anchor for button1
		AnchorPane.setTopAnchor(button1, 10.0);
		AnchorPane.setLeftAnchor(button1, 10.0);

		Button button2 = new Button("Bottom-Left");
		button2.setPrefSize(100, 20);

		// Set the Bottom and Left anchor for Button 2
		AnchorPane.setBottomAnchor(button2, 10.0);
		AnchorPane.setLeftAnchor(button2, 10.0);

		Button button3 = new Button("Top-Right");
		button3.setPrefSize(100, 20);
		// Set the Top and Right anchor for Button 3
		AnchorPane.setTopAnchor(button3, 10.0);
		AnchorPane.setRightAnchor(button3, 10.0);

		Button button4 = new Button("Bottom-Right");
		button4.setPrefSize(100, 20);

		// Set the Bottom and Right anchor for Button 4
		AnchorPane.setBottomAnchor(button4, 10.0);
		AnchorPane.setRightAnchor(button4, 10.0);

		// Add components to the pane
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.getChildren().addAll(button1, button2, button3, button4);

		Scene scene = new Scene(anchorPane);
		primaryStage.setScene(scene);

		primaryStage.setWidth(500);
		primaryStage.setHeight(300);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
