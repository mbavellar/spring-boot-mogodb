package com.mbavellar.springbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbavellar.springbootmongodb.domain.Post;
import com.mbavellar.springbootmongodb.repositories.PostRepository;
import com.mbavellar.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

  @Autowired
  private PostRepository repository;
  
  public List<Post> findAll() {
    return repository.findAll();
  }
  
  public Post findById(String id) {
    return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
  }
  
  public Post insert(Post post) {
    return repository.insert(post);
  }
  
  public void delete(String id) {
    repository.deleteById(id);
  }
  
  public Post update(Post post) {
    return repository.save(updateData(post));
  }
  
  private Post updateData(Post updatedPost) {
    Post post = findById(updatedPost.getId());
    post.setTitle(updatedPost.getTitle());
    post.setDate(updatedPost.getDate());
    post.setBody(updatedPost.getBody());
    return post;
  }
}