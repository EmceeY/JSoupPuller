package models.readin;

import models.Film;
import models.data.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 4/25/17.
 */
public class FileReadIn {

    @Autowired
    private FilmDao filmDao;

    public void addToDB(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("text-netflix-output.txt"));

            String currentLine;

            while ((currentLine = in.readLine()) != null){

                //separates out each film
                String[] films = currentLine.split("(FILM)");

                for (String film : films){
                    String[] filmInformation = film.split("\\|\\|");
                        if (filmInformation.length == 10){
                            Film newFilm = new Film(filmInformation[0], filmInformation[1], filmInformation[2], filmInformation[3],
                                    filmInformation[4], filmInformation[5], filmInformation[6], filmInformation[7], filmInformation[8],
                                    filmInformation[9]);

                            filmDao.save(newFilm);
                        }
                        else if(filmInformation.length == 8){
                            Film newFilm = new Film(filmInformation[0], filmInformation[1], filmInformation[2], filmInformation[3],
                                    filmInformation[4], filmInformation[5], filmInformation[6], filmInformation[7]);

                            filmDao.save(newFilm);
                        }
                        else{
                            System.out.print("not enough film information");
                        }
                }
            }

        }catch(IOException e){e.printStackTrace();}

    }

}
