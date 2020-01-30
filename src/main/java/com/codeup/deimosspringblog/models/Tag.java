package com.codeup.deimosspringblog.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = ("INT UNSIGNED"))
    private long id;

    @Column(length = 50)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;

    public Tag(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
