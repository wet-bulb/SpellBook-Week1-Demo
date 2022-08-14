package com.spelltome.production;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class PostController {

    private final PostServiceImpl postServiceImpl;

    PostController(PostServiceImpl postServiceImpl) {
        this.postServiceImpl = postServiceImpl;
    }

    @GetMapping("/posts")
    Page<Post> all(@RequestParam int page) {
        return postServiceImpl.findAllPost(page);
    }

    @GetMapping("/taverns/{tavernId}/posts")
    Page<Post> tavern(@PathVariable(value = "tavernId") long tavernId, @RequestParam int page) {
        return postServiceImpl.findAllPostByTavernId(tavernId, page);
    }

    @PostMapping("/posts")
    Post add(@RequestBody Post newPost) {
        return postServiceImpl.addPost(newPost);
    }


}
