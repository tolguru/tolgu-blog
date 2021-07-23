package com.tolgu.blog.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 이 어노테이션으로 스프링 부트 자동 설정, Bean 읽기 생성 자동 설정됨
public class Application { // 설정의 시작이기 때문에 항상 최상단에 위치해야 함
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS(Web Application Server) 실행, 톰캣 필요 없음
    }
}
