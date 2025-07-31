package org.example.hexlet.repository;

import org.example.hexlet.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static List<User> entities = new ArrayList<>();
    private static long idCounter = 1;

    public static void save(User user) {
        // Если это новый пользователь (без ID), добавляем его
        if (user.getId() == null) {
            user.setId(idCounter++);
            entities.add(user);
        }
        // Если пользователь уже существует (есть ID), обновляем его
        else {
            var existingUser = find(user.getId())
                .orElseThrow(() -> new RuntimeException("User with id = " + user.getId() + " not found"));
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
        }
    }

    public static List<User> getEntities() {
        return entities;
    }

    public static Optional<User> find(Long id) {
        return entities.stream()
                       .filter(u -> u.getId().equals(id))
                       .findFirst();
    }

    public static void delete(Long id) {
        var user = find(id)
            .orElseThrow(() -> new RuntimeException("User with id = " + id + " not found"));
        entities.remove(user);
    }
}