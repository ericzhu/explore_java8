/* ---------------------------------------------------------------------------
 *
 * COPYRIGHT (c) 2015 KRONOS Inc. All Rights Reserved.
 *
 * The copyright to the computer program(s) herein is the property of
* AD OPT Technologies Inc. The program(s) may be used and/or copied
 * only with the written permission from AD OPT Technologies Inc.
 * or in accordance with the terms and conditions stipulated in the
 * agreement/contract under which the program(s) have been supplied.
 *
 * Author: xiaoyu.zhu
 * Date  : 2015-05-29
 * 
 * ---------------------------------------------------------------------------
 */

package com.javafx.ch01;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Demo02_StackPane extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		// Create root node on the scene
		StackPane root = new StackPane();
		
		// Create drop shadow effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setColor(Color.GRAY);
		dropShadow.setOffsetY(3.0);
		
		// Create a rectangle element
		Rectangle rectangle = new Rectangle(400, 200, Color.AQUA);
		rectangle.setArcHeight(30);
		rectangle.setArcWidth(80);
		rectangle.setEffect(dropShadow);
		
		// Create a text that will display on top of the rectangle shape
		Text text = new Text("Hello StackPane");
		text.setFill(Color.DARKSLATEGRAY); 
		text.setFont(Font.font(null, FontWeight.BOLD, 32));
		text.setEffect(dropShadow);
		
		// Fade the text in and out
		FadeTransition fade = new FadeTransition(Duration.seconds(1.5), text);
		fade.setFromValue(1.0);
		fade.setToValue(0.0);
		fade.setCycleCount(Animation.INDEFINITE);
		fade.setAutoReverse(true);
		fade.play();
		
		// Set the Rectangle and Text on the root element of the StackPane
		root.getChildren().setAll(rectangle, text);
		
		// Create scene and set the scene on the stage
		Scene scene = new Scene(root, 600, 300, Color.LIGHTBLUE);
		stage.setTitle("Hello StackPane");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
