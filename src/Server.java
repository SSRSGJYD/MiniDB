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
import java.util.Scanner;
import java.util.regex.Pattern;

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
			// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�
			this.msg = null;
		}
	}
	
	public static boolean sqlExecute(String sql, responseMsg responseMsg,String mode) throws ClassNotFoundException, IOException {
		if(sql==null || sql.length()==0) {
			responseMsg = null;
			return true;
		}
		if(mode.equals("single")) {
			sql=sql.replaceAll("\r", "");
<<<<<<< HEAD
			if(sql.replaceAll("\\s+", "").length()<=1){
=======
			if(sql.replaceAll("\\s+", "").length() <= 1) {
>>>>>>> master
				responseMsg.msg = "{\"msg\":\"nothing\"}";
				return false;
			}
			sql=sql.replace('\n',' ');
			sql=sql.replace('\t',' ');
			sql=sql.toLowerCase();
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
				
				Result res = db.execute(extractor.st,true);
				responseMsg.msg = res.json(res.time);
				return true;
			}
			catch(Exception e) {
				responseMsg.msg = "{\"msg\":\""+e.toString()+"\"}";
				return false;
			}
		}
		else {
			Scanner scan = new Scanner(sql);
			scan.useDelimiter(Pattern.compile(";"));
			String cmd;
			Result res = null;
			long time=0;
			while (scan.hasNext()) {
				cmd = scan.next();
				cmd=cmd.replaceAll("\r", "");
<<<<<<< HEAD
				if(cmd.replaceAll("\\s+", "").length()<=1)continue;
=======
				if(cmd.replaceAll("\\s+", "").length()<=1)
					continue;
>>>>>>> master
				cmd=cmd.replace('\n',' ');
				cmd=cmd.replace('\t',' ');
				cmd=cmd.toLowerCase();
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
					res = db.execute(extractor.st,false);
					time+=res.time;
				}
				catch(Exception e) {
					responseMsg.msg = "{\"msg\":\""+e.toString()+"\"}";
					return false;
				}
			}
			if(res==null) {
				responseMsg.msg = "{\"msg\":\"empty file!\"}";
				return false;
			}
			else {
				responseMsg.msg = res.json(time);
				db.commit();
			}

		}
		return true;
	}
	
	//鍚姩鏈嶅姟鍣紝鐩戝惉瀹㈡埛绔姹�
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//鍒濆鍖� MiniDB
		db = new MiniDB();
		
		//HttpServerProvider provider = HttpServerProvider.provider();
		//鐩戝惉绔彛8080锛屽悓鏃舵帴鏀�100涓姹�
		HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 100);
		//鐩戝惉Login璇锋眰
		HttpContext contextLogin = httpServer.createContext("/login", new LoginHandler());
		//contextLogin.getFilters().add(new ParameterFilter());
		//鐩戝惉SQL璇锋眰
		HttpContext contextSQL = httpServer.createContext("/execute", new ExecuteHandler());
		//contextSQL.getFilters().add(new ParameterFilter());
		
		httpServer.setExecutor(null);
		httpServer.start();
		System.out.println("Server started!");
	}
	
	//Login璇锋眰澶勭悊
	static class LoginHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange Exchange) throws IOException {		
			//鍝嶅簲淇℃伅
			responseMsg responseMsg = new responseMsg();
			responseMsg.msg = "{\"msg\":\"login failed!\"}";
			Headers responseHeaders = Exchange.getResponseHeaders();
			responseHeaders.set("Content-Type", "application/json");
			
			//鑾峰彇璇锋眰鏂规硶
			String requestMethod = Exchange.getRequestMethod();
			System.out.println("method:" + requestMethod);
			
			
			String username = null;
			String password = null;
			if(requestMethod.equals("GET")) {
				//鑾峰緱get鍙傛暟
				Map<String, Object> parameters = new HashMap<String, Object>();
                URI requestedUri = Exchange.getRequestURI();
                String query = requestedUri.getRawQuery();
                parseQuery(query, parameters);
				username = (String) parameters.get("username");
				password = (String) parameters.get("password");	
			}
			else if(requestMethod.equals("POST")) {
				//鑾峰緱post鍙傛暟
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
			
			//楠岃瘉鐢ㄦ埛
			if(!db.login(username, password)) {
				//鍝嶅簲鏍煎紡
				responseMsg.msg = "{\"msg\":\"login failed!\"}";
				Exchange.sendResponseHeaders(500, responseMsg.msg.getBytes().length);
			}
			else {
				//鍝嶅簲鏍煎紡
				responseMsg.msg = db.getInfo();
//				responseMsg.msg = "{\"msg\":\"login failed!\"}";
				Exchange.sendResponseHeaders(200, responseMsg.msg.getBytes().length);
			}
			
			//Exchange.sendResponseHeaders(200, responseMsg.msg.getBytes().length);
			//鑾峰緱杈撳嚭娴�
			OutputStream out = Exchange.getResponseBody();
			out.write(responseMsg.msg.getBytes());
			out.flush();
			Exchange.close();
		}
	}
	
	//SQL璇锋眰澶勭悊
	static class ExecuteHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange Exchange) throws IOException {
			//鍝嶅簲淇℃伅
			responseMsg responseMsg = new responseMsg();
			//鍝嶅簲鏍煎紡
			Headers responseHeaders = Exchange.getResponseHeaders();
			responseHeaders.set("Content-Type", "application/json");
			
			//鑾峰彇璇锋眰鏂规硶
			String requestMethod = Exchange.getRequestMethod();
			System.out.println("method:" + requestMethod);
			
			
			String username = null;
			String password = null;
			String sql = null;
			String mode = null;
			if(requestMethod.equals("GET")) {
				//鑾峰緱request鍙傛暟
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
				//鑾峰緱post鍙傛暟
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
					//鍝嶅簲鏍煎紡
					Exchange.sendResponseHeaders(200, responseMsg.msg.getBytes().length);
				}
				else {
					System.out.println("responseMsg:" + responseMsg.msg);
					//鍝嶅簲鏍煎紡
					Exchange.sendResponseHeaders(500, responseMsg.msg.getBytes().length);
				}
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}
			
			//鑾峰緱杈撳嚭娴�
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
