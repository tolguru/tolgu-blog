package com.tolgu.blog.springboot.web.dto;

import com.tolgu.blog.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // Setter은 만들지 않는다. 대신 명확한 목적을 지닌 메소드를 만들어 사용한다.
@NoArgsConstructor
public class PostsSaveRequestDTO {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDTO(String title, String  content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() { // 팩토리 메소드
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
