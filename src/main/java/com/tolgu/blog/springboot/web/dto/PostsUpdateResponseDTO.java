package com.tolgu.blog.springboot.web.dto;

import com.tolgu.blog.springboot.domain.posts.Posts;
import customUtil.TimeFormatter;
import lombok.Getter;

@Getter
public class PostsUpdateResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String author;
    private Long authorID;

    public PostsUpdateResponseDTO(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.authorID = entity.getAuthorID();
    }
}
