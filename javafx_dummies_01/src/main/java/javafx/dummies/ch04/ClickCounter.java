package javafx.dummies.ch04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClickCounter extends Application {	
	
	int iClickCount = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create button
		Button btn = new Button();
		btn.setText("Click me please!");
		btn.setOnAction(e -> buttonClick());
		
		// Add the button to a layout pane
		BorderPane pane = new BorderPane();
		pane.setCenter(btn);
		
		// Add the layout pane to a scene
		Scene scene = new Scene(pane, 250, 150);
		
		// Add the scene to the stage, set the title and show the stage
		primaryStage.setScene(scene);
		primaryStage.setTitle("Click Counter");
		primaryStage.show();
		
	}
	
	private void buttonClick() {
		iClickCount++;
		
		if(iClickCount == 1) {
			MessageBox.show("You have clicked once.", "Click");
		} else {
			MessageBox.show("You have clicked " + iClickCount + " times",  "Clicked");
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
