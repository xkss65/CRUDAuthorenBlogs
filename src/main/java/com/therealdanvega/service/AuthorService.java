package com.therealdanvega.service;

import java.util.List;

//import com.therealdanvega.domain.Post;
import com.therealdanvega.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.therealdanvega.domain.Author;
import com.therealdanvega.repository.AuthorRepository;

@Service
public class AuthorService {

	private AuthorRepository authorRepository;

	@Autowired
	public AuthorService(AuthorRepository authorRepository) {
//>??
//		super(); Neeeeeee
//<??
		this.authorRepository = authorRepository;
	}

	public Author getLatestAuthor(){
		return authorRepository.findFirstByOrderByFirstName();
	}

	public Author getLatestAuthor(Long id){ return authorRepository.findOne(id); }

	public List<Author> list() {
		return authorRepository.findAll();
	}

	public Author get(Long id) {
		return authorRepository.findOne(id);
	}

	public Author save(Author author) {
		return authorRepository.save(author);
	}

	public void delete(Long id) {
		authorRepository.delete(id);
	}


}






