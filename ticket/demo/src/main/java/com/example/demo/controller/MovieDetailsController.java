package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MovieDetails;
import com.example.demo.service.MovieDetailsService;

@RestController
public class MovieDetailsController {
    @Autowired
    private MovieDetailsService mds;

    @PostMapping("/postdetails")
    public ResponseEntity<MovieDetails> postMethodName(@RequestBody MovieDetails md) 
    {
        return new ResponseEntity<>(mds.post(md),HttpStatus.CREATED);
    }

    @GetMapping("/details/{ticketId}")
    public ResponseEntity<MovieDetails> getMethodName(@PathVariable("ticketIdd") int ticketId) {
       MovieDetails mdtt=mds.getDetails(ticketId);
       if(mdtt!=null)
       {
        return new ResponseEntity<>(mdtt,HttpStatus.OK);
       }
       else{
           return new ResponseEntity<>(mdtt,HttpStatus.NOT_FOUND);
       }
    }
    @PutMapping("/api/Moviedetails/{TicketId}")
    public ResponseEntity<MovieDetails> putMethodName(@PathVariable("TicketId") int id, @RequestBody MovieDetails m) {
        if(mds.updateDetailsMovie(id,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/Moviedetails/{TicketId}")
    public ResponseEntity<Boolean> delete(@PathVariable("TicketId")int id)
    {
        if(mds.deleteMovieDetails(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/moviedetails/{TicketId}")
    public ResponseEntity<MovieDetails> findTicketmethod(@PathVariable int TicketId) 
    {
        MovieDetails mdtt = mds.findTicket(TicketId);
        try{
            return new ResponseEntity<>(mdtt,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(mdtt,HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
    }