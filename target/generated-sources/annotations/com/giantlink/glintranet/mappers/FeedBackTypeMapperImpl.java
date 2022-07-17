package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.FeedBackType;
import com.giantlink.glintranet.entities.FeedBackType.FeedBackTypeBuilder;
import com.giantlink.glintranet.requests.FeedBackTypeRequest;
import com.giantlink.glintranet.responses.FeedBackTypeResponse;
import com.giantlink.glintranet.responses.FeedBackTypeResponse.FeedBackTypeResponseBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2022-07-13T14:18:48+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
=======
    date = "2022-07-16T12:28:52+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.0.v20210708-0430, environment: Java 17 (Eclipse Adoptium)"
>>>>>>> e0c5843f9a874028499c6accdb15ca66f5bd7dd4
)
@Component
public class FeedBackTypeMapperImpl implements FeedBackTypeMapper {

    @Override
    public FeedBackType requestToEntity(FeedBackTypeRequest request) {
        if ( request == null ) {
            return null;
        }

        FeedBackTypeBuilder feedBackType = FeedBackType.builder();

        feedBackType.name( request.getName() );

        return feedBackType.build();
    }

    @Override
    public FeedBackTypeResponse entityToResponse(FeedBackType feedBackType) {
        if ( feedBackType == null ) {
            return null;
        }

        FeedBackTypeResponseBuilder feedBackTypeResponse = FeedBackTypeResponse.builder();

        feedBackTypeResponse.id( feedBackType.getId() );
        feedBackTypeResponse.name( feedBackType.getName() );

        return feedBackTypeResponse.build();
    }
}
