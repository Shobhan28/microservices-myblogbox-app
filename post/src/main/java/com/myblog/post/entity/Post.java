package com.myblog.post.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="posts_table")
public class Post {
    @Id
    private String id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "published_date")
    private Date publishedDate;

    @PrePersist
    protected void onCreate() {
        publishedDate = new Date(System.currentTimeMillis());
    }
}