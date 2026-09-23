package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket=new Socket("192.168.100.136",8721);
            DataOutputStream out=new DataOutputStream(socket.getOutputStream());
            DataInputStream in=new DataInputStream(socket.getInputStream());
            Scanner sc=new Scanner(System.in);) {

            while (true){
                System.out.println("Search by Department ID: ");
                int departmentID=sc.nextInt();
                out.writeInt(departmentID);
                out.flush();

                String dto= in.readUTF();
                System.out.println(dto);

            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
