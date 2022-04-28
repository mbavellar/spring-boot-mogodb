package com.mbavellar.springbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbavellar.springbootmongodb.domain.User;
import com.mbavellar.springbootmongodb.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;
  
  public List<User> findAll() {
    return repository.findAll();
  }
}
