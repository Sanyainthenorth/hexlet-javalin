package org.example.hexlet;

public class NamedRoutes {
    // Основные маршруты
    public static String rootPath() { return "/"; }
    public static String helloPath() { return "/hello"; }

    // Маршруты курсов
    public static String coursesPath() { return "/courses"; }
    public static String buildCoursePath() { return "/courses/build"; }
    public static String coursePath(Long id) { return coursePath(String.valueOf(id)); }
    public static String coursePath(String id) { return "/courses/" + id; }

    // Маршруты пользователей
    public static String usersPath() { return "/users"; }
    public static String buildUserPath() { return "/users/build"; }
    public static String userPath(Long id) { return userPath(String.valueOf(id)); }
    public static String userPath(String id) { return "/users/" + id; }
    public static String userPostPath(Long userId, Long postId) {
        return userPostPath(String.valueOf(userId), String.valueOf(postId));
    }
    public static String userPostPath(String userId, String postId) {
        return "/users/" + userId + "/post/" + postId;
    }
    public static String editUserPath(String id) {
        return "/users/" + id + "/edit";
    }

    public static String editUserPath(long id) {
        return editUserPath(String.valueOf(id));
    }

    public static String editCoursePath(String id) {
        return "/courses/" + id + "/edit";
    }

    public static String editCoursePath(long id) {
        return editCoursePath(String.valueOf(id));
    }
    public static String sessionsPath() {
        return "/sessions";
    }

    public static String buildSessionPath() {
        return "/sessions/build";
    }
}
