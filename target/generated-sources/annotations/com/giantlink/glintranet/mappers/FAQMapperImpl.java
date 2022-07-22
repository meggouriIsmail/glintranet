package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Comment;
import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.entities.FAQ.FAQBuilder;
import com.giantlink.glintranet.entities.Role;
import com.giantlink.glintranet.entities.Section;
import com.giantlink.glintranet.entities.Tag;
import com.giantlink.glintranet.requests.FAQRequest;
import com.giantlink.glintranet.responses.CommentResponse;
import com.giantlink.glintranet.responses.CommentResponse.CommentResponseBuilder;
import com.giantlink.glintranet.responses.EmployeeResSimplified;
import com.giantlink.glintranet.responses.EmployeeResSimplified.EmployeeResSimplifiedBuilder;
import com.giantlink.glintranet.responses.FAQResponse;
import com.giantlink.glintranet.responses.FAQResponse.FAQResponseBuilder;
import com.giantlink.glintranet.responses.RoleResponse;
import com.giantlink.glintranet.responses.RoleResponse.RoleResponseBuilder;
import com.giantlink.glintranet.responses.SectionResponse;
import com.giantlink.glintranet.responses.SectionResponse.SectionResponseBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-20T09:03:52+0100",
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
        fAQ.votesDown( faqRequest.getVotesDown() );
        fAQ.votesUp( faqRequest.getVotesUp() );

        return fAQ.build();
    }

    @Override
    public FAQResponse entityToResponse(FAQ faq) {
        if ( faq == null ) {
            return null;
        }

        FAQResponseBuilder fAQResponse = FAQResponse.builder();

        fAQResponse.comments( commentSetToCommentResponseList( faq.getComments() ) );
        fAQResponse.content( faq.getContent() );
        fAQResponse.description( faq.getDescription() );
        fAQResponse.employee( employeeToEmployeeResSimplified( faq.getEmployee() ) );
        fAQResponse.id( faq.getId() );
        fAQResponse.postingDate( faq.getPostingDate() );
        fAQResponse.section( sectionToSectionResponse( faq.getSection() ) );
        fAQResponse.status( faq.getStatus() );
        Set<Tag> set = faq.getTags();
        if ( set != null ) {
            fAQResponse.tags( new HashSet<Tag>( set ) );
        }
        fAQResponse.votes( faq.getVotes() );
        fAQResponse.votesDown( faq.getVotesDown() );
        fAQResponse.votesUp( faq.getVotesUp() );

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

    protected CommentResponse commentToCommentResponse(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentResponseBuilder commentResponse = CommentResponse.builder();

        commentResponse.commentDate( comment.getCommentDate() );
        commentResponse.content( comment.getContent() );
        commentResponse.id( comment.getId() );

        return commentResponse.build();
    }

    protected List<CommentResponse> commentSetToCommentResponseList(Set<Comment> set) {
        if ( set == null ) {
            return null;
        }

        List<CommentResponse> list = new ArrayList<CommentResponse>( set.size() );
        for ( Comment comment : set ) {
            list.add( commentToCommentResponse( comment ) );
        }

        return list;
    }

    protected RoleResponse roleToRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponseBuilder roleResponse = RoleResponse.builder();

        roleResponse.description( role.getDescription() );
        roleResponse.id( role.getId() );
        roleResponse.name( role.getName() );

        return roleResponse.build();
    }

    protected Set<RoleResponse> roleSetToRoleResponseSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleResponse> set1 = new HashSet<RoleResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleResponse( role ) );
        }

        return set1;
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
        employeeResSimplified.phoneNumber( employee.getPhoneNumber() );
        employeeResSimplified.roles( roleSetToRoleResponseSet( employee.getRoles() ) );
        employeeResSimplified.username( employee.getUsername() );

        return employeeResSimplified.build();
    }

    protected SectionResponse sectionToSectionResponse(Section section) {
        if ( section == null ) {
            return null;
        }

        SectionResponseBuilder sectionResponse = SectionResponse.builder();

        sectionResponse.id( section.getId() );
        sectionResponse.name( section.getName() );
        sectionResponse.timestamp( section.getTimestamp() );

        return sectionResponse.build();
    }
}
