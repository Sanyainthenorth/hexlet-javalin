package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class UsersController {
    public static void index(Context ctx) {
        try {
            var users = UserRepository.getEntities();
            var page = new UsersPage(users);
            page.setFlash(ctx.consumeSessionAttribute("flash"));
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        } catch (SQLException e) {
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Database error"
            ));
            ctx.redirect(NamedRoutes.usersPath());
        }
    }

    public static void show(Context ctx) {
        try {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var user = UserRepository.find(id)
                                     .orElseThrow(() -> new NotFoundResponse("User not found"));
            var page = new UserPage(user);
            page.setFlash(ctx.consumeSessionAttribute("flash"));
            ctx.render("users/show.jte", Collections.singletonMap("page", page));
        } catch (SQLException e) {
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Database error"
            ));
            ctx.redirect(NamedRoutes.usersPath());
        }
    }

    public static void build(Context ctx) {
        var page = new BuildUserPage();
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("users/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        try {
            String name = Objects.requireNonNull(ctx.formParam("name")).trim();
            String email = Objects.requireNonNull(ctx.formParam("email")).trim().toLowerCase();
            String password = Objects.requireNonNull(ctx.formParam("password"));
            String passwordConfirmation = Objects.requireNonNull(ctx.formParam("passwordConfirmation"));

            // Валидация
            ctx.formParamAsClass("name", String.class)
               .check(n -> !n.isEmpty(), "Имя не может быть пустым")
               .get();

            ctx.formParamAsClass("email", String.class)
               .check(e -> e.matches(".+@.+\\..+"), "Некорректный email")
               .get();

            ctx.formParamAsClass("password", String.class)
               .check(p -> p.length() >= 6, "Пароль должен быть не менее 6 символов")
               .check(p -> p.equals(passwordConfirmation), "Пароли не совпадают")
               .get();

            var user = new User(name, email, password);
            UserRepository.save(user);

            ctx.sessionAttribute("flash", Map.of(
                "type", "success",
                "message", "Пользователь успешно создан!"
            ));
            ctx.redirect(NamedRoutes.usersPath());

        } catch (ValidationException e) {
            var page = new BuildUserPage(
                null, // id для нового пользователя
                ctx.formParam("name"),
                ctx.formParam("email"),
                e.getErrors()
            );
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Ошибка при создании пользователя"
            ));
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        } catch (SQLException e) {
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Ошибка базы данных при создании пользователя"
            ));
            ctx.redirect(NamedRoutes.usersPath());
        }
    }

    public static void edit(Context ctx) {
        try {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var user = UserRepository.find(id)
                                     .orElseThrow(() -> new NotFoundResponse("User not found"));
            var page = new BuildUserPage(
                user.getId(),
                user.getName(),
                user.getEmail(),
                Collections.emptyMap()
            );
            page.setFlash(ctx.consumeSessionAttribute("flash"));
            ctx.render("users/edit.jte", Collections.singletonMap("page", page));
        } catch (SQLException e) {
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Ошибка базы данных"
            ));
            ctx.redirect(NamedRoutes.usersPath());
        }
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        try {
            String name = Objects.requireNonNull(ctx.formParam("name")).trim();
            String email = Objects.requireNonNull(ctx.formParam("email")).trim().toLowerCase();
            String password = ctx.formParam("password");
            String passwordConfirmation = ctx.formParam("passwordConfirmation");

            // Валидация
            ctx.formParamAsClass("name", String.class)
               .check(n -> !n.isEmpty(), "Имя не может быть пустым")
               .get();

            ctx.formParamAsClass("email", String.class)
               .check(e -> e.matches(".+@.+\\..+"), "Некорректный email")
               .get();

            if (password != null && !password.isEmpty()) {
                ctx.formParamAsClass("password", String.class)
                   .check(p -> p.length() >= 6, "Пароль должен быть не менее 6 символов")
                   .check(p -> p.equals(passwordConfirmation), "Пароли не совпадают")
                   .get();
            }

            var user = UserRepository.find(id)
                                     .orElseThrow(() -> new NotFoundResponse("User not found"));
            user.setName(name);
            user.setEmail(email);
            if (password != null && !password.isEmpty()) {
                user.setPassword(password);
            }

            UserRepository.save(user);

            ctx.sessionAttribute("flash", Map.of(
                "type", "success",
                "message", "Пользователь успешно обновлен!"
            ));
            ctx.redirect(NamedRoutes.userPath(id.toString()));
        } catch (ValidationException e) {
            var page = new BuildUserPage(
                id,
                ctx.formParam("name"),
                ctx.formParam("email"),
                e.getErrors()
            );
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Ошибка при обновлении пользователя"
            ));
            ctx.render("users/edit.jte", Collections.singletonMap("page", page));
        } catch (SQLException e) {
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Ошибка базы данных"
            ));
            ctx.redirect(NamedRoutes.usersPath());
        }
    }

    public static void destroy(Context ctx) {
        try {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            UserRepository.delete(id);

            ctx.sessionAttribute("flash", Map.of(
                "type", "success",
                "message", "Пользователь успешно удален"
            ));
        } catch (SQLException e) {
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Ошибка базы данных при удалении пользователя"
            ));
        }

        ctx.redirect(NamedRoutes.usersPath());
    }
}