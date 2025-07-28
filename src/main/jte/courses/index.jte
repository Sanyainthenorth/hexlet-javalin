@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.model.Course
@param CoursesPage page

<div class="container mt-5">
    <h1>${page.getHeader()}</h1>

    <form action="/courses" method="get" class="mb-4">
        <div class="input-group">
            <input type="text" name="term" class="form-control"
                   placeholder="Поиск по названию" value="${page.getTerm() != null ? page.getTerm() : ""}">
            <button class="btn btn-outline-secondary" type="submit">Искать</button>
        </div>
    </form>

    <a href="/courses/build" class="btn btn-success mb-3">Добавить курс</a>

    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Описание</th>
            </tr>
        </thead>
        <tbody>
            @for(Course course : page.getCourses())
                <tr>
                    <td>${course.getId()}</td>
                    <td><a href="/courses/${course.getId()}">${course.getName()}</a></td>
                    <td>${course.getDescription()}</td>
                </tr>
            @endfor
        </tbody>
    </table>
</div>