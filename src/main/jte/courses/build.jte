@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page

<div class="container mt-5">
    @if(page.getErrors() != null && !page.getErrors().isEmpty())
        <div class="alert alert-danger">
            <ul class="mb-0">
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        </div>
    @endif

    <form action="/courses" method="post">
        <div class="mb-3">
            <label class="form-label">
                Название курса
                <input type="text" name="name" class="form-control"
                       value="${page.getName() != null ? page.getName() : ""}" required>
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Описание
                <textarea name="description" class="form-control" required>${page.getDescription() != null ? page.getDescription() : ""}</textarea>
            </label>
        </div>
        <input type="submit" value="Создать курс" class="btn btn-primary">
    </form>
</div>