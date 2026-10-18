package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import dto.CarRequestDTO;
import dto.CarResponseDTO;
import protocol.ActionType;
import protocol.Request;
import protocol.Response;
import service.CarService;
import service.impl.CarServiceImpl;

public class HandleClient implements Runnable{
	private final Socket socket;
	private final CarService carService;
	
	

	public HandleClient(Socket socket) {
		super();
		this.socket = socket;
		this.carService = new CarServiceImpl();
	}



	@Override
	public void run() {
		try(
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				){
			
			while(true) {
				Request request = (Request) in.readObject();
				Response response = handle(request);
				out.writeObject(response);
				out.flush();
				out.reset();
			}
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	private Response handle(Request request) {
		ActionType actionType = request.getActionType();
		Response response = new Response();
		switch (actionType) {
		case CAR_ADD ->{
			CarRequestDTO requestDTO = (CarRequestDTO) request.getData();
			if(requestDTO != null && carService.findById(requestDTO.id()) != null) {
				response.setMessage("Duplicate in primary key");
			}else {
				carService.add(requestDTO);
				response.setSuccess(true);
				response.setData(carService.findById(requestDTO.id()));
				response.setMessage("Inserted");
			}
		}
		case CAR_UPDATE ->{}
		case CAR_DELETE ->{}
		case CAR_FIND_ALL ->{}
		case CAR_FIND_BY_ID ->{
			long carId = (long) request.getData();
			CarResponseDTO responseDTO = carService.findById(carId);
			if(responseDTO == null)
				response.setMessage("Not found.");
			else {
				response.setSuccess(true);
				response.setData(responseDTO);
				response.setMessage("Found one result.");
			}
		}
		case GET_RENTAL_HISTORY ->{}
		
		}
		return response;
	}

}
