package com.pawsitivity.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawsitivity.server.features.post.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
