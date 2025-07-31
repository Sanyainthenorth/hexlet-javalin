@import org.example.hexlet.dto.users.BuildUserPage
@import org.example.hexlet.NamedRoutes

@param BuildUserPage page

@template.layout.page(
    content = @`
        <div class="container mt-5">
            <h1>Редактирование пользователя</h1>

            <form action="${NamedRoutes.userPath(page.getId())}" method="post">
                <input type="hidden" name="_method" value="patch">

                <div class="mb-3">
                    <label class="form-label">
                        Имя
                        <input type="text" name="name" value="${page.getName()}" class="form-control">
                    </label>
                    @if (page.getError("name") != null)
                        <div class="text-danger">${page.getError("name")}</div>
                    @endif
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Email
                        <input type="email" name="email" value="${page.getEmail()}" class="form-control">
                    </label>
                    @if (page.getError("email") != null)
                        <div class="text-danger">${page.getError("email")}</div>
                    @endif
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Новый пароль (оставьте пустым, если не хотите менять)
                        <input type="password" name="password" class="form-control">
                    </label>
                    @if (page.getError("password") != null)
                        <div class="text-danger">${page.getError("password")}</div>
                    @endif
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Подтверждение пароля
                        <input type="password" name="passwordConfirmation" class="form-control">
                    </label>
                </div>

                <button type="submit" class="btn btn-primary">Сохранить</button>
                <a href="${NamedRoutes.usersPath()}" class="btn btn-secondary">Отмена</a>
            </form>
        </div>
    `
)