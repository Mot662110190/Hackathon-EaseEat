package com.Easeat.data.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.Easeat.data.Entity.User;
import com.Easeat.data.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class UserControllers {

    private UserService userService;

    @Autowired
    public UserControllers(UserService userService) {
        this.userService = userService;
    }

   @PostMapping("/users")
    public User addUser (@RequestBody User user){
               user.setId(0);
               return userService.save(user);
    }
    
    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
       User myUser =  userService.findById(id);
       if(myUser==null){
        throw new RuntimeException("เกิดข้อผิดพลาดในกระบวนการทำงาน");
    }
    return myUser;
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id){
        User myUser =  userService.findById(id);
        if(myUser==null){
            throw new RuntimeException("เกิดข้อผิดพลาดในกระบวนการทำงาน");
        }
        userService.deleteById(id);
        return "ลบข้อมูลแล้ว";
    }
    @PutMapping("/users")
    public User updateUser (@RequestBody User user){
        return userService.save(user);
}
}
