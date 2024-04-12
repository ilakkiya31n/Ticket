package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MovieDetails;
import com.example.demo.repository.MovieDetailsRepo;

@Service
public class MovieDetailsService {
    @Autowired
    private MovieDetailsRepo mdr;

     public MovieDetails post( MovieDetails md)
    {
        return mdr.save(md);
    }

    public MovieDetails getDetails( int ticketId )
    {
        return mdr.findById(ticketId).orElse(null);
    }
    public  boolean updateDetailsMovie(int id, MovieDetails m)
    {
        if(this.getDetails(id)==null)
        {
            return false;
        }
        try{
            mdr.save(m);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteMovieDetails(int id)
    {
        if(this.getDetails(id)==null)
        {
            return false;
        }
        mdr.deleteById(id);
        return true;
    }
    public MovieDetails findTicket(int TicketId) {
        return mdr.findTicketId(TicketId);
    }
}
