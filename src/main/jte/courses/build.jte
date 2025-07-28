<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить курс</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Добавить новый курс</h1>

    <form action="/courses" method="post">
        <div class="mb-3">
            <label class="form-label">
                Название курса
                <input type="text" name="name" class="form-control" required>
            </label>
        </div>

        <div class="mb-3">
            <label class="form-label">
                Описание
                <textarea name="description" class="form-control" required></textarea>
            </label>
        </div>

        <input type="submit" value="Создать курс" class="btn btn-primary">
    </form>
</div>
</body>
</html>