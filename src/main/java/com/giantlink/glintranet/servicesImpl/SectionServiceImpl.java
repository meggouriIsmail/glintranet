package com.giantlink.glintranet.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.Section;
import com.giantlink.glintranet.mappers.SectionMapper;
import com.giantlink.glintranet.repositories.EmployeeRepository;
import com.giantlink.glintranet.repositories.SectionRepository;
import com.giantlink.glintranet.requests.SectionRequest;
import com.giantlink.glintranet.responses.SectionResponse;
import com.giantlink.glintranet.services.SectionService;

@Service
public class SectionServiceImpl implements SectionService
{
	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	SectionMapper sectionMapper;

	@Override
	public SectionResponse add(SectionRequest request) {
		Optional<Section> findSection = sectionRepository.findByName(request.getName());
		if(findSection.isPresent()) 
		{	throw new NonUniqueResultException(Section.class.getSimpleName()+" already exist ");	}
		
		Section section = null;
		section = Section.builder().name(request.getName()).build();
		sectionRepository.save(section);
		
		return sectionMapper.entityToResponse(section);
	}

	@Override
	public SectionResponse get(Long id)    {
		Optional<Section> findSection = sectionRepository.findById(id);
		if(!findSection.isPresent()) 
			{	throw new NoSuchElementException("section doesn't exist"); }
		
		Section section = sectionRepository.getById(id);
		return sectionMapper.entityToResponse(section);
		
	}

	@Override
	public List<SectionResponse> getAll() {
		List<SectionResponse> list = new ArrayList<SectionResponse>();  
		sectionRepository.findAll().forEach(sec -> list.add(sectionMapper.entityToResponse(sec)));
		return list;
	}

	@Override
	public SectionResponse update(Long id, SectionRequest request) {
		Optional<Section> sec = sectionRepository.findById(id);
		if(!sec.isPresent())
		{ throw new NoSuchElementException("section doesn't exist");	}
		
		
		Section section = sectionRepository.getById(id);
		section.setName(request.getName());
		sectionRepository.save(section);
		
		return sectionMapper.entityToResponse(section);
	}

	@Override
	public void delete(Long id) 
	{
		Optional<Section> sec = sectionRepository.findById(id);
		if(!sec.isPresent())
		{ throw new NoSuchElementException("section doesn't exist");	}
		
		sectionRepository.deleteById(id);
	}

}
