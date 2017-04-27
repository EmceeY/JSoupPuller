package models.readin;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by User on 4/18/17.
 */

public class AllFlicks{
    public static void main (String[] args) throws IOException {
        String url = "https://www.finder.com/netflix-tv-shows";
        System.out.println("Fetching " + url + "...");

        Document doc = Jsoup.connect(url).get();
        Elements shows = doc.select("tr");

        Whitelist whiteList = new Whitelist();

        System.out.println("Links: (" + shows.size() + ")");
        for (Element link : shows) {

//            List<Node> showInfo = link.childNodesCopy();
//            System.out.println(" ");
//            for(Node info : showInfo){
//                Document output = Jsoup.parse(info.toString());
//                System.out.println(output);
//            }
            System.out.println( "*: <" + link.attr("abs:href") +
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
