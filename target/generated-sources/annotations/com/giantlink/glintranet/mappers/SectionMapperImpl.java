package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Section;
import com.giantlink.glintranet.entities.Section.SectionBuilder;
import com.giantlink.glintranet.requests.SectionRequest;
import com.giantlink.glintranet.responses.SectionResponse;
import com.giantlink.glintranet.responses.SectionResponse.SectionResponseBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-16T12:28:52+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.0.v20210708-0430, environment: Java 17 (Eclipse Adoptium)"
)
@Component
public class SectionMapperImpl implements SectionMapper {

    @Override
    public Section requestToEntity(SectionRequest request) {
        if ( request == null ) {
            return null;
        }

        SectionBuilder section = Section.builder();

        section.name( request.getName() );
        section.timestamp( request.getTimestamp() );

        return section.build();
    }

    @Override
    public SectionResponse entityToResponse(Section section) {
        if ( section == null ) {
            return null;
        }

        SectionResponseBuilder sectionResponse = SectionResponse.builder();

        sectionResponse.id( section.getId() );
        sectionResponse.name( section.getName() );
        sectionResponse.timestamp( section.getTimestamp() );

        return sectionResponse.build();
    }

    @Override
    public List<SectionResponse> mapSection(List<Section> sections) {
        if ( sections == null ) {
            return null;
        }

        List<SectionResponse> list = new ArrayList<SectionResponse>( sections.size() );
        for ( Section section : sections ) {
            list.add( entityToResponse( section ) );
        }

        return list;
    }
}
