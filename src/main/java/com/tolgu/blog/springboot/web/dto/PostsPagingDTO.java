package com.tolgu.blog.springboot.web.dto;

import lombok.Getter;

@Getter
public class PostsPagingDTO {
    private int totalPages;
    private Long totalElements;
    private int size;
    private int nowPage;

    public PostsPagingDTO(int totalPages, Long totalElements, int size, int nowPage) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.size = size;
        this.nowPage = nowPage;
    }
}
