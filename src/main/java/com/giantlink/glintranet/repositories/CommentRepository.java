package com.giantlink.glintranet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.giantlink.glintranet.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	@Query("select COUNT(*) as totalComments from Comment")
	int getTotComment();

}
