package com.giantlink.glintranet.mappers;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.Comment;
import com.giantlink.glintranet.entities.Reply;
import com.giantlink.glintranet.requests.CommentRequest;
import com.giantlink.glintranet.responses.CommentResponse;
import com.giantlink.glintranet.responses.ReplyResponse;

@Mapper(componentModel = "spring")
public interface CommentMapper {

	CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

	Comment toEntity(CommentRequest commentRequest);

	CommentResponse toResponse(Comment comment);

	List<CommentResponse> mapComments(List<Comment> employees);

	Set<ReplyResponse> mapReplies(Set<Reply> employees);
}
