package com.codeup.deimosspringblog.repositories;

import com.codeup.deimosspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Posts extends JpaRepository<Post, Long> {

    Post findById(long id);}
