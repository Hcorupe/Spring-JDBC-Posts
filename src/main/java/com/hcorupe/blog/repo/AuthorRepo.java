package com.hcorupe.blog.repo;

import com.hcorupe.blog.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Integer> {
}
