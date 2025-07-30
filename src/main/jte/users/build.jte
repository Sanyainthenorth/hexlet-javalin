@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page

@template.layout.page(
    content = @`
        <div class="container mt-5">
            @if(page.getErrors() != null && !page.getErrors().isEmpty())
                <div class="alert alert-danger">
                    <ul class="mb-0">
                        @for(var validator : page.getErrors().values())
                            @for(var error : validator)
                                <li>${error.getMessage()}</li>
                            @endfor
                        @endfor
                    </ul>
                </div>
            @endif

            <form action="/users" method="post">
                <div class="mb-3">
                    <label class="form-label">
                        Имя
                        <input type="text" name="name" class="form-control" value="${page.getName() != null ? page.getName() : ""}" required>
                    </label>
                </div>
                <div class="mb-3">
                    <label class="form-label">
                        Email
                        <input type="email" name="email" class="form-control" value="${page.getEmail() != null ? page.getEmail() : ""}" required>
                    </label>
                </div>
                <div class="mb-3">
                    <label class="form-label">
                        Пароль
                        <input type="password" name="password" class="form-control" required>
                    </label>
                </div>
                <div class="mb-3">
                    <label class="form-label">
                        Подтверждение пароля
                        <input type="password" name="passwordConfirmation" class="form-control" required>
                    </label>
                </div>
                <input type="submit" value="Зарегистрировать" class="btn btn-primary">
            </form>
        </div>
    `
)