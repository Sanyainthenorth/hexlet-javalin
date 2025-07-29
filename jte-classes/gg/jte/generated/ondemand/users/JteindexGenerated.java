package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,16,16,16,18,18,18,19,19,19,20,20,20,22,22,25,25,25,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n<div class=\"container mt-5\">\n    <h1>Список пользователей</h1>\n\n    <table class=\"table\">\n        <thead>\n            <tr>\n                <th>ID</th>\n                <th>Имя</th>\n                <th>Email</th>\n            </tr>\n        </thead>\n        <tbody>\n            ");
		for (User user : page.getUsers()) {
			jteOutput.writeContent("\n                <tr>\n                    <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(user.getId());
			jteOutput.writeContent("</td>\n                    <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(user.getName());
			jteOutput.writeContent("</td>\n                    <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(user.getEmail());
			jteOutput.writeContent("</td>\n                </tr>\n            ");
		}
		jteOutput.writeContent("\n        </tbody>\n    </table>\n</div>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
