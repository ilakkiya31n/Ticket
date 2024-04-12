package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
@Service
public class UserService {
      @Autowired
    UserRepo ur;
    public User create(User u)
    {
        return ur.save(u);
    }
    public List<User> getAllDetails()
    {
        return ur.findAll();
    }
    public User getMe(String id)
    {
        return ur.findById(id).orElse(null);
    }
    public  boolean updateDetails(String id,User u)
    {
        if(this.getMe(id)==null)
        {
            return false;
        }
        try{
            ur.save(u);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteUser(String id)
    {
        if(this.getMe(id)==null)
        {
            return false;
        }
        ur.deleteById(id);
        return true;
    }
    public List<User> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return ur.findAll(sort);
    }
    public List<User> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return ur.findAll(page).getContent();
    }

    //sorting and pagination
    public List<User> getsort(int pageNumber,int pageSize,String field)
    {          return ur.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
    public List<User> sortEmail() {
        return ur.findByEmailId();
    }
    public List<User> sortByName() {
        return ur.findByName();  }


}
