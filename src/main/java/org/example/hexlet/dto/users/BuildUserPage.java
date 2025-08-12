package org.example.hexlet.dto.users;

import io.javalin.validation.ValidationError;
import org.example.hexlet.dto.BasePage;

import java.util.List;
import java.util.Map;

public class BuildUserPage extends BasePage {

    private Long id;
    private String name;
    private String email;
    private Map<String, List<ValidationError<Object>>> errors;

    public BuildUserPage() {
    }

    public BuildUserPage(Long id, String name, String email, Map<String, List<ValidationError<Object>>> errors) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.errors = errors;
    }

    // Геттеры
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, List<ValidationError<Object>>> getErrors() {
        return errors;
    }

    // Метод для получения сообщения об ошибке
    public String getError(String fieldName) {
        if (errors == null || !errors.containsKey(fieldName) || errors.get(fieldName).isEmpty()) {
            return null;
        }
        return errors.get(fieldName).get(0).getMessage();
    }
}