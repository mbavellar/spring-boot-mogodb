package com.mbavellar.springbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbavellar.springbootmongodb.domain.User;
import com.mbavellar.springbootmongodb.repositories.UserRepository;
import com.mbavellar.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;
  
  public List<User> findAll() {
    return repository.findAll();
  }
  
  public User findById(String id) {
    return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User Not Found" + id));
  }
  
  public User insert(User user) {
    return repository.insert(user);
  }
}
