package com.ada.controller;

import com.ada.dto.ResponseDTO;
import com.ada.entity.Comment;
import com.ada.service.CommentServiceImpl;
import com.ada.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/comment/")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private SessionService sessionService;


    @PostMapping("addComment/{bookName}")
    public ResponseDTO addComment(@PathVariable("bookName") String bookName, @RequestBody Comment comment, HttpServletRequest request){
        if(sessionService.getSessionInfo(request)!=null) {
            commentService.addComment(bookName, comment);
            return ResponseDTO.getInstance().success("Successfully added");
        }
        return ResponseDTO.getInstance().success("Please login before hit the url");
    }


    @PostMapping("addReply/{commentId}")
    public ResponseDTO addReply(@PathVariable("commentId") String commentId,@RequestBody Comment comment,HttpServletRequest request){
        if(sessionService.getSessionInfo(request)!=null) {
            commentService.addReply(commentId, comment);
            return ResponseDTO.getInstance().success("Successfully added");
        }
        return ResponseDTO.getInstance().success("Please login before hit the url");
    }

}
