package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.BuildCoursePage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,4,4,4,7,7,8,8,9,9,9,10,10,11,11,14,14,21,21,21,21,21,21,21,21,21,27,27,27,32,32,32,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildCoursePage page) {
		jteOutput.writeContent("\n<div class=\"container mt-5\">\n    ");
		if (page.getErrors() != null && !page.getErrors().isEmpty()) {
			jteOutput.writeContent("\n        <div class=\"alert alert-danger\">\n            <ul class=\"mb-0\">\n                ");
			for (var validator : page.getErrors().values()) {
				jteOutput.writeContent("\n                    ");
				for (var error : validator) {
					jteOutput.writeContent("\n                        <li>");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(error.getMessage());
					jteOutput.writeContent("</li>\n                    ");
				}
				jteOutput.writeContent("\n                ");
			}
			jteOutput.writeContent("\n            </ul>\n        </div>\n    ");
		}
		jteOutput.writeContent("\n\n    <form action=\"/courses\" method=\"post\">\n        <div class=\"mb-3\">\n            <label class=\"form-label\">\n                Название курса\n                <input type=\"text\" name=\"name\" class=\"form-control\"");
		var __jte_html_attribute_0 = page.getName() != null ? page.getName() : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required>\n            </label>\n        </div>\n        <div class=\"mb-3\">\n            <label class=\"form-label\">\n                Описание\n                <textarea name=\"description\" class=\"form-control\" required>");
		jteOutput.setContext("textarea", null);
		jteOutput.writeUserContent(page.getDescription() != null ? page.getDescription() : "");
		jteOutput.writeContent("</textarea>\n            </label>\n        </div>\n        <input type=\"submit\" value=\"Создать курс\" class=\"btn btn-primary\">\n    </form>\n</div>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
