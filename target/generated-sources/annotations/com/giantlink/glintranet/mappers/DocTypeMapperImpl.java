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
    date = "2022-06-29T02:05:50+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.0.v20210708-0430, environment: Java 16.0.2 (Oracle Corporation)"
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
