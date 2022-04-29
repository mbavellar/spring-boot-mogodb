package com.mbavellar.springbootmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mbavellar.springbootmongodb.domain.Comment;
import com.mbavellar.springbootmongodb.domain.Post;
import com.mbavellar.springbootmongodb.domain.User;
import com.mbavellar.springbootmongodb.dto.AuthorDTO;
import com.mbavellar.springbootmongodb.repositories.CommentRepository;
import com.mbavellar.springbootmongodb.repositories.PostRepository;
import com.mbavellar.springbootmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private CommentRepository commentRepository;
  
  @Override
  public void run(String... args) throws Exception {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    
    userRepository.deleteAll();
    
    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");
    
    userRepository.saveAll(Arrays.asList(maria, alex, bob));
    
    postRepository.deleteAll();
    
    Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!",
        "Vou viajar para São Paulo, abraços!", new AuthorDTO(maria));
    Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!",
        "Acordei feliz hoje!", new AuthorDTO(maria));
    
    commentRepository.deleteAll();
    
    Comment comment1 = new Comment(null, sdf.parse("21/03/2018"), "Boa viagem, mano!", new AuthorDTO(alex));
    Comment comment2 = new Comment(null, sdf.parse("22/03/2018"), "Aproveite!", new AuthorDTO(bob));
    Comment comment3 = new Comment(null, sdf.parse("23/03/2018"), "Tenha um ótimo dia!", new AuthorDTO(alex));
    
    commentRepository.saveAll(Arrays.asList(comment1, comment2, comment3));
    
    post1.getComments().addAll(Arrays.asList(comment1, comment2));
    post2.getComments().add(comment3);
    
    postRepository.saveAll(Arrays.asList(post1, post2));
    
    maria.getPosts().addAll(Arrays.asList(post1, post2));
    userRepository.save(maria);
  }

}
