package com.codeup.deimosspringblog.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = ("INT UNSIGNED"))
    private long id;

    @Column(length = 50)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;
}
