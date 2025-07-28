@import io.javalin.http.Context

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Регистрация пользователя</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Регистрация нового пользователя</h1>

        <form action="/users" method="post">
            <input type="hidden" name="_charset_" value="UTF-8">

            <div class="mb-3">
                <label class="form-label">
                    Имя
                    <input type="text" name="name" class="form-control" required>
                </label>
            </div>

            <div class="mb-3">
                <label class="form-label">
                    Email
                    <input type="email" name="email" class="form-control" required>
                </label>
            </div>

            <div class="mb-3">
                <label class="form-label">
                    Пароль
                    <input type="password" name="password" class="form-control" required minlength="6">
                </label>
            </div>

            <button type="submit" class="btn btn-primary">Зарегистрировать</button>
        </form>
    </div>
</body>
</html>