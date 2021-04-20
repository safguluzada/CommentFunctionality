package com.ada.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "comments")
public class Comment {


    @Id
    private String id;

    private Long bookId;

    private String commenter;

    private String comment;

    private List<Comment> replies = new ArrayList<>(1);

    public Comment(Long bookId, String commenter, String comment, List<Comment> replies) {
        this.bookId = bookId;
        this.commenter = commenter;
        this.comment = comment;
        this.replies = replies;
    }
}
