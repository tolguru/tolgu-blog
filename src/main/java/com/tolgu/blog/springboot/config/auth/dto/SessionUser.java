package com.tolgu.blog.springboot.config.auth.dto;

import com.tolgu.blog.springboot.domain.posts.user.User;
import lombok.Getter;

import java.io.Serializable;

// 인증된 사용자 정보를 필요한 만큼 Session 클래스에 저장. 이후 Service에서 HttpSession 클래스에 등록
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
