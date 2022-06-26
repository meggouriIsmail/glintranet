package com.giantlink.glintranet.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.Comment;
import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.mappers.CommentMapper;
import com.giantlink.glintranet.repositories.CommentRepository;
import com.giantlink.glintranet.repositories.FAQRepository;
import com.giantlink.glintranet.requests.CommentRequest;
import com.giantlink.glintranet.responses.CommentResponse;
import com.giantlink.glintranet.services.CommentService;

@Service
public class CommentServiceImp implements CommentService {
	
	@Autowired
	CommentRepository commentRepository;

	@Autowired
	FAQRepository faqRepository;
	
	@Autowired
	CommentMapper commentMapper;

	@Override
	public CommentResponse add(CommentRequest commentRequest) {
		Optional<FAQ> optionalFAQ = faqRepository.findById(commentRequest.getFaq_Id());

		if (optionalFAQ.isPresent()) {
			Comment comment = Comment.builder()
					.commentDate(commentRequest.getCommentDate())
					.content(commentRequest.getContent())
					.faq(optionalFAQ.get())
					.build();
			return commentMapper.toResponse(commentRepository.save(comment));
		}
		
		return null;
	}

	@Override
	public CommentResponse get(Long id) {
		return commentMapper.toResponse(commentRepository.findById(id).get());
	}

	@Override
	public List<CommentResponse> getAll() {
		return commentMapper.mapComments(commentRepository.findAll());
	}

	@Override
	public void delete(Long id) {
		commentRepository.deleteById(id);
	}

	@Override
	public CommentResponse update(Long id, CommentRequest commentRequest) {
		FAQ FAQ = faqRepository.getById(commentRequest.getFaq_Id());
		
		Comment comment = commentRepository.getById(id);
		comment.setCommentDate(commentRequest.getCommentDate());
		comment.setContent(commentRequest.getContent());
		comment.setFaq(FAQ);
		
		return commentMapper.toResponse(commentRepository.save(comment));
	}

}
