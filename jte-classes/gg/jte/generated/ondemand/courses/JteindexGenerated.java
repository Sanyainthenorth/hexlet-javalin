package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,6,6,6,6,9,9,9,11,11,13,13,15,15,17,17,17,17,17,17,17,18,18,18,20,20,22,22,24,24,24,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html>\n<head>\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</title>\n</head>\n<body>\n    <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</h1>\n\n    ");
		if (page.getCourses().isEmpty()) {
			jteOutput.writeContent("\n        <p>Пока не добавлено ни одного курса</p>\n    ");
		} else {
			jteOutput.writeContent("\n        <ul>\n        ");
			for (var course : page.getCourses()) {
				jteOutput.writeContent("\n            <li>\n                <a href=\"/courses/");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(course.getId());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(course.getName());
				jteOutput.writeContent("</a>\n                - ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(course.getDescription());
				jteOutput.writeContent("\n            </li>\n        ");
			}
			jteOutput.writeContent("\n        </ul>\n    ");
		}
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
