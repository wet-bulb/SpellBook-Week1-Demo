package com.spellbook.wk1demov3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final PostServiceImpl postServiceImpl;

    PostController(PostServiceImpl postServiceImpl) {
        this.postServiceImpl = postServiceImpl;
    }

    @GetMapping("/posts")
    List<Post> all() {
        return postServiceImpl.findAllPost();
    }

    @PostMapping("/posts")
    Post add(@RequestBody Post newPost) {
        return postServiceImpl.addPost(newPost);
    }


}
