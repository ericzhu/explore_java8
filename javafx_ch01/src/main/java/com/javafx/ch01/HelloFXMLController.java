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

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class HelloFXMLController implements Initializable {
	
	@FXML
	private Rectangle rectangle;
	
	@FXML
	private Text text;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Fade text node in and out
		FadeTransition fade = new FadeTransition(Duration.seconds(2), text);
		fade.setFromValue(1.0);
		fade.setToValue(0.0);
		fade.setCycleCount(Animation.INDEFINITE);
		fade.setAutoReverse(true);
		fade.play();
	}
}
