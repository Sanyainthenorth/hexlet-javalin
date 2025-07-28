package org.example.hexlet.repository;

import org.example.hexlet.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static List<User> entities = new ArrayList<>();
    private static long idCounter = 1;

    public static void save(User user) {
        user.setId(idCounter++);
        entities.add(user);
    }

    public static List<User> getEntities() {
        return entities;
    }

    public static Optional<User> find(Long id) {
        return entities.stream()
                       .filter(u -> u.getId().equals(id))
                       .findFirst();
    }
}