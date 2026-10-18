package mapper;

import dto.reponse.RentalContractHistoryDTO;
import entity.ContractStatus;

import java.time.LocalDate;

public class RentalContractHistoryMapper {
    public static RentalContractHistoryDTO toReponseDTO(Object[] obj){
        return new RentalContractHistoryDTO((Long) obj[0], (String) obj[1], (LocalDate) obj[2], (LocalDate) obj[3], (ContractStatus) obj[4]);
    }
}
