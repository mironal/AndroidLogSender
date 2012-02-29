package jp.mironal.java.app.androidlogserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class AndroidLogServer implements Callable<Void> {

	private ServerSocket serverSocket;
	private ExecutorService es = Executors.newSingleThreadExecutor();
	private AtomicBoolean runnning = new AtomicBoolean(true);
	
	private final String IP;
	private final int port;
	
	public AndroidLogServer(String ip, int port) {
		IP = ip;
		this.port = port;
	}
	
	public void start() throws IOException{
		runnning.set(true); 
		es.submit(this);
	}
	
	public void stop(){
		runnning.set(false);
	}
	
	@Override
	public Void call() throws Exception {
		
		serverSocket = new  ServerSocket(port, 5, InetAddress.getByName(IP));
		System.out.println("start server.");
		System.out.println("IP : " + serverSocket.getLocalSocketAddress());
		System.out.println("PORT : " + serverSocket.getLocalPort());
		while(runnning.get()){
			Socket sock = serverSocket.accept();
			InputStream in = sock.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			do{
				String line = br.readLine();
				System.out.println(line);	
			}while(br.ready());
			
		}
		return null;
	}
	
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		if( args.length == 2){
			new AndroidLogServer(args[0], Integer.parseInt(args[1])).start();
		}
		
	}

	

}
