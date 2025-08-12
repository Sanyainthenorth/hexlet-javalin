package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.NamedRoutes;
public final class JteeditGenerated {
	public static final String JTE_NAME = "users/edit.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,8,8,10,11,11,12,12,12,12,13,13,13,16,16,25,25,25,25,25,25,25,25,25,33,33,33,33,33,33,33,33,33,34,34,34,34,35,35,36,36,36,37,37,45,45,45,45,45,45,45,45,45,46,46,46,46,47,47,48,48,48,49,49,59,59,59,59,60,60,61,61,61,62,62,76,76,76,76,76,76,76,76,76,87,87,87,87,87,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"container mt-5\">\n            ");
				jteOutput.writeContent("\n            ");
				if (page.getFlash() != null) {
					jteOutput.writeContent("\n                <div class=\"alert alert-");
					jteOutput.setContext("div", "class");
					jteOutput.writeUserContent(page.getFlash().get("type"));
					jteOutput.setContext("div", null);
					jteOutput.writeContent(" alert-dismissible fade show mb-4\">\n                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getFlash().get("message"));
					jteOutput.writeContent("\n                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n                </div>\n            ");
				}
				jteOutput.writeContent("\n\n            <div class=\"card shadow-sm\">\n                <div class=\"card-header bg-primary text-white\">\n                    <h1 class=\"card-title mb-0\">\n                        <i class=\"bi bi-pencil-square\"></i> Редактирование пользователя\n                    </h1>\n                </div>\n                <div class=\"card-body\">\n                    <form");
				var __jte_html_attribute_0 = NamedRoutes.userPath(page.getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n                        <input type=\"hidden\" name=\"_method\" value=\"patch\">\n\n                        <div class=\"mb-3\">\n                            <label for=\"name\" class=\"form-label\">Имя</label>\n                            <input type=\"text\"\n                                   name=\"name\"\n                                   id=\"name\"");
				var __jte_html_attribute_1 = page.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("\n                                   class=\"form-control ");
				jteOutput.setContext("input", "class");
				jteOutput.writeUserContent(page.getError("name") != null ? "is-invalid" : "");
				jteOutput.setContext("input", null);
				jteOutput.writeContent("\">\n                            ");
				if (page.getError("name") != null) {
					jteOutput.writeContent("\n                                <div class=\"invalid-feedback\">");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getError("name"));
					jteOutput.writeContent("</div>\n                            ");
				}
				jteOutput.writeContent("\n                        </div>\n\n                        <div class=\"mb-3\">\n                            <label for=\"email\" class=\"form-label\">Email</label>\n                            <input type=\"email\"\n                                   name=\"email\"\n                                   id=\"email\"");
				var __jte_html_attribute_2 = page.getEmail();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("\n                                   class=\"form-control ");
				jteOutput.setContext("input", "class");
				jteOutput.writeUserContent(page.getError("email") != null ? "is-invalid" : "");
				jteOutput.setContext("input", null);
				jteOutput.writeContent("\">\n                            ");
				if (page.getError("email") != null) {
					jteOutput.writeContent("\n                                <div class=\"invalid-feedback\">");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getError("email"));
					jteOutput.writeContent("</div>\n                            ");
				}
				jteOutput.writeContent("\n                        </div>\n\n                        <div class=\"mb-3\">\n                            <label for=\"password\" class=\"form-label\">\n                                Новый пароль (оставьте пустым, если не хотите менять)\n                            </label>\n                            <input type=\"password\"\n                                   name=\"password\"\n                                   id=\"password\"\n                                   class=\"form-control ");
				jteOutput.setContext("input", "class");
				jteOutput.writeUserContent(page.getError("password") != null ? "is-invalid" : "");
				jteOutput.setContext("input", null);
				jteOutput.writeContent("\">\n                            ");
				if (page.getError("password") != null) {
					jteOutput.writeContent("\n                                <div class=\"invalid-feedback\">");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getError("password"));
					jteOutput.writeContent("</div>\n                            ");
				}
				jteOutput.writeContent("\n                        </div>\n\n                        <div class=\"mb-3\">\n                            <label for=\"passwordConfirmation\" class=\"form-label\">\n                                Подтверждение пароля\n                            </label>\n                            <input type=\"password\"\n                                   name=\"passwordConfirmation\"\n                                   id=\"passwordConfirmation\"\n                                   class=\"form-control\">\n                        </div>\n\n                        <div class=\"d-flex justify-content-between\">\n                            <a");
				var __jte_html_attribute_3 = NamedRoutes.usersPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-outline-secondary\">\n                                <i class=\"bi bi-x-lg\"></i> Отмена\n                            </a>\n                            <button type=\"submit\" class=\"btn btn-primary\">\n                                <i class=\"bi bi-save\"></i> Сохранить изменения\n                            </button>\n                        </div>\n                    </form>\n                </div>\n            </div>\n        </div>\n    ");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
