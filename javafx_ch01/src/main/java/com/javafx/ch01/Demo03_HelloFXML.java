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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Demo03_HelloFXML extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		
		// Create the root node of the scene by loading FMXL file
		Parent root = FXMLLoader.load(getClass().getResource("HelloFXML.fxml"));
		
		// Create a scene with a background color
		Scene scene = new Scene(root, 600, 300, Color.LIGHTBLUE);
		
		
		// Set the scene on the stage with a title
		stage.setTitle("Hello FXML");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
