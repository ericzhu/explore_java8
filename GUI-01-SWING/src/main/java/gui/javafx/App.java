package gui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane borderPane = new BorderPane();

		TextArea textArea = new TextArea();

		Button helloBtn = new Button("Hello");
		Button goodbyeBtn = new Button("Goodbye");
		Button bottomBtn = new Button("ClickMe!");
		
		helloBtn.setOnAction(e -> textArea.appendText("Hello\n"));
		goodbyeBtn.setOnAction(e -> textArea.appendText("Goodbye\n"));
		bottomBtn.setOnAction(e -> textArea.appendText("Clicked Me! "));
		

		FlowPane flowPane = new FlowPane();
		flowPane.getChildren().addAll(helloBtn, goodbyeBtn);

		borderPane.setTop(flowPane);
		borderPane.setCenter(textArea);
		borderPane.setBottom(bottomBtn);

		Scene scene = new Scene(borderPane, 800, 500);

		primaryStage.setTitle("Hello JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
