  package com.giantlink.glintranet.servicesImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.EmployeeFAQ;
import com.giantlink.glintranet.entities.EmployeeFaqId;
import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.entities.Reply;
import com.giantlink.glintranet.entities.Section;
import com.giantlink.glintranet.entities.Tag;
import com.giantlink.glintranet.mappers.EmployeeMapper;
import com.giantlink.glintranet.mappers.FAQMapper;
import com.giantlink.glintranet.repositories.EmployeeFaqRepository;
import com.giantlink.glintranet.repositories.EmployeeRepository;
import com.giantlink.glintranet.repositories.FAQRepository;
import com.giantlink.glintranet.repositories.SectionRepository;
import com.giantlink.glintranet.repositories.TagRepository;
import com.giantlink.glintranet.requests.FAQRequest;
import com.giantlink.glintranet.responses.CommentResponse;
import com.giantlink.glintranet.responses.FAQResponse;
import com.giantlink.glintranet.responses.ReplyResponse;
import com.giantlink.glintranet.services.FAQService;

@Service
public class FAQServiceImpl implements FAQService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	SectionRepository sectionRepository;

	@Autowired
	TagRepository tagRepository;

	@Autowired
	FAQRepository faqRepository;
	
	@Autowired
	EmployeeFaqRepository employeeFaqRepository;

	@Autowired
	FAQMapper faqMapper;

	@Override
	public FAQResponse addFaq(FAQRequest faqRequest) {
		int vote = 0;
		Optional<Employee> emp = employeeRepository.findById(faqRequest.getEmployee_id());
		Optional<Section> sec = sectionRepository.findById(faqRequest.getSection_id());
		if (!emp.isPresent() && !sec.isPresent()) {
			throw new RuntimeException("employee doesnt exist");
		} else {
			FAQ faq = FAQ.builder().content(faqRequest.getContent()).description(faqRequest.getDescription())
					.votes(vote).status(faqRequest.getStatus()).build();

			faq.setEmployee(emp.get());
			faq.setSection(sec.get());
			faqRepository.save(faq);

			Set<Tag> tags = faq.getTags() == null ? new HashSet<>() : faq.getTags();
			
			if (faqRequest.getTags() != null && !faqRequest.getTags().isEmpty()) {
				faqRequest.getTags().forEach(t -> {
					Optional<Tag> opTag = tagRepository.findByName(t.getName());
					if (opTag.isPresent()) {
						tags.add(opTag.get());						
					}
				});
				faq.setTags(tags);
				faqRepository.save(faq);
			}

			return faqMapper.entityToResponse(faq);
		}
	}

	@Override
	public List<FAQResponse> getAll() {
		
		
		List<FAQResponse> allFAQs = new ArrayList<FAQResponse>();
		faqRepository.findAll(Sort.by(Sort.Direction.DESC, "postingDate")).forEach(faq -> {
			List<CommentResponse> commentResponses = new ArrayList<CommentResponse>();
			
			faq.getComments().forEach(comment -> {
				CommentResponse response = CommentResponse.builder()
						.id(comment.getId())
						.commentDate(comment.getCommentDate())
						.content(comment.getContent())
						.employeeCommentResponse(EmployeeMapper.INSTANCE.employeeToEmployeeComment(comment.getEmployee()))
						.build();
						
						commentResponses.add(response);
					});
			FAQResponse faqResponse = faqMapper.entityToResponse(faq);
			faqResponse.setComments(commentResponses);
			
			allFAQs.add(faqResponse);
			
		});
		return allFAQs;
	}
	
	@Override
	public List<FAQResponse> getAllBySection(Long sectionId) {
		
		
		List<FAQResponse> allFAQs = new ArrayList<FAQResponse>();
		faqRepository.findAllBySection(sectionId).forEach(faq -> {
			List<CommentResponse> commentResponses = new ArrayList<CommentResponse>();
			
			faq.getComments().forEach(comment -> {
				CommentResponse response = CommentResponse.builder()
						.id(comment.getId())
						.commentDate(comment.getCommentDate())
						.content(comment.getContent())
						.employeeCommentResponse(EmployeeMapper.INSTANCE.employeeToEmployeeComment(comment.getEmployee()))
						.build();
				
				commentResponses.add(response);
			});
			FAQResponse faqResponse = faqMapper.entityToResponse(faq);
			faqResponse.setComments(commentResponses);
			
			allFAQs.add(faqResponse);
			
		});
		return allFAQs;
	}

	@Override
	public FAQResponse getFaq(Long id) {
		Optional<FAQ> faq = faqRepository.findById(id);
		if (faq.isEmpty()) {
			throw new NoSuchElementException("FAQ doesnt exist");
		}

		FAQResponse response = faqMapper.entityToResponse(faqRepository.getById(id));

		List<CommentResponse> commentResponses = new ArrayList<CommentResponse>();
		
		faqRepository.getById(id).getComments().forEach(comment -> {
			CommentResponse commentResponse = CommentResponse.builder()
					.id(comment.getId())
					.commentDate(comment.getCommentDate())
					.content(comment.getContent())
					.employeeCommentResponse(EmployeeMapper.INSTANCE.employeeToEmployeeComment(comment.getEmployee()))
					.replies(buildReplies(comment.getReplies()))
					.build();
					
					commentResponses.add(commentResponse);
				});
		response.setComments(commentResponses);
		
		return response;
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
	public FAQResponse editFaq(Long id, FAQRequest faqRequest) {
		Optional<Employee> foundEmp = employeeRepository.findById(faqRequest.getEmployee_id());
		Optional<Section> foundSec = sectionRepository.findById(faqRequest.getSection_id());
		Optional<FAQ> faq = faqRepository.findById(id);

		if (foundEmp.isEmpty()) {
			throw new NoSuchElementException("Employee doesnt exist");
		}

		if (foundSec.isEmpty()) {
			throw new NoSuchElementException("Section doesnt exist");
		}

		if (faq.isEmpty()) {
			throw new NoSuchElementException("FAQ doesnt exist");
		}

		FAQ updatedFaq = faqRepository.getById(id);
		updatedFaq.setContent(faqRequest.getContent());
		updatedFaq.setDescription(faqRequest.getDescription());
		updatedFaq.setStatus(faqRequest.getStatus());

		updatedFaq.setEmployee(foundEmp.get());
		updatedFaq.setSection(foundSec.get());

		faqRepository.save(updatedFaq);

		return faqMapper.entityToResponse(updatedFaq);
	}

	@Override
	public void deleteFaq(Long id) {
		faqRepository.deleteById(id);

	}

	@Override
	public FAQResponse voteDown(Long id) 
	{
		FAQ faq = faqRepository.getById(id);
		Employee employee = employeeRepository.findById(faq.getEmployee().getId()).get();
		
		int vote = faq.getVotes();
		int voteDown = faq.getVotesDown(), voteUp = faq.getVotesUp();
		
		if(employeeFaqRepository.existsById(new EmployeeFaqId(employee.getId(),faq.getId())))
		{
			EmployeeFAQ employeeFAQ = employeeFaqRepository.findById(new EmployeeFaqId(employee.getId(),id)).get();
			if(employeeFAQ.isVoted_down()) 
			{
				employeeFAQ.setVoted_down(false);
				
				employeeFaqRepository.save(employeeFAQ);
				voteDown--;
			}
			else if(employeeFAQ.isVoted_up()) 
			{
				employeeFAQ.setVoted_up(false);
				employeeFAQ.setVoted_down(true);
				employeeFaqRepository.save(employeeFAQ);
				voteUp--;
				voteDown++;

			}
			
			  else if(employeeFAQ.isVoted_up() == false && employeeFAQ.isVoted_down() == false) 
			  { 
				  employeeFAQ.setVoted_down(true);
				  employeeFaqRepository.save(employeeFAQ); 
				  voteDown++;
			  } 
		}
		else 
		{
			EmployeeFAQ employeeFAQ2 = new EmployeeFAQ();
			
			employeeFAQ2.setEmployee(employee);
			employeeFAQ2.setFaq(faq);
			employeeFAQ2.setEmployeeFaqId(new EmployeeFaqId(employee.getId(), faq.getId()));
			
			employeeFAQ2.setVoted_up(true);
			employeeFAQ2.setVoted_down(false);
			
			employeeFaqRepository.save(employeeFAQ2);
			
			vote++;
			voteUp++;
		} 
		
		faq.setVotes(vote);
		faq.setVotesUp(voteUp);
		faq.setVotesDown(voteDown);
		faqRepository.save(faq);

		return faqMapper.entityToResponse(faq);
	}

	@Override
	public FAQResponse voteUp(Long id) 
	{
		FAQ faq = faqRepository.findById(id).get();
		Employee employee = employeeRepository.findById(faq.getEmployee().getId()).get();
		
		int vote = faq.getVotes();
		int voteUp = faq.getVotesUp(), voteDown = faq.getVotesDown();
		 

		if(employeeFaqRepository.existsById(new EmployeeFaqId(employee.getId(),faq.getId())))
		{
			EmployeeFAQ employeeFAQ = employeeFaqRepository.findById(new EmployeeFaqId(employee.getId(),id)).get();
			if(employeeFAQ.isVoted_up()) 
			{
				employeeFAQ.setVoted_up(false);
				employeeFaqRepository.save(employeeFAQ);
				voteUp--;	
			}
			else if(employeeFAQ.isVoted_down()) 
			{
				employeeFAQ.setVoted_down(false);
				employeeFAQ.setVoted_up(true);
				employeeFaqRepository.save(employeeFAQ);

				voteDown--;
				voteUp++;

			}
			else if(employeeFAQ.isVoted_up() == false && employeeFAQ.isVoted_down() == false) 
			{ 
				employeeFAQ.setVoted_up(true);
				employeeFaqRepository.save(employeeFAQ);
				voteUp++; 
			}
			 
		}
		else 
		{
			EmployeeFAQ employeeFAQ2 = new EmployeeFAQ();
			employeeFAQ2.setEmployee(employee);
			employeeFAQ2.setFaq(faq);
			employeeFAQ2.setEmployeeFaqId(new EmployeeFaqId(employee.getId(), faq.getId()));
			
			employeeFAQ2.setVoted_up(true);
			employeeFAQ2.setVoted_down(false);
			
			vote++;
			voteUp++;
			
			employeeFaqRepository.save(employeeFAQ2);
		}
		
		
		faq.setVotes(vote);
		faq.setVotesUp(voteUp);
		faq.setVotesDown(voteDown);
		faqRepository.save(faq);

		return faqMapper.entityToResponse(faq);
	}

	@Override
	public EmployeeFAQ faqVote(Long id_employee, Long id_faq) 
	{
		Optional<EmployeeFAQ> found = employeeFaqRepository.findById(new EmployeeFaqId(id_employee,id_faq));
		if(found.isEmpty()) 
		{ throw new NoSuchElementException("No record");		}
		
		EmployeeFAQ employeeFAQ = found.get();
		
		
		return employeeFAQ;
	}

}
