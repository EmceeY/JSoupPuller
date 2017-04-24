import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by User on 4/18/17.
 */

public class ListLinks{
    public static void main (String[] args) throws IOException {
        String url = "https://www.allflicks.net";
        System.out.println("Fetching " + url + "...");

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");

        System.out.println("Media: " + media.size());
        for (Element src : media) {
            if (src.tagName().equals("img"))
                System.out.println(src.attr("abs:src") + src.attr("width") +
                        src.attr("height") + src.attr("alt"));
            else
                System.out.println(" * " + src.tagName() + ": <" + src.attr("abs:src") + ">");
        }

        System.out.println("Imports: (" + imports.size() + ")");
        for (Element link : imports) {
            System.out.println(" * " + link.tagName() + " <" + link.attr("abs:href") +
                    "> (" + link.attr("rel") + ")");
        }

        System.out.println("Links: (" + links.size() + ")");
        for (Element link : links) {
            System.out.println(" * a: <" + link.attr("abs:href") +
                    "> (" + (link.text()) + ")");
        }
    }
        private static void print(String msg, Object... args){
            System.out.println(String.format(msg,args));
    }

    private static String trim(String s, int width){
            if (s.length() > width)
                return s.substring(0, width-1) + ".";
            else
                return s;
    }


}
