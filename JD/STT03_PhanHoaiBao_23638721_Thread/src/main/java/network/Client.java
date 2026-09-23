package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //10.10.48.188
        try(Socket socket=new Socket("10.10.48.38",4391);
            DataOutputStream out=new DataOutputStream(socket.getOutputStream());
            DataInputStream in=new DataInputStream(socket.getInputStream());
            Scanner sc=new Scanner(System.in);){

            System.out.println("connected");
            while(true){

                System.out.print("Enter message:");
                String message=sc.nextLine();

                out.writeUTF(message);
                out.flush();

                String recievedMessage=in.readUTF();
                System.out.print("Recieved message: "+recievedMessage);

            }






        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
