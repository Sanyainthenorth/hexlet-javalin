@import org.example.hexlet.NamedRoutes

@template.layout.page(
    content = @`
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header">
                            <h4>Вход в систему</h4>
                        </div>
                        <div class="card-body">
                            <form action="${NamedRoutes.sessionsPath()}" method="post">
                                <div class="mb-3">
                                    <label for="nickname" class="form-label">Никнейм</label>
                                    <input type="text" class="form-control" id="nickname" name="nickname" required>
                                </div>
                                <div class="mb-3">
                                    <label for="password" class="form-label">Пароль</label>
                                    <input type="password" class="form-control" id="password" name="password" required>
                                </div>
                                <button type="submit" class="btn btn-primary">Войти</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    `
)