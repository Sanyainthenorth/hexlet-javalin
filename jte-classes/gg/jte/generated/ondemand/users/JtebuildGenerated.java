package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.BuildUserPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,4,4,4,7,7,8,8,9,9,9,10,10,11,11,14,14,20,20,20,20,20,20,20,20,20,26,26,26,26,26,26,26,26,26,43,43,43,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
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
		jteOutput.writeContent("\n\n    <form action=\"/users\" method=\"post\">\n        <div class=\"mb-3\">\n            <label class=\"form-label\">\n                Имя\n                <input type=\"text\" name=\"name\" class=\"form-control\"");
		var __jte_html_attribute_0 = page.getName() != null ? page.getName() : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required>\n            </label>\n        </div>\n        <div class=\"mb-3\">\n            <label class=\"form-label\">\n                Email\n                <input type=\"email\" name=\"email\" class=\"form-control\"");
		var __jte_html_attribute_1 = page.getEmail() != null ? page.getEmail() : "";
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required>\n            </label>\n        </div>\n        <div class=\"mb-3\">\n            <label class=\"form-label\">\n                Пароль\n                <input type=\"password\" name=\"password\" class=\"form-control\" required>\n            </label>\n        </div>\n        <div class=\"mb-3\">\n            <label class=\"form-label\">\n                Подтверждение пароля\n                <input type=\"password\" name=\"passwordConfirmation\" class=\"form-control\" required>\n            </label>\n        </div>\n        <input type=\"submit\" value=\"Зарегистрировать\" class=\"btn btn-primary\">\n    </form>\n</div>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
