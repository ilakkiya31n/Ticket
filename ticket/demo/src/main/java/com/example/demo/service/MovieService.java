package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepo;

@Service
public class MovieService {
    @Autowired
    MovieRepo mr;
    public Movie create(Movie m)
    {
        return mr.save(m);
    }
    public List<Movie> getAllDetails()
    {
        return mr.findAll();
    }
    public Movie getMe(int id)
    {
        return mr.findById(id).orElse(null);
    }
    public  boolean updateDetails(int id, Movie m)
    {
        if(this.getMe(id)==null)
        {
            return false;
        }
        try{
            mr.save(m);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteMovie(int id)
    {
        if(this.getMe(id)==null)
        {
            return false;
        }
        mr.deleteById(id);
        return true;
    }
}
