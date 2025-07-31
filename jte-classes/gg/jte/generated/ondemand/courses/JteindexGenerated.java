package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,6,6,8,8,12,12,12,12,12,12,12,12,12,24,24,26,26,26,27,27,27,28,28,28,30,30,30,30,30,30,30,30,30,31,31,31,31,31,31,31,31,31,32,32,32,32,37,37,41,41,41,43,43,43,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"container mt-5\">\n            <h1>Список курсов</h1>\n\n            <a");
				var __jte_html_attribute_0 = NamedRoutes.buildCoursePath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-success mb-3\">Добавить курс</a>\n\n            <table class=\"table table-striped\">\n                <thead>\n                    <tr>\n                        <th>ID</th>\n                        <th>Название</th>\n                        <th>Описание</th>\n                        <th>Действия</th>\n                    </tr>\n                </thead>\n                <tbody>\n                    ");
				for (Course course : page.getCourses()) {
					jteOutput.writeContent("\n                        <tr>\n                            <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(course.getId());
					jteOutput.writeContent("</td>\n                            <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(course.getName());
					jteOutput.writeContent("</td>\n                            <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(course.getDescription());
					jteOutput.writeContent("</td>\n                            <td>\n                                <a");
					var __jte_html_attribute_1 = NamedRoutes.coursePath(course.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" class=\"btn btn-primary btn-sm\">Просмотр</a>\n                                <a");
					var __jte_html_attribute_2 = NamedRoutes.editCoursePath(course.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_2);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" class=\"btn btn-warning btn-sm\">Редактировать</a>\n                                <form action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(NamedRoutes.coursePath(course.getId()));
					jteOutput.setContext("form", null);
					jteOutput.writeContent("/delete\" method=\"post\" class=\"d-inline\">\n                                    <button type=\"submit\" class=\"btn btn-danger btn-sm\" onclick=\"return confirm('Удалить курс?')\">Удалить</button>\n                                </form>\n                            </td>\n                        </tr>\n                    ");
				}
				jteOutput.writeContent("\n                </tbody>\n            </table>\n        </div>\n    ");
			}
		});
		jteOutput.writeContent("\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
