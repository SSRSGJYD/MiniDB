package minidb.client;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnectionDialogController {
	private Stage stage;
	private Scene scene;
	
	@FXML
	private TextField passwordTextField;
	@FXML
	private TextField usernameTextField;
	@FXML
	private TextField ipTextField;
	@FXML
	private Button connectBtn;
	@FXML
	private TextField portTextField;
	
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
	
	public void connect() {
		//TODO 
		stage.close();
	}

}
