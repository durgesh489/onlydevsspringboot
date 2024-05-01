package com.durgesh.onlydevs.controllers.users;

import com.durgesh.onlydevs.entities.users.LoginUser;
import com.durgesh.onlydevs.responses.ApiResponse;
import com.durgesh.onlydevs.entities.users.User;
import com.durgesh.onlydevs.exceptions.NullFieldException;
import com.durgesh.onlydevs.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.lang.reflect.Field;
import java.util.Optional;


@RestController
@RequestMapping("/users")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserRepository userRepository;




    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signup(@RequestBody User user, HttpServletRequest request) {
        try {
            checkForNullFields(user);
            User res =userRepository.findByEmail(user.getEmail());
            if (res == null) {
                User result = userRepository.save(user);
                ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, "User Saved", request.getRequestURI(), result, true);
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
            }
            else{
                ApiResponse apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST, "User Already Exists", request.getRequestURI(), null, false);
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }
        }
        catch (IllegalAccessException e) {
            e.printStackTrace(); // Handle or log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginUser loginUser, HttpServletRequest request) {
        try {
            checkForNullFields(loginUser);
            User result =userRepository.findByEmail(loginUser.getEmail());
            if(result!=null){
                if(result.getPassword().equals(loginUser.getPassword())){
                    ApiResponse apiResponse = new ApiResponse( HttpStatus.OK,"Login Succesfully",request.getRequestURI(), result,true);
                    return new ResponseEntity<>(apiResponse, HttpStatus.OK);
                }
                else{
                    ApiResponse apiResponse = new ApiResponse( HttpStatus.BAD_REQUEST,"Invalid Password",request.getRequestURI(), null,false);
                    return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);

                }
            }else{
                ApiResponse apiResponse = new ApiResponse( HttpStatus.NOT_FOUND,"User Not Found",request.getRequestURI(), null,false);
                return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);

            }

        }
        catch (IllegalAccessException e) {
            e.printStackTrace(); // Handle or log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    private void checkForNullFields(Object object) throws IllegalAccessException {
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(object) == null) {
                throw new NullFieldException(field.getName() + " cannot be null");
            }
        }
    }


    @GetMapping
    public List<User> getAllUsers(){
        List<User>users=(List<User>) userRepository.findAll();
        return users;
    }
    @DeleteMapping
    public String deleteAllUsers(){
        userRepository.deleteAll();
        return "users deleted";
    }
}
