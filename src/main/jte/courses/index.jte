@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.model.Course
@import gg.jte.Content

@param CoursesPage page

@template.layout.page(
    content = @`
        <div class="container mt-3">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h1>${page.getHeader()}</h1>
                <a href="${NamedRoutes.buildCoursePath()}" class="btn btn-success">
                    <i class="bi bi-plus-lg"></i> Добавить курс
                </a>
            </div>

            @if (page.getTerm() != null && !page.getTerm().isEmpty())
                <div class="alert alert-info mb-3">
                    Результаты поиска по запросу: "${page.getTerm()}"
                    <a href="${NamedRoutes.coursesPath()}" class="float-end">Сбросить поиск</a>
                </div>
            @endif

            @if (page.getCourses().isEmpty())
                <div class="alert alert-warning">Курсы не найдены</div>
            @else
                <div class="table-responsive">
                    <table class="table table-striped table-hover align-middle">
                        <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Название</th>
                                <th>Описание</th>
                                <th class="text-end">Действия</th>
                            </tr>
                        </thead>
                        <tbody>
                            @for(Course course : page.getCourses())
                                <tr>
                                    <td>${course.getId()}</td>
                                    <td>${course.getName()}</td>
                                    <td>${course.getDescription()}</td>
                                    <td class="text-end">
                                        <div class="btn-group" role="group">
                                            <a href="${NamedRoutes.coursePath(course.getId())}"
                                               class="btn btn-sm btn-outline-primary">
                                                <i class="bi bi-eye"></i>
                                            </a>
                                            <a href="${NamedRoutes.editCoursePath(course.getId())}"
                                               class="btn btn-sm btn-outline-warning">
                                                <i class="bi bi-pencil"></i>
                                            </a>
                                            <form action="${NamedRoutes.deleteCoursePath(course.getId().toString())}"
                                                  method="post"
                                                  class="d-inline"
                                                  onsubmit="return confirm('Вы точно хотите удалить курс?')">
                                                <button type="submit" class="btn btn-sm btn-outline-danger">
                                                    <i class="bi bi-trash"></i>
                                                </button>
                                            </form>
                                        </div>
                                    </td>
                                </tr>
                            @endfor
                        </tbody>
                    </table>
                </div>
            @endif
        </div>
    `,
    page = page
)