package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Document;
import com.giantlink.glintranet.responses.DocResponse;
import com.giantlink.glintranet.responses.DocResponse.DocResponseBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-19T09:29:58+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class DocMapperImpl implements DocMapper {

    @Override
    public List<DocResponse> mapResponses(List<Document> documents) {
        if ( documents == null ) {
            return null;
        }

        List<DocResponse> list = new ArrayList<DocResponse>( documents.size() );
        for ( Document document : documents ) {
            list.add( documentToDocResponse( document ) );
        }

        return list;
    }

    protected DocResponse documentToDocResponse(Document document) {
        if ( document == null ) {
            return null;
        }

        DocResponseBuilder docResponse = DocResponse.builder();

        docResponse.contentType( document.getContentType() );
        docResponse.documentName( document.getDocumentName() );
        docResponse.id( document.getId() );
        docResponse.size( document.getSize() );

        return docResponse.build();
    }
}
