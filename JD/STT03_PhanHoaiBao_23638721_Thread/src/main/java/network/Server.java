package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket=new ServerSocket(8721);){
            System.out.println("Ready!!");

            Socket socket=serverSocket.accept();
            System.out.println(socket.getPort());
            System.out.println(socket.getInetAddress().getHostName());

            DataOutputStream out=new DataOutputStream(socket.getOutputStream());
            DataInputStream in=new DataInputStream(socket.getInputStream());
            Scanner sc=new Scanner(System.in);

            while (true){
                String recievedMessage=in.readUTF();
                System.out.print("Recieved message: "+recievedMessage);

                System.out.print("Enter message: ");
                String message=sc.nextLine();

                out.writeUTF(message);
                out.flush();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
