package com.javafx.ch02;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Demo01_TextShape extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();
		Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 40);
		
		Text text = new Text(50, 50, "This is the text string for demo");
		text.setFill(Color.color(1.0, 0, 0, 0.5));
		text.setStroke(Color.DARKBLUE);
		text.setStrokeType(StrokeType.OUTSIDE);
		text.setUnderline(true);
		
		
		text.setFont(font);
		
		root.getChildren().add(text);
		Scene scene = new Scene(root, 800, 200);
		scene.setFill(Color.LIGHTSKYBLUE);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
