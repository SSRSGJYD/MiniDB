package minidb.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnectionDialogController {
	private Stage stage;
	private Scene scene;
	private ConnectionInfo connectionInfo;
	private SimpleStringProperty schemas;
	
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
	
	public void setConnectionInfo(ConnectionInfo connectionInfo) {
		this.connectionInfo = connectionInfo;
	}
	
	public void setSchemas(SimpleStringProperty schemas) {
		this.schemas = schemas;
	}
	
	public void connect() {
		String baseURL = "http://" + ipTextField.getText() + ":" + portTextField.getText();
		String loginURL = "http://" + ipTextField.getText() + ":" + portTextField.getText() + "/login";
		try {
			HttpClientContext context = HttpClientContext.create();
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(120000).setSocketTimeout(60000)
					       .setConnectionRequestTimeout(60000).build();
			CloseableHttpAsyncClient httpClient = HttpAsyncClients.custom()
					     .setDefaultRequestConfig(requestConfig)
					     .build();
			
			HttpPost httpPost = new HttpPost(loginURL);
			httpPost.addHeader(HTTP.CONTENT_TYPE,"application/x-www-form-urlencoded");
			String json = String.format("{'username':%s,'password':%s}", usernameTextField.getText(), passwordTextField.getText());
			StringEntity se = new StringEntity(json);
			se.setContentEncoding("UTF-8");
			se.setContentType("application/json");
			httpPost.setEntity(se);
			// async request
			httpClient.start();
			httpClient.execute(httpPost, new FutureCallback<HttpResponse>() {
				public void completed(final HttpResponse response) {
					if(response.getStatusLine().getStatusCode() == 200) {
						// login success
					    connectionInfo.httpClient = httpClient;
					    connectionInfo.requestConfig = requestConfig;
					    connectionInfo.context = context;
					    connectionInfo.baseURL = baseURL;
					    connectionInfo.username = usernameTextField.getText();
					    connectionInfo.password = passwordTextField.getText();
					    // receive schemas and update treeView
						try {
							schemas.set(EntityUtils.toString(response.getEntity(), "utf-8"));
						} catch (ParseException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					    stage.close();
					}
					else {
						// login failed
						Alert information = new Alert(Alert.AlertType.ERROR,"connection failed!");
						information.setTitle("error"); 
						information.setHeaderText("Error!");	
						information.show();
					}
                }

                public void failed(final Exception ex) {
                	// login failed
					Alert information = new Alert(Alert.AlertType.ERROR,"connection failed!");
					information.setTitle("error"); 
					information.setHeaderText("Error!");	
					information.show();
                }

                public void cancelled() {
                	// login failed
					Alert information = new Alert(Alert.AlertType.ERROR,"connection failed!");
					information.setTitle("error"); 
					information.setHeaderText("Error!");	
					information.show();
                }
			});
		} 
		catch (Exception e) {
			// login failed
			Alert information = new Alert(Alert.AlertType.ERROR,"connection failed!");
			information.setTitle("error"); 
			information.setHeaderText("Error!");	
			information.show();
		}
	}

}
