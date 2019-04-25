package minidb.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SceneController {
	private Stage stage;
	private Scene scene;
	
	@FXML
	private MenuItem connectMenuItem;
	@FXML
	private MenuItem openMenuItem;
	@FXML
	private MenuItem saveMenuItem;
	@FXML
	private MenuItem closeMenuItem;
	@FXML
	private MenuItem aboutMenuItem;
	
	@FXML
	private TreeView treeView;
	@FXML
	private TextArea textArea;
	@FXML
	private Button executeBtn;
	@FXML
	private Button clearBtn;
	@FXML
	private Label bottomLabel;
	
	public Stage getStage() {
		return this.stage;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public Scene getScene() {
		return this.scene;
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public void initialize() {
		textArea.setText("Please enter sql commands here!");
		textArea.setFont(new Font(18));
	}
	
	public void execute() {
		final String sql = textArea.getText();
		// TODO
		System.out.println(sql);
	}
	
	public void clear() {
		textArea.clear();
	}
	
	public void connect() {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ConnectionDialog.fxml"));
        AnchorPane dialog = null;
		try {
			dialog = (AnchorPane) (loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
        Scene connectionScene = new Scene(dialog);
        Stage connectionStage = new Stage();
        connectionStage.setScene(connectionScene);
        ConnectionDialogController controller = loader.getController();
        controller.setScene(connectionScene);
        controller.setStage(connectionStage);
        connectionStage.show();
	}
	
	public void openScript() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Script");
		File f = fileChooser.showOpenDialog(stage);
		if(f.canRead()) {
			try {
				FileInputStream reader = new FileInputStream(f);
				Long fileLength = f.length();
				byte[] bytes = new byte[fileLength.intValue()];
				reader.read(bytes);
				reader.close();
				textArea.setText(new String(bytes));
			} catch (IOException e) {
				Alert information = new Alert(Alert.AlertType.ERROR,"cannot read the file!");
				information.setTitle("error"); 
				information.setHeaderText("Error!");	
				information.show();
				e.printStackTrace();
			}
		}
		else {
			Alert information = new Alert(Alert.AlertType.ERROR,"cannot read the file!");
			information.setTitle("error"); 
			information.setHeaderText("Error!");	
			information.show();
		}
	}
	
	public void saveScript() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Script");
		File f = fileChooser.showOpenDialog(stage);
		if(f.canWrite()) {
			try {
				FileOutputStream writer = new FileOutputStream(f);
				byte[] bytes = textArea.getText().getBytes();
				writer.write(bytes);
				writer.close();
			} catch (IOException e) {
				Alert information = new Alert(Alert.AlertType.ERROR,"cannot write to the file!");
				information.setTitle("error"); 
				information.setHeaderText("Error!");	
				information.show();
				e.printStackTrace();
			}
		}
		else {
			Alert information = new Alert(Alert.AlertType.ERROR,"cannot write to the file!");
			information.setTitle("error"); 
			information.setHeaderText("Error!");	
			information.show();
		}
	}
	
	public void about() {
		
	}
	
	
}
