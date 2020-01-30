package com.codeup.deimosspringblog.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Posts extends JpaRepository<Post, Long> {

    Post findById(long id);

}
