package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.DocType;
import com.giantlink.glintranet.entities.DocType.DocTypeBuilder;
import com.giantlink.glintranet.requests.DocTypeRequest;
import com.giantlink.glintranet.responses.DocTypeResponse;
import com.giantlink.glintranet.responses.DocTypeResponse.DocTypeResponseBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-17T15:10:21+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class DocTypeMapperImpl implements DocTypeMapper {

    @Override
    public DocType requestToEntity(DocTypeRequest request) {
        if ( request == null ) {
            return null;
        }

        DocTypeBuilder docType = DocType.builder();

        docType.name( request.getName() );

        return docType.build();
    }

    @Override
    public DocTypeResponse entityToResponse(DocType docType) {
        if ( docType == null ) {
            return null;
        }

        DocTypeResponseBuilder docTypeResponse = DocTypeResponse.builder();

        docTypeResponse.id( docType.getId() );
        docTypeResponse.name( docType.getName() );

        return docTypeResponse.build();
    }
}
