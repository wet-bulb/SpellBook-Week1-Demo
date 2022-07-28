package com.spellbook.wk1demov3;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository repository;

    PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Post> findAllPost() {
        return repository.findAll();
    }

    @Override
    public Post addPost(Post newPost) {
        return repository.save(newPost);
    }
}
