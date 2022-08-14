package com.spelltome.production;

import org.springframework.data.domain.Page;

public interface PostService {
    Page<Post> findAllPost(int page);
//    Post findAllPostByID(long id);
    Post addPost(Post post);
//    void deleteAllData();

    Page<Post> findAllPostByTavernId(long id, int page);
}
