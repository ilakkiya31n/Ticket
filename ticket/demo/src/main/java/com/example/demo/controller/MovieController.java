package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
@RestController
public class MovieController {
    @Autowired
     MovieService ms;
     @PostMapping("/api/moviepost")
     public ResponseEntity<Movie> add(@RequestBody Movie m)
     {
        Movie ust=ms.create(m);
        return new ResponseEntity<>(ust,HttpStatus.CREATED);
     }
     @GetMapping("/api/movieget")
     public ResponseEntity<List<Movie>> showinfo()
     {
       return new ResponseEntity<>(ms.getAllDetails(),HttpStatus.OK);
     }
     @PutMapping("/api/Movie/{TicketId}")
    public ResponseEntity<Movie> putMethodName(@PathVariable("TicketId") int id, @RequestBody Movie m) {
        if(ms.updateDetails(id,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/Movie/{TicketId}")
    public ResponseEntity<Boolean> delete(@PathVariable("TicketId")int id)
    {
        if(ms.deleteMovie(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
