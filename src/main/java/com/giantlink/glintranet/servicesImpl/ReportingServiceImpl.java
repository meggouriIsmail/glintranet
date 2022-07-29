package com.giantlink.glintranet.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.repositories.CommentRepository;
import com.giantlink.glintranet.repositories.DocumentRepository;
import com.giantlink.glintranet.repositories.FAQRepository;
import com.giantlink.glintranet.repositories.ProjectRepository;
import com.giantlink.glintranet.responses.ReportingResponse;
import com.giantlink.glintranet.services.ReportingService;

@Service
public class ReportingServiceImpl implements ReportingService
{
	@Autowired
	FAQRepository faqRepository;
	
	@Autowired
	DocumentRepository documentRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public ReportingResponse getReports() {
		ReportingResponse response = new ReportingResponse();
		response.setTotFAQs(faqRepository.getFAQTotal());
		response.setTotDocs(documentRepository.getDocsTotal());
		response.setTotComment(commentRepository.getTotComment());
		response.setTotProjects(projectRepository.getTotProjects());
		response.setReports(faqRepository.getFaqBySectionName());
		
		return response;
	}

	
	
	
}
