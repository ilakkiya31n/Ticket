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

import com.example.demo.model.User;
import com.example.demo.service.UserService;
@RestController
public class UserController {
     @Autowired
     UserService us;
     @PostMapping("/api")
     public ResponseEntity<User> add(@RequestBody User u)
     {
        User ust=us.create(u);
        return new ResponseEntity<>(ust,HttpStatus.CREATED);
     }
     @GetMapping("/userdetails")
     public ResponseEntity<List<User>> showinfo()
     {
       return new ResponseEntity<>(us.getAllDetails(),HttpStatus.OK);
     }
     @PutMapping("/api/User/{emailId}")
    public ResponseEntity<User> putMethodName(@PathVariable("emailId") String id, @RequestBody User u) {
        if(us.updateDetails(id,u) == true)
        {
            return new ResponseEntity<>(u,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/User/{emailId}")
    public ResponseEntity<Boolean> delete(@PathVariable("emailId")String id)
    {
        if(us.deleteUser(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
@GetMapping("/api/user/sortBy/{field}")
  public List<User> g(@PathVariable String field )
  {
    return us.sort(field);
  }
  @GetMapping("/api/user/{offset}/{pagesize}")
  public List<User> get(@PathVariable int offset,@PathVariable int pagesize)
  {
      return us.page(pagesize, offset);
  }
  
  //sorting and pagination
  @GetMapping("/api/user/{offset}/{pagesize}/{field}")
  public List<User> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
  {
      return us.getsort(offset,pagesize,field);
  }
  @GetMapping("/user/emailId/{emailId}")
  public ResponseEntity<?> getuserbyEmailId()  {
      try{
          return new ResponseEntity<>(us.sortEmail(),HttpStatus.OK);  }
         catch(Exception e){
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }}
  @GetMapping("/user/name/{name}")
  public ResponseEntity<?> getUserByName() {
      try{
          return new ResponseEntity<>(us.sortByName(),HttpStatus.OK);
         }
         catch(Exception e){
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }}

}


