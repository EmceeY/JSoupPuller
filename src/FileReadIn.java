import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 4/25/17.
 */
public class FileReadIn {

    public static void main(String[] args){
        try {
            BufferedReader in = new BufferedReader(new FileReader("text-netflix-output.txt"));

            String currentLine;



            String[] tokens = {};

            while ((currentLine = in.readLine()) != null){

                tokens = currentLine.split("DATA");


                for (int i = 0; i < tokens.length; i++){
                    System.out.println(tokens[i]);
                }

            }






        }catch(IOException e){e.printStackTrace();}
    }

}
