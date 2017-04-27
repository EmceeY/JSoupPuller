package controllers;

import models.Film;
import models.data.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by User on 4/26/17.
 */
public class FilmController {

    ArrayList<Film> listOfFilms = new ArrayList<>();

    public ArrayList<Film> parseToArray() throws IOException{
        try {
            BufferedReader in = new BufferedReader(new FileReader("text-netflix-output.txt"));

            String currentLine;

            String[] tokens = {};

            while ((currentLine = in.readLine()) != null){

                tokens = currentLine.split("DATA");


                    System.out.print(tokens[7]);


            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return listOfFilms;
    }

}





