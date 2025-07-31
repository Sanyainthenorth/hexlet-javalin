package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;


public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
            config.http.defaultContentType = "text/html; charset=utf-8";
        });

        // Инициализация тестовых данных
        CourseRepository.save(new Course("Java Basics", "Основы Java и ООП"));
        UserRepository.save(new User("John Doe", "john@example.com", "password123"));

        // Основной маршрут
        app.get(NamedRoutes.rootPath(), ctx -> ctx.render("index.jte"));

        // Маршруты для курсов
        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);
        app.get(NamedRoutes.editCoursePath("{id}"), CoursesController::edit);
        //app.patch(NamedRoutes.coursePath("{id}"), CoursesController::update);
        app.post("/courses/{id}", CoursesController::update);
        app.post(NamedRoutes.coursePath("{id}") + "/delete", CoursesController::destroyByPost);

        // Маршруты для пользователей
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        app.get(NamedRoutes.editUserPath("{id}"), UsersController::edit);
        app.post(NamedRoutes.userPath("{id}"), UsersController::update);
        app.post(NamedRoutes.userPath("{id}") + "/delete", UsersController::destroyByPost);

        // Дополнительные маршруты
        app.get(NamedRoutes.helloPath(), ctx -> {
            String name = ctx.queryParam("name");
            if (name == null || name.isEmpty()) {
                name = "World";
            }
            ctx.result("Hello, " + name + "!");
        });

        app.get(NamedRoutes.userPostPath("{id}", "{postId}"), ctx -> {
            String userId = ctx.pathParam("id");
            String postId = ctx.pathParam("postId");
            ctx.result("User ID: " + userId + ", Post ID: " + postId);
        });

        app.start(7070);
    }
}