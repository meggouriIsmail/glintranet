package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Tag;
import com.giantlink.glintranet.entities.Tag.TagBuilder;
import com.giantlink.glintranet.requests.TagRequest;
import com.giantlink.glintranet.responses.TagResponse;
import com.giantlink.glintranet.responses.TagResponse.TagResponseBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-01T15:31:13+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag requestToEntity(TagRequest tagRequest) {
        if ( tagRequest == null ) {
            return null;
        }

        TagBuilder tag = Tag.builder();

        tag.description( tagRequest.getDescription() );
        tag.name( tagRequest.getName() );

        return tag.build();
    }

    @Override
    public TagResponse entityToResponse(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagResponseBuilder tagResponse = TagResponse.builder();

        tagResponse.description( tag.getDescription() );
        tagResponse.id( tag.getId() );
        tagResponse.name( tag.getName() );

        return tagResponse.build();
    }
}
