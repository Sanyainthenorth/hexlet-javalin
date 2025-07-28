package org.example.hexlet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Course {
    private Long id;
    private String name = ""; // Инициализация по умолчанию
    private String description = ""; // Инициализация по умолчанию

    public Course(String name, String description) {
        this.name = name != null ? name : "";
        this.description = description != null ? description : "";
    }
}