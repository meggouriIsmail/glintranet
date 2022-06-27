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
    date = "2022-06-27T20:16:05+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.0.v20210708-0430, environment: Java 17 (Eclipse Adoptium)"
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
        commentResponse.id( String.valueOf( comment.getId() ) );

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
