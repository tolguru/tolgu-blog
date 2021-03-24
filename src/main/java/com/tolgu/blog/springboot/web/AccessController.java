package com.tolgu.blog.springboot.web;

import com.tolgu.blog.springboot.web.dto.AccessResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {

    @GetMapping("/AccessTest")
    public String isOn() {
        return "On";
    }

    @GetMapping("/AccessTest/dto")
    public AccessResponseDTO helloDTO(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new AccessResponseDTO(name, amount);
    }
}
