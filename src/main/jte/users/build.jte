@import org.example.hexlet.dto.users.BuildUserPage
@import org.example.hexlet.NamedRoutes

@param BuildUserPage page

@template.layout.page(
    content = @`
        <div class="container mt-5">
            <!-- Flash-сообщение -->
            @if (page.getFlash() != null)
                <div class="alert alert-${page.getFlash().get("type")} alert-dismissible fade show">
                    ${page.getFlash().get("message")}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            @endif

            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h1 class="card-title mb-0">Создание пользователя</h1>
                </div>
                <div class="card-body">
                    <form action="${NamedRoutes.usersPath()}" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label">Имя</label>
                            <input type="text"
                                   name="name"
                                   id="name"
                                   value="${page.getName()}"
                                   class="form-control ${page.getError("name") != null ? "is-invalid" : ""}">
                            @if (page.getError("name") != null)
                                <div class="invalid-feedback">${page.getError("name")}</div>
                            @endif
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email"
                                   name="email"
                                   id="email"
                                   value="${page.getEmail()}"
                                   class="form-control ${page.getError("email") != null ? "is-invalid" : ""}">
                            @if (page.getError("email") != null)
                                <div class="invalid-feedback">${page.getError("email")}</div>
                            @endif
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Пароль</label>
                            <input type="password"
                                   name="password"
                                   id="password"
                                   class="form-control ${page.getError("password") != null ? "is-invalid" : ""}">
                            @if (page.getError("password") != null)
                                <div class="invalid-feedback">${page.getError("password")}</div>
                            @endif
                        </div>

                        <div class="mb-3">
                            <label for="passwordConfirmation" class="form-label">Подтверждение пароля</label>
                            <input type="password"
                                   name="passwordConfirmation"
                                   id="passwordConfirmation"
                                   class="form-control">
                        </div>

                        <div class="d-flex justify-content-between">
                            <a href="${NamedRoutes.usersPath()}" class="btn btn-outline-secondary">
                                <i class="bi bi-arrow-left"></i> Назад
                            </a>
                            <button type="submit" class="btn btn-primary">
                                <i class="bi bi-save"></i> Создать
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    `,
    page = page
)