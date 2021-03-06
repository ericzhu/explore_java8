package javafx.starterapp.ui;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.starterapp.model.Person;
import javafx.starterapp.model.StarterAppModel;

public class StarterAppMain extends Application {

	StarterAppModel model = new StarterAppModel();
	Stage stage;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(final Stage primaryStage) {
		stage = primaryStage;
		
		// a VBox for holding menus and toolbar
		VBox topBox = new VBox(createMenus(), createToolBar());
		
		// The root node on the scene
		BorderPane borderPane = new BorderPane();
		
		// Set the main content to the center area of the BorderPane
		borderPane.setCenter(createTabs());
		
		// Set the topBox which contains menus and toolbar to the Top part of the BorderPane
		borderPane.setTop(topBox);
		
		// Create a scene and set the BorderPane as root node on it
		Scene scene = new Scene(borderPane, 980, 600);
		
		// Add a stylesheet on the scene
		// The style applied at scene level affects on all the nodes on the scene  
		scene.getStylesheets().add("/javafx/starterapp/ui/starterApp.css");
		
		// Set scene on the stage
		stage.setScene(scene);
		stage.setTitle("Starter App");
		stage.show();
	}

	protected MenuBar createMenus() {
		//CONCEPT: MENU, MENU ITEM
		
		// ----- "File" menu -----
		// Create a menu item "New..."
		MenuItem itemNew = new MenuItem("New...", new ImageView(new Image( getClass().getResourceAsStream("images/paper.png"))));
		// Add key shortcut for this menu item
		itemNew.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
		// Add event handler for click event
		itemNew.setOnAction(e -> System.out.println(e.getEventType() + " occurred on MenuItem New"));
		// Create menu item "Save"
		MenuItem itemSave = new MenuItem("Save");
		Menu menuFile = new Menu("File");
		menuFile.getItems().addAll(itemNew, itemSave);
		
		// ----- "Edit" menu -----
		MenuItem itemCut = new MenuItem("Cut");
		MenuItem itemCopy = new MenuItem("Copy");
		MenuItem itemPaste = new MenuItem("Paste");
		Menu menuEdit = new Menu("Edit");
		menuEdit.getItems().addAll(itemCut, itemCopy, itemPaste);
		
		// Create menu bar and add menus to it.
		MenuBar menuBar = new MenuBar();
		menuBar.getStyleClass().add("lightBlueBk");
		menuBar.getMenus().addAll(menuFile, menuEdit);
		return menuBar;
	}

