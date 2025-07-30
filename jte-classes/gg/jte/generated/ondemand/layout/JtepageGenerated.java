package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.NamedRoutes;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,83,83,83,83,83,83,83,83,83,83,86,86,86,86,86,86,86,86,86,89,89,89,89,89,89,89,89,89,101,101,101,126,126,126,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <title>Sasha Courses</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n    <style>\n        :root {\n            --primary-color: #0d6efd;\n            --secondary-color: #f8f9fa;\n            --hover-color: #0b5ed7;\n        }\n\n        .navbar-custom {\n            background-color: var(--primary-color);\n            box-shadow: 0 0.15rem 1.75rem 0 rgba(33, 37, 41, 0.1);\n            padding: 0.8rem 0;\n        }\n\n        .navbar-custom .nav-link {\n            color: white;\n            transition: all 0.2s ease;\n            padding: 0.5rem 1rem;\n            margin: 0 0.2rem;\n            border-radius: 0.25rem;\n        }\n\n        .navbar-custom .nav-link:hover {\n            background-color: rgba(255, 255, 255, 0.1);\n            transform: translateY(-1px);\n        }\n\n        .navbar-custom .btn-outline-light:hover {\n            color: var(--primary-color);\n            background-color: white;\n        }\n\n        footer {\n            background-color: var(--secondary-color);\n            padding: 1.5rem 0;\n            margin-top: 3rem;\n        }\n\n        main {\n            min-height: calc(100vh - 120px);\n            padding: 2rem 0;\n        }\n\n        .nav-link.active {\n            font-weight: 600;\n            background-color: rgba(255, 255, 255, 0.15) !important;\n        }\n\n        .nav-link.active::after {\n            content: '';\n            display: block;\n            width: 100%;\n            height: 2px;\n            background-color: white;\n            margin-top: 0.2rem;\n            animation: underline 0.3s ease;\n        }\n\n        @keyframes underline {\n            from { width: 0; }\n            to { width: 100%; }\n        }\n    </style>\n</head>\n<body>\n    <nav class=\"navbar navbar-expand-lg navbar-dark navbar-custom mb-4\">\n        <div class=\"container\">\n            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\">\n                <span class=\"navbar-toggler-icon\"></span>\n            </button>\n            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n                <ul class=\"navbar-nav me-auto\">\n                    <li class=\"nav-item\">\n                        <a class=\"nav-link\"");
		var __jte_html_attribute_0 = NamedRoutes.rootPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Главная</a>\n                    </li>\n                    <li class=\"nav-item\">\n                        <a class=\"nav-link\"");
		var __jte_html_attribute_1 = NamedRoutes.coursesPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Курсы</a>\n                    </li>\n                    <li class=\"nav-item\">\n                        <a class=\"nav-link\"");
		var __jte_html_attribute_2 = NamedRoutes.usersPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Пользователи</a>\n                    </li>\n                </ul>\n                <div class=\"d-flex\">\n                    <a href=\"/login\" class=\"btn btn-outline-light me-2\">Войти</a>\n                    <a href=\"/register\" class=\"btn btn-light\">Регистрация</a>\n                </div>\n            </div>\n        </div>\n    </nav>\n\n    <main class=\"container\">\n        ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n    </main>\n\n    <footer class=\"text-center\">\n        <div class=\"container\">\n            <p class=\"mb-0 text-muted\">© 2025 Sasha Courses. Все права защищены.</p>\n        </div>\n    </footer>\n\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n    <script>\n        document.addEventListener('DOMContentLoaded', function() {\n            const currentPath = window.location.pathname;\n            const navLinks = document.querySelectorAll('.nav-link');\n\n            navLinks.forEach(link => {\n                const linkPath = link.getAttribute('href');\n                if (currentPath === linkPath ||\n                   (linkPath !== '/' && currentPath.startsWith(linkPath))) {\n                    link.classList.add('active');\n                }\n            });\n        });\n    </script>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, content);
	}
}
