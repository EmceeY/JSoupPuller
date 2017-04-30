import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sqlin.FileToDatabase;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 4/26/17.
 */

@SpringBootApplication
public class FilmDataApplication {

    public static void main(String args[]) throws IOException{
        FileToDatabase fileToDatabase = new FileToDatabase();
        ArrayList toPrint = fileToDatabase.fileToDatabse("text-netflix-output-full-part2.txt");
        System.out.println(toPrint.toString());
    }
}
