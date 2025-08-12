@import org.example.hexlet.dto.users.UserPage
@import org.example.hexlet.NamedRoutes

@param UserPage page

@template.layout.page(
    content = @`
        <div class="container mt-5">
            <!-- Flash-сообщение -->
            @if (page.getFlash() != null)
                <div class="alert alert-${page.getFlash().get("type")} alert-dismissible fade show mb-4">
                    ${page.getFlash().get("message")}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            @endif

            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h1 class="card-title mb-0">
                        <i class="bi bi-person"></i> Пользователь: ${page.getUser().getName()}
                    </h1>
                </div>
                <div class="card-body">
                    <div class="mb-4">
                        <h5 class="mb-3"><i class="bi bi-info-circle"></i> Детали:</h5>
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <tbody>
                                    <tr>
                                        <th scope="row" class="w-25">ID</th>
                                        <td>${page.getUser().getId()}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Email</th>
                                        <td>${page.getUser().getEmail()}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Дата регистрации</th>
                                        <td>${page.getUser().getCreatedAt()}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="d-flex justify-content-start gap-2">
                        <a href="${NamedRoutes.usersPath()}" class="btn btn-outline-secondary">
                            <i class="bi bi-arrow-left"></i> Назад к списку
                        </a>
                        <a href="${NamedRoutes.editUserPath(page.getUser().getId())}" class="btn btn-outline-warning">
                            <i class="bi bi-pencil"></i> Редактировать
                        </a>
                        <form action="${NamedRoutes.deleteUserPath(page.getUser().getId())}"
                              method="post"
                              class="d-inline"
                              onsubmit="return confirm('Вы уверены, что хотите удалить этого пользователя?')">
                            <button type="submit" class="btn btn-outline-danger">
                                <i class="bi bi-trash"></i> Удалить
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    `,
    page = page
)