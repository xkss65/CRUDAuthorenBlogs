package com.therealdanvega.repository;

import com.therealdanvega.domain.Author;
import com.therealdanvega.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findFirstByOrderByFirstName();

}
