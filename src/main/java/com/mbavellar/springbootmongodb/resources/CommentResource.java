package com.mbavellar.springbootmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbavellar.springbootmongodb.domain.Comment;
import com.mbavellar.springbootmongodb.services.CommentService;

@RestController
@RequestMapping(value = "/comments")
public class CommentResource {

  @Autowired
  private CommentService service;
  
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<Comment>> findAll() {
    return ResponseEntity.ok().body(service.findAll());
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Comment> findById(@PathVariable String id) {
    return ResponseEntity.ok().body(service.findById(id));
  }
}