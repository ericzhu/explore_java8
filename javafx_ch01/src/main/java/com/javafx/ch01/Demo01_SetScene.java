package com.javafx.ch01;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Demo01_SetScene extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		Group root = new Group();
		Scene scene = new Scene(root, 500, 300, Color.LIGHTYELLOW);
		
		stage.setScene(scene);
		stage.setTitle("Set Scene");
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
