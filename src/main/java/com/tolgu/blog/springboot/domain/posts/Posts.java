package com.tolgu.blog.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity { // 기존 VO(DTO) 역할인 듯

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    //Column은 옵션을 줄 때 사용
    private String author;

    @Column(nullable = false)
    private int views;

    @Column(nullable = false)
    private Long authorID;

    @Builder
    public Posts(String title, String content, String author, int views, Long authorID) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.views = views;
        this.authorID = authorID;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void increaseViews() { // 조건 넣어야 함
        this.views = views+1;
    }
}
