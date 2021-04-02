package com.tolgu.blog.springboot.web;

import com.tolgu.blog.springboot.domain.posts.PostsRepository;
import com.tolgu.blog.springboot.web.dto.PostsSaveRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@RequiredArgsConstructor
//@Controller
public class SaveDummyTestController {
//    private final PostsRepository postsRepository;
//    private final int DummyCount = 500;
//
//
//    @GetMapping("/api/v1/posts/DummyTest")
//    public String createDummy() {
//        PostsSaveRequestDTO postsDTO;
//
//        for (int i = 1; i <= DummyCount; i++) {
//            postsDTO = PostsSaveRequestDTO.builder()
//                    .title(i + "번째 게시물")
//                    .author("TestDummy")
//                    .content("TestDummy")
//                    .build();
//            postsRepository.save(postsDTO.toEntity(1L));
//        }
//
//        return "/";
//    }
}
