import dao.CarDAO;
import service.impl.CarService;

public class Main {
    public static void main(String[] args) {


        CarDAO carDAO=new CarDAO();

        CarService carService=new CarService();
//
//        carDAO.findAll().forEach(e-> System.out.println(e));
//        carDAO.getContractByCustomer("C002").forEach(e-> System.out.printf("%-20s%-20s%-20s%-20s%-20s%n",e[0],e[1],e[2],e[3],e[4]));
//        System.out.println(carDAO.findById(1l));

        carService.getContractByCustomer("C002").forEach(rental -> System.out.println(rental));


    }
}
