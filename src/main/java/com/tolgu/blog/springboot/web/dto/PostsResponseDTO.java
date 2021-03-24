package com.tolgu.blog.springboot.web.dto;

import com.tolgu.blog.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String author;
//    private int views;
//    private int likes;
//    private int authorID;
// 게시글 확인했을 때 응답 DTO. 게시글 확인 페이지 만들고 수정해야 함

    public PostsResponseDTO(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
//        this.views = entity.getViews();
//        this.likes = entity.getLikes();
//        this.authorID = entity.getAuthorID();
    }
}
