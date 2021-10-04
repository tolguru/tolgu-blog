package com.tolgu.blog.springboot.web;

import com.tolgu.blog.springboot.config.auth.LoginUser;
import com.tolgu.blog.springboot.config.auth.dto.SessionUser;
import com.tolgu.blog.springboot.domain.posts.Posts;
import com.tolgu.blog.springboot.service.posts.PostsService;
import com.tolgu.blog.springboot.web.dto.PostsResponseDTO;
import com.tolgu.blog.springboot.web.dto.PostsSaveRequestDTO;
import com.tolgu.blog.springboot.web.dto.PostsUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // final로 선언된 것들을 초기화하는 생성자를 자동으로 만들어줌
@RestController // requestBody + Controller
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDTO requestDTO, @LoginUser SessionUser user) {

        if (user != null) {
            return postsService.save(requestDTO, user.getId()); // 게시글 작성 시 세션의 유저 PK를 함께 저장
        }

        return -1L;
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDTO requestDTO) {
        return postsService.update(id, requestDTO);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDTO findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete (@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
