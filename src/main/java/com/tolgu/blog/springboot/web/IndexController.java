package com.tolgu.blog.springboot.web;

import com.tolgu.blog.springboot.config.auth.LoginUser;
import com.tolgu.blog.springboot.config.auth.dto.SessionUser;
import com.tolgu.blog.springboot.service.posts.PostsService;
import com.tolgu.blog.springboot.web.dto.PostsIndexPageDTO;
import com.tolgu.blog.springboot.web.dto.PostsResponseDTO;
import com.tolgu.blog.springboot.web.dto.PostsUpdateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

//    @GetMapping("/")
//    public String index(@PageableDefault(sort = {"id"},
//            direction = Sort.Direction.DESC,
//            size = 10) Pageable page, Model model) {
//        model.addAttribute("posts", postsService.findPagingDesc(page));
//
//        model.addAttribute("page", 0);
//        return "index";
//    }

    @GetMapping("/")
    public String indexPage(@PageableDefault(sort = {"id"},
            direction = Sort.Direction.DESC,
            size = 10) Pageable page, Model model) {
        PostsIndexPageDTO posts = postsService.findPagingDesc(page);
        model.addAttribute("posts", posts.getPostsListResponseDTO());
        model.addAttribute("page", posts.getPostsPagingDTO());
        return "index";
    }

    @GetMapping("/posts/read/{id}")
    public String postsRead(@PathVariable Long id, @LoginUser SessionUser user, Model model) {
        PostsResponseDTO dto = postsService.findById(id);
        model.addAttribute("post", dto);

        // 유저 ID와 게시자 ID 비교, 같을 시 웹에서 수정, 삭제 버튼을 노출
        if (user.getId().equals(dto.getAuthorID())) {
            model.addAttribute("user", user.getId());
        }

        return "posts-read";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        PostsUpdateResponseDTO dto = postsService.findByIdforUpdate(id);
        if (user.getId().equals(dto.getAuthorID())) {
            model.addAttribute("post", dto);
            return "posts-update";
        }
        return "posts-error";
    }

    @GetMapping("/myprofile")
    public String myProfile(@LoginUser SessionUser user, Model model) {
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "my-profile";
    }
}
