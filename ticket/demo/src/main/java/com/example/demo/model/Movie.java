package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="moviedetails")
public class Movie {
    @Id
    private  int TicketId;
    @Column(name="Moviename")
    private  String MovieName;
    @Column(name="Language")
    private  String Language;
    @Column(name = "Moviecategory")
    private  String Moviecategory;
    @Column(name="Location")
    private  String Location;
    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL )
    @JsonManagedReference
    private MovieDetails movieDetails;

public Movie() {
  }
  public Movie(int ticketId, String movieName, String language, String moviecategory, String location,
          String bookingticket,MovieDetails movieDetails) {
      TicketId = ticketId;
      MovieName = movieName;
      Language = language;
    Moviecategory = moviecategory;
      Location = location;
      this.movieDetails = movieDetails;
  }
  public int getTicketId() {
      return TicketId;
  }
  public void setTicketId(int ticketId) {
      TicketId = ticketId;
  }
  public String getMovieName() {
      return MovieName;
  }
  public void setMovieName(String movieName) {
      MovieName = movieName;
  }
  public String getLanguage() {
      return Language;
  }
  public void setLanguage(String language) {
      Language = language;
  }
  public String getMoviecategory() {
      return Moviecategory;
  }
  
  public String getLocation() {
      return Location;
  }
  public void setLocation(String location) {
      Location = location;
  }
public MovieDetails getMovieDetails() {
    return movieDetails;
}
public void setMovieDetails(MovieDetails movieDetails) {
    this.movieDetails = movieDetails;
}
public void setMoviecategory(String moviecategory) {
    Moviecategory = moviecategory;
}

}
