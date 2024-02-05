package com.hcorupe.blog.model.dto;

import com.hcorupe.blog.model.Author;
import com.hcorupe.blog.model.Post;

public record PostDetails(Post post, Author author) {
}
