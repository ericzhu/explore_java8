package javafx.ch04.ex02;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class VBoxDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(4);
		dropShadow.setOffsetY(6);
		dropShadow.setColor(Color.rgb(150, 50, 50, 0.688));
		
		VBox vbox = new VBox(50);
		vbox.setAlignment(Pos.CENTER);
		
		Circle circle = new Circle(50, Color.BLUE);
		circle.relocate(50, 50);
		
		Rectangle square = new Rectangle(100, 100, Color.RED);
		square.setArcHeight(30);
		square.setArcWidth(30);
		square.relocate(200, 50);
		
		vbox.getChildren().addAll(circle, square);
		vbox.setEffect(dropShadow);
		
		Scene scene = new Scene(vbox, 350, 200, Color.LIGHTGREEN);
		
		stage.setScene(scene);
		stage.setTitle("HBox demo");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
