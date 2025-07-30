package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationError;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.List;
import java.util.Map;

import static io.javalin.rendering.template.TemplateUtil.model;

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
        app.get(NamedRoutes.rootPath(), ctx -> {
            ctx.render("index.jte");
        });

        // Маршруты для курсов
        app.get(NamedRoutes.buildCoursePath(), ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", model("page", page));
        });

        app.post(NamedRoutes.coursesPath(), ctx -> {
            var name = ctx.formParam("name").trim();
            var description = ctx.formParam("description").trim();

            try {
                ctx.formParamAsClass("name", String.class)
                   .check(n -> n.length() > 2, "Название должно быть длиннее 2 символов")
                   .get();

                ctx.formParamAsClass("description", String.class)
                   .check(d -> d.length() > 10, "Описание должно быть длиннее 10 символов")
                   .get();

                var course = new Course(name, description);
                CourseRepository.save(course);
                ctx.redirect(NamedRoutes.coursesPath());
            } catch (ValidationException e) {
                var page = new BuildCoursePage(name, description, e.getErrors());
                ctx.render("courses/build.jte", model("page", page));
            }
        });

        app.get(NamedRoutes.coursesPath(), ctx -> {
            String term = ctx.queryParam("term");
            var courses = CourseRepository.search(term);
            var page = new CoursesPage(courses, "Каталог курсов", term);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get(NamedRoutes.coursePath("{id}"), ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            var course = CourseRepository.find(id).orElse(null);
            if (course == null) {
                ctx.status(404).result("Курс не найден");
                return;
            }
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });

        // Маршруты для пользователей
        app.get(NamedRoutes.buildUserPath(), ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", model("page", page));
        });

        app.post(NamedRoutes.usersPath(), ctx -> {
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            try {
                var password = ctx.formParamAsClass("password", String.class)
                                  .check(p -> !p.isEmpty(), "Пароль не может быть пустым")
                                  .check(p -> p.length() >= 6, "Пароль должен быть не менее 6 символов")
                                  .check(p -> p.equals(passwordConfirmation), "Пароли не совпадают")
                                  .get();

                var user = new User(name, email, password);
                UserRepository.save(user);
                ctx.redirect(NamedRoutes.usersPath());
            } catch (ValidationException e) {
                var page = new BuildUserPage(name, email, e.getErrors());
                ctx.render("users/build.jte", model("page", page));
            }
        });

        app.get(NamedRoutes.usersPath(), ctx -> {
            var users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        app.get(NamedRoutes.userPath("{id}"), ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            var user = UserRepository.find(id).orElse(null);
            if (user == null) {
                ctx.status(404).result("Пользователь не найден");
                return;
            }
            ctx.render("users/show.jte", model("user", user));
        });

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