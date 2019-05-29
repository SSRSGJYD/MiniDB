import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;  
import com.sun.net.httpserver.HttpHandler;  
import com.sun.net.httpserver.HttpServer;  


import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import minidb.basic.database.MiniDB;
import minidb.result.Result;
import minidb.server.ParameterFilter;

import org.apache.commons.io.IOUtils;


public class Server {
	
	static MiniDB db;
	
	static class responseMsg {
		String msg = null;
		
		public responseMsg() {
			// TODO 自动生成的构造函数存根
			this.msg = null;
		}
	}
	
	public static boolean sqlExecute(String sql, responseMsg responseMsg,String mode) throws ClassNotFoundException, IOException {
		if(sql==null || sql.length()==0) {
			responseMsg = null;
			return true;
		}
		if(mode.equals("single")) {
			CharStream input = CharStreams.fromString(sql);
			MiniSQLLexer lexer = new MiniSQLLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

			CommonTokenStream tokens = new CommonTokenStream(lexer);

			MiniSQLParser parser = new MiniSQLParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(ThrowingErrorListener.INSTANCE);

			try {
				ParseTree tree = parser.sql();
				
				MyListener extractor = new MyListener();
				ParseTreeWalker walker=new ParseTreeWalker();
				walker.walk(extractor, tree);		
				
				Result res = db.execute(extractor.st);
				responseMsg.msg = res.json();
				return true;
			}
			catch(Exception e) {
				responseMsg.msg = "{\"msg\":\"syntax error!\"}";
				return false;
			}
		}
		else {
			InputStream targetStream = new ByteArrayInputStream(sql.getBytes());
			InputStreamReader in=new InputStreamReader(targetStream);
			BufferedReader br=new BufferedReader(in);
			String cmd;
			while((cmd=br.readLine())!=null) {
				if(cmd.length()==0)continue;
				CharStream input = CharStreams.fromString(cmd);
				MiniSQLLexer lexer = new MiniSQLLexer(input);
				lexer.removeErrorListeners();
				lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

				CommonTokenStream tokens = new CommonTokenStream(lexer);

				MiniSQLParser parser = new MiniSQLParser(tokens);
				parser.removeErrorListeners();
				parser.addErrorListener(ThrowingErrorListener.INSTANCE);

				try {
					ParseTree tree = parser.sql();
					
					MyListener extractor = new MyListener();
					ParseTreeWalker walker=new ParseTreeWalker();
					walker.walk(extractor, tree);		
					
					Result res = db.execute(extractor.st);
					responseMsg.msg = res.json();
					return true;
				}
				catch(Exception e) {
					responseMsg.msg = "{\"msg\":\"syntax error!\"}";
					return false;
				}
			}

		}

	}
	
