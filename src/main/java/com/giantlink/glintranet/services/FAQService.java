package com.giantlink.glintranet.services;

import java.util.List;

import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.requests.FAQRequest;
import com.giantlink.glintranet.responses.FAQResponse;

public interface FAQService 
{
	FAQResponse addFaq(FAQRequest faqRequest);
	List<FAQResponse> getAll();
	FAQResponse getFaq(Long id);
	FAQResponse editFaq(Long id, FAQRequest faqRequest);
	void deleteFaq(Long id);
	FAQResponse voteUp(Long id);	
	void voteDown(Long id);
}
