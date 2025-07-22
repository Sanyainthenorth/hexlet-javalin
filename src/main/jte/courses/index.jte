@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

<!DOCTYPE html>
<html>
<head>
    <title>${page.getHeader()}</title>
</head>
<body>
    <h1>${page.getHeader()}</h1>

    @if(page.getCourses().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
    @else
        <ul>
        @for(var course : page.getCourses())
            <li>
                <a href="/courses/${course.getId()}">${course.getName()}</a>
                - ${course.getDescription()}
            </li>
        @endfor
        </ul>
    @endif
</body>
</html>