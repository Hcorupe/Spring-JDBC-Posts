package com.hcorupe.blog.repo;

import com.hcorupe.blog.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Integer> {
}
