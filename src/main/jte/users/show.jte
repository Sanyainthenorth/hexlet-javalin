@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <h1>Профиль пользователя</h1>

        <div class="user-profile">
            <p><strong>ID:</strong> ${page.getUser().getId()}</p>
            <p><strong>Имя:</strong> ${page.getUser().getName()}</p>
            <p><strong>Email:</strong> ${page.getUser().getEmail()}</p>
        </div>

        <div class="actions">
            <a href="/users/${page.getUser().getId()}/edit" class="btn">Редактировать</a>
            <a href="/users" class="btn">Назад к списку</a>
        </div>
    `
)