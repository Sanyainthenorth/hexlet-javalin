package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;

import java.util.Map;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CoursesController {

    public static void index(Context ctx) {
        String term = ctx.queryParam("term");
        var courses = CourseRepository.search(term);
        var page = new CoursesPage(courses, "Каталог курсов", term);
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                                     .orElseThrow(() -> new NotFoundResponse("Course with id = " + id + " not found"));
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage(null, "", "", Map.of());
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void create(Context ctx) {
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
            // id отсутствует при создании нового курса, передаем null
            var page = new BuildCoursePage(null, name, description, e.getErrors());
            ctx.render("courses/build.jte", model("page", page));
        }
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                                     .orElseThrow(() -> new NotFoundResponse("Course with id = " + id + " not found"));
        var page = new BuildCoursePage(course.getId(), course.getName(), course.getDescription(), Map.of());
        ctx.render("courses/edit.jte", model("page", page));
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var name = ctx.formParam("name").trim();
        var description = ctx.formParam("description").trim();

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

            ctx.redirect(NamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var page = new BuildCoursePage(id, name, description, e.getErrors());
            ctx.render("courses/edit.jte", model("page", page));
        }
    }



    public static void destroyByPost(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        CourseRepository.delete(id);
        ctx.redirect(NamedRoutes.coursesPath());
    }
}
