package com.joe.infokeeperbackend.post.service;

import java.util.List;

import com.joe.infokeeperbackend.post.domain.Post;

public interface PostService {
	public Post findOne(long id);
	
	public void save(Post resource);

	public List<Post> fetchPostsById();

	public void delete(long id);
}
