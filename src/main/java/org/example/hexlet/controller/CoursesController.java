package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.NamedRoutes;

import java.sql.SQLException;
import java.util.Map;

public class CoursesController {
    public static void index(Context ctx) {
        try {
            String term = ctx.queryParam("term");
            var courses = CourseRepository.search(term);
            var page = new CoursesPage(courses, "Каталог курсов", term);

            // Обработка flash-сообщений
            var flash = ctx.consumeSessionAttribute("flash");
            if (flash != null) {
                if (flash instanceof Map) {
                    page.setFlash((Map<String, String>) flash);
                } else {
                    page.setFlash(Map.of("message", flash.toString(), "type", "info"));
                }
            }

            ctx.render("courses/index.jte", Map.of("page", page));

        } catch (SQLException e) {
            e.printStackTrace();
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Ошибка базы данных: " + e.getMessage()
            ));
            ctx.redirect(NamedRoutes.coursesPath());
        }
    }

    public static void show(Context ctx) {
        try {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var course = CourseRepository.find(id)
                                         .orElseThrow(() -> new NotFoundResponse("Course not found"));
            var page = new CoursePage(course);

            var flash = ctx.consumeSessionAttribute("flash");
            if (flash instanceof Map) {
                page.setFlash((Map<String, String>) flash);
            } else if (flash != null) {
                page.setFlash(Map.of("message", String.valueOf(flash), "type", "info"));
            }

            ctx.render("courses/show.jte", Map.of("page", page));
        } catch (SQLException e) {
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Ошибка базы данных при получении курса"
            ));
            ctx.redirect(NamedRoutes.coursesPath());
        }
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage(null, "", "", Map.of());

        var flash = ctx.consumeSessionAttribute("flash");
        if (flash instanceof Map) {
            page.setFlash((Map<String, String>) flash);
        } else if (flash != null) {
            page.setFlash(Map.of("message", String.valueOf(flash), "type", "info"));
        }

        ctx.render("courses/build.jte", Map.of("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        if (name == null) name = "";
        else name = name.trim();

        var description = ctx.formParam("description");
        if (description == null) description = "";
        else description = description.trim();

        try {
            ctx.formParamAsClass("name", String.class)
               .check(n -> n.length() > 2, "Название должно быть длиннее 2 символов")
               .get();

            ctx.formParamAsClass("description", String.class)
               .check(d -> d.length() > 10, "Описание должно быть длиннее 10 символов")
               .get();

            var course = new Course(name, description);
            CourseRepository.save(course);

            ctx.sessionAttribute("flash", Map.of(
                "message", "Курс успешно создан!",
                "type", "success"
            ));

            ctx.redirect(NamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var page = new BuildCoursePage(null, name, description, e.getErrors());

            ctx.sessionAttribute("flash", Map.of(
                "message", "Ошибка при создании курса",
                "type", "danger"
            ));

            ctx.render("courses/build.jte", Map.of("page", page));
        } catch (SQLException e) {
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Ошибка базы данных при создании курса"
            ));
            ctx.redirect(NamedRoutes.coursesPath());
        }
    }

    public static void edit(Context ctx) {
        try {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var course = CourseRepository.find(id)
                                         .orElseThrow(() -> new NotFoundResponse("Course not found"));
            var page = new BuildCoursePage(course.getId(), course.getName(), course.getDescription(), Map.of());

            var flash = ctx.consumeSessionAttribute("flash");
            if (flash instanceof Map) {
                page.setFlash((Map<String, String>) flash);
            } else if (flash != null) {
                page.setFlash(Map.of("message", String.valueOf(flash), "type", "info"));
            }

            ctx.render("courses/edit.jte", Map.of("page", page));
        } catch (SQLException e) {
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Ошибка базы данных при получении курса для редактирования"
            ));
            ctx.redirect(NamedRoutes.coursesPath());
        }
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = ctx.formParam("name");
        if (name == null) name = "";
        else name = name.trim();

        var description = ctx.formParam("description");
        if (description == null) description = "";
        else description = description.trim();

        try {
            ctx.formParamAsClass("name", String.class)
               .check(n -> n.length() > 2, "Название должно быть длиннее 2 символов")
               .get();

            ctx.formParamAsClass("description", String.class)
               .check(d -> d.length() > 10, "Описание должно быть длиннее 10 символов")
               .get();

            var course = CourseRepository.find(id)
                                         .orElseThrow(() -> new NotFoundResponse("Course not found"));
            course.setName(name);
            course.setDescription(description);
            CourseRepository.save(course);

            ctx.sessionAttribute("flash", Map.of(
                "message", "Курс успешно обновлен!",
                "type", "success"
            ));

            ctx.redirect(NamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var page = new BuildCoursePage(id, name, description, e.getErrors());

            ctx.sessionAttribute("flash", Map.of(
                "message", "Ошибка при обновлении курса",
                "type", "danger"
            ));

            ctx.render("courses/edit.jte", Map.of("page", page));
        } catch (SQLException e) {
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Ошибка базы данных при обновлении курса"
            ));
            ctx.redirect(NamedRoutes.coursesPath());
        }
    }

    public static void destroy(Context ctx) {
        String idStr = ctx.pathParam("id");
        try {
            Long id = Long.parseLong(idStr);
            CourseRepository.delete(id);

            ctx.sessionAttribute("flash", Map.of(
                "type", "success",
                "message", "Курс успешно удалён"
            ));
        } catch (NumberFormatException e) {
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Неверный ID курса"
            ));
        } catch (SQLException e) {
            ctx.sessionAttribute("flash", Map.of(
                "type", "danger",
                "message", "Ошибка базы данных при удалении курса"
            ));
        }

        ctx.redirect(NamedRoutes.coursesPath());
    }
}
