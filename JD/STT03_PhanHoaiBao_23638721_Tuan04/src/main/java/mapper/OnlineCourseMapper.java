package mapper;

import dto.OnlineCourseRequestDTO;
import dto.OnlineCourseResponseDTO;
import entity.OnlineCourse;

public class OnlineCourseMapper {

    public static OnlineCourse toEntity(OnlineCourseRequestDTO dto) {
        if (dto == null) return null;
        return new OnlineCourse(dto.getId(), dto.getCredits(), dto.getTitle(), dto.getUrl());
    }

    public static OnlineCourseResponseDTO toDTO(OnlineCourse entity) {
        if (entity == null) return null;
        return new OnlineCourseResponseDTO(entity.getId(), entity.getCredits(), entity.getTitle(), entity.getUrl());
    }
}
