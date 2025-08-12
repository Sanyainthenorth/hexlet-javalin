package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,11,11,17,17,21,21,23,23,26,26,26,28,28,28,28,28,28,28,28,28,34,34,36,36,36,36,36,36,36,36,36,38,38,40,40,40,40,40,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"container\">\n            <h1>Добро пожаловать на сайт Сашеньки!</h1>\n            <p>Это мой учебный проект по веб-разработке на Java</p>\n\n            ");
				if (!page.isVisited()) {
					jteOutput.writeContent("\n                <div class=\"alert alert-info mt-3\">\n                    <h4>Привет, новый посетитель!</h4>\n                    <p>Это твой первый визит на мой сайт! Надеюсь, тебе здесь понравится :)</p>\n                    <p>Здесь я учусь веб-разработке на Java с Javalin.</p>\n                </div>\n            ");
				} else {
					jteOutput.writeContent("\n                <div class=\"alert alert-light mt-3\">\n                    <p>Рада снова тебя видеть! Ты уже был(а) здесь раньше.</p>\n                </div>\n            ");
				}
				jteOutput.writeContent("\n\n            ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\n                <div class=\"card mt-4\">\n                    <div class=\"card-body\">\n                        <h5 class=\"card-title\">Привет, ");
					jteOutput.setContext("h5", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent("!</h5>\n                        <p class=\"card-text\">Вы вошли в систему.</p>\n                        <form");
					var __jte_html_attribute_0 = NamedRoutes.sessionsPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"post\">\n                            <input type=\"hidden\" name=\"_method\" value=\"DELETE\">\n                            <button type=\"submit\" class=\"btn btn-danger\">Выйти</button>\n                        </form>\n                    </div>\n                </div>\n            ");
				} else {
					jteOutput.writeContent("\n                <div class=\"mt-4\">\n                    <a");
					var __jte_html_attribute_1 = NamedRoutes.buildSessionPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" class=\"btn btn-primary\">Войти</a>\n                </div>\n            ");
				}
				jteOutput.writeContent("\n        </div>\n    ");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
