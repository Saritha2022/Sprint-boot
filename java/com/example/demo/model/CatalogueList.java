package com.example.demo.model;

public class CatalogueList {
	String movieName;
	 String movieDescription;
	int movieRating;
	
	
	@Override
	public String toString() {
		return "CatalogueList [movieName=" + movieName + ", movieDescription=" + movieDescription + ", movieRating="
				+ movieRating + "]";
	}
	public CatalogueList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CatalogueList(String movieName, String movieDescription, int movieRating) {
		super();
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.movieRating = movieRating;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	public int getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}
}

