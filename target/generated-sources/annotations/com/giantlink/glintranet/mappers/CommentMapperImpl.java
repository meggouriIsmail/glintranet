package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Comment;
import com.giantlink.glintranet.entities.Comment.CommentBuilder;
import com.giantlink.glintranet.requests.CommentRequest;
import com.giantlink.glintranet.responses.CommentResponse;
import com.giantlink.glintranet.responses.CommentResponse.CommentResponseBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-06T15:19:41+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment toEntity(CommentRequest commentRequest) {
        if ( commentRequest == null ) {
            return null;
        }

        CommentBuilder comment = Comment.builder();

        comment.commentDate( commentRequest.getCommentDate() );
        comment.content( commentRequest.getContent() );

        return comment.build();
    }

    @Override
    public CommentResponse toResponse(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentResponseBuilder commentResponse = CommentResponse.builder();

        commentResponse.commentDate( comment.getCommentDate() );
        commentResponse.content( comment.getContent() );
        commentResponse.id( comment.getId() );

        return commentResponse.build();
    }

    @Override
    public List<CommentResponse> mapComments(List<Comment> employees) {
        if ( employees == null ) {
            return null;
        }

        List<CommentResponse> list = new ArrayList<CommentResponse>( employees.size() );
        for ( Comment comment : employees ) {
            list.add( toResponse( comment ) );
        }

        return list;
    }
}
