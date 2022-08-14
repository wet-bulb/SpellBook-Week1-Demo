package com.spellbook.production;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository repository;

    PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Post> findAllPost(int page) {
        Pageable pageWithSixElements = PageRequest.of(page, 6, Sort.by("id").descending());
        Page<Post> postPage = repository.findAll(pageWithSixElements);
        System.out.println(postPage);
        return postPage;
    }

    @Override
    public Page<Post> findAllPostByTavernId(long id, int page) {
        Pageable pageWithSixElements = PageRequest.of(page, 6, Sort.by("id").descending());
        Page<Post> postPage = repository.findByTavernId(id, pageWithSixElements);
        System.out.println(postPage);
        return postPage;
    }

    @Override
    public Post addPost(Post newPost) {
        return repository.save(newPost);
    }
}
