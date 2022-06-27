package com.giantlink.glintranet.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.giantlink.glintranet.entities.FeedBackType;
import com.giantlink.glintranet.mappers.FeedBackTypeMapper;
import com.giantlink.glintranet.repositories.FeedBackTypeRepository;
import com.giantlink.glintranet.requests.FeedBackTypeRequest;
import com.giantlink.glintranet.responses.FeedBackTypeResponse;
import com.giantlink.glintranet.services.FeedBackTypeService;

@Service
public class FeedBackTypeServiceImpl implements FeedBackTypeService
{
	@Autowired
	FeedBackTypeRepository typeRepository;

	@Autowired
	FeedBackTypeMapper typeMapper;
	
	@Override
	public FeedBackTypeResponse add(FeedBackTypeRequest request) 
	{
		Optional<FeedBackType> foundType = typeRepository.findByName(request.getName());
		if(foundType.isPresent()) 
		{	throw new NonUniqueResultException(FeedBackType.class.getSimpleName()+" already exist");	}
		
		FeedBackType type = null;
		type = FeedBackType.builder()
				.name(request.getName()).build();
		
		typeRepository.save(type);
		return typeMapper.entityToResponse(type);
	}

	@Override
	public FeedBackTypeResponse get(Long id) {
		Optional<FeedBackType> foundType = typeRepository.findById(id);
		if(!foundType.isPresent()) 
		{	throw new NoSuchElementException(FeedBackType.class.getSimpleName()+" doesnt exist ");	}
		
		FeedBackType type = typeRepository.getById(id);
		return typeMapper.entityToResponse(type);
	}

	@Override
	public List<FeedBackTypeResponse> getAll() {
		List<FeedBackTypeResponse> types = new ArrayList<>();
		typeRepository.findAll().forEach(t -> types.add(typeMapper.entityToResponse(t)));
		
		return types;
	}

	@Override
	public FeedBackTypeResponse update(Long id, FeedBackTypeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
