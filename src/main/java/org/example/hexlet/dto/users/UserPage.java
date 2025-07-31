package org.example.hexlet.dto.users;

import org.example.hexlet.model.User;
import org.example.hexlet.NamedRoutes;

public class UserPage {
    private User user;

    public UserPage(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    // Добавляем методы для путей
    public String getUsersPath() {
        return NamedRoutes.usersPath();
    }

    public String getEditUserPath() {
        return NamedRoutes.editUserPath(user.getId());
    }

    public String getUserPath() {
        return NamedRoutes.userPath(user.getId());
    }
}