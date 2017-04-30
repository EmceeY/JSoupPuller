package readin;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by User on 4/18/17.
 * Crawls a website and writes data to a CSV equivalent, parsable file.
 * Uses '||' instead of commas in order to preserve the sanctity of the data.
 */

public class ListLinks {
    public static void main(String[] args) throws IOException {

        // prints the first page of the website to file
//        String url = "https://www.netflixreleases.com/movies";
//        System.out.println("Fetching " + url + "...");

//        Document doc = Jsoup.connect(url).get();
        PrintWriter writer = new PrintWriter("text-netflix-output-television.txt", "UTF-8");


        for (int j = 2; j < 127; j++) {
            String urlLoop = "https://www.netflixreleases.com/tvshows/?page=" + j;
            System.out.println("Fetching " + urlLoop + "...");

            Document doc = Jsoup.connect(urlLoop).get();


            Elements movies = doc.select("ul.clean.clearfix").select("li");
            Elements moviePictures = doc.select("ul.clean.clearfix").select("li").select("[src]");
            Elements movieLinks = doc.select("ul.clean.clearfix").select("li").select("a[href]");


            try {

                //loop over Array List of Elements

                for (int i = 0; i < movies.size(); i++) {

                    String movieUrl = movieLinks.get(i).attr("abs:href");

                    Document docMovie = Jsoup.connect(movieUrl).get();

                    Elements information = docMovie.select("dd");

                    Elements countries = docMovie.select("span.flag-icon.flag-icon-us");

                    Elements description = docMovie.select("div.description.full.nopadding").select("p");


                    //prints out information, image location, and description if the title is on Netflix, USA
                    if (countries.hasAttr("title")) {
                        writer.print("FILM");
                        for (Element info : information) {
                            writer.print(info.text() + "||");
                        }
                        writer.print(moviePictures.get(i).attr("abs:src") + "||" + description.text());
                    }

                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        writer.close();
    }

}
