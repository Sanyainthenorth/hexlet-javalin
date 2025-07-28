package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,5,5,5,5,10,10,10,10,10,10,10,10,10,26,26,28,28,28,29,29,29,29,29,29,29,30,30,30,32,32,35,35,35,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n<div class=\"container mt-5\">\n    <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</h1>\n\n    <form action=\"/courses\" method=\"get\" class=\"mb-4\">\n        <div class=\"input-group\">\n            <input type=\"text\" name=\"term\" class=\"form-control\"\n                   placeholder=\"Поиск по названию\"");
		var __jte_html_attribute_0 = page.getTerm() != null ? page.getTerm() : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">\n            <button class=\"btn btn-outline-secondary\" type=\"submit\">Искать</button>\n        </div>\n    </form>\n\n    <a href=\"/courses/build\" class=\"btn btn-success mb-3\">Добавить курс</a>\n\n    <table class=\"table\">\n        <thead>\n            <tr>\n                <th>ID</th>\n                <th>Название</th>\n                <th>Описание</th>\n            </tr>\n        </thead>\n        <tbody>\n            ");
		for (Course course : page.getCourses()) {
			jteOutput.writeContent("\n                <tr>\n                    <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(course.getId());
			jteOutput.writeContent("</td>\n                    <td><a href=\"/courses/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(course.getId());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\">");
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(course.getName());
			jteOutput.writeContent("</a></td>\n                    <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(course.getDescription());
			jteOutput.writeContent("</td>\n                </tr>\n            ");
		}
		jteOutput.writeContent("\n        </tbody>\n    </table>\n</div>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
