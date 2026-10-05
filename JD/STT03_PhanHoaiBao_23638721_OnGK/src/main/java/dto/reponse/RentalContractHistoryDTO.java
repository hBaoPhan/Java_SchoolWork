package dto.reponse;

import entity.ContractStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class RentalContractHistoryDTO {
    private Long id;
    private String carName;
    private LocalDate startDate;
    private LocalDate endDate;
    private ContractStatus contractStatus;
}
