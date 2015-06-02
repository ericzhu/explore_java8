package javafx.ch06.ex01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FirstEventHandler extends Application {
	
	private void handleClick(Event event) {
		System.out.println("Method Reference");
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetX(5);
		dropShadow.setColor(Color.GREY);
		
		Button button1 = new Button("Anonymous Class");
		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Anonymous Inner Class");
			}
		});
		
		
		Button button2 = new Button("Lambda");
		button2.setOnAction(event -> System.out.println("Lambda"));
		
		Button button3 = new Button("Method Reference");
		button3.setOnAction(this::handleClick);
		
		HBox buttonBox = new HBox(10, button1, button2, button3);
		buttonBox.setAlignment(Pos.CENTER); 
		buttonBox.setEffect(dropShadow);
		
		
		
		StackPane stackPane = new StackPane();
		stackPane.getChildren().add(buttonBox);
		stackPane.setStyle("-fx-background-color:palegreen");
		
		Scene scene = new Scene(stackPane, 500, 300);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Event Handler");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
