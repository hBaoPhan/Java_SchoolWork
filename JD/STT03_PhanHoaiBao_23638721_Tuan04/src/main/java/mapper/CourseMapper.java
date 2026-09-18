package mapper;

import dto.CourseResponseDTO;
import entity.Course;

public class CourseMapper {

    public static CourseResponseDTO toDTO(Course course) {
        if (course == null) return null;
        return new CourseResponseDTO(course.getId(), course.getCredits(), course.getTitle());
    }
}
