package com.mbavellar.springbootmongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mbavellar.springbootmongodb.domain.Post;
import com.mbavellar.springbootmongodb.domain.User;
import com.mbavellar.springbootmongodb.dto.UserDTO;
import com.mbavellar.springbootmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  
  @Autowired
  private UserService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UserDTO>> findAll() {
    List<UserDTO> list = service.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(list);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    return ResponseEntity.ok().body(new UserDTO(service.findById(id))); 
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
    User user = service.insert(getUserFromDTO(userDTO, null));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable String id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id) {
    service.update(getUserFromDTO(userDTO, id));
    return ResponseEntity.noContent().build();
  }
  
  @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
  public ResponseEntity<List<Post>> findAllPosts(@PathVariable String id) {
    return ResponseEntity.ok().body(service.findById(id).getPosts());
  }
  
  @SuppressWarnings("static-method")
  private User getUserFromDTO(UserDTO userDTO, String id) {
    return new User(id == null ? userDTO.getId() : id, userDTO.getName(), userDTO.getEmail());
  }
}