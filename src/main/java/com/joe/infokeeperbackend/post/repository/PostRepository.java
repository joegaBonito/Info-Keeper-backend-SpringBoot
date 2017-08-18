package com.joe.infokeeperbackend.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joe.infokeeperbackend.post.domain.Post;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
	
	@Query("SELECT p FROM Post p WHERE p.deleteYN = 'N' ORDER BY p.id ASC ")
	public List<Post> findAllPostsWhereDeleteYNIsN();
	
}
