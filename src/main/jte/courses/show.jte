@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.NamedRoutes

@param CoursePage page

@template.layout.page(
    page = page,
    content = @`
        <div class="container mt-3">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h2 class="card-title mb-0">${page.getCourse().getName()}</h2>
                </div>
                <div class="card-body">
                    <h5 class="card-subtitle mb-3 text-muted">Описание курса</h5>
                    <p class="card-text">${page.getCourse().getDescription()}</p>
                </div>
                <div class="card-footer bg-transparent">
                    <div class="d-flex justify-content-between">
                        <a href="${NamedRoutes.coursesPath()}" class="btn btn-outline-secondary">
                            <i class="bi bi-arrow-left"></i> Назад к списку
                        </a>
                        <div class="btn-group">
                            <a href="${NamedRoutes.editCoursePath(page.getCourse().getId())}"
                               class="btn btn-warning">
                                <i class="bi bi-pencil"></i> Редактировать
                            </a>
                            <form action="${NamedRoutes.coursePath(page.getCourse().getId())}"
                                  method="post" class="ms-2">
                                <input type="hidden" name="_method" value="delete">
                                <button type="submit" class="btn btn-danger"
                                        onclick="return confirm('Вы уверены, что хотите удалить этот курс?')">
                                    <i class="bi bi-trash"></i> Удалить
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    `
)