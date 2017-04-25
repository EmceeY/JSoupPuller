import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by User on 4/18/17.
 */

public class ListLinks{
    public static void main (String[] args) throws IOException {
        String url = "https://www.netflixreleases.com/movies";
        System.out.println("Fetching " + url + "...");

        Document doc = Jsoup.connect(url).get();

        Elements movies = doc.select("ul.clean.clearfix").select("li");
        Elements moviePictures = doc.select("ul.clean.clearfix").select("li").select("[src]");
        Elements movieLinks = doc.select("ul.clean.clearfix").select("li").select("a[href]");

        try {
            //loop over Array List of Elements
            PrintWriter writer = new PrintWriter("text-netflix-output.txt", "UTF-8");
            for (int i = 0; i < movies.size(); i++) {

                String movieUrl = movieLinks.get(i).attr("abs:href");

                Document docMovie = Jsoup.connect(movieUrl).get();

                Elements information = docMovie.select("dd");

                Elements countries = docMovie.select("span.flag-icon.flag-icon-us");

                Elements description = docMovie.select("div.description.full.nopadding").select("p");


                //prints out information, image location, and description if the title is on Netflix, USA
                if (countries.hasAttr("title")) {

                    for(Element info : information){
                    writer.print(" DATA " + info.text());
                    }
                    writer.println( " DATA " + moviePictures.get(i).attr("abs:src") + " DATA " + description.text());
                }

//                    writer.println(information.text() + " DATA " + moviePictures.get(i).attr("abs:src") + " DATA " + description.text() +"EOF" );
//                }

//            //irrelevant text matching method to see if title was on Netflix
//            Elements onNetflix = docMovie.select(":matchesOwn(Yes!)");


//            //prints out whether or not a particular title is on Netflix
//            System.out.println(onNetflix.text());

//            //prints out all information of a specific movie link, pulled from the link in a picture
//            System.out.println(information.text());

//            //prints out {title, year, imdb rating}movies, picture URL, movie URL
//            System.out.println(movies.get(i).text() + " " + moviePictures.get(i).attr("abs:src") + " " +
//                    movieLinks.get(i).attr("abs:href") );

            }
            writer.close();


//        //loop through 525 pages of movies
//        for(int j = 2; j < 525; j++){
//            String urlLoop = "https://www.netflixreleases.com/movies/?page=" +j;
//            System.out.println("Fethcing" + urlLoop + "...");
//            Document docLoop = Jsoup.connect(urlLoop).get();
//
//            //loop through 25 movies on each page
//            for(int i = 0; i < 25; i++) {
//                Elements movies = docLoop.select("#content,div.list.full.nopadding,ul.clean.clearfix,li.listitem.one-sixth.mobile-one-half.nopadding:nth-child(" + i + "),a");
//                System.out.println(movies);
//            }
//        }

//        System.out.println("Media: " + media.size());
//        for (Element src : media) {
//            if (src.tagName().equals("img"))
//                System.out.println(src.attr("abs:src") + src.attr("width") +
//                        src.attr("height") + src.attr("alt"));
//            else
//                System.out.println(" * " + src.tagName() + ": <" + src.attr("abs:src") + ">");
//        }
//
//        System.out.println("Imports: (" + imports.size() + ")");
//        for (Element link : imports) {
//            System.out.println(" * " + link.tagName() + " <" + link.attr("abs:href") +
//                    "> (" + link.attr("rel") + ")");
//        }
//
//        System.out.println("Links: (" + links.size() + ")");
//        for (Element link : links) {
//            System.out.println( link.cssSelector() + " * a: <" + link.attr("abs:href") +
//                    "> (" + (link.text()) + ")");
//        }


        }catch (IOException e){e.printStackTrace();}

    }
}
