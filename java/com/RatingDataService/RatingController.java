package com.RatingDataService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Rating;
import Model.UserRating;

@RestController
public class RatingController {
	@RequestMapping("/ratingsdata/{movieId}")
	public List<Rating> getRating(@PathVariable String movieId){
		return Collections.singletonList(new Rating("424"
				,4));
	}
	
	@GetMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId){	
		List<Rating>ratingList =  Arrays.asList(new Rating("RRR",4),
				new Rating("ABCD",3));
		UserRating userRating=new UserRating();
		userRating.setUserRating(ratingList);
		return userRating;
	}

}
