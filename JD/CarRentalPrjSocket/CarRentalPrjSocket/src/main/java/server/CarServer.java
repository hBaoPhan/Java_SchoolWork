package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarServer {
	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		try(ServerSocket serverSocket = new ServerSocket(1234)){
			System.out.println("Ready...");
			
			while(true) { //24/7
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress());
				System.out.println(socket.getInetAddress().getHostName());
				
				pool.submit(new HandleClient(socket));
			}
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			pool.shutdown();
		}
		
	}
}
