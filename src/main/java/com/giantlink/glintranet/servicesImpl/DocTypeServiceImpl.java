package com.giantlink.glintranet.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.DocType;
import com.giantlink.glintranet.mappers.DocTypeMapper;
import com.giantlink.glintranet.repositories.DocTypeRepository;
import com.giantlink.glintranet.requests.DocTypeRequest;
import com.giantlink.glintranet.responses.DocTypeResponse;
import com.giantlink.glintranet.services.DocTypeService;

@Service
public class DocTypeServiceImpl implements DocTypeService 
{

	@Autowired
	DocTypeRepository docTypeRepository;
	
	@Autowired
	DocTypeMapper docTypeMapper;
	
	@Override
	public DocTypeResponse add(DocTypeRequest request) {
		Optional<DocType> findType = docTypeRepository.findByName(request.getName());
		if(findType.isPresent()) 
		{
			throw new NonUniqueResultException("Type already exist");
		}
		DocType docType = null;
		docType = DocType.builder().name(request.getName()).build();
		docTypeRepository.save(docType);
		
		return docTypeMapper.entityToResponse(docType);
	}

	@Override
	public DocTypeResponse get(Long id) 
	{
		Optional<DocType> findDoc = docTypeRepository.findById(id);
		if(!findDoc.isPresent()) 
		{
			throw new NoSuchElementException("No such Type");
		}
		DocType docType = docTypeRepository.getById(id);
		return docTypeMapper.entityToResponse(docType);
	}

	@Override
	public List<DocTypeResponse> getAll() {
		List<DocTypeResponse> docTypes =  new ArrayList<>();
		docTypeRepository.findAll().forEach(t -> docTypes.add(docTypeMapper.entityToResponse(t)));
		return docTypes;
	}

	@Override
	public DocTypeResponse update(Long id, DocTypeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		Optional<DocType> findType = docTypeRepository.findById(id);
		if(!findType.isPresent()) 
		{	throw new NoSuchElementException("No such type");	}
		
		docTypeRepository.deleteById(id);
	}

}
