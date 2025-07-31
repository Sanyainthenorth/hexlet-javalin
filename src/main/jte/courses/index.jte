@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.model.Course
@import org.example.hexlet.NamedRoutes

@param CoursesPage page

@template.layout.page(
    content = @`
        <div class="container mt-5">
            <h1>Список курсов</h1>

            <a href="${NamedRoutes.buildCoursePath()}" class="btn btn-success mb-3">Добавить курс</a>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Название</th>
                        <th>Описание</th>
                        <th>Действия</th>
                    </tr>
                </thead>
                <tbody>
                    @for(Course course : page.getCourses())
                        <tr>
                            <td>${course.getId()}</td>
                            <td>${course.getName()}</td>
                            <td>${course.getDescription()}</td>
                            <td>
                                <a href="${NamedRoutes.coursePath(course.getId())}" class="btn btn-primary btn-sm">Просмотр</a>
                                <a href="${NamedRoutes.editCoursePath(course.getId())}" class="btn btn-warning btn-sm">Редактировать</a>
                                <form action="${NamedRoutes.coursePath(course.getId())}/delete" method="post" class="d-inline">
                                    <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Удалить курс?')">Удалить</button>
                                </form>
                            </td>
                        </tr>
                    @endfor
                </tbody>
            </table>
        </div>
    `
)

