@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.NamedRoutes

@param CoursePage page

@template.layout.page(
    content = @`
        <div class="container mt-5">
            <div class="card">
                <div class="card-body">
                    <h1 class="card-title">${page.getCourse().getName()}</h1>
                    <p class="card-text">${page.getCourse().getDescription()}</p>

                    <div class="mt-4">
                        <a href="${NamedRoutes.coursesPath()}" class="btn btn-primary me-2">
                            <i class="bi bi-arrow-left"></i> Назад к списку
                        </a>
                        <a href="${NamedRoutes.editCoursePath(page.getCourse().getId())}"
                           class="btn btn-warning me-2">
                            <i class="bi bi-pencil"></i> Редактировать
                        </a>
                        <form action="${NamedRoutes.coursePath(page.getCourse().getId())}"
                              method="post" class="d-inline">
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
    `
)