package com.giantlink.glintranet.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.requests.FAQRequest;
import com.giantlink.glintranet.responses.FAQResponse;

@Mapper(componentModel = "spring")
public interface FAQMapper 
{
	FAQMapper INSTANCE = Mappers.getMapper(FAQMapper.class);
	
	FAQ requestToEntity(FAQRequest faqRequest);
	FAQResponse entityToResponse(FAQ faq);
	
	List<FAQResponse> mapFAQs(List<FAQ> faqs);
}
