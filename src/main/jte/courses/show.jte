@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

<!DOCTYPE html>
<html>
<head>
    <title>${page.getCourse().getName()}</title>
</head>
<body>
    <h1>${page.getCourse().getName()}</h1>
    <p>${page.getCourse().getDescription()}</p>
    <a href="/courses">Назад к списку курсов</a>
</body>
</html>