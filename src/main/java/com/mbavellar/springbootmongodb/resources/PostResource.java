package com.mbavellar.springbootmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbavellar.springbootmongodb.domain.Post;
import com.mbavellar.springbootmongodb.resources.util.URL;
import com.mbavellar.springbootmongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
  
  @Autowired
  private PostService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<Post>> findAll() {
    return ResponseEntity.ok().body(service.findAll());
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Post> findById(@PathVariable String id) {
    return ResponseEntity.ok().body(service.findById(id));
  }
  
  @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
  public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
    text = URL.decodeParam(text);
    return ResponseEntity.ok().body(service.findByTitle(text));
  }
}
