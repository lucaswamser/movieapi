package br.com.lucaswamser.moviesapi.app.repository;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import br.com.lucaswamser.moviesapi.app.model.Movie;

@Component
public class MoviesLoader implements ApplicationRunner {

    private MoviesRepository movieRepository;

    @Autowired
    public MoviesLoader(MoviesRepository moviesRepository) {
        this.movieRepository = moviesRepository;
    }

  
	public void run(ApplicationArguments args) throws Exception {
		Path path = Paths.get("./data/movielist.csv");
		List<String> content = Files.readAllLines(path);
		//removendo o header
		content.remove(0);
		
		for (String i : content) {
			
			Movie movie = new Movie(i);
			if (!movieRepository.existsByTitle(movie.getTitle())) {
				System.out.println(movie.toString());
				movieRepository.save(movie);
			}
		}

		
		
		
	}
}