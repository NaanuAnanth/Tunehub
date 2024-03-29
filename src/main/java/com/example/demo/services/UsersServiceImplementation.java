package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;
import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService{

	@Autowired
	UsersRepository repo;
	
	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "added sucessfully";
	}

	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null)
		{
		  return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user = repo.findByEmail(email);
		if(password.equals(user.getPassword()))
		{
		   return true;
		}
		else
		{
			return false;
		}
	}

	
	public String getRole(String email) {
		Users user = repo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
		
		
	}

}
