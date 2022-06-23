package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.entities.FAQ.FAQBuilder;
import com.giantlink.glintranet.entities.Tag;
import com.giantlink.glintranet.requests.FAQRequest;
import com.giantlink.glintranet.responses.EmployeeResSimplified;
import com.giantlink.glintranet.responses.EmployeeResSimplified.EmployeeResSimplifiedBuilder;
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
    date = "2022-06-23T16:06:06+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.0.v20210708-0430, environment: Java 17 (Eclipse Adoptium)"
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
        fAQResponse.employee( employeeToEmployeeResSimplified( faq.getEmployee() ) );
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

    protected EmployeeResSimplified employeeToEmployeeResSimplified(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeResSimplifiedBuilder employeeResSimplified = EmployeeResSimplified.builder();

        employeeResSimplified.CIN( employee.getCIN() );
        employeeResSimplified.birthDate( employee.getBirthDate() );
        employeeResSimplified.email( employee.getEmail() );
        employeeResSimplified.firstName( employee.getFirstName() );
        employeeResSimplified.id( employee.getId() );
        employeeResSimplified.lastName( employee.getLastName() );
        employeeResSimplified.password( employee.getPassword() );
        employeeResSimplified.phoneNumber( employee.getPhoneNumber() );
        employeeResSimplified.username( employee.getUsername() );

        return employeeResSimplified.build();
    }
}
