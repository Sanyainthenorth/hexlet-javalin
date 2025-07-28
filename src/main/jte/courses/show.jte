@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

<div class="container mt-5">
    <h1>${page.getCourse().getName()}</h1>
    <p>${page.getCourse().getDescription()}</p>
    <a href="/courses" class="btn btn-primary">Назад к списку</a>
</div>