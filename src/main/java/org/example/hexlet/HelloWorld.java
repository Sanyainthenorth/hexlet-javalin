package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));

        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));

        app.get("/hello", ctx -> {
            String name = ctx.queryParam("name");
            if (name == null || name.isEmpty()) {
                name = "World";
            }
            ctx.result("Hello, " + name + "!");
        });

        app.get("/users/{id}/post/{postId}", ctx -> {
            String userId = ctx.pathParam("id");
            String postId = ctx.pathParam("postId");
            ctx.result("User ID: " + userId + ", Post ID: " + postId);
        });

        // Создаем тестовые данные
        List<Course> courses = List.of(
            new Course(1L, "Java Basics", "Основы программирования на Java"),
            new Course(2L, "Spring Framework", "Введение в Spring Framework"),
            new Course(3L, "Database Design", "Принципы проектирования баз данных")
        );

        // Обработчик для списка курсов
        app.get("/courses", ctx -> {
            var page = new CoursesPage(courses, "Список курсов");
            ctx.render("courses/index.jte", model("page", page));
        });

        // Обработчик для страницы курса
        app.get("/courses/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            var course = courses.stream()
                                .filter(c -> c.getId().equals(id))
                                .findFirst()
                                .orElse(null);

            if (course == null) {
                ctx.status(404).result("Курс не найден");
                return;
            }

            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });

        app.start(7070); // Стартуем веб-сервер
    }
}