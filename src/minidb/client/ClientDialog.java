package minidb.client;
	
import java.io.IOException;

import com.sun.webkit.ContextMenu.ShowContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ClientDialog extends Application {
	
	private Stage primaryStage;
    private VBox rootLayout;
	
	@Override
	public void start(Stage primaryStage) {	
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("MiniDB Client Dialog");
		this.primaryStage.setWidth(950);
		this.primaryStage.setHeight(650);
		this.primaryStage.setResizable(false);
		initRootLayout();
		showContent();
	}
	
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClientDialog.class.getResource("MainScene.fxml"));
            rootLayout = (VBox) loader.load();
            rootLayout.setAlignment(Pos.CENTER);
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout, 900, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showContent() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClientDialog.class.getResource("Scene.fxml"));
            AnchorPane content = (AnchorPane) loader.load();
            content.setMinHeight(590);
            content.setMinWidth(940);
            // Set person overview into the center of root layout.
            rootLayout.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}