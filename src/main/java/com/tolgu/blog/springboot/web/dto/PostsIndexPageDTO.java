package com.tolgu.blog.springboot.web.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PostsIndexPageDTO {
    private List<PostsListResponseDTO> postsListResponseDTO;
    private PostsPagingDTO postsPagingDTO;

    public PostsIndexPageDTO(List<PostsListResponseDTO> postsListResponseDTO, PostsPagingDTO postsPagingDTO) {
        this.postsListResponseDTO = postsListResponseDTO;
        this.postsPagingDTO = postsPagingDTO;
    }
}
