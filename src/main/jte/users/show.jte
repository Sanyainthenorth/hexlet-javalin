@import org.example.hexlet.dto.users.UserPage
@import org.example.hexlet.NamedRoutes

@param UserPage page

@template.layout.page(
    content = @`
        <div class="container mt-5">
            <div class="card">
                <div class="card-body">
                    <h1 class="card-title">Пользователь: ${page.getUser().getName()}</h1>

                    <div class="mb-4">
                        <h5>Детали:</h5>
                        <ul class="list-group">
                            <li class="list-group-item">
                                <strong>ID:</strong> ${page.getUser().getId()}
                            </li>
                            <li class="list-group-item">
                                <strong>Email:</strong> ${page.getUser().getEmail()}
                            </li>
                        </ul>
                    </div>

                    <div class="btn-group">
                        <a href="${NamedRoutes.usersPath()}" class="btn btn-secondary">
                            Назад к списку
                        </a>
                        <a href="${NamedRoutes.editUserPath(page.getUser().getId())}" class="btn btn-warning">
                            Редактировать
                        </a>
                        <form action="${NamedRoutes.userPath(page.getUser().getId())}/delete" method="post" class="d-inline">
                            <button type="submit" class="btn btn-danger"
                                    onclick="return confirm('Удалить пользователя?')">
                                Удалить
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    `
)
