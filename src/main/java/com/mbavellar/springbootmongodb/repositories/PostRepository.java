package com.mbavellar.springbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mbavellar.springbootmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { }