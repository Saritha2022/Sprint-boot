package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.*;

@RestController
public class MovieController {

@Autowired
RestTemplate restTemplate;
@RequestMapping("/catalogue/{userId}")
public List<CatalogueList> getCatalog(@PathVariable String userId){


	//RestTemplate restTemplate = new RestTemplate();

	List<Rating>ratingList =  Arrays.asList(new Rating("123",4),
			new Rating("567",3));
	System.out.println("try......");

		return ratingList.stream()
			.map(rating -> {
				Movie movie= restTemplate.getForObject("http://localhost:8085/movies/"+userId, Movie.class);
				return new CatalogueList(movie.getMovieId(),"Description of movie  :",rating.getRating());
			}).collect(Collectors.toList());

			//System.out.println("hello");

}
@GetMapping("/catalogue")
public String getCatalogueWord() {
	return "Catalogue calling movie n rating";
}
		
	//@RequestMapping("/catalogue/{userId}")
	public  List<CatalogueList> getMovieCatalogueList(@PathVariable String userId) {
		//return catList.stream().filter(i -> i.getMovieName().equals(userId)).findFirst().get();
		return Collections.singletonList(new CatalogueList("rrrr","dfgthh",4));
	}
}

/*
@RestController
public class MovieController {
	
	List<CatalogueList>catList=Arrays.asList(new CatalogueList("Happy Days", "evergreen", 4)
			,new CatalogueList("Jurassic Park", "New Explosion", 4),
			new CatalogueList("RRR", "MultiHero Balancing ", 4));

	@RequestMapping("/test")
	public String getHelloMessage() {
		return "Hi This a Test Meggage";
	}

	@RequestMapping("/hello")
	public String getHello() {
		return "Hello Good Morning";
	}
	@RequestMapping("/hi")
	public String sayHello() {
		return "hi Mapping Working";
	}
	@RequestMapping("/catalogue")
	public List<CatalogueList> getCatalogue() {
						return catList;
	}*/


