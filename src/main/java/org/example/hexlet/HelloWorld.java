package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
            config.http.defaultContentType = "text/html; charset=utf-8";
        });

        // Инициализация тестовых данных для курсов
        CourseRepository.save(new Course("Java Basics", "Основы Java и ООП"));
        CourseRepository.save(new Course("Spring", "Фреймворк Spring для веб-разработки"));
        CourseRepository.save(new Course("Web Development", "HTML, CSS и JavaScript"));
        CourseRepository.save(new Course("Database", "SQL и проектирование баз данных"));
        CourseRepository.save(new Course("Algorithms", "Структуры данных и алгоритмы"));

        // Инициализация тестовых данных для пользователей
        UserRepository.save(new User("John Doe", "john@example.com", "password123"));
        UserRepository.save(new User("Jane Smith", "jane@example.com", "securepass"));

        // Основные маршруты
        app.get("/", ctx -> ctx.result("Hello World"));

        // Обработчики для курсов
        app.get("/courses/build", ctx -> {
            ctx.render("courses/build.jte");
        });

        app.post("/courses", ctx -> {
            try {
                var name = ctx.formParam("name").trim();
                var description = ctx.formParam("description").trim();

                if (name.isEmpty() || description.isEmpty()) {
                    ctx.status(400).result("Все поля обязательны");
                    return;
                }

                var course = new Course(name, description);
                CourseRepository.save(course);
                ctx.redirect("/courses");
            } catch (Exception e) {
                ctx.status(500).result("Ошибка сервера: " + e.getMessage());
            }
        });

        app.get("/courses", ctx -> {
            String term = ctx.queryParam("term");
            var courses = CourseRepository.search(term);
            var page = new CoursesPage(courses, "Каталог курсов", term);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
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
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx -> {
            try {
                var name = ctx.formParam("name").trim();
                var email = ctx.formParam("email").trim().toLowerCase();
                var password = ctx.formParam("password");

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    ctx.status(400).result("Все поля обязательны для заполнения");
                    return;
                }

                var user = new User(name, email, password);
                UserRepository.save(user);
                ctx.redirect("/users");
            } catch (Exception e) {
                ctx.status(500).result("Ошибка сервера: " + e.getMessage());
            }
        });

        app.get("/users", ctx -> {
            var users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        app.get("/users/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            var user = UserRepository.find(id).orElse(null);
            if (user == null) {
                ctx.status(404).result("Пользователь не найден");
                return;
            }
            ctx.render("users/show.jte", model("user", user));
        });

        // Дополнительные маршруты
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

        app.start(7070);
    }
}