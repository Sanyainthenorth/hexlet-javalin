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

import java.util.Collections;
import java.util.Objects;

public class UsersController {
    public static void index(Context ctx) {
        var users = UserRepository.getEntities();
        var page = new UsersPage(users);
        ctx.render("users/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                                 .orElseThrow(() -> new NotFoundResponse("User not found"));
        var page = new UserPage(user);
        ctx.render("users/show.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        try {
            // Получаем параметры с проверкой на null
            String name = ctx.formParam("name");
            String email = ctx.formParam("email");
            String password = ctx.formParam("password");
            String passwordConfirmation = ctx.formParam("passwordConfirmation");

            // Валидация
            ctx.formParamAsClass("name", String.class)
               .check(Objects::nonNull, "Имя обязательно для заполнения")
               .check(n -> !n.trim().isEmpty(), "Имя не может быть пустым")
               .get();

            ctx.formParamAsClass("email", String.class)
               .check(Objects::nonNull, "Email обязателен для заполнения")
               .check(e -> e.matches(".+@.+\\..+"), "Некорректный email")
               .get();

            ctx.formParamAsClass("password", String.class)
               .check(Objects::nonNull, "Пароль обязателен для заполнения")
               .check(p -> !p.isEmpty(), "Пароль не может быть пустым")
               .check(p -> p.length() >= 6, "Пароль должен быть не менее 6 символов")
               .check(p -> p.equals(passwordConfirmation), "Пароли не совпадают")
               .get();

            // Создаем пользователя
            var user = new User(
                name.trim(),
                email.trim().toLowerCase(),
                password
            );

            UserRepository.save(user);
            ctx.redirect(NamedRoutes.usersPath());

        } catch (ValidationException e) {
            // Возвращаем ошибки в форму
            var page = new BuildUserPage(
                null,
                ctx.formParam("name"),
                ctx.formParam("email"),
                e.getErrors()
            );
            ctx.render("users/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                                 .orElseThrow(() -> new NotFoundResponse("User not found"));
        var page = new BuildUserPage(user.getId(), user.getName(), user.getEmail(), Collections.emptyMap());
        ctx.render("users/edit.jte", Collections.singletonMap("page", page));
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var name = ctx.formParam("name").trim();
        var email = ctx.formParam("email").trim().toLowerCase();
        var password = ctx.formParam("password");
        var passwordConfirmation = ctx.formParam("passwordConfirmation");

        try {
            ctx.formParamAsClass("name", String.class)
               .check(n -> !n.isEmpty(), "Имя не может быть пустым")
               .get();

            ctx.formParamAsClass("email", String.class)
               .check(e -> e.matches(".+@.+\\..+"), "Некорректный email")
               .get();

            if (!password.isEmpty()) {
                ctx.formParamAsClass("password", String.class)
                   .check(p -> p.length() >= 6, "Пароль должен быть не менее 6 символов")
                   .check(p -> p.equals(passwordConfirmation), "Пароли не совпадают")
                   .get();
            }

            var user = UserRepository.find(id)
                                     .orElseThrow(() -> new NotFoundResponse("User not found"));
            user.setName(name);
            user.setEmail(email);

            if (!password.isEmpty()) {
                user.setPassword(password);
            }

            UserRepository.save(user);
            ctx.redirect(NamedRoutes.usersPath());
        } catch (ValidationException e) {
            var page = new BuildUserPage(id, name, email, e.getErrors());
            ctx.render("users/edit.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroyByPost(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}