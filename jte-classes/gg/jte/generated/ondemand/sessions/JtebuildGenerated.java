package gg.jte.generated.ondemand.sessions;
import org.example.hexlet.NamedRoutes;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "sessions/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,4,4,13,13,13,13,13,13,13,13,13,29,29,29,29,29,29,29,29};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div class=\"container mt-5\">\n            <div class=\"row justify-content-center\">\n                <div class=\"col-md-6\">\n                    <div class=\"card\">\n                        <div class=\"card-header\">\n                            <h4>Вход в систему</h4>\n                        </div>\n                        <div class=\"card-body\">\n                            <form");
				var __jte_html_attribute_0 = NamedRoutes.sessionsPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n                                <div class=\"mb-3\">\n                                    <label for=\"nickname\" class=\"form-label\">Никнейм</label>\n                                    <input type=\"text\" class=\"form-control\" id=\"nickname\" name=\"nickname\" required>\n                                </div>\n                                <div class=\"mb-3\">\n                                    <label for=\"password\" class=\"form-label\">Пароль</label>\n                                    <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" required>\n                                </div>\n                                <button type=\"submit\" class=\"btn btn-primary\">Войти</button>\n                            </form>\n                        </div>\n                    </div>\n                </div>\n            </div>\n        </div>\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
