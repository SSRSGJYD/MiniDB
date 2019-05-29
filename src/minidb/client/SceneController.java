package minidb.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class SceneController {
	private Stage stage;
	private Scene scene;
	private ConnectionInfo connectionInfo;
	
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
	private TreeView<String> treeView;
	private SimpleStringProperty schemas;
	
	@FXML
	private TextArea textArea;
	@FXML
	private Button executeBtn;
	@FXML
	private Button clearBtn;
	@FXML
	private Label bottomLabel;
	@FXML
	private ScrollPane resultScroll;
	@FXML
	private RadioButton printResultRadio;
	@FXML
	private RadioButton saveResultRadio;
	@FXML
	private Button resultPathBtn;
	@FXML
	private TextField resultPath;
	
	private ToggleGroup group;
	private String resultFilePath;
	private boolean inExecution;
	private boolean printResult;
	
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
		this.connectionInfo = new ConnectionInfo();
		this.schemas = new SimpleStringProperty();
		schemas.addListener(new ChangeListener<String>() {
		      @Override
		      public void changed(ObservableValue<? extends String> ov, String oldVal,
		          String newVal) {
		        // update treeView
		    	TreeItem<String> root = new TreeItem<String>("Databases");
		    	treeView.setRoot(root);
		    	// JSON object:[{"database_name":"", "schemas":[{"schema_name":"", "attributes":[{"name":"", "type":""},...]},...]},...]
		    	JSONArray array = JSONObject.parseArray(newVal);
		    	for(Object object : array) {
		    		JSONObject database = (JSONObject)object;
		    		TreeItem<String> databaseItem = new TreeItem<String>("Database:" + database.get("database_name").toString());
		    		root.getChildren().add(databaseItem);
		    		JSONArray schemas = JSONObject.parseArray(database.get("schemas").toString());
		    		for(Object object2 : schemas) {
			    		JSONObject jsonObject = (JSONObject)object2;
			    		TreeItem<String> schemaItem = new TreeItem<String>("Schema:" + jsonObject.get("schema_name").toString());
			    		databaseItem.getChildren().add(schemaItem);
			    		JSONArray attributeArray = (JSONArray)jsonObject.get("attributes");
			    		for(Object attributeObject : attributeArray) {
			    			String attributeStr = ((JSONObject)attributeObject).get("name").toString() + ":"
			    									+ ((JSONObject)attributeObject).get("type").toString();
			    			TreeItem<String> attributeItem = new TreeItem<String>(attributeStr);
			    			schemaItem.getChildren().add(attributeItem);
			    		}
			    	}
		    	}
		      }
		    });
		
		// toggle group (radio buttons)
		printResult = true;
		group = new ToggleGroup();
		printResultRadio.setToggleGroup(group);
		printResultRadio.setUserData(0);
		saveResultRadio.setToggleGroup(group);
		saveResultRadio.setUserData(1);
		printResultRadio.setSelected(true);
		resultPathBtn.setDisable(true);
		group.selectedToggleProperty().addListener(
                new ChangeListener<Toggle>() {
                    public void changed(
                            ObservableValue<? extends Toggle> ov,
                            Toggle old_toggle, Toggle new_toggle) {
                        if(inExecution) {
                        	// do not allow changes during execution
                        	group.selectToggle(old_toggle);
                        }
                        if(new_toggle != null) {
                        	if((int)new_toggle.getUserData() == 0) {
                            	// print to console
                            	printResult = true;
                            	resultPathBtn.setDisable(true);
                            }
                        	else {
                        		// save result to file
                        		printResult = false;
                        		resultPathBtn.setDisable(false);
                        	}
                        }
                    }
                });
		//
		
		//just for test
		//this.schemas.set("[{\"database_name\":\"database1\",\"schemas\":[{\"schema_name\":\"schema1\", \"attributes\":[{\"name\":\"id\", \"type\":\"int\"},{\"name\":\"name\", \"type\":\"String\"}]}]}]");
		//just for test
		//String str = "{\"attributes\":[\"id\",\"name\"], \"rows\":[{\"id\":\"id1\",\"name\":\"name1\"},{\"id\":\"id2\",\"name\":\"name2\"}]}";
		//"{"attributes":["id","name"], "rows":[{"id":"id1","name":"name1"},{"id":"id2","name":"name2"}]}"
//		TableView<Map> tableView = new TableView<>();
//		JSONObject object = JSONObject.parseObject(str);
//		JSONArray attributeArr = (JSONArray) object.get("attributes");
//		for(Object attribute:attributeArr) {
//			TableColumn<Map, String> column = new TableColumn<Map, String>((String)attribute);
//			column.setCellValueFactory(new MapValueFactory<String>((String)attribute));
//			tableView.getColumns().add(column);
//		}
//		JSONArray rowArr = (JSONArray) object.get("rows");
//		ObservableList<Map> data = FXCollections.observableArrayList();
//		for(Object row:rowArr) {
//			Map<String, String> map = new HashMap<>();
//			int i = 0;
//			for(Object attribute:attributeArr) {
//				map.put((String)attribute,((JSONObject)row).get((String)attribute).toString());
//			}
//			data.add(map);
//		}
//		tableView.setItems(data);
//		resultScroll.setContent(tableView);
	}
	
	public void choosePath() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose file path to save result");
		File f = fileChooser.showOpenDialog(stage);
		if(f != null) {
			if(f.canWrite()) {
				resultFilePath = f.getPath();
				resultPath.setText(resultFilePath);
			}
			else {
				Alert information = new Alert(Alert.AlertType.ERROR,"cannot write to the file!");
				information.setTitle("error");
				information.setHeaderText("Error!");	
				information.show();
			}
		}
	}
	
	public void execute() {
		final String sql = textArea.getText();
		doExecute(sql, "single");
	}
	
	public void importExecute() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Import Script and Execute");
		File f = fileChooser.showOpenDialog(stage);
		if(f != null) {
			if(f.canRead()) {
				try {
					FileInputStream reader = new FileInputStream(f);
					Long fileLength = f.length();
					byte[] bytes = new byte[fileLength.intValue()];
					reader.read(bytes);
					reader.close();
					textArea.setText("import " + f.getAbsolutePath());
					doExecute(new String(bytes), "multi");
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
		
	}
	
	public void doExecute(String sql, String mode) {
		if(inExecution) {
			return;
		}
		try {
			String executeURL = connectionInfo.baseURL + "/execute";
			HttpPost httpPost = new HttpPost(executeURL);
			httpPost.addHeader(HTTP.CONTENT_TYPE,"application/json");
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("username", connectionInfo.username));
			pairs.add(new BasicNameValuePair("password", connectionInfo.password));
			pairs.add(new BasicNameValuePair("sql", sql));
			pairs.add(new BasicNameValuePair("mode", mode));
			httpPost.setEntity(new UrlEncodedFormEntity(pairs, "UTF-8"));
			
			// async request
			inExecution = true;
			connectionInfo.httpClient.start();
			connectionInfo.httpClient.execute(httpPost, new FutureCallback<HttpResponse>() {
				public void completed(final HttpResponse response) {
					if(response.getStatusLine().getStatusCode() == 200) {
						Platform.runLater(new Runnable() {
						    @Override
						    public void run() {
						        //鏇存柊JavaFX鐨勪富绾跨▼鐨勪唬鐮佹斁鍦ㄦ澶�
						    	// execute success
								HttpEntity entity = response.getEntity();
								if(entity != null) { 
									String responseStr = null;
									try {
										responseStr = EntityUtils.toString(entity);
									} catch (ParseException | IOException e) {
										e.printStackTrace();
									}
									JSONObject object = JSONObject.parseObject(responseStr);
									boolean hasData = object.getBooleanValue("data");
									if(hasData) {
										if(printResult) {
											// show result table
											TableView<Map> tableView = new TableView<>();
											
											JSONArray attributeArr = (JSONArray) object.get("attributes");
											for(Object attribute:attributeArr) {
												TableColumn<Map, String> column = new TableColumn<Map, String>((String)attribute);
												column.setCellValueFactory(new MapValueFactory<String>((String)attribute));
												tableView.getColumns().add(column);
											}
											JSONArray rowArr = (JSONArray) object.get("rows");
											ObservableList<Map> data = FXCollections.observableArrayList();
											for(Object row:rowArr) {
												Map<String, String> map = new HashMap<>();
												int i = 0;
												for(Object attribute:attributeArr) {
													map.put((String)attribute,((JSONObject)row).get((String)attribute).toString());
												}
												data.add(map);
											}
											tableView.setItems(data);
											resultScroll.setContent(tableView);
											// show execution time
											float time = object.getFloatValue("time");
											bottomLabel.setText(String.format("execution time: %f ms", time/1000000));
										}
										else {
											// save to file
											try {
												File f = new File(resultFilePath);
												FileWriter writer = new FileWriter(f);

												JSONArray attributeArr = (JSONArray) object.get("attributes");
												// attribute header
												for(Object attribute:attributeArr) {
													writer.write((String)attribute + "\t");
												}
												writer.write("\n");
												// records
												JSONArray rowArr = (JSONArray) object.get("rows");
												ObservableList<Map> data = FXCollections.observableArrayList();
												for(Object row:rowArr) {
													for(Object attribute:attributeArr) {
														writer.write(((JSONObject)row).get((String)attribute).toString() + "\t");											
													}
													writer.write("\n");
												}
												float time = object.getFloatValue("time");
												writer.write(String.format("execution time: %f ms", time/1000000));
												writer.close();
												// show execution time
												bottomLabel.setText(String.format("execution time: %f ms", time/1000000));
											} catch (Exception e) {
												// TODO: handle exception
											}
										}
									}
									else { // no data
										// show msg in result area
										String msg = object.getString("msg");
										TextArea area = new TextArea();
										area.setText(msg);
										resultScroll.setContent(area);
										// show execution time
										float time = object.getFloatValue("time");
										bottomLabel.setText(String.format("execution time: %f ms", time/1000000));
									}
								}
						    }
						});
					}
					else {
						// execute failed
						Platform.runLater(new Runnable() {
						    @Override
						    public void run() {
						        //鏇存柊JavaFX鐨勪富绾跨▼鐨勪唬鐮佹斁鍦ㄦ澶�
						    	HttpEntity entity = response.getEntity();
								if(entity != null) { 
									String responseStr = null;
									try {
										responseStr = EntityUtils.toString(entity);
									} catch (ParseException | IOException e) {
										e.printStackTrace();
									}
									JSONObject object = JSONObject.parseObject(responseStr);
									String errorMsg = object.getString("msg");
									// show error msg in result area
									TextArea area = new TextArea();
									area.setText(errorMsg);
									resultScroll.setContent(area);
									// show error msg in alert dialog
									Alert information = new Alert(Alert.AlertType.ERROR, errorMsg);
									information.setTitle("error"); 
									information.setHeaderText("Error!");	
									information.show();
								}
						    }
						});
					}
					inExecution = false;
                }

                public void failed(final Exception ex) {
                	// connection failed
                	Platform.runLater(new Runnable() {
                	    @Override
                	    public void run() {
                	        //鏇存柊JavaFX鐨勪富绾跨▼鐨勪唬鐮佹斁鍦ㄦ澶�
                	    	inExecution = false;
        					Alert information = new Alert(Alert.AlertType.ERROR,"connection failed!");
        					information.setTitle("error"); 
        					information.setHeaderText("Error!");	
        					information.show();
                	    }
                	});
                }

                public void cancelled() {
                	// connection failed
                	Platform.runLater(new Runnable() {
                	    @Override
                	    public void run() {
                	        //鏇存柊JavaFX鐨勪富绾跨▼鐨勪唬鐮佹斁鍦ㄦ澶�
                	    	inExecution = false;
        					Alert information = new Alert(Alert.AlertType.ERROR,"connection failed!");
        					information.setTitle("error"); 
        					information.setHeaderText("Error!");	
        					information.show();
                	    }
                	});
                }
			});
		} catch (Exception e) {
			// connection failed
			inExecution = false;
			Alert information = new Alert(Alert.AlertType.ERROR,"connection failed!");
			information.setTitle("error"); 
			information.setHeaderText("Error!");	
			information.show();
		}
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
        connectionStage.setHeight(250);
        connectionStage.setWidth(350);
        connectionStage.setResizable(false);
        connectionStage.initModality(Modality.APPLICATION_MODAL);
        ConnectionDialogController controller = loader.getController();
        controller.setScene(connectionScene);
        controller.setStage(connectionStage);
        controller.setConnectionInfo(connectionInfo);
        controller.setSchemas(schemas);
        controller.initialize();
        connectionStage.show();
	}
	
	public void openScript() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Script");
		File f = fileChooser.showOpenDialog(stage);
		if(f != null) {
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
		
	}
	
	public void saveScript() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Script");
		File f = fileChooser.showOpenDialog(stage);
		if(f != null) {
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
		
	}
	
	public void about() {
		Alert information = new Alert(Alert.AlertType.INFORMATION);
		information.setTitle("About"); 
		information.setHeaderText("About Minidb");	
		information.show();
	}
	
	public void refresh() {
		if(connectionInfo == null) {
			// no connection yet
			connect();
			return;
		}
		String baseURL = connectionInfo.baseURL;
		String loginURL = baseURL + "/login";
		try {
			HttpClientContext context = HttpClientContext.create();
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(120000).setSocketTimeout(60000)
					       .setConnectionRequestTimeout(60000).build();
			CloseableHttpAsyncClient httpClient = HttpAsyncClients.custom()
					     .setDefaultRequestConfig(requestConfig)
					     .build();
			
			HttpPost httpPost = new HttpPost(loginURL);
			httpPost.addHeader(HTTP.CONTENT_TYPE,"application/json");
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("username", connectionInfo.username));
			pairs.add(new BasicNameValuePair("password", connectionInfo.password));
			httpPost.setEntity(new UrlEncodedFormEntity(pairs, "UTF-8"));
      
			// async request
			httpClient.start();
			httpClient.execute(httpPost, new FutureCallback<HttpResponse>() {
				public void completed(final HttpResponse response) {
					if(response.getStatusLine().getStatusCode() == 200) {
						Platform.runLater(new Runnable() {
						    @Override
						    public void run() {
						        //更新JavaFX的主线程的代码放在此处
								// login success
							    connectionInfo.httpClient = httpClient;
							    // receive schemas and update treeView
								try {
									schemas.set(EntityUtils.toString(response.getEntity(), "utf-8"));
								} catch (ParseException | IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						    }
						});

					}
					else {
						Platform.runLater(new Runnable() {
						    @Override
						    public void run() {
						        //更新JavaFX的主线程的代码放在此处
						    	// login failed
						    	connectionInfo = null;
								Alert information = new Alert(Alert.AlertType.ERROR,"connection failed!");
								information.setTitle("error"); 
								information.setHeaderText("Error!");	
								information.show();
						    }
						});
						
					}
                }

                public void failed(final Exception ex) {
                	Platform.runLater(new Runnable() {
                	    @Override
                	    public void run() {
                	        //更新JavaFX的主线程的代码放在此处
                	    	// login failed
                	    	connectionInfo = null;
        					Alert information = new Alert(Alert.AlertType.ERROR,"connection failed!");
        					information.setTitle("error"); 
        					information.setHeaderText("Error!");	
        					information.show();
                	    }
                	});
                	
                }

                public void cancelled() {
                	Platform.runLater(new Runnable() {
                	    @Override
                	    public void run() {
                	        //更新JavaFX的主线程的代码放在此处
                	    	// login failed
                	    	connectionInfo = null;
        					Alert information = new Alert(Alert.AlertType.ERROR,"connection failed!");
        					information.setTitle("error"); 
        					information.setHeaderText("Error!");	
        					information.show();
                	    }
                	});
                	
                }
			});
		} 
		catch (Exception e) {
			// login failed
			connectionInfo = null;
			Alert information = new Alert(Alert.AlertType.ERROR,"connection failed!");
			information.setTitle("error"); 
			information.setHeaderText("Error!");	
			information.show();
		}
	}
	
	
}
