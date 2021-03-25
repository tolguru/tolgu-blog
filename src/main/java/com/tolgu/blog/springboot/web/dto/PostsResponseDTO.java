package com.tolgu.blog.springboot.web.dto;

import com.tolgu.blog.springboot.domain.posts.Posts;
import customUtil.TimeChecker;
import customUtil.TimeFormatter;
import lombok.Getter;

@Getter
public class PostsResponseDTO {
    private String title;
    private String content;
    private String author;
    private String createdDate;
    private int views;
    private Long authorID;
// 게시글 확인했을 때 응답 DTO. 게시글 확인 페이지 만들고 수정해야 함

    public PostsResponseDTO(Posts entity) {
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.views = entity.getViews();
        this.authorID = entity.getAuthorID();
        createdDate = TimeFormatter.formTime(entity.getCreatedDate());
    }
}
