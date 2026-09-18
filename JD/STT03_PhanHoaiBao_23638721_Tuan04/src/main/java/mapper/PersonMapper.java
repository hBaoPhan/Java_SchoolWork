package mapper;

import dto.PersonResponseDTO;
import entity.Person;

public class PersonMapper {

    public static PersonResponseDTO toDTO(Person person) {
        if (person == null) return null;
        return new PersonResponseDTO(person.getId(), person.getFirstName(), person.getLastName());
    }
}
