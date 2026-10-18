import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import dto.request.CarRequestDTO;
import enums.CarStatus;
import protocol.ActionType;
import protocol.Request;
import protocol.Response;


public class Client {
public static void main(String[] args) {
		
		try(Socket socket = new Socket("HOAI_BAO", 1234);
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				Scanner scanner = new Scanner(System.in);
				){
			
			int choice = 0;
			Request request = null;
			do {
				printMenu();
				choice = scanner.nextInt();
				switch (choice) {
				case 1 -> {
					CarRequestDTO requestDTO = newCar(scanner);
					request = new Request(ActionType.ADD, requestDTO);
				}
				case 2 -> {}
				case 3 -> {}
				case 4 -> {
					System.out.println("Enter car ID: ");
					long carId = scanner.nextLong();
					request = new Request(ActionType.FIND_BY_ID, carId);
				}
				case 5 -> {}
				case 6 -> {}
					
					
				}
				
				Response response = sendRequest(out, in, request);
				System.out.println(response);
			}while(choice > 0);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static CarRequestDTO newCar(Scanner scanner) {
		System.out.println("Car id: ");
		long carId = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Car name: ");
		String name = scanner.nextLine();
		System.out.println("Brand: ");
		String brand = scanner.nextLine();
		System.out.println("License: ");
		String license = scanner.nextLine();
		System.out.println("Seats: ");
		int seats = scanner.nextInt();
		System.out.println("Price: ");
		double price = scanner.nextDouble();
		
		return new CarRequestDTO(CarStatus.AVAILABLE,price , name,seats,  license, brand,carId  );
	}

	private static Response sendRequest(ObjectOutputStream out, ObjectInputStream in, Request request) throws IOException, ClassNotFoundException, IOException {
		out.writeObject(request);
		out.flush();
		out.reset();
		return (Response) in.readObject();
	}

	private static void printMenu() {
		System.out.println("1. Add new car");
		System.out.println("2. Update car");
		System.out.println("3. Delete car by id");
		System.out.println("4. Find car by id");
		System.out.println("5. Find all");
		System.out.println("6. Get rental history");
	}

}
