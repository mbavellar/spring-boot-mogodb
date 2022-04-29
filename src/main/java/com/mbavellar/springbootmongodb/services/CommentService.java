package com.mbavellar.springbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbavellar.springbootmongodb.domain.Comment;
import com.mbavellar.springbootmongodb.repositories.CommentRepository;
import com.mbavellar.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class CommentService {

  @Autowired
  private CommentRepository repository;
  
  public List<Comment> findAll() {
    return repository.findAll();
  }
  
  public Comment findById(String id) {
    return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
  }
  
  public Comment insert(Comment comment) {
    return repository.insert(comment);
  }
  
  public void delete(String id) {
    repository.deleteById(id);
  }
  
  public Comment update(Comment comment) {
    return repository.save(updateData(comment));
  }
  
  private Comment updateData(Comment updatedComment) {
    Comment comment = findById(updatedComment.getId());
    comment.setDate(updatedComment.getDate());
    comment.setText(updatedComment.getText());
    return comment;
  }
}
