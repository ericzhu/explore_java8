package learn.javafx.ch10.pane;


import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

public class GroupEffect extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		// Create two buttons
		Button okButton = new Button("OK");
		Button cancelButton = new Button("Cancel");
		
		// Set the location of the OK button
		okButton.setLayoutX(10);
		okButton.setLayoutY(10);
		
		// Set the location of the OK button relative to the OK button
		NumberBinding layoutXBinding = okButton.layoutXProperty().add(okButton.widthProperty().add(10));
		cancelButton.layoutXProperty().bind(layoutXBinding);
		cancelButton.layoutYProperty().bind(okButton.layoutYProperty()); 
		
		Group root = new Group();
		root.getChildren().addAll(okButton, cancelButton);
		
		root.setEffect(new DropShadow());
		root.setRotate(10);
		root.setOpacity(0.80);
		

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Positioning Nodes in a Group");
		stage.show();
		
		
	}

}
