package com.giantlink.glintranet.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.DocType;
import com.giantlink.glintranet.requests.DocTypeRequest;
import com.giantlink.glintranet.responses.DocTypeResponse;

@Mapper(componentModel = "spring")
public interface DocTypeMapper 
{
	DocTypeMapper INSTANCE = Mappers.getMapper(DocTypeMapper.class);
	
	DocType requestToEntity(DocTypeRequest request);
	DocTypeResponse entityToResponse(DocType docType);
}
