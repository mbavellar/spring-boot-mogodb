package com.mbavellar.springbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mbavellar.springbootmongodb.domain.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {}