package com.tolgu.blog.springboot.web.dto;

import com.tolgu.blog.springboot.domain.posts.Posts;
import customUtil.TimeChecker;
import lombok.Getter;

// Index의 게시글 DTO
@Getter
public class PostsListResponseDTO {
    private Long id;
    private String title;
    private String author;
    private String createdDate;
    private int views;
    private Long authorID;

    public PostsListResponseDTO(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.views = entity.getViews();
        this.authorID = entity.getAuthorID();
        createdDate = TimeChecker.transeDateForm(entity.getCreatedDate());
    }
}
