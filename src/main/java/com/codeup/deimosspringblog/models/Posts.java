package com.codeup.deimosspringblog.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Posts extends JpaRepository<Post, Long> {

    Post findById(long id);
}
