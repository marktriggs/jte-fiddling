package net.dishevelled;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.PrintWriterOutput;
import gg.jte.resolve.ResourceCodeResolver;

public class App
{
    public record FileEntry(String filename, int size, String mimeType) {}

    public static void main( String[] args )
    {
        CodeResolver codeResolver = new ResourceCodeResolver("templates");
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);

        try (PrintWriter stdout = new PrintWriter(System.out)) {
            TemplateOutput output = new PrintWriterOutput(stdout);

            HashMap<String, Object> params = new HashMap<String, Object>();

            params.put("name", "Mark");
            params.put("now", new Date());
            params.put("files", Arrays.asList(
                                              new FileEntry("/etc/passwd", 3100, "text/plain"),
                                              new FileEntry("/etc/shadow", 6100, "text/plain"),
                                              new FileEntry("/dev/zero", 0, "application/octet-stream")
                                              ));

            templateEngine.render("index.jte", params, output);
        }
    }
}
