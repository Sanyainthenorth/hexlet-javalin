@import org.example.hexlet.dto.users.BuildUserPage
@import org.example.hexlet.NamedRoutes

@param BuildUserPage page


@template.layout.page(
    content = @`
        <div class="container mt-5">
            <h1>Создание пользователя</h1>

            <form action="${NamedRoutes.usersPath()}" method="post" class="mt-4">
                <div class="mb-3">
                    <label class="form-label">
                        Имя
                        <input type="text" name="name" value="${page.getName()}" class="form-control">
                    </label>
                    @if (page.getError("name") != null)
                        <div class="text-danger mt-1">${page.getError("name")}</div>
                    @endif
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Email
                        <input type="email" name="email" value="${page.getEmail()}" class="form-control">
                    </label>
                    @if (page.getError("email") != null)
                        <div class="text-danger mt-1">${page.getError("email")}</div>
                    @endif
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Пароль
                        <input type="password" name="password" class="form-control">
                    </label>
                    @if (page.getError("password") != null)
                        <div class="text-danger mt-1">${page.getError("password")}</div>
                    @endif
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Подтверждение пароля
                        <input type="password" name="passwordConfirmation" class="form-control">
                    </label>
                </div>

                <button type="submit" class="btn btn-primary">Создать</button>
            </form>
        </div>
    `
)