import controllers.FilmController;
import models.readin.FileReadIn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * Created by User on 4/26/17.
 */

@SpringBootApplication
public class FilmDataApplication {

    public static void main(String args[]) {
        SpringApplication.run(FilmDataApplication.class, args);}
}
