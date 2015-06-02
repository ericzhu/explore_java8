package javafx.ch06.ex03;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ButtonDemo extends Application {
	
	private VBox vBox = new VBox(40);

	@Override
	public void start(Stage primaryStage) throws Exception {
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(4);
		dropShadow.setOffsetY(6);
		dropShadow.setColor(Color.rgb(150,  50, 50, .066));
		
		Label label = new Label("Change Background Color");
		label.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
		
//		Button yellowButton = new Button("Yellow");
//		Button cyanButton = new Button("Cyan");
	}
	
//	private Button makeButton(String colorName) {
//		Button button = new Button(colorName);
//	}
	
}
