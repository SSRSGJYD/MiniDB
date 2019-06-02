package application;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;

public class ConnectionInfo {
	public CloseableHttpAsyncClient httpClient;
	public HttpClientContext context;
	public RequestConfig requestConfig;
	public String baseURL;
	public String username;
	public String password;
	
	public ConnectionInfo() {}
}
