package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.model.Course;
import gg.jte.Content;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,7,7,10,10,13,13,13,14,14,14,14,14,14,14,14,14,19,19,21,21,21,22,22,22,22,22,22,22,22,22,24,24,26,26,28,28,40,40,42,42,42,43,43,43,44,44,44,47,47,47,47,47,47,47,47,47,51,51,51,51,51,51,51,51,51,55,55,55,55,55,55,55,55,55,66,66,70,70,72,72,72,72,72,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"container mt-3\">\n            <div class=\"d-flex justify-content-between align-items-center mb-4\">\n                <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getHeader());
				jteOutput.writeContent("</h1>\n                <a");
				var __jte_html_attribute_0 = NamedRoutes.buildCoursePath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-success\">\n                    <i class=\"bi bi-plus-lg\"></i> Добавить курс\n                </a>\n            </div>\n\n            ");
				if (page.getTerm() != null && !page.getTerm().isEmpty()) {
					jteOutput.writeContent("\n                <div class=\"alert alert-info mb-3\">\n                    Результаты поиска по запросу: \"");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getTerm());
					jteOutput.writeContent("\"\n                    <a");
					var __jte_html_attribute_1 = NamedRoutes.coursesPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" class=\"float-end\">Сбросить поиск</a>\n                </div>\n            ");
				}
				jteOutput.writeContent("\n\n            ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\n                <div class=\"alert alert-warning\">Курсы не найдены</div>\n            ");
				} else {
					jteOutput.writeContent("\n                <div class=\"table-responsive\">\n                    <table class=\"table table-striped table-hover align-middle\">\n                        <thead class=\"table-dark\">\n                            <tr>\n                                <th>ID</th>\n                                <th>Название</th>\n                                <th>Описание</th>\n                                <th class=\"text-end\">Действия</th>\n                            </tr>\n                        </thead>\n                        <tbody>\n                            ");
					for (Course course : page.getCourses()) {
						jteOutput.writeContent("\n                                <tr>\n                                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(course.getId());
						jteOutput.writeContent("</td>\n                                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(course.getName());
						jteOutput.writeContent("</td>\n                                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(course.getDescription());
						jteOutput.writeContent("</td>\n                                    <td class=\"text-end\">\n                                        <div class=\"btn-group\" role=\"group\">\n                                            <a");
						var __jte_html_attribute_2 = NamedRoutes.coursePath(course.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_2);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent("\n                                               class=\"btn btn-sm btn-outline-primary\">\n                                                <i class=\"bi bi-eye\"></i>\n                                            </a>\n                                            <a");
						var __jte_html_attribute_3 = NamedRoutes.editCoursePath(course.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_3);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent("\n                                               class=\"btn btn-sm btn-outline-warning\">\n                                                <i class=\"bi bi-pencil\"></i>\n                                            </a>\n                                            <form");
						var __jte_html_attribute_4 = NamedRoutes.deleteCoursePath(course.getId().toString());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
							jteOutput.writeContent(" action=\"");
							jteOutput.setContext("form", "action");
							jteOutput.writeUserContent(__jte_html_attribute_4);
							jteOutput.setContext("form", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent("\n                                                  method=\"post\"\n                                                  class=\"d-inline\"\n                                                  onsubmit=\"return confirm('Вы точно хотите удалить курс?')\">\n                                                <button type=\"submit\" class=\"btn btn-sm btn-outline-danger\">\n                                                    <i class=\"bi bi-trash\"></i>\n                                                </button>\n                                            </form>\n                                        </div>\n                                    </td>\n                                </tr>\n                            ");
					}
					jteOutput.writeContent("\n                        </tbody>\n                    </table>\n                </div>\n            ");
				}
				jteOutput.writeContent("\n        </div>\n    ");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
