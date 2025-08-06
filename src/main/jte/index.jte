@import org.example.hexlet.dto.MainPage
@import org.example.hexlet.NamedRoutes
@param MainPage page

@template.layout.page(
    content = @`
        <div class="container">
            <h1>Добро пожаловать на сайт Сашеньки!</h1>
            <p>Это мой учебный проект по веб-разработке на Java</p>

            @if(!page.isVisited())
                <div class="alert alert-info mt-3">
                    <h4>Привет, новый посетитель!</h4>
                    <p>Это твой первый визит на мой сайт! Надеюсь, тебе здесь понравится :)</p>
                    <p>Здесь я учусь веб-разработке на Java с Javalin.</p>
                </div>
            @else
                <div class="alert alert-light mt-3">
                    <p>Рада снова тебя видеть! Ты уже был(а) здесь раньше.</p>
                </div>
            @endif

            @if(page.getCurrentUser() != null)
                <div class="card mt-4">
                    <div class="card-body">
                        <h5 class="card-title">Привет, ${page.getCurrentUser()}!</h5>
                        <p class="card-text">Вы вошли в систему.</p>
                        <form action="${NamedRoutes.sessionsPath()}" method="post">
                            <input type="hidden" name="_method" value="DELETE">
                            <button type="submit" class="btn btn-danger">Выйти</button>
                        </form>
                    </div>
                </div>
            @else
                <div class="mt-4">
                    <a href="${NamedRoutes.buildSessionPath()}" class="btn btn-primary">Войти</a>
                </div>
            @endif
        </div>
    `
)