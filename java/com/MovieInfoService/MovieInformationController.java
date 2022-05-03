package com.MovieInfoService;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInformationController {
	
	
			
	
	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId){
		return new Movie(movieId,"Movie Name  Standard");
	}

}
