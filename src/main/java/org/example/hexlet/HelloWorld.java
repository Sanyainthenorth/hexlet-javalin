package org.example.hexlet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.BaseRepository;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import org.example.hexlet.dto.MainPage;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {

        // Настройка подключения к БД
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:project;DB_CLOSE_DELAY=-1;");

        var dataSource = new HikariDataSource(hikariConfig);
        BaseRepository.dataSource = dataSource;

        // Загрузка схемы БД
        try {
            var url = HelloWorld.class.getClassLoader().getResourceAsStream("schema.sql");
            if (url == null) {
                throw new RuntimeException("Schema file not found");
            }

            var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));

            try (var connection = dataSource.getConnection();
                 var statement = connection.createStatement()) {
                statement.execute(sql);
            }
        } catch (Exception e) {
            System.err.println("Failed to initialize database: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }


        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
            config.http.defaultContentType = "text/html; charset=utf-8";
        });

        app.before(ctx -> {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            String method = ctx.method().name();
            String path = ctx.path();
            System.out.printf("[%s] %s %s%n", timestamp, method, path);
        });

        app.get("/", ctx -> {
            Boolean visited = ctx.cookie("visited") != null;
            String currentUser = ctx.sessionAttribute("currentUser");
            var page = new MainPage(visited, currentUser);
            ctx.render("index.jte", model("page", page));

            if (!visited) {
                ctx.cookie("visited", "true");
            }
        });

        // Маршруты для сессий
        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);
        app.delete(NamedRoutes.sessionsPath(), SessionsController::destroy);

        // Маршруты для курсов
        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);
        app.get(NamedRoutes.editCoursePath("{id}"), CoursesController::edit);
        app.post(NamedRoutes.coursePath("{id}"), CoursesController::update);
        //app.post(NamedRoutes.coursePath("{id}") + "/delete", CoursesController::destroy);
        app.post("/courses/{id}/delete", CoursesController::destroy);

        // Маршруты для пользователей
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        app.get(NamedRoutes.editUserPath("{id}"), UsersController::edit);
        app.post(NamedRoutes.userPath("{id}"), UsersController::update);
        app.post("/users/{id}/delete", UsersController::destroy);

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