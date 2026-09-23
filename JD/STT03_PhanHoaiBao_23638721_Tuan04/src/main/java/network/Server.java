package network;

import dto.DepartmentResponseDTO;
import service.impl.DepartmentService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket=new ServerSocket(8721)){
            while (true){
                Socket socket=serverSocket.accept();
                Handler handler=new Handler(socket);
                Thread thread=new Thread(handler);
                thread.start();

            }

        }
    }
}

class Handler implements Runnable{
    private final Socket socket;
    private DepartmentService departmentService;

    public Handler(Socket socket) {
        super();
        this.socket=socket;
        departmentService=new DepartmentService();
    }

    @Override
    public void run() {
        try(
                DataOutputStream out=new DataOutputStream(socket.getOutputStream());
                DataInputStream in=new DataInputStream(socket.getInputStream());
                Scanner sc=new Scanner(System.in);
                ){

            int departmentId=in.readInt();
            DepartmentResponseDTO dto=departmentService.findById(departmentId);
            out.writeUTF(dto.toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
