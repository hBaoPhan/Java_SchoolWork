package mapper;

import dto.OnsiteCourseRequestDTO;
import dto.OnsiteCourseResponseDTO;
import entity.OnsiteCourse;

public class OnsiteCourseMapper {

    public static OnsiteCourse toEntity(OnsiteCourseRequestDTO dto) {
        if (dto == null) return null;
        return new OnsiteCourse(dto.getId(), dto.getCredits(), dto.getTitle(), dto.getDays(),  dto.getTime(),dto.getLocation());
    }

    public static OnsiteCourseResponseDTO toDTO(OnsiteCourse entity) {
        if (entity == null) return null;
        return new OnsiteCourseResponseDTO(entity.getId(), entity.getCredits(), entity.getTitle(), entity.getDays(), entity.getLocation(), entity.getTime());
    }
}
