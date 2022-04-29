package com.mbavellar.springbootmongodb.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbavellar.springbootmongodb.domain.Post;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<Post>> findAll() {
    return null;
  }
}
