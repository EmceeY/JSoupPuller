package models.readin;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HtmlToPlainText {
    private static final String userAgent = "Mozilla/5.0 (jsoup)";
    private static final int timeout = 5 * 1000;

    public static void main(String... args) throws IOException {
        final String url = "https://www.netflixreleases.com/movies";


        for (int i = 0; i <= 0; i++) {
            String selector = "#content,div.list.full.nopadding,ul.clean.clearfix,li.listitem.one-sixth.mobile-one-half.nopadding:nth-child(1),a[href]";


            // fetch the specified URL and parse to a HTML DOM
            Document doc = Jsoup.connect(url).userAgent(userAgent).timeout(timeout).get();

            org.jsoup.examples.HtmlToPlainText formatter = new org.jsoup.examples.HtmlToPlainText();

//            if (selector != null) {
            Elements elements = doc.select(selector); // get each element that matches the CSS selector
            for (Element element : elements) {
                if (element.hasClass("a[href]")) {
                    System.out.print("LINK -->");
                }
                String plainText = formatter.getPlainText(element); // format that element to plain text
                System.out.println(plainText);
            }
//            } else { // format the whole doc
//                String plainText = formatter.getPlainText(doc);
//                System.out.println(plainText);
        }
    }
}