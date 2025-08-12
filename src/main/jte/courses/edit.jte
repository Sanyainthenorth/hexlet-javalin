@import org.example.hexlet.dto.courses.BuildCoursePage
@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.model.Course

@param BuildCoursePage page

@template.layout.page(
    content = @`
        <div class="container mt-3">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h1 class="card-title mb-0">Редактирование курса</h1>
                </div>
                <div class="card-body">
                    <form action="${NamedRoutes.coursePath(page.getId())}" method="post">
                        <input type="hidden" name="_method" value="patch">

                        <div class="mb-3">
                            <label for="name" class="form-label">Название курса</label>
                            <input type="text"
                                   class="form-control ${page.getError("name") != null ? "is-invalid" : ""}"
                                   id="name"
                                   name="name"
                                   value="${page.getName()}"
                                   required>
                            @if (page.getError("name") != null)
                                <div class="invalid-feedback">${page.getError("name")}</div>
                            @endif
                        </div>

                        <div class="mb-3">
                            <label for="description" class="form-label">Описание курса</label>
                            <textarea class="form-control ${page.getError("description") != null ? "is-invalid" : ""}"
                                      id="description"
                                      name="description"
                                      rows="5"
                                      required>${page.getDescription()}</textarea>
                            @if (page.getError("description") != null)
                                <div class="invalid-feedback">${page.getError("description")}</div>
                            @endif
                        </div>

                        <div class="d-flex justify-content-end gap-2">
                            <a href="${NamedRoutes.coursesPath()}" class="btn btn-outline-secondary">
                                <i class="bi bi-x-lg"></i> Отмена
                            </a>
                            <button type="submit" class="btn btn-primary">
                                <i class="bi bi-save"></i> Сохранить
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    `,
    page = page
)