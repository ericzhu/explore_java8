package learn.javafx.ch01.intro;

import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FXParamApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parameters p = this.getParameters();
		Map<String, String> namedParams = p.getNamed();
		List<String> unnamedParams = p.getUnnamed();
		List<String> rawParams = p.getRaw();
		
		String paramStr = "named parameters: " + namedParams + "\n" + 
				"unnamedParams: " + unnamedParams + "\n" +
				"raw params: " + rawParams;
		
		TextArea textArea = new TextArea(paramStr);
		Group root = new Group(textArea);
		
		stage.setScene(new Scene(root));
		stage.setTitle("Application Params");
		stage.show();
		
		
	}

}
