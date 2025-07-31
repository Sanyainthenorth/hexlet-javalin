@import org.example.hexlet.dto.courses.BuildCoursePage
@import org.example.hexlet.NamedRoutes

@param BuildCoursePage page

@template.layout.page(
    content = @`
        <div class="container mt-5">
            <h1>Редактирование курса</h1>

            <form action="${NamedRoutes.coursePath(page.getId())}" method="post" class="mt-4">
                <!-- УДАЛИЛИ <input type="hidden" name="_method" value="patch"> -->

                <div class="mb-3">
                    <label class="form-label">
                        Название
                        <input type="text" name="name" value="${page.getName()}" class="form-control" required>
                    </label>
                    @if (page.getError("name") != null)
                        <div class="text-danger mt-1">${page.getError("name")}</div>
                    @endif
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Описание
                        <textarea name="description" class="form-control" required>${page.getDescription()}</textarea>
                    </label>
                    @if (page.getError("description") != null)
                        <div class="text-danger mt-1">${page.getError("description")}</div>
                    @endif
                </div>

                <button type="submit" class="btn btn-primary">Сохранить</button>
                <a href="${NamedRoutes.coursesPath()}" class="btn btn-secondary ms-2">Отмена</a>
            </form>
        </div>
    `
)
