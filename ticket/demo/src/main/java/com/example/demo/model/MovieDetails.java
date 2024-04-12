package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="moviepaymentdetails")
public class MovieDetails {
    @Id
    private  int TicketId;
    @Column(name="Moviename")
    private  String MovieName;
    @Column(name="NumberOfTickets")
    private  int NoOfTickets;
    @Column(name="Amount")
    private  double Amount;
    @OneToOne
    @JsonBackReference
    private Movie movie;
    
    public MovieDetails() {
    }
    public MovieDetails(int ticketId, String movieName, int noOfTickets, double amount, Movie movie) {
        TicketId = ticketId;
        MovieName = movieName;
        NoOfTickets = noOfTickets;
        Amount = amount;
        this.movie = movie;
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
    public int getNoOfTickets() {
        return NoOfTickets;
    }
    public void setNoOfTickets(int noOfTickets) {
        NoOfTickets = noOfTickets;
    }
    public double getAmount() {
        return Amount;
    }
    public void setAmount(double amount) {
        Amount = amount;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
}
