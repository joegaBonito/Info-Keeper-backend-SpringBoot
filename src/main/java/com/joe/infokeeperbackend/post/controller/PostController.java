package com.joe.infokeeperbackend.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.joe.infokeeperbackend.post.domain.Post;
import com.joe.infokeeperbackend.post.service.PostService;


@Controller
public class PostController {
	
	@Autowired
	PostService postService;
	

	@RequestMapping(value="/showinfo/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> fetchPost(@PathVariable("id") long id) {
		Post post = postService.findOne(id);
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}
	
	@RequestMapping(value="/showinfolists", method=RequestMethod.GET)
	public ResponseEntity<?> fetchPosts() {
		List<Post> posts = postService.fetchPostsById();
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}
	
	@RequestMapping(value="/createinfo", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createPost(@RequestBody Post resource) {
		resource.setDeleteYN('N');
		postService.save(resource);
	}
	
	@RequestMapping(value="/updateinfo/{id}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updatePost(@PathVariable("id") long id, @RequestBody Post resource) {
		Post post = postService.findOne(id);
		post.setSource(resource.getSource());
		post.setInfoId(resource.getInfoId());
		post.setInfoPassword(resource.getInfoPassword());
		post.setKeyNotes(resource.getKeyNotes());
		postService.save(post);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deletePost(@PathVariable("id") long id) {
		postService.delete(id);
	}
}
