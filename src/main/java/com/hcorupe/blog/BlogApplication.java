package com.hcorupe.blog;

import com.hcorupe.blog.model.Author;
import com.hcorupe.blog.model.Comment;
import com.hcorupe.blog.model.Post;
import com.hcorupe.blog.repo.AuthorRepo;
import com.hcorupe.blog.repo.PostRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(PostRepo posts, AuthorRepo authors){
		return args -> {

			AggregateReference<Author, Integer> harrison =
					AggregateReference.to(
							authors.save(
									new Author(
											null,
											"Harrison",
											"Corupe",
											"Hcorupe@email.com",
											"Hcorupe"))
											.id());

			AggregateReference<Author, Integer> testUser2 =
					AggregateReference.to(
							authors.save(
											new Author(
													null,
													"TestUser2",
													"Two",
													"UserTWO@email.com",
													"TwoUser"))
									.id());

			AggregateReference<Author, Integer> testUser3 =
					AggregateReference.to(
							authors.save(
											new Author(
													null,
													"TestUser3",
													"Three",
													"UserThree@email.com",
													"ThreeUser"))
									.id());

			Post post = new Post("Post Title", "Post Content", harrison);
			Post post1 = new Post("Post Title2", "Post Content2", testUser2);
			Post post2 = new Post("Post Title3", "Post Content3", testUser3);



			post.addComment(new Comment("Harrison","Comment content"));
			post1.addComment(new Comment("testUser2", "Comment Content 2"));
			post2.addComment(new Comment("testUser3", "Comment Content 3"));



			posts.save(post);
			posts.save(post1);
			posts.save(post2);



		};
	}

}
