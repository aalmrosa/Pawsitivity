package com.pawsitivity.server.controller;

import com.pawsitivity.server.dto.PostDto;
import com.pawsitivity.server.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/posts")
@Controller
public class PostController {
    private PostService postService;

    @GetMapping("/new")
    public String newPost(Model model) {
        model.addAttribute("postDto", new PostDto());
        return "new-post";
    }

    @PostMapping("/new/create")
    public String createNewPost(@ModelAttribute PostDto postDto) {
        postService.save(postDto);
        return "new-post";
    }
}
