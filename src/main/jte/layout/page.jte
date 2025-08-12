@import gg.jte.Content
@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.BasePage

@param Content content
@param BasePage page = null

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sasha Courses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <style>
        :root {
            --primary-color: #0d6efd;
            --secondary-color: #f8f9fa;
            --hover-color: #0b5ed7;
        }

        .navbar-custom {
            background-color: var(--primary-color);
            box-shadow: 0 0.15rem 1.75rem 0 rgba(33, 37, 41, 0.1);
            padding: 0.8rem 0;
        }

        .navbar-custom .nav-link {
            color: white;
            transition: all 0.2s ease;
            padding: 0.5rem 1rem;
            margin: 0 0.2rem;
            border-radius: 0.25rem;
        }

        .navbar-custom .nav-link:hover {
            background-color: rgba(255, 255, 255, 0.1);
            transform: translateY(-1px);
        }

        .navbar-custom .btn-outline-light:hover {
            color: var(--primary-color);
            background-color: white;
        }

        footer {
            background-color: var(--secondary-color);
            padding: 1.5rem 0;
            margin-top: 3rem;
        }

        main {
            min-height: calc(100vh - 120px);
            padding: 2rem 0;
        }

        .nav-link.active {
            font-weight: 600;
            background-color: rgba(255, 255, 255, 0.15) !important;
        }

        .nav-link.active::after {
            content: '';
            display: block;
            width: 100%;
            height: 2px;
            background-color: white;
            margin-top: 0.2rem;
            animation: underline 0.3s ease;
        }

        @keyframes underline {
            from { width: 0; }
            to { width: 100%; }
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark navbar-custom mb-4">
        <div class="container">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${NamedRoutes.rootPath()}">Главная</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${NamedRoutes.coursesPath()}">Курсы</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${NamedRoutes.usersPath()}">Пользователи</a>
                    </li>
                </ul>
                <div class="d-flex">
                    <a href="/login" class="btn btn-outline-light me-2">Войти</a>
                    <a href="/register" class="btn btn-light">Регистрация</a>
                </div>
            </div>
        </div>
    </nav>

    <main class="container">
        @if(page != null && page.getFlash() != null && !page.getFlash().isEmpty())
            <div class="alert alert-${page.getFlash().get("type")} alert-dismissible fade show mt-3" role="alert">
                ${page.getFlash().get("message")}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        @endif

        ${content}
    </main>

    <footer class="text-center">
        <div class="container">
            <p class="mb-0 text-muted">© 2025 Sasha Courses. Все права защищены.</p>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const currentPath = window.location.pathname;
            const navLinks = document.querySelectorAll('.nav-link:not(.btn)');

            navLinks.forEach(link => {
                const linkPath = link.getAttribute('href');
                if (currentPath === linkPath ||
                   (linkPath !== '/' && currentPath.startsWith(linkPath))) {
                    link.classList.add('active');
                }
            });
        });
    </script>
</body>
</html>