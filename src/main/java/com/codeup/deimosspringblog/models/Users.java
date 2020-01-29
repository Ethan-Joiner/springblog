package com.codeup.deimosspringblog.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<User, Long> {
}
