package minidb.client;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;


public class ConnectionInfo {
	public CloseableHttpClient httpClient;
	public HttpClientContext context;
	public RequestConfig requestConfig;
	public String baseURL;
	public String username;
	public String password;
	
	public ConnectionInfo() {}
}
