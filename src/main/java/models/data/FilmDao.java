package models.data;

import models.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by User on 4/26/17.
 */

@Repository
@Transactional
public interface FilmDao extends CrudRepository<Film, Integer> {
}
