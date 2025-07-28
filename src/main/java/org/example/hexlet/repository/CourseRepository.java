package org.example.hexlet.repository;

import org.example.hexlet.model.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository {
    private static List<Course> entities = new ArrayList<>();
    private static long idCounter = 1;

    public static void save(Course course) {
        course.setId(idCounter++);
        entities.add(course);
    }

    public static List<Course> search(String term) {
        if (term == null || term.isEmpty()) {
            return getEntities();
        }

        String lowerTerm = term.toLowerCase();
        List<Course> result = new ArrayList<>();

        for (Course course : entities) {
            if ((course.getName() != null && course.getName().toLowerCase().contains(lowerTerm)) ||
                (course.getDescription() != null && course.getDescription().toLowerCase().contains(lowerTerm))) {
                result.add(course);
            }
        }

        return result;
    }

    public static Optional<Course> find(Long id) {
        return entities.stream()
                       .filter(c -> c.getId().equals(id))
                       .findFirst();
    }

    public static List<Course> getEntities() {
        return entities;
    }

    public static void delete(Long id) {
        entities.removeIf(c -> c.getId().equals(id));
    }
}