package com.ada.service;

import com.ada.entity.Comment;
import com.ada.exception.CustomNotFoundException;
import com.ada.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService
{

    private static Long replyId = 1L;

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public void addComment(String bookName,Comment comment) {
        Long bookId = bookService.findBookByBookName(bookName).getId();
        Comment commentEntity = new Comment(bookId,comment.getCommenter(),comment.getComment(),null);
        commentRepository.save(commentEntity);
    }

    @Override
    public void addReply(String id, Comment comment) {
        Comment comment1 = commentRepository.findById(id).orElseThrow(()->new CustomNotFoundException(String.format("No any commenter with id ",id)));
        Comment commentEntity = new Comment(String.valueOf(replyId),comment1.getBookId(),comment.getCommenter(),comment.getComment(),null);
        List<Comment> commentList = comment1.getReplies();
        commentList.add(commentEntity);
        comment1.setReplies(commentList);
        commentRepository.save(comment1);
        replyId++;
    }

}
