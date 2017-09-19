package com.joe.infokeeperbackend.post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

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
	public void createPost( @RequestParam(value="fileData") MultipartFile fileData, 
							@RequestParam(value="source") String source,
							@RequestParam(value="infoId") String infoId,
							@RequestParam(value="infoPassword") String infoPassword,
							@RequestParam(value="keyNotes") String keyNotes) throws IOException {
		Post p = new Post();
		p.setDeleteYN('N');
		byte[] bytesarray = fileData.getBytes();
		p.setFileData(bytesarray);
		p.setSource(source);
		p.setInfoId(infoId);
		p.setInfoPassword(infoPassword);
		p.setKeyNotes(keyNotes);
		postService.save(p);
	}
	
	@RequestMapping(value="/updateinfo/{id}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updatePost(@PathVariable("id") long id, 
			@RequestParam(value="fileData") MultipartFile fileData, 
			@RequestParam(value="source") String source,
			@RequestParam(value="infoId") String infoId,
			@RequestParam(value="infoPassword") String infoPassword,
			@RequestParam(value="keyNotes") String keyNotes) throws IOException {
		Post post = postService.findOne(id);
		byte[] bytesarray = fileData.getBytes();
		post.setFileData(bytesarray);
		post.setSource(source);
		post.setInfoId(infoId);
		post.setInfoPassword(infoPassword);
		post.setKeyNotes(keyNotes);
		postService.save(post);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deletePost(@PathVariable("id") long id) {
		postService.delete(id);
	}
	
	/*
	 * Displays image to web from the database blob.
	 */
	@RequestMapping(value = "/post/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		byte[] imageContent = postService.findOne(id).getFileData();
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
}
