package com.spellbook.wk1demov3;

import java.util.List;

public interface PostService {
    List<Post> findAllPost();
//    Post findAllPostByID(long id);
    Post addPost(Post post);
//    void deleteAllData();
}