	//启动服务器，监听客户端请求
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//初始化 MiniDB
		db = new MiniDB();
		
		
		//HttpServerProvider provider = HttpServerProvider.provider();
		//监听端口8080，同时接收100个请求
		HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 100);
		//监听Login请求
		HttpContext contextLogin = httpServer.createContext("/login", new LoginHandler());
		//contextLogin.getFilters().add(new ParameterFilter());
		//监听SQL请求
		HttpContext contextSQL = httpServer.createContext("/execute", new ExecuteHandler());
		//contextSQL.getFilters().add(new ParameterFilter());
		
		httpServer.setExecutor(null);
		httpServer.start();
		System.out.println("Server started!");
	}
	
	//Login请求处理
	static class LoginHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange Exchange) throws IOException {		
			//响应信息
			responseMsg responseMsg = new responseMsg();
			responseMsg.msg = "{\"msg\":\"login failed!\"}";
			Headers responseHeaders = Exchange.getResponseHeaders();
			responseHeaders.set("Content-Type", "application/json");
			
			//获取请求方法
			String requestMethod = Exchange.getRequestMethod();
			System.out.println("method:" + requestMethod);
			
			
			String username = null;
			String password = null;
			if(requestMethod.equals("GET")) {
				//获得get参数
				Map<String, Object> parameters = new HashMap<String, Object>();
                URI requestedUri = Exchange.getRequestURI();
                String query = requestedUri.getRawQuery();
                parseQuery(query, parameters);
				username = (String) parameters.get("username");
				password = (String) parameters.get("password");	
			}
			else if(requestMethod.equals("POST")) {
				//获得post参数
				//parse request
	            Map<String, Object> parameters = new HashMap<String, Object>();
	            InputStreamReader isr = new InputStreamReader(Exchange.getRequestBody(), "utf-8");
	            BufferedReader br = new BufferedReader(isr);
	            String query = br.readLine();
	            parseQuery(query, parameters);    
				username = (String) parameters.get("username");
				password = (String) parameters.get("password");
			}
            
			System.out.println("username:" + username);
			System.out.println("password:" + password);	
			
			//验证用户
			if(!db.login(username, password)) {
				//响应格式
				responseMsg.msg = "{\"msg\":\"login failed!\"}";
				Exchange.sendResponseHeaders(500, responseMsg.msg.getBytes().length);
			}
			else {
				//响应格式
				//responseMsg.msg = db.getInfo();
				responseMsg.msg = "{\"msg\":\"login failed!\"}";
				Exchange.sendResponseHeaders(200, responseMsg.msg.getBytes().length);
			}
			
			//Exchange.sendResponseHeaders(200, responseMsg.msg.getBytes().length);
			//获得输出流
			OutputStream out = Exchange.getResponseBody();
			out.write(responseMsg.msg.getBytes());
			out.flush();
			Exchange.close();
		}
	}
	
	//SQL请求处理
	static class ExecuteHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange Exchange) throws IOException {
			//响应信息
			responseMsg responseMsg = new responseMsg();
			//响应格式
			Headers responseHeaders = Exchange.getResponseHeaders();
			responseHeaders.set("Content-Type", "application/json");
			
			//获取请求方法
			String requestMethod = Exchange.getRequestMethod();
			System.out.println("method:" + requestMethod);
			
			
			String username = null;
			String password = null;
			String sql = null;
			String mode = null;
			if(requestMethod.equals("GET")) {
				//获得request参数
				 // parse request
                Map<String, Object> parameters = new HashMap<String, Object>();
                URI requestedUri = Exchange.getRequestURI();
                String query = requestedUri.getRawQuery();
                parseQuery(query, parameters);
				username = (String) parameters.get("username");
				password = (String) parameters.get("password");
				sql = (String) parameters.get("sql");
			}
			else if(requestMethod.equals("POST")) {
				//获得post参数
				// parse request
	            Map<String, Object> parameters = new HashMap<String, Object>();
	            InputStreamReader isr = new InputStreamReader(Exchange.getRequestBody(), "utf-8");
	            BufferedReader br = new BufferedReader(isr);
	            String query = br.readLine();
	            System.out.println(query);
	            parseQuery(query, parameters);    
	            System.out.println(parameters);
				username = (String) parameters.get("username");
				password = (String) parameters.get("password");
				sql = (String) parameters.get("sql");
				mode = (String) parameters.get("mode");
			}
			
			System.out.println("username:" + username);
			System.out.println("password:" + password);
			System.out.println("sql:" + sql);
			
			try {
				if(sqlExecute(sql, responseMsg,mode)) {
					System.out.println("responseMsg:" + responseMsg.msg);
					//响应格式
					Exchange.sendResponseHeaders(200, responseMsg.msg.getBytes().length);
				}
				else {
					System.out.println("responseMsg:" + responseMsg.msg);
					//响应格式
					Exchange.sendResponseHeaders(500, responseMsg.msg.getBytes().length);
				}
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}
			
			//获得输出流
			OutputStream out = Exchange.getResponseBody();
			out.write(responseMsg.msg.getBytes());
			out.flush();
			Exchange.close();
		}
	}
	
	public static void parseQuery(String query, Map<String, 
			Object> parameters) throws UnsupportedEncodingException {

		         if (query != null) {
		                 String pairs[] = query.split("[&]");
		                 for (String pair : pairs) {
		                          String param[] = pair.split("[=]");
		                          String key = null;
		                          String value = null;
		                          if (param.length > 0) {
		                          key = URLDecoder.decode(param[0], 
		                          	System.getProperty("file.encoding"));
		                          }

		                          if (param.length > 1) {
		                                   value = URLDecoder.decode(param[1], 
		                                   System.getProperty("file.encoding"));
		                          }

		                          if (parameters.containsKey(key)) {
		                                   Object obj = parameters.get(key);
		                                   if (obj instanceof List<?>) {
		                                            List<String> values = (List<String>) obj;
		                                            values.add(value);

		                                   } else if (obj instanceof String) {
		                                            List<String> values = new ArrayList<String>();
		                                            values.add((String) obj);
		                                            values.add(value);
		                                            parameters.put(key, values);
		                                   }
		                          } else {
		                                   parameters.put(key, value);
		                          }
		                 }
		         }
		}
	
}
