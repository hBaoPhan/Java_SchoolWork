import dao.CarDAO;

public class Main {
    public static void main(String[] args) {


        CarDAO carDAO=new CarDAO();
//
//        carDAO.findAll().forEach(e-> System.out.println(e));
        carDAO.getCOntractByCustomer("C002").forEach(e-> System.out.printf("%-20s%-20s%-20s%-20s%-20s%n",e[0],e[1],e[2],e[3],e[4]));

    }
}
