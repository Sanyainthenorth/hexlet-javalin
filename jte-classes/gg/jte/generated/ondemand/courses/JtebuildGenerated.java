package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.BuildCoursePage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,7,7,10,10,11,11,12,12,12,13,13,14,14,17,17,24,24,24,24,24,24,24,24,24,30,30,30,36,36,36,36,36,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildCoursePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"container mt-5\">\n            ");
				if (page.getErrors() != null && !page.getErrors().isEmpty()) {
					jteOutput.writeContent("\n                <div class=\"alert alert-danger\">\n                    <ul class=\"mb-0\">\n                        ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\n                            ");
						for (var error : validator) {
							jteOutput.writeContent("\n                                <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\n                            ");
						}
						jteOutput.writeContent("\n                        ");
					}
					jteOutput.writeContent("\n                    </ul>\n                </div>\n            ");
				}
				jteOutput.writeContent("\n\n            <form action=\"/courses\" method=\"post\">\n                <div class=\"mb-3\">\n                    <label class=\"form-label\">\n                        Название курса\n                        <input type=\"text\" name=\"name\" class=\"form-control\"");
				var __jte_html_attribute_0 =  page.getName() != null ? page.getName() : "" ;
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" required>\n                    </label>\n                </div>\n                <div class=\"mb-3\">\n                    <label class=\"form-label\">\n                        Описание\n                        <textarea name=\"description\" class=\"form-control\" required>");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(page.getDescription() != null ? page.getDescription() : "");
				jteOutput.writeContent("</textarea>\n                    </label>\n                </div>\n                <input type=\"submit\" value=\"Создать курс\" class=\"btn btn-primary\">\n            </form>\n        </div>\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
