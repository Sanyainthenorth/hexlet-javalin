package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,6,6,8,8,12,12,12,12,12,12,12,12,12,24,24,26,26,26,27,27,27,28,28,28,30,30,30,30,30,30,30,30,30,31,31,31,31,31,31,31,31,31,32,32,32,32,39,39,43,43,43,44,44,44,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n       <div class=\"container mt-5\">\n           <h1>Список пользователей</h1>\n\n           <a");
				var __jte_html_attribute_0 = NamedRoutes.buildUserPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" class=\"btn btn-success mb-3\">Добавить пользователя</a>\n\n           <table class=\"table table-striped\">\n               <thead>\n                   <tr>\n                       <th>ID</th>\n                       <th>Имя</th>\n                       <th>Email</th>\n                       <th>Действия</th>\n                   </tr>\n               </thead>\n               <tbody>\n                   ");
				for (User user : page.getUsers()) {
					jteOutput.writeContent("\n                       <tr>\n                           <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(user.getId());
					jteOutput.writeContent("</td>\n                           <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(user.getName());
					jteOutput.writeContent("</td>\n                           <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(user.getEmail());
					jteOutput.writeContent("</td>\n                           <td>\n                               <a");
					var __jte_html_attribute_1 = NamedRoutes.userPath(user.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" class=\"btn btn-primary btn-sm me-2\">Просмотр</a>\n                               <a");
					var __jte_html_attribute_2 = NamedRoutes.editUserPath(user.getId());
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_2);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" class=\"btn btn-warning btn-sm me-2\">Редактировать</a>\n                               <form action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(NamedRoutes.userPath(user.getId()));
					jteOutput.setContext("form", null);
					jteOutput.writeContent("/delete\" method=\"post\" class=\"d-inline\">\n                                   <button type=\"submit\" class=\"btn btn-danger btn-sm\" onclick=\"return confirm('Удалить пользователя?')\">\n                                       Удалить\n                                   </button>\n                               </form>\n                           </td>\n                       </tr>\n                   ");
				}
				jteOutput.writeContent("\n               </tbody>\n           </table>\n       </div>\n    ");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
