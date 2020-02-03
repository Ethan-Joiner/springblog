package com.codeup.deimosspringblog.repositories;

import com.codeup.deimosspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<User, Long> {
    User findById(long id);
}
