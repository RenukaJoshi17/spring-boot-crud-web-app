package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.Entity.User;
import com.example.crud.Repository.CRUDRepository;
import com.example.crud.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")

public class CRUDController {
	@Autowired
	CRUDRepository crudRepository;
	
	@GetMapping("/users")
	public User createUser(@RequestBody User user) {
		return crudRepository.save(user);
	}
	@PostMapping("/users")
	public User getUserById(@PathVariable (value = "id") Long userId) {
		return crudRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id" , userId));
	}
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {
		
		User user = crudRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
		user.setPostName(userDetails.getPostName());
		user.setComment(userDetails.getComment());
		
		User updatedUser = crudRepository.save(user);
		return updatedUser;
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId){
		
		User user = crudRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id", userId));
		crudRepository.delete(user);
		return ResponseEntity.ok().build();	
	}
	
	
}
