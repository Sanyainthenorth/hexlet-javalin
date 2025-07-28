@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.model.User
@param UsersPage page

<div class="container mt-5">
    <h1>Список пользователей</h1>

    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            @for(User user : page.getUsers())
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
            @endfor
        </tbody>
    </table>
</div>