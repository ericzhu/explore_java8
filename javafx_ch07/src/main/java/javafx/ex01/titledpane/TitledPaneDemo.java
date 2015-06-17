package javafx.ex01.titledpane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class TitledPaneDemo extends Application {

	TitledPane titledpane = new TitledPane();

	@Override
	public void start(Stage primaryStage) throws Exception {

		titledpane = new TitledPane();
		titledpane.setText("Information");
		titledpane.setContent(createGridPane());
		titledpane.setAnimated(true);
		titledpane.setCollapsible(true);
		titledpane.setExpanded(true);
		
		

		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(10, 10, 10, 10));
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.getChildren().setAll(titledpane);

		MenuBar menubar = createMenuBar();

		VBox vbox = new VBox();
		vbox.getChildren().add(menubar);

		BorderPane borderpane = new BorderPane();
		borderpane.getStylesheets().add(this.getClass().getResource("titledpanecustomization.css").toExternalForm());
		borderpane.setTop(vbox);
		borderpane.setCenter(hbox);

		// Set the Layout Pane of Scene
		Scene scene = new Scene(borderpane);
		borderpane.prefHeightProperty().bind(scene.heightProperty());
		borderpane.prefWidthProperty().bind(scene.widthProperty());

		// Set the title of Stage
		primaryStage.setTitle("TitledPane Demo");
		// Set the width of Stage
		primaryStage.setWidth(300);
		// Set the height of Stage
		primaryStage.setHeight(300);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		

		// Show Stage
		primaryStage.show();

	}

	private GridPane createGridPane() {

		Label label1 = new Label("Name:");
		Label label2 = new Label("Birth:");
		Label label3 = new Label("Tel.:");
		Label label4 = new Label("E-Mail:");

		TextField textfield1 = new TextField();
		textfield1.setPrefColumnCount(15);
		textfield1.setTooltip(new Tooltip("Name"));

		TextField textfield2 = new TextField();
		textfield2.setPrefColumnCount(15);
		textfield2.setTooltip(new Tooltip("Birthday"));

		TextField textfield3 = new TextField();
		textfield3.setPrefColumnCount(15);
		textfield3.setTooltip(new Tooltip("Phone Number"));

		TextField textfield4 = new TextField();
		textfield4.setPrefColumnCount(15);
		textfield4.setTooltip(new Tooltip("e-mail"));

		GridPane gridpane = new GridPane();
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		gridpane.setPadding(new Insets(5, 5, 5, 5));

		gridpane.add(label1, 0, 0);
		gridpane.add(label2, 0, 1);
		gridpane.add(label3, 0, 2);
		gridpane.add(label4, 0, 3);

		gridpane.add(textfield1, 1, 0);
		gridpane.add(textfield2, 1, 1);
		gridpane.add(textfield3, 1, 2);
		gridpane.add(textfield4, 1, 3);

		return gridpane;
	}

	private MenuBar createMenuBar() {

		CheckMenuItem checkmenuitem1 = new CheckMenuItem("Animated");
		checkmenuitem1.setSelected(true);

		checkmenuitem1.setOnAction(e -> {
			CheckMenuItem chkmenuitem = (CheckMenuItem) e.getSource();
			if (chkmenuitem.isSelected()) {
				titledpane.setCollapsible(true);
			} else {
				titledpane.setCollapsible(false);
			}
		});

		CheckMenuItem checkmenuitem2 = new CheckMenuItem("Collapsible");
		checkmenuitem2.setSelected(true);
		checkmenuitem2.setOnAction(e -> {
			CheckMenuItem chkmenuitem = (CheckMenuItem) e.getSource();
			if (chkmenuitem.isSelected())
				titledpane.setCollapsible(true);
			else
				titledpane.setCollapsible(false);
		});

		CheckMenuItem checkmenuitem3 = new CheckMenuItem("Expanded");
		checkmenuitem3.setSelected(true);
		checkmenuitem3.setOnAction(e -> {
			CheckMenuItem chkmenuitem = (CheckMenuItem) e.getSource();

			if (chkmenuitem.isSelected())
				titledpane.setExpanded(true);
			else
				titledpane.setExpanded(false);
		});

		Menu menuState = new Menu("State");
		menuState.getItems().addAll(checkmenuitem1, checkmenuitem2, checkmenuitem3);

		MenuBar menubar = new MenuBar();
		menubar.getMenus().add(menuState);
		return menubar;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
