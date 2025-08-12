package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,6,6,9,9,13,13,13,13,13,13,13,13,13,18,18,22,22,34,34,36,36,36,37,37,37,38,38,38,41,41,41,41,41,41,41,41,41,46,46,46,46,46,46,46,46,46,51,51,51,51,51,51,51,51,51,64,64,68,68,70,70,70,70,70,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n       <div class=\"container mt-5\">\n           <div class=\"d-flex justify-content-between align-items-center mb-4\">\n               <h1 class=\"mb-0\">Список пользователей</h1>\n               <a");
				var __jte_html_attribute_0 = NamedRoutes.buildUserPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-success\">\n                   <i class=\"bi bi-plus-lg\"></i> Добавить пользователя\n               </a>\n           </div>\n\n           ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n               <div class=\"alert alert-info\">\n                   <i class=\"bi bi-info-circle\"></i> Пользователи не найдены\n               </div>\n           ");
				} else {
					jteOutput.writeContent("\n               <div class=\"table-responsive\">\n                   <table class=\"table table-striped table-hover align-middle\">\n                       <thead class=\"table-dark\">\n                           <tr>\n                               <th>ID</th>\n                               <th>Имя</th>\n                               <th>Email</th>\n                               <th class=\"text-end\">Действия</th>\n                           </tr>\n                       </thead>\n                       <tbody>\n                           ");
					for (User user : page.getUsers()) {
						jteOutput.writeContent("\n                               <tr>\n                                   <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getId());
						jteOutput.writeContent("</td>\n                                   <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getName());
						jteOutput.writeContent("</td>\n                                   <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getEmail());
						jteOutput.writeContent("</td>\n                                   <td class=\"text-end\">\n                                       <div class=\"btn-group\" role=\"group\" aria-label=\"Действия с пользователем\">\n                                           <a");
						var __jte_html_attribute_1 = NamedRoutes.userPath(user.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_1);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent("\n                                              class=\"btn btn-sm btn-outline-primary\"\n                                              title=\"Просмотр\">\n                                               <i class=\"bi bi-eye\"></i>\n                                           </a>\n                                           <a");
						var __jte_html_attribute_2 = NamedRoutes.editUserPath(user.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_2);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent("\n                                              class=\"btn btn-sm btn-outline-warning\"\n                                              title=\"Редактировать\">\n                                               <i class=\"bi bi-pencil\"></i>\n                                           </a>\n                                           <form");
						var __jte_html_attribute_3 = NamedRoutes.deleteUserPath(user.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
							jteOutput.writeContent(" action=\"");
							jteOutput.setContext("form", "action");
							jteOutput.writeUserContent(__jte_html_attribute_3);
							jteOutput.setContext("form", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent("\n                                                 method=\"post\"\n                                                 class=\"d-inline\"\n                                                 onsubmit=\"return confirm('Вы уверены, что хотите удалить этого пользователя?')\">\n                                               <button type=\"submit\"\n                                                       class=\"btn btn-sm btn-outline-danger\"\n                                                       title=\"Удалить\">\n                                                   <i class=\"bi bi-trash\"></i>\n                                               </button>\n                                           </form>\n                                       </div>\n                                   </td>\n                               </tr>\n                           ");
					}
					jteOutput.writeContent("\n                       </tbody>\n                   </table>\n               </div>\n           ");
				}
				jteOutput.writeContent("\n       </div>\n    ");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
