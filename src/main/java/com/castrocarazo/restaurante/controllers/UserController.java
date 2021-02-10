package com.castrocarazo.restaurante.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.castrocarazo.restaurante.dao.IUserDao;
import com.castrocarazo.restaurante.domain.User;
import com.castrocarazo.restaurante.domain.UserResponse;


@RestController()
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	IUserDao usuarios;
	
	@GetMapping()
	public ResponseEntity<List<User>> getAll(){
		try{
			List<User> users = (List<User>) usuarios.findAll();
			return new ResponseEntity<>(users, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping("login")
    public ResponseEntity<UserResponse> login(@RequestParam String username, @RequestParam String password){
		UserResponse response = new UserResponse();
		try {
			List<User> user = usuarios.findByUsernameAndPassword(username, password);
			
			if (!user.isEmpty()) {
				response.setUser(user.get(0));
				response.setStatus("success");
				response.setMessage("welcome");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
				response.setStatus("error");
				response.setMessage("user/password incorrect");
            	return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
            }
		}catch (Exception exception) {
			response.setMessage(exception.getMessage());
			response.setStatus("error");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
