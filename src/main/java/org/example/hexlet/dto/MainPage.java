package org.example.hexlet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MainPage {
    private Boolean visited;
    private String currentUser;

    // Добавляем метод isVisited() для совместимости с шаблоном
    public boolean isVisited() {
        return visited != null && visited;
    }
}