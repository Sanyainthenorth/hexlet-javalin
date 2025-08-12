package org.example.hexlet.dto.courses;

import org.example.hexlet.dto.BasePage;
import org.example.hexlet.model.Course;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CoursesPage extends BasePage {
    private List<Course> courses;
    private String header;
    private String term; // Добавляем поле для поискового запроса
}