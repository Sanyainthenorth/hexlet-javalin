@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.model.User
@import org.example.hexlet.NamedRoutes

@param UsersPage page

@template.layout.page(
    content = @`
       <div class="container mt-5">
           <div class="d-flex justify-content-between align-items-center mb-4">
               <h1 class="mb-0">Список пользователей</h1>
               <a href="${NamedRoutes.buildUserPath()}" class="btn btn-success">
                   <i class="bi bi-plus-lg"></i> Добавить пользователя
               </a>
           </div>

           @if (page.getUsers().isEmpty())
               <div class="alert alert-info">
                   <i class="bi bi-info-circle"></i> Пользователи не найдены
               </div>
           @else
               <div class="table-responsive">
                   <table class="table table-striped table-hover align-middle">
                       <thead class="table-dark">
                           <tr>
                               <th>ID</th>
                               <th>Имя</th>
                               <th>Email</th>
                               <th class="text-end">Действия</th>
                           </tr>
                       </thead>
                       <tbody>
                           @for(User user : page.getUsers())
                               <tr>
                                   <td>${user.getId()}</td>
                                   <td>${user.getName()}</td>
                                   <td>${user.getEmail()}</td>
                                   <td class="text-end">
                                       <div class="btn-group" role="group" aria-label="Действия с пользователем">
                                           <a href="${NamedRoutes.userPath(user.getId())}"
                                              class="btn btn-sm btn-outline-primary"
                                              title="Просмотр">
                                               <i class="bi bi-eye"></i>
                                           </a>
                                           <a href="${NamedRoutes.editUserPath(user.getId())}"
                                              class="btn btn-sm btn-outline-warning"
                                              title="Редактировать">
                                               <i class="bi bi-pencil"></i>
                                           </a>
                                           <form action="${NamedRoutes.deleteUserPath(user.getId())}"
                                                 method="post"
                                                 class="d-inline"
                                                 onsubmit="return confirm('Вы уверены, что хотите удалить этого пользователя?')">
                                               <button type="submit"
                                                       class="btn btn-sm btn-outline-danger"
                                                       title="Удалить">
                                                   <i class="bi bi-trash"></i>
                                               </button>
                                           </form>
                                       </div>
                                   </td>
                               </tr>
                           @endfor
                       </tbody>
                   </table>
               </div>
           @endif
       </div>
    `,
    page = page
)