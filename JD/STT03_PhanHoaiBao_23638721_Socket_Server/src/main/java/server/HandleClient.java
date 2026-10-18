package server;

import dto.reponse.CarReponseDTO;
import dto.reponse.RentalContractHistoryDTO;
import dto.request.CarRequestDTO;
import protocol.ActionType;
import protocol.Response;
import protocol.Request;
import service.impl.CarService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class HandleClient implements Runnable {
    private final Socket socket;
    private final CarService carService;

    public HandleClient(Socket socket) {
        this.socket = socket;
        this.carService = new CarService();
    }

    @Override
    public void run() {
        try (ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream ouput = new ObjectOutputStream(socket.getOutputStream())) {

            while (true) {
                Request request = (Request) input.readObject();
                Response reponse = handleRequest(request);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private Response handleRequest(Request request) {
        ActionType actionType = request.getActionType();
        Response response = new Response();
        switch (actionType) {
            case ADD -> {
                CarRequestDTO requestDTO = (CarRequestDTO) request.getData();
                if (requestDTO != null && carService.findById(requestDTO.getId())!=null) {
                    response.setMessage("Duplicate key");
                    response.setSuccess(false);
                } else {
                    carService.create(requestDTO);
                    response.setSuccess(true);
                    response.setData(carService.findById(requestDTO.getId()));
                    response.setMessage("Added successfully");
                }
            }
            case UPDATE -> {
                CarRequestDTO carRequestDTO= (CarRequestDTO) request.getData();
                CarReponseDTO carReponseDTO=carService.findById(carRequestDTO.getId());
                if(carReponseDTO!=null){
                    carService.update(carRequestDTO);
                    response.setSuccess(true);
                    response.setData(carService.findById(carRequestDTO.getId()));
                    response.setMessage("Updated successfully");
                }else{
                    response.setMessage("Not found");
                    response.setSuccess(false);
                }

            }
            case DELETE -> {
                CarReponseDTO carReponseDTO=carService.findById((Long) request.getData());
                if(carReponseDTO!=null){
                    carService.delete((Long) request.getData());
                    response.setSuccess(true);
                    response.setMessage("Deleted successfully");
                }else{
                    response.setMessage("Not found");
                    response.setSuccess(false);
                }

            }
            case FIND_BY_ID -> {
                CarReponseDTO carReponseDTO=carService.findById((Long) request.getData());
                if(carReponseDTO==null){
                    response.setMessage("Not found");
                }else {
                    response.setMessage("Founded");
                    response.setData(carReponseDTO);
                    response.setSuccess(true);
                }

            }
            case FIND_ALL -> {
               List<CarReponseDTO> carList=carService.findALl();
                if(carList==null){
                    response.setMessage("Not found");
                }else {
                    response.setMessage("Founded");
                    response.setData(carList);
                    response.setSuccess(true);
                }
            }
            case GET_RENTAL_HISTORY -> {
                List<RentalContractHistoryDTO> carList=carService.getContractByCustomer((String) request.getData());
                if(carList==null){
                    response.setMessage("Not found");
                }else {
                    response.setMessage("Founded");
                    response.setData(carList);
                    response.setSuccess(true);
                }

            }
        }
        return response;
    }
}
