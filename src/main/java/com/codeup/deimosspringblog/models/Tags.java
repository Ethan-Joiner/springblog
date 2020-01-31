package com.codeup.deimosspringblog.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tags extends JpaRepository<Tag, Long> {
    List<Tag> findAll();
    Tag findById(long id);
}
