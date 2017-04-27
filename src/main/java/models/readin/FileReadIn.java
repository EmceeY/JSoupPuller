package models.readin;

import models.Film;
import models.data.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by User on 4/25/17.
 */
public class FileReadIn {

    public static void main (String[] args) throws IOException{
        try {
            BufferedReader in = new BufferedReader(new FileReader("text-netflix-output.txt"));

            String currentLine;

            PrintWriter writer10 = new PrintWriter("SQL-database-script-10.txt", "UTF-8");

            PrintWriter writer8 = new PrintWriter("SQL-database-script-8.txt", "UTF-8");

            while ((currentLine = in.readLine()) != null){

                //separates out each film
                String[] films = currentLine.split("(FILM)");

                for (String film : films){
                    String[] filmInformation = film.split("\\|\\|");
                        if (filmInformation.length == 10){
                            writer10.print( "VALUES (");
                            for (int i = 0; i < filmInformation.length; i++) {
                                if(i < 6){
                                    writer10.print( "'" + filmInformation[i] + "'" + ",");
                                }
                                else{
                                    writer10.print( "'" + filmInformation[i] + "'");
                                }

                            }
                            writer10.print(");");
                            writer10.println();

                        }
                        else if(filmInformation.length == 8){
                            writer8.print( "VALUES (");
                            for (int i = 0; i < filmInformation.length; i++) {
                                if(i < 6){
                                    writer8.print( "'" + filmInformation[i] + "'" + ",");
                                }
                                else{
                                    writer8.print( "'" + filmInformation[i] + "'");
                                }

                            }
                            writer8.print(");");
                            writer8.println();
                        }
                        else{
                            System.out.print("not enough film information for: " + filmInformation[0]);
                        }
                }
            }

            writer10.close();
            writer8.close();

        }catch(IOException e){e.printStackTrace();}


    }

}
