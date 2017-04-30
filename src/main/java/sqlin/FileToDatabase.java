package sqlin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by User on 4/25/17.
 * Parses RAW web output and returns a formatted String that can be written to a MySQL database.
 */
public class FileToDatabase {

    public ArrayList fileToDatabse (String url) throws IOException{

        ArrayList<String> processedFilms = new ArrayList<String>();

        try {

            BufferedReader in = new BufferedReader(new FileReader(url));

            String currentLine;



            while ((currentLine = in.readLine()) != null){


                //separates out each film
                String[] films = currentLine.split("(FILM)");


                for (String film : films){
                    String filmReformat = film.replaceAll("\"", "");
                    String[] filmInformation = filmReformat.split("\\|\\|");
                        if (filmInformation.length == 10){
                            String film10 = "(";

                            for (int i = 0; i < filmInformation.length; i++) {
                                if(i < 9){

                                    film10 +=  '"' + filmInformation[i] + '"' + ",";
                                }
                                else{

                                    film10 += '"' + filmInformation[i] + '"';
                                }

                            }

                            film10 += ");";

                            processedFilms.add(film10);


                        }
                        else if(filmInformation.length == 8){

                            String film8 = "(";
                            for (int i = 0; i < filmInformation.length; i++) {
                                if(i < 7){

                                    film8 += '"' + filmInformation[i] + '"' + ",";
                                }
                                else{

                                    film8 += '"' + filmInformation[i] + '"';
                                }

                            }

                            film8 += ");";

                            processedFilms.add(film8);

                        }
                }
            }

        }catch(IOException e){e.printStackTrace();}

        return processedFilms;
    }

}
