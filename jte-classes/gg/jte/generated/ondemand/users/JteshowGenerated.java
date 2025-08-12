package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.NamedRoutes;
public final class JteshowGenerated {
	public static final String JTE_NAME = "users/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,8,8,10,11,11,12,12,12,12,13,13,13,16,16,21,21,21,32,32,32,36,36,36,44,44,44,44,44,44,44,44,44,47,47,47,47,47,47,47,47,47,50,50,50,50,50,50,50,50,50,62,62,62,62,62,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserPage page) {
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
				jteOutput.writeContent("\n\n            <div class=\"card shadow-sm\">\n                <div class=\"card-header bg-primary text-white\">\n                    <h1 class=\"card-title mb-0\">\n                        <i class=\"bi bi-person\"></i> Пользователь: ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getUser().getName());
				jteOutput.writeContent("\n                    </h1>\n                </div>\n                <div class=\"card-body\">\n                    <div class=\"mb-4\">\n                        <h5 class=\"mb-3\"><i class=\"bi bi-info-circle\"></i> Детали:</h5>\n                        <div class=\"table-responsive\">\n                            <table class=\"table table-bordered\">\n                                <tbody>\n                                    <tr>\n                                        <th scope=\"row\" class=\"w-25\">ID</th>\n                                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUser().getId());
				jteOutput.writeContent("</td>\n                                    </tr>\n                                    <tr>\n                                        <th scope=\"row\">Email</th>\n                                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUser().getEmail());
				jteOutput.writeContent("</td>\n                                    </tr>\n                                </tbody>\n                            </table>\n                        </div>\n                    </div>\n\n                    <div class=\"d-flex justify-content-start gap-2\">\n                        <a");
				var __jte_html_attribute_0 = NamedRoutes.usersPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-outline-secondary\">\n                            <i class=\"bi bi-arrow-left\"></i> Назад к списку\n                        </a>\n                        <a");
				var __jte_html_attribute_1 = NamedRoutes.editUserPath(page.getUser().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-outline-warning\">\n                            <i class=\"bi bi-pencil\"></i> Редактировать\n                        </a>\n                        <form");
				var __jte_html_attribute_2 = NamedRoutes.deleteUserPath(page.getUser().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("\n                              method=\"post\"\n                              class=\"d-inline\"\n                              onsubmit=\"return confirm('Вы уверены, что хотите удалить этого пользователя?')\">\n                            <button type=\"submit\" class=\"btn btn-outline-danger\">\n                                <i class=\"bi bi-trash\"></i> Удалить\n                            </button>\n                        </form>\n                    </div>\n                </div>\n            </div>\n        </div>\n    ");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserPage page = (UserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
