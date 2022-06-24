package com.giantlink.glintranet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giantlink.glintranet.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
