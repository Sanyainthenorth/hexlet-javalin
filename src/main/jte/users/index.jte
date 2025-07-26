@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <h1>Список пользователей</h1>

        <a href="/users/new" class="btn">Создать пользователя</a>

        @if(page.getUsers().isEmpty())
            <p>Пользователи не найдены</p>
        @else
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Имя</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    @for(var user : page.getUsers())
                        <tr>
                            <td>${user.getId()}</td>
                            <td><a href="/users/${user.getId()}">${user.getName()}</a></td>
                            <td>${user.getEmail()}</td>
                        </tr>
                    @endfor
                </tbody>
            </table>
        @endif
    `
)