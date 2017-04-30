package readin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by User on 4/25/17.
 * Parses RAW web output and places it into distinct files based on the number of variables present in the data.
 * Currently formatted for many mySQL/myphpadmin upload.
 */
public class FileReadIn {

    public static void main (String[] args) throws IOException{
        try {
            BufferedReader in = new BufferedReader(new FileReader("text-netflix-output-full-part2.txt"));

            String currentLine;

            PrintWriter writer10 = new PrintWriter("SQL-database-script-10.txt", "UTF-8");

            PrintWriter writer8 = new PrintWriter("SQL-database-script-8.txt", "UTF-8");

            writer10.print( "VALUES");

            writer8.print( "VALUES");

            while ((currentLine = in.readLine()) != null){

                //separates out each film
                String[] films = currentLine.split("(FILM)");

                for (String film : films){
                    String[] filmInformation = film.split("\\|\\|");
                        if (filmInformation.length == 10){
                            writer10.print( "(");
                            for (int i = 0; i < filmInformation.length; i++) {
                                if(i < 9){
                                    writer10.print( '"' + filmInformation[i] + '"' + ",");
                                }
                                else{
                                    writer10.print( '"' + filmInformation[i] + '"');
                                }

                            }
                            writer10.print("),");


                        }
                        else if(filmInformation.length == 8){
                            writer8.print( "(");
                            for (int i = 0; i < filmInformation.length; i++) {
                                if(i < 7){
                                    writer8.print( '"' + filmInformation[i] + '"' + ",");
                                }
                                else{
                                    writer8.print( '"' + filmInformation[i] + '"');
                                }

                            }
                            writer8.print("),");

                        }
                }
            }

            writer10.close();
            writer8.close();

        }catch(IOException e){e.printStackTrace();}


    }

}
