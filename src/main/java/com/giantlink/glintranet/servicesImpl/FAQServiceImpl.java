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
import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.entities.Section;
import com.giantlink.glintranet.entities.Tag;
import com.giantlink.glintranet.mappers.EmployeeMapper;
import com.giantlink.glintranet.mappers.FAQMapper;
import com.giantlink.glintranet.repositories.EmployeeRepository;
import com.giantlink.glintranet.repositories.FAQRepository;
import com.giantlink.glintranet.repositories.SectionRepository;
import com.giantlink.glintranet.repositories.TagRepository;
import com.giantlink.glintranet.requests.FAQRequest;
import com.giantlink.glintranet.responses.CommentResponse;
import com.giantlink.glintranet.responses.FAQResponse;
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
			//werioh
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
					.build();
					
					commentResponses.add(commentResponse);
				});
		response.setComments(commentResponses);
		
		return response;
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
	public FAQResponse voteDown(Long id) {
		FAQ faq = faqRepository.getById(id);
		int vote = faq.getVotes();
		vote--;
		faq.setVotes(vote);
		faqRepository.save(faq);

		return faqMapper.entityToResponse(faq);
	}

	@Override
	public FAQResponse voteUp(Long id) {
		FAQ faq = faqRepository.findById(id).get();
		int vote = faq.getVotes();
		vote++;
		faq.setVotes(vote);
		faqRepository.save(faq);

		return faqMapper.entityToResponse(faq);
	}

}
