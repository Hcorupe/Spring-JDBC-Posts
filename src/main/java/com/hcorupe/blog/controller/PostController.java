package com.hcorupe.blog.controller;

import com.hcorupe.blog.model.Post;
import com.hcorupe.blog.model.dto.PostDetails;
import com.hcorupe.blog.repo.AuthorRepo;
import com.hcorupe.blog.repo.PostRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    //POST and AUTHOR aggregate relationship

    private final PostRepo posts;
    private final AuthorRepo authors;

    public PostController(PostRepo posts, AuthorRepo authors) {
        this.posts = posts;
        this.authors = authors;
    }

    @GetMapping
    public Iterable<Post> findAll(){
        return posts.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Integer id){
        return posts.findById(id).orElse(null);
    }

    @GetMapping("/{id}/details")
    public PostDetails getPostDetails(@PathVariable Integer id){
        Post post = posts.findById(id).orElse(null);
        return new PostDetails(post, authors.findById(post.getAuthor().getId()).get());
    }


}
