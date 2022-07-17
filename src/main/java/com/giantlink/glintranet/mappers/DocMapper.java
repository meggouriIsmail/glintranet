package com.giantlink.glintranet.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.Document;
import com.giantlink.glintranet.responses.DocResponse;

@Mapper(componentModel = "spring")
public interface DocMapper {
	DocMapper INSTANCE = Mappers.getMapper(DocMapper.class);
	
	List<DocResponse> mapResponses(List<Document> documents);
}
