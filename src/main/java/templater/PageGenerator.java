package templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PageGenerator {
    private static PageGenerator ourInstance = new PageGenerator();
    private static final String HTML_DIR = "servlets/templates";
    private final Configuration cfg;


    public static PageGenerator getInstance() {
        return ourInstance;
    }

    private PageGenerator() {
        cfg = new Configuration(new Version(2,3,23));

    }

    public String getPage(String filename, Map<String, Object> data) {
        Writer stream = new StringWriter();

        try {
            cfg.setClassForTemplateLoading(this.getClass(), "/templates/");
            Template template = cfg.getTemplate(filename);
            template.process(data, stream);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }

}
