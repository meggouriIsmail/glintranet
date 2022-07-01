package com.giantlink.glintranet.services;

import java.util.List;

import com.giantlink.glintranet.requests.FAQRequest;
import com.giantlink.glintranet.responses.FAQResponse;

public interface FAQService {
	FAQResponse addFaq(FAQRequest faqRequest);

	List<FAQResponse> getAll();

	List<FAQResponse> getAllBySection(Long sectionId);

	FAQResponse getFaq(Long id);

	FAQResponse editFaq(Long id, FAQRequest faqRequest);

	void deleteFaq(Long id);

	FAQResponse voteUp(Long id);

	FAQResponse voteDown(Long id);
}
