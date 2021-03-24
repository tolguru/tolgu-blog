package com.tolgu.blog.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfileController {
    private final Environment env;

    @GetMapping("/profile")
    public String profile() {
        // 현재 실행 중인 Active Profile을 모두 가져옴 (real, oauth, real-db)
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        
        // 스트링 리스트 생성
        List<String> realProfiles = Arrays.asList("real", "real1", "real2");

        // 실행 중인 Profile이 없다면 default, 있다면 첫 번째 Profile을 가져옴
        String defaultProfile = profiles.isEmpty()? "default" : profiles.get(0);

        return profiles.stream().filter(realProfiles::contains).findAny().orElse(defaultProfile);
    }
}
