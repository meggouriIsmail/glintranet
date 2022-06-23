package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.entities.FAQ.FAQBuilder;
import com.giantlink.glintranet.entities.Tag;
import com.giantlink.glintranet.requests.FAQRequest;
import com.giantlink.glintranet.responses.FAQResponse;
import com.giantlink.glintranet.responses.FAQResponse.FAQResponseBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-23T12:55:00+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class FAQMapperImpl implements FAQMapper {

    @Override
    public FAQ requestToEntity(FAQRequest faqRequest) {
        if ( faqRequest == null ) {
            return null;
        }

        FAQBuilder fAQ = FAQ.builder();

        fAQ.content( faqRequest.getContent() );
        fAQ.description( faqRequest.getDescription() );
        fAQ.postingDate( faqRequest.getPostingDate() );
        fAQ.status( faqRequest.getStatus() );
        fAQ.votes( faqRequest.getVotes() );

        return fAQ.build();
    }

    @Override
    public FAQResponse entityToResponse(FAQ faq) {
        if ( faq == null ) {
            return null;
        }

        FAQResponseBuilder fAQResponse = FAQResponse.builder();

        fAQResponse.content( faq.getContent() );
        fAQResponse.description( faq.getDescription() );
        fAQResponse.employee( faq.getEmployee() );
        fAQResponse.id( faq.getId() );
        fAQResponse.postingDate( faq.getPostingDate() );
        fAQResponse.status( faq.getStatus() );
        Set<Tag> set = faq.getTags();
        if ( set != null ) {
            fAQResponse.tags( new HashSet<Tag>( set ) );
        }
        fAQResponse.votes( faq.getVotes() );

        return fAQResponse.build();
    }

    @Override
    public List<FAQResponse> mapFAQs(List<FAQ> faqs) {
        if ( faqs == null ) {
            return null;
        }

        List<FAQResponse> list = new ArrayList<FAQResponse>( faqs.size() );
        for ( FAQ fAQ : faqs ) {
            list.add( entityToResponse( fAQ ) );
        }

        return list;
    }
}
