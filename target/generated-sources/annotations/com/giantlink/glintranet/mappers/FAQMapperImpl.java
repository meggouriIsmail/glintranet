package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Comment;
import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.entities.FAQ.FAQBuilder;
import com.giantlink.glintranet.entities.Reply;
import com.giantlink.glintranet.entities.Section;
import com.giantlink.glintranet.entities.Tag;
import com.giantlink.glintranet.requests.FAQRequest;
import com.giantlink.glintranet.responses.CommentResponse;
import com.giantlink.glintranet.responses.CommentResponse.CommentResponseBuilder;
import com.giantlink.glintranet.responses.EmployeeCommentRes;
import com.giantlink.glintranet.responses.EmployeeCommentRes.EmployeeCommentResBuilder;
import com.giantlink.glintranet.responses.FAQResponse;
import com.giantlink.glintranet.responses.FAQResponse.FAQResponseBuilder;
import com.giantlink.glintranet.responses.ReplyResponse;
import com.giantlink.glintranet.responses.ReplyResponse.ReplyResponseBuilder;
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
    date = "2022-07-28T13:13:03+0100",
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
        fAQResponse.employee( employeeToEmployeeCommentRes( faq.getEmployee() ) );
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

    protected ReplyResponse replyToReplyResponse(Reply reply) {
        if ( reply == null ) {
            return null;
        }

        ReplyResponseBuilder replyResponse = ReplyResponse.builder();

        replyResponse.content( reply.getContent() );
        replyResponse.id( reply.getId() );
        replyResponse.replyDate( reply.getReplyDate() );

        return replyResponse.build();
    }

    protected Set<ReplyResponse> replySetToReplyResponseSet(Set<Reply> set) {
        if ( set == null ) {
            return null;
        }

        Set<ReplyResponse> set1 = new HashSet<ReplyResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Reply reply : set ) {
            set1.add( replyToReplyResponse( reply ) );
        }

        return set1;
    }

    protected CommentResponse commentToCommentResponse(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentResponseBuilder commentResponse = CommentResponse.builder();

        commentResponse.commentDate( comment.getCommentDate() );
        commentResponse.content( comment.getContent() );
        commentResponse.id( comment.getId() );
        commentResponse.replies( replySetToReplyResponseSet( comment.getReplies() ) );

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

    protected EmployeeCommentRes employeeToEmployeeCommentRes(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeCommentResBuilder employeeCommentRes = EmployeeCommentRes.builder();

        employeeCommentRes.firstName( employee.getFirstName() );
        employeeCommentRes.lastName( employee.getLastName() );
        employeeCommentRes.username( employee.getUsername() );

        return employeeCommentRes.build();
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
