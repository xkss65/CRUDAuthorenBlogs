package com.therealdanvega.controller;

import com.therealdanvega.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.therealdanvega.service.PostService;

@Controller
public class HomeController {

//	private AuthorService authorService;
	private PostService postService;

	@Autowired
	public HomeController(PostService postService){
		this.postService = postService;
	}
//	public HomeController(AuthorService authorService){
//		this.authorService = authorService;
//	}

	@RequestMapping("/")
	public String home(Model model){
		model.addAttribute("post", postService.getLatestPost());
//		model.addAttribute("author", authorService.getLatestAuthor());
		return "index";
	}

}
