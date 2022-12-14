package com.giantlink.glintranet.services;

import java.util.List;

import com.giantlink.glintranet.requests.CommentRequest;
import com.giantlink.glintranet.requests.ReplyRequest;
import com.giantlink.glintranet.responses.CommentResponse;
import com.giantlink.glintranet.responses.ReplyResponse;

public interface CommentService {
	CommentResponse add(CommentRequest commentRequest);

	ReplyResponse add(ReplyRequest replyRequest);

	CommentResponse get(Long id);

	List<CommentResponse> getAll();

	void delete(Long id);

	CommentResponse update(Long id, CommentRequest commentRequest);
}
