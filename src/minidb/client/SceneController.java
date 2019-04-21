package minidb.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeView;
import javafx.scene.text.Font;

public class SceneController {
	@FXML
	private TreeView treeView;
	@FXML
	private TextArea textArea;
	@FXML
	private Button executeBtn;
	@FXML
	private Button clearBtn;
	@FXML
	private Label label;
	
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
}
