package org.example.hexlet.dto.courses;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuildCoursePage {
    private Long id; // Добавлен id курса для поддержки ссылок на редактирование
    private String name;
    private String description;
    private Map<String, List<ValidationError<Object>>> errors;

    public String getError(String fieldName) {
        if (errors == null || !errors.containsKey(fieldName) || errors.get(fieldName).isEmpty()) {
            return null;
        }
        return errors.get(fieldName).get(0).getMessage();
    }
}
