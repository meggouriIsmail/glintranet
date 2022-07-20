package com.giantlink.glintranet.servicesImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.Comment;
import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.entities.Reply;
import com.giantlink.glintranet.mappers.CommentMapper;
import com.giantlink.glintranet.mappers.EmployeeMapper;
import com.giantlink.glintranet.repositories.CommentRepository;
import com.giantlink.glintranet.repositories.EmployeeRepository;
import com.giantlink.glintranet.repositories.FAQRepository;
import com.giantlink.glintranet.repositories.ReplyRepository;
import com.giantlink.glintranet.requests.CommentRequest;
import com.giantlink.glintranet.requests.ReplyRequest;
import com.giantlink.glintranet.responses.CommentResponse;
import com.giantlink.glintranet.responses.ReplyResponse;
import com.giantlink.glintranet.services.CommentService;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	FAQRepository faqRepository;

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ReplyRepository replyRepository;

	@Autowired
	CommentMapper commentMapper;

	@Override
	public CommentResponse add(CommentRequest commentRequest) {
		Optional<FAQ> optionalFAQ = faqRepository.findById(commentRequest.getFaq_Id());
		Optional<Employee> optionalEmp = employeeRepository.findById(commentRequest.getEmp_Id());

		if (optionalFAQ.isPresent()) {
			Comment comment = Comment.builder().commentDate(commentRequest.getCommentDate())
					.content(commentRequest.getContent()).faq(optionalFAQ.get()).employee(optionalEmp.get()).build();
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
		List<CommentResponse> commentResponses = new ArrayList<CommentResponse>();
		commentRepository.findAll().forEach(comment -> {
			CommentResponse response = CommentResponse.builder()
					.id(comment.getId())
					.commentDate(comment.getCommentDate())
					.content(comment.getContent())
					.replies(buildReplies(comment.getReplies()))
					.employeeCommentResponse(EmployeeMapper.INSTANCE.employeeToEmployeeComment(comment.getEmployee()))
					.build();
					
					commentResponses.add(response);
				});
		return commentResponses;
	}
	
	private Set<ReplyResponse> buildReplies(Set<Reply> replies){

		Set<ReplyResponse> replyResponses = new HashSet<ReplyResponse>();
		replies.forEach(reply -> {
			ReplyResponse response = ReplyResponse.builder()
					.id(reply.getId())
					.content(reply.getContent())
					.employeeCommentResponse(EmployeeMapper.INSTANCE.employeeToEmployeeComment(reply.getEmployee()))
					.replyDate(reply.getReplyDate())
					.build();
			replyResponses.add(response);
		});
		
		return replyResponses;
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

	@Override
	public ReplyResponse add(ReplyRequest replyRequest) {
		Comment comment = commentRepository.getById(replyRequest.getCmt_Id());
		Employee employee = employeeRepository.getById(replyRequest.getEmp_Id());
		
		Reply reply = Reply.builder()
				.comment(comment)
				.content(replyRequest.getContent())
				.employee(employee)
				.build();
		Reply savedRepl = replyRepository.save(reply);
		ReplyResponse replyResponse = ReplyResponse.builder()
				.id(savedRepl.getId())
				.content(savedRepl.getContent())
				.replyDate(savedRepl.getReplyDate())
				.employeeCommentResponse(EmployeeMapper.INSTANCE.employeeToEmployeeComment(employee))
				.build();
		return replyResponse;
	}

}
