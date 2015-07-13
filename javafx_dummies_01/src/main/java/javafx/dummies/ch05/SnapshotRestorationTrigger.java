package javafx.dummies.ch05;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SnapshotRestorationTrigger extends Application {	
	
	int iClickCount = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		primaryStage.setX(bounds.getMinX());
		primaryStage.setY(bounds.getMinY());
		primaryStage.setWidth(bounds.getWidth());
		primaryStage.setHeight(bounds.getHeight());
		
		
		// Create button
		Button btn = new Button();
		btn.setText("Click me please!");
		btn.setOnAction(e -> buttonClick());
		
		// Add the button to a layout pane
		BorderPane pane = new BorderPane();
		pane.setCenter(btn);
		
		// Add the layout pane to a scene
		Scene scene = new Scene(pane);
		
		// Add the scene to the stage, set the title and show the stage
		primaryStage.setScene(scene);
		primaryStage.setTitle("Click Counter");
		primaryStage.show();
	}
	
	private void buttonClick() {
		iClickCount++;
		
		if(iClickCount == 1) {
			SnapshotRestorationDialog.show("You have clicked once.", "Restore Snapshot");
		} else {
			SnapshotRestorationDialog.show("You have clicked " + iClickCount + " times",  "Restore Snapshot");
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
