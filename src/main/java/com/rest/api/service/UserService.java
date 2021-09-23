package com.rest.api.service;
import com.rest.api.exception.UserNotFoundException;
import com.rest.api.model.User;
import com.rest.api.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public User findUser(int id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("This User Not Found " + id));
    }

    public User addUser(User user) {
//        user.setBirthdate(new Date());
        return userRepo.save(user);
    }
    public void deleteuser(int id){
        if(id <=0 ) {
            throw new UserNotFoundException("User Not Found ID " + id);
        }
         userRepo.deleteById(id);

    }
}
