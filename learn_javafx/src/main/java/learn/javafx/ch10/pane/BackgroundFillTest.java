package learn.javafx.ch10.pane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BackgroundFillTest extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Pane p1 = this.getCSSStyledPane();
		Pane p2 = this.getObjectStylePane();

		p1.setLayoutX(10);
		p1.setLayoutY(10);

		p2.layoutYProperty().bind(p1.layoutYProperty());
		p2.layoutXProperty().bind(p1.layoutXProperty().add(p1.widthProperty()).add(20));

		Pane root = new Pane(p1, p2);
		root.setPrefSize(240, 70);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Setting Background Fills for a Region");
		primaryStage.show();
		primaryStage.sizeToScene();

	}

	public Pane getCSSStyledPane() {
		Pane p = new Pane();
		p.setPrefSize(100, 50);
		p.setStyle("-fx-background-color: lightgray, red;" + "-fx-background-insets: 0, 4;"
				+ "-fx-background-radius: 4, 2;");
		return p;
	}

	public Pane getObjectStylePane() {
		Pane p = new Pane();
		p.setPrefSize(100, 50);

		BackgroundFill lightGrayFill = new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(4), new Insets(0));
		BackgroundFill redFill = new BackgroundFill(Color.RED, new CornerRadii(2), new Insets(4));

		Background bg = new Background(lightGrayFill, redFill);
		p.setBackground(bg);

		return p;
	}

}
