package br.com.lucaswamser.moviesapi.app.rest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucaswamser.moviesapi.app.model.Movie;
import br.com.lucaswamser.moviesapi.app.model.ProducerWinnerIntervalApiReturn;
import br.com.lucaswamser.moviesapi.app.repository.MoviesRepository;

@RestController


public class MoviesController {
	
    private MoviesRepository movieRepository;

    @Autowired
    public MoviesController(MoviesRepository moviesRepository) {
        this.movieRepository = moviesRepository;
    }
    

	@GetMapping("/movies/list")
	public List<Movie> getMovies() {
		List<Movie> target = new ArrayList<>();
		this.movieRepository.findAll().forEach(target::add);
	    return target;
	}
	
	@GetMapping("/movies/winnerinterval")
	public ProducerWinnerIntervalApiReturn getProducerWinnerInterval() {
		List<Map<String,Object>>  target = new ArrayList<>();
		this.movieRepository.findAllProducerWinnerInterval().forEach(target::add);
		
	    return  new ProducerWinnerIntervalApiReturn(target);
	}


}
