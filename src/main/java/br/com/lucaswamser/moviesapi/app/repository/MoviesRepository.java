package br.com.lucaswamser.moviesapi.app.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.lucaswamser.moviesapi.app.model.Movie;
@Repository
public interface MoviesRepository extends CrudRepository<Movie, Long> {

  List<Movie> findBytitle(String lastName);

  Movie findById(long id);
  
  Boolean existsByTitle(String title);
  
  
  @Query(value = "select producer,followingWin,previousWin,(followingWin-previousWin) as interval from(\n"
  		+ "select producers as producer, \n"
  		+ "year as followingWin,\n"
  		+ "(select year from movie_producers\n"
  		+ "left join  movie on id = movie_id\n"
  		+ "where p1.producers = producers\n"
  		+ "and winner = 1\n"
  		+ "order by year asc\n"
  		+ "limit 1\n"
  		+ " ) as previousWin\n"
  		+ "from movie_producers p1\n"
  		+ "left join  movie on id = movie_id\n"
  		+ "where movie.winner = 1\n"
  		+ ")\n"
  		+ "where interval > 0\n"
  		+ "order by interval asc", nativeQuery = true)
  List<Map<String,Object>> findAllProducerWinnerInterval();
}