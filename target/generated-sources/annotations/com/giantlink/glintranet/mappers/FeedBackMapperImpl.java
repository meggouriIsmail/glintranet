package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.FeedBack;
import com.giantlink.glintranet.entities.FeedBack.FeedBackBuilder;
import com.giantlink.glintranet.requests.FeedBackRequest;
import com.giantlink.glintranet.responses.FeedBackResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-27T20:16:13+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.0.v20210708-0430, environment: Java 17 (Eclipse Adoptium)"
)
@Component
public class FeedBackMapperImpl implements FeedBackMapper {

    @Override
    public FeedBack requestToEntity(FeedBackRequest request) {
        if ( request == null ) {
            return null;
        }

        FeedBackBuilder feedBack = FeedBack.builder();

        feedBack.content( request.getContent() );

        return feedBack.build();
    }

    @Override
    public FeedBackResponse entityToResponse(FeedBack feedBack) {
        if ( feedBack == null ) {
            return null;
        }

        FeedBackResponse feedBackResponse = new FeedBackResponse();

        feedBackResponse.setContent( feedBack.getContent() );
        feedBackResponse.setId( feedBack.getId() );
        feedBackResponse.setTimestamp( feedBack.getTimestamp() );

        return feedBackResponse;
    }

    @Override
    public List<FeedBackResponse> mapFeedBacks(List<FeedBack> feedBacks) {
        if ( feedBacks == null ) {
            return null;
        }

        List<FeedBackResponse> list = new ArrayList<FeedBackResponse>( feedBacks.size() );
        for ( FeedBack feedBack : feedBacks ) {
            list.add( entityToResponse( feedBack ) );
        }

        return list;
    }
}
