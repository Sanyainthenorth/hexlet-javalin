@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.model.User
@import org.example.hexlet.NamedRoutes

@param UsersPage page

@template.layout.page(
    content = @`
       <div class="container mt-5">
           <h1>Список пользователей</h1>

           <a href="${NamedRoutes.buildUserPath()}" class="btn btn-success mb-3">Добавить пользователя</a>

           <table class="table table-striped">
               <thead>
                   <tr>
                       <th>ID</th>
                       <th>Имя</th>
                       <th>Email</th>
                       <th>Действия</th>
                   </tr>
               </thead>
               <tbody>
                   @for(User user : page.getUsers())
                       <tr>
                           <td>${user.getId()}</td>
                           <td>${user.getName()}</td>
                           <td>${user.getEmail()}</td>
                           <td>
                               <a href="${NamedRoutes.userPath(user.getId())}" class="btn btn-primary btn-sm me-2">Просмотр</a>
                               <a href="${NamedRoutes.editUserPath(user.getId())}" class="btn btn-warning btn-sm me-2">Редактировать</a>
                               <form action="${NamedRoutes.userPath(user.getId())}/delete" method="post" class="d-inline">
                                   <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Удалить пользователя?')">
                                       Удалить
                                   </button>
                               </form>
                           </td>
                       </tr>
                   @endfor
               </tbody>
           </table>
       </div>
    `
)
