package com.ada.service;

import com.ada.entity.Comment;

public interface CommentService {

    void addComment(String bookName, Comment comment);

    void addReply(String id, Comment comment);
}
