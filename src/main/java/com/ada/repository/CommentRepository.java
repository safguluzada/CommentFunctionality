package com.ada.repository;

import com.ada.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CommentRepository extends MongoRepository<Comment, Integer> {

    Optional<Comment> findByBookId(Long bookId);
    Optional<Comment> findById(String id);
}
