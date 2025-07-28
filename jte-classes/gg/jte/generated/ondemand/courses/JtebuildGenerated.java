package gg.jte.generated.ondemand.courses;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {30,30,30,30,30,30,30,30,30,30,30};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<!DOCTYPE html>\n<html>\n<head>\n    <meta charset=\"UTF-8\">\n    <title>Добавить курс</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n</head>\n<body>\n<div class=\"container mt-5\">\n    <h1>Добавить новый курс</h1>\n\n    <form action=\"/courses\" method=\"post\">\n        <div class=\"mb-3\">\n            <label class=\"form-label\">\n                Название курса\n                <input type=\"text\" name=\"name\" class=\"form-control\" required>\n            </label>\n        </div>\n\n        <div class=\"mb-3\">\n            <label class=\"form-label\">\n                Описание\n                <textarea name=\"description\" class=\"form-control\" required></textarea>\n            </label>\n        </div>\n\n        <input type=\"submit\" value=\"Создать курс\" class=\"btn btn-primary\">\n    </form>\n</div>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
