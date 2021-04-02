package com.tolgu.blog.springboot.config.auth;

import com.tolgu.blog.springboot.domain.posts.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 해당 클래스 없으면 구글 로그인 안 됨
@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // h2 console 화면을 사용하기 위해 아래 옵션을 비활성화
        http.csrf().disable().headers().frameOptions().disable()
                .and()
                // URL 권한을 설정하기 위한 시작
                .authorizeRequests()
                // URL 권한 관리 대상 설정, permitAll()은 전체 열람 권한 허용. 참고로 글쓰기는 허용 안했기 때문에 로그인해야 함
                // hasRole(Role.USER.name())은 USER 권한을 가진 사람만 허용한다는 뜻
                .antMatchers("/login", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile", "/page").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                // 설정된 URL을 제외한 나머지를 authenticated(인증된. 로그인한 사용자) 처리. 강제로 로그인 화면으로 이동됨..
                .anyRequest().authenticated()
                .and()
                // 로그아웃과 관련된 설정. 로그아웃 성공 시 "/" 경로로 이동
                .logout().logoutSuccessUrl("/login")
                .and()
                // OAuth2 로그인 기능에 대한 설정 시작점
                .oauth2Login().loginPage("/login")
                // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정 담당
                .userInfoEndpoint()
                // 소셜 로그인 성공 시 후속 조치할 UserService 인터페이스의 구현체 등록. 소셜 서비스들에서의 추가 작업 명시 가능
                .userService(customOAuth2UserService);
    }
}
