package net.dishevelled;

import java.io.PrintWriter;
import java.util.HashMap;

import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.PrintWriterOutput;
import gg.jte.output.StringOutput;
import gg.jte.html.HtmlTemplateOutput;
import gg.jte.resolve.ResourceCodeResolver;

public class App
{
    public static void main( String[] args )
    {
        CodeResolver codeResolver = new ResourceCodeResolver("templates");
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);

        TemplateOutput output = new PrintWriterOutput(new PrintWriter(System.out));
        templateEngine.render("index.jte", new HashMap<String, Object>(), output);
    }
}