	protected ToolBar createToolBar() {
		Button newButton = new Button();
		
		// ----- "New" button -----
		//Add a image on the button
		newButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("images/paper.png"))));
		//Assign the control an id for latter reference
		newButton.setId("newButton");
		//set a tooltip to the button
		newButton.setTooltip(new Tooltip("New Document... Ctrl+N"));
		newButton.setOnAction(e -> System.out.println("New toolbar button clicked"));
		
		// ----- "Edit" button -----
		Button editButton = new Button();
		editButton.setId("editButton");
		editButton.setGraphic(new Circle(8, Color.GREEN));
		editButton.setText("Edit");
		
		// ----- "Delete" button -----
		Button deleteButton = new Button();
		deleteButton.setGraphic(new Circle(8, Color.BLUE));
		deleteButton.setId("deleteButton");
		deleteButton.setText("Delete");
		
		// ----- Togglebutton for bolding the text -----
		ToggleButton boldButton = new ToggleButton();
		boldButton.setGraphic(new Circle(8, Color.MAROON));
		boldButton.setId("boldButton");
		boldButton.setText("Bold");
		boldButton.setOnAction(e -> {
			// Get the target of the event
			ToggleButton tb = ((ToggleButton) e.getTarget());
			
			// Print out the event type
			System.out.print(e.getEventType() + " occurred on ToggleButton " + tb.getId());
			System.out.print(", and selectedProperty is: ");
			
			// get the "selectedProperty" of the ToggleButton
			System.out.println(tb.selectedProperty().getValue());
		});
		
		// ----- Togglebutton for make the text italic -----
		ToggleButton italicButton = new ToggleButton();
		italicButton.setGraphic(new Circle(8, Color.YELLOW));
		italicButton.setId("italicButton");
		italicButton.setText("Italic");
		italicButton.setOnAction(e -> {
			ToggleButton tb = ((ToggleButton) e.getTarget());
			System.out.print(e.getEventType() + " occurred on ToggleButton " + tb.getId());
			System.out.print(", and selectedProperty is: ");
			System.out.println(tb.selectedProperty().getValue());
		});
		
		// ------ Create a toggle group containing align left, center and right -----
		final ToggleGroup alignToggleGroup = new ToggleGroup();
		
		ToggleButton leftAlignButton = new ToggleButton();
		leftAlignButton.setGraphic(new Circle(8, Color.PURPLE));
		leftAlignButton.setId("leftAlignButton");
		leftAlignButton.setText("Align <-");
		
		leftAlignButton.setToggleGroup(alignToggleGroup);
		ToggleButton centerAlignButton = new ToggleButton();
		centerAlignButton.setGraphic(new Circle(8, Color.ORANGE));
		centerAlignButton.setId("centerAlignButton");
		centerAlignButton.setText("Align ><");
		centerAlignButton.setToggleGroup(alignToggleGroup);
		
		ToggleButton rightAlignButton = new ToggleButton();
		rightAlignButton.setGraphic(new Circle(8, Color.CYAN));
		rightAlignButton.setId("rightAlignButton");
		rightAlignButton.setText("Align ->");
		rightAlignButton.setToggleGroup(alignToggleGroup);
		
		// Create a tool bar and set buttons to it, and seperate some of them with vertical separator
		ToolBar toolBar = new ToolBar(newButton, editButton, deleteButton,
				new Separator(Orientation.VERTICAL), boldButton, italicButton,
				new Separator(Orientation.VERTICAL), leftAlignButton,
				centerAlignButton, rightAlignButton);

		
		// Set the selected toggle
		alignToggleGroup.selectToggle(alignToggleGroup.getToggles().get(0));
		alignToggleGroup.selectedToggleProperty().addListener(
				(ov, oldValue, newValue) -> { 
					ToggleButton tb = ((ToggleButton) alignToggleGroup.getSelectedToggle());
					if (tb != null) {
						System.out.println(tb.getId() + " selected");
					}
				});

		return toolBar;
	}

	protected TabPane createTabs() {
		final WebView webView = new WebView();
		Tab tableTab = new Tab("TableView");
		tableTab.setContent(createTableDemoNode());
		tableTab.setClosable(false);
		Tab accordionTab = new Tab("Accordion/TitledPane");
		accordionTab.setContent(createAccordionTitledDemoNode());
		accordionTab.setClosable(false);
		Tab splitTab = new Tab("SplitPane/TreeView/ListView");
		splitTab.setContent(createSplitTreeListDemoNode());
		splitTab.setClosable(false);
		Tab treeTableTab = new Tab("TreeTableView");
		treeTableTab.setContent(createTreeTableDemoNode());
		treeTableTab.setClosable(false);
		Tab scrollTab = new Tab("ScrollPane/Miscellaneous");
		scrollTab.setContent(createScrollMiscDemoNode());
		scrollTab.setClosable(false);
		Tab htmlTab = new Tab("HTMLEditor");
		htmlTab.setContent(createHtmlEditorDemoNode());
		htmlTab.setClosable(false);
		Tab webViewTab = new Tab("WebView");
		webViewTab.setContent(webView);
		webViewTab.setClosable(false);
		webViewTab.setOnSelectionChanged(e -> {
			String randomWebSite = model.getRandomWebSite();
			if (webViewTab.isSelected()) {
				webView.getEngine().load(randomWebSite);
				System.out.println("WebView tab is selected, loading: "
						+ randomWebSite);
			}
		});
		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(tableTab, accordionTab, splitTab,
				treeTableTab, scrollTab, htmlTab, webViewTab);

		return tabPane;
	}

	Node createTableDemoNode() {
		TableView table = new TableView(model.getTeamMembers());
		TableColumn firstNameColumn = new TableColumn("First Name");
		firstNameColumn.setCellValueFactory(new PropertyValueFactory("firstName"));
		firstNameColumn.setPrefWidth(180);
		TableColumn lastNameColumn = new TableColumn("Last Name");
		lastNameColumn
				.setCellValueFactory(new PropertyValueFactory("lastName"));
		lastNameColumn.setPrefWidth(180);
		TableColumn phoneColumn = new TableColumn("Phone Number");
		phoneColumn.setCellValueFactory(new PropertyValueFactory("phone"));
		phoneColumn.setPrefWidth(180);
		table.getColumns().addAll(firstNameColumn, lastNameColumn, phoneColumn);
		table.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(ObservableValue observable, Object oldValue,
								Object newValue) -> {
							Person selectedPerson = (Person) newValue;
							System.out.println(selectedPerson
									+ " chosen in TableView");
						});
		return table;
	}

	Node createAccordionTitledDemoNode() {
		TitledPane paneA = new TitledPane("TitledPane A", new TextArea(
				"TitledPane A content"));
		TitledPane paneB = new TitledPane("TitledPane B", new TextArea(
				"TitledPane B content"));
		TitledPane paneC = new TitledPane("TitledPane C", new TextArea(
				"TitledPane C content"));
		Accordion accordion = new Accordion();
		accordion.getPanes().addAll(paneA, paneB, paneC);
		accordion.setExpandedPane(paneA);
		return accordion;
	}

	Node createSplitTreeListDemoNode() {
		TreeItem animalTree = new TreeItem("Animal");
		animalTree.getChildren().addAll(new TreeItem("Lion"), new TreeItem("Tiger"), new TreeItem("Bear"));
		TreeItem mineralTree = new TreeItem("Mineral");
		mineralTree.getChildren().addAll(new TreeItem("Copper"), new TreeItem("Diamond"), new TreeItem("Quartz"));
		TreeItem vegetableTree = new TreeItem("Vegetable");
		vegetableTree.getChildren().addAll(new TreeItem("Arugula"), new TreeItem("Broccoli"), new TreeItem("Cabbage"));

		TreeItem root = new TreeItem("Root");
		root.getChildren().addAll(animalTree, mineralTree, vegetableTree);
		TreeView treeView = new TreeView(root);
		treeView.setMinWidth(150);
		treeView.setShowRoot(false);
		treeView.setEditable(false);

		ListView listView = new ListView(model.listViewItems);

		SplitPane splitPane = new SplitPane();
		splitPane.getItems().addAll(treeView, listView);

		treeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		treeView.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(ObservableValue observable, Object oldValue, Object newValue) -> {
							TreeItem treeItem = (TreeItem) newValue;
							if (newValue != null && treeItem.isLeaf()) {
								model.listViewItems.clear();
								for (int i = 1; i <= 10000; i++) {
									model.listViewItems.add(treeItem.getValue() + " " + i);
								}
							}
						});

		return splitPane;
	}

	Node createTreeTableDemoNode() {
		TreeTableView<Person> treeTableView = new TreeTableView(model.getFamilyTree());
		TreeTableColumn<Person, String> firstNameColumn = new TreeTableColumn("First Name");
		firstNameColumn.setCellValueFactory(new TreeItemPropertyValueFactory("firstName"));
		firstNameColumn.setPrefWidth(180);
		TreeTableColumn lastNameColumn = new TreeTableColumn("Last Name");
		lastNameColumn.setCellValueFactory(new TreeItemPropertyValueFactory("lastName"));
		lastNameColumn.setPrefWidth(180);
		TreeTableColumn phoneColumn = new TreeTableColumn("Phone Number");
		phoneColumn.setCellValueFactory(new TreeItemPropertyValueFactory("phone"));
		phoneColumn.setPrefWidth(180);
		treeTableView.getColumns().addAll(firstNameColumn, lastNameColumn,phoneColumn);
		treeTableView.getSelectionModel().selectedItemProperty() .addListener(
						(ObservableValue<? extends TreeItem<Person>> observable, TreeItem<Person> oldValue, TreeItem<Person> newValue) -> {
							Person selectedPerson = newValue.getValue();
							System.out.println(selectedPerson + " chosen in TreeTableView");
						});
		treeTableView.setShowRoot(false);
		return treeTableView;
	}

	Node createScrollMiscDemoNode() {
		Button button = new Button("Button");
		button.setOnAction(e -> System.out.println(e.getEventType()
				+ " occurred on Button"));
		final CheckBox checkBox = new CheckBox("CheckBox");
		checkBox.setOnAction(e -> {
			System.out.print(e.getEventType() + " occurred on CheckBox");
			System.out.print(", and selectedProperty is: ");
			System.out.println(checkBox.selectedProperty().getValue());
		});

		final ToggleGroup radioToggleGroup = new ToggleGroup();
		RadioButton radioButton1 = new RadioButton("RadioButton1");
		radioButton1.setToggleGroup(radioToggleGroup);
		RadioButton radioButton2 = new RadioButton("RadioButton2");
		radioButton2.setToggleGroup(radioToggleGroup);
		HBox radioBox = new HBox(10, radioButton1, radioButton2);

		Hyperlink link = new Hyperlink("Hyperlink");
		link.setOnAction(e -> System.out.println(e.getEventType()
				+ " occurred on Hyperlink"));

		ChoiceBox choiceBox;
		choiceBox = new ChoiceBox(model.choiceBoxItems);
		choiceBox.getSelectionModel().selectFirst();
		choiceBox.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					System.out.println(newValue + " chosen in ChoiceBox");
				});

		MenuItem menuA = new MenuItem("MenuItem A");
		menuA.setOnAction(e -> System.out.println(e.getEventType()
				+ " occurred on Menu Item A"));
		MenuItem menuB = new MenuItem("MenuItem B");
		MenuButton menuButton = new MenuButton("MenuButton");
		menuButton.getItems().addAll(menuA, menuB);

		MenuItem splitMenuA = new MenuItem("MenuItem A");
		splitMenuA.setOnAction(e -> System.out.println(e.getEventType()
				+ " occurred on Menu Item A"));
		MenuItem splitMenuB = new MenuItem("MenuItem B");
		SplitMenuButton splitMenuButton = new SplitMenuButton(splitMenuA,
				splitMenuB);
		splitMenuButton.setText("SplitMenuButton");
		splitMenuButton.setOnAction(e -> System.out.println(e.getEventType()
				+ " occurred on SplitMenuButton"));

		final TextField textField = new TextField();
		textField.setPromptText("Enter user name");
		textField.setPrefColumnCount(16);
		textField.textProperty().addListener((ov, oldValue, newValue) -> {
			System.out.println("TextField text is: " + textField.getText());
		});

		final PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Enter password");
		passwordField.setPrefColumnCount(16);
		passwordField.focusedProperty().addListener(
				(ov, oldValue, newValue) -> {
					if (!passwordField.isFocused()) {
						System.out.println("PasswordField text is: "
								+ passwordField.getText());
					}
				});

		final TextArea textArea = new TextArea();
		textArea.setPrefColumnCount(12);
		textArea.setPrefRowCount(4);
		textArea.focusedProperty().addListener((ov, oldValue, newValue) -> {
			if (!textArea.isFocused()) {
				System.out.println("TextArea text is: " + textArea.getText());
			}
		});

		LocalDate today = LocalDate.now();
		DatePicker datePicker = new DatePicker(today);
		datePicker.setOnAction(e -> System.out.println("Selected date: "
				+ datePicker.getValue()));

		ColorPicker colorPicker = new ColorPicker(Color.BLUEVIOLET);
		colorPicker.setOnAction(e -> System.out.println("Selected color: "
				+ colorPicker.getValue()));

		final ProgressIndicator progressIndicator = new ProgressIndicator();
		progressIndicator.setPrefWidth(200);
		progressIndicator.progressProperty().bind(
				model.rpm.divide(model.maxRpm));

		final Slider slider = new Slider(-1, model.maxRpm, 0);
		slider.setPrefWidth(200);
		slider.valueProperty().bindBidirectional(model.rpm);

		final ProgressBar progressBar = new ProgressBar();
		progressBar.setPrefWidth(200);
		progressBar.progressProperty().bind(model.kph.divide(model.maxKph));

		final ScrollBar scrollBar = new ScrollBar();
		scrollBar.setPrefWidth(200);
		scrollBar.setMin(-1);
		scrollBar.setMax(model.maxKph);
		scrollBar.valueProperty().bindBidirectional(model.kph);

		VBox variousControls = new VBox(20, button, checkBox, radioBox, link,
				choiceBox, menuButton, splitMenuButton, textField,
				passwordField, new HBox(10, new Label("TextArea:"), textArea),
				datePicker, colorPicker, progressIndicator, slider,
				progressBar, scrollBar);

		variousControls.setPadding(new Insets(10, 10, 10, 10));
		radioToggleGroup.selectToggle(radioToggleGroup.getToggles().get(0));
		radioToggleGroup.selectedToggleProperty().addListener(
				(ov, oldValue, newValue) -> {
					RadioButton rb = ((RadioButton) radioToggleGroup.getSelectedToggle());
					if (rb != null) {
						System.out.println(rb.getText() + " selected");
					}
				});

		MenuItem contextA = new MenuItem("MenuItem A");
		contextA.setOnAction(e -> System.out.println(e.getEventType() + " occurred on Menu Item A"));
		MenuItem contextB = new MenuItem("MenuItem B");
		final ContextMenu contextMenu = new ContextMenu(contextA, contextB);

		ScrollPane scrollPane = new ScrollPane(variousControls);
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollPane.setOnMousePressed((MouseEvent me) -> {
			if (me.getButton() == MouseButton.SECONDARY) {
				contextMenu.show(stage, me.getScreenX(), me.getScreenY());
			}
		});

		return scrollPane;
	}

	Node createHtmlEditorDemoNode() {
		final BorderPane htmlEditorDemo;
		final HTMLEditor htmlEditor = new HTMLEditor();
		htmlEditor.setHtmlText("<p>Replace this text</p>");
		Button viewHtmlButton = new Button("View HTML");
		viewHtmlButton.setOnAction(e -> {
			Popup alertPopup = createAlertPopup(htmlEditor.getHtmlText());
			alertPopup.show(
					stage, (stage.getWidth() - alertPopup.getWidth()) / 2
							+ stage.getX(), (stage.getHeight() - alertPopup.getHeight()) / 2
							+ stage.getY());
		});
		htmlEditorDemo = new BorderPane();
		htmlEditorDemo.setCenter(htmlEditor);
		htmlEditorDemo.setBottom(viewHtmlButton);

		BorderPane.setAlignment(viewHtmlButton, Pos.CENTER);
		BorderPane.setMargin(viewHtmlButton, new Insets(10, 0, 10, 0));
		return htmlEditorDemo;
	}

	Popup createAlertPopup(String text) {
		Popup alertPopup = new Popup();

		final Label htmlLabel = new Label(text);
		htmlLabel.setWrapText(true);
		htmlLabel.setMaxWidth(280);
		htmlLabel.setMaxHeight(140);

		Button okButton = new Button("OK");
		okButton.setOnAction(e -> alertPopup.hide());

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(htmlLabel);
		borderPane.setBottom(okButton);

		Rectangle rectangle = new Rectangle(300, 200, Color.LIGHTBLUE);
		rectangle.setArcHeight(20);
		rectangle.setArcWidth(20);
		rectangle.setStroke(Color.GRAY);
		rectangle.setStrokeWidth(2);
		StackPane contentPane = new StackPane(rectangle, borderPane);

		alertPopup.getContent().add(contentPane);

		BorderPane.setAlignment(okButton, Pos.CENTER);
		BorderPane.setMargin(okButton, new Insets(10, 0, 10, 0));
		return alertPopup;
	}

}
