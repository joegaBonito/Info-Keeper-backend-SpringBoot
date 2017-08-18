package com.joe.infokeeperbackend.post.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joe.infokeeperbackend.post.domain.Post;
import com.joe.infokeeperbackend.post.repository.PostRepository;
import com.joe.infokeeperbackend.post.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepository;

	@Override
	public Post findOne(long id) {
		return postRepository.findOne(id);
	}

	@Override
	public void save(Post resource) {
		postRepository.save(resource);
	}

	@Override
	public List<Post> fetchPostsById() {
		return postRepository.findAllPostsWhereDeleteYNIsN();
	}

	@Override
	public void delete(long id) {
		Post post = postRepository.findOne(id);
		post.setDeleteYN('Y');
		save(post);
	}
}

