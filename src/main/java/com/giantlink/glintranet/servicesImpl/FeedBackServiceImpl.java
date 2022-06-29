package com.giantlink.glintranet.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.FeedBack;
import com.giantlink.glintranet.entities.FeedBackType;
import com.giantlink.glintranet.entities.Project;
import com.giantlink.glintranet.mappers.FeedBackMapper;
import com.giantlink.glintranet.repositories.EmployeeRepository;
import com.giantlink.glintranet.repositories.FeedBackRepository;
import com.giantlink.glintranet.repositories.FeedBackTypeRepository;
import com.giantlink.glintranet.repositories.ProjectRepository;
import com.giantlink.glintranet.requests.FeedBackRequest;
import com.giantlink.glintranet.responses.FeedBackResponse;
import com.giantlink.glintranet.services.FeedBackService;

@Service
public class FeedBackServiceImpl implements FeedBackService
{
	@Autowired
	FeedBackRepository feedBackRepository;
	
	@Autowired
	FeedBackTypeRepository typeRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	FeedBackMapper mapper;

	@Override
	public FeedBackResponse add(FeedBackRequest request) {
		Optional<Employee> employee = employeeRepository.findById(request.getEmployee_id());
		Optional<FeedBackType> type = typeRepository.findById(request.getType_id());
		Optional<Project> project   = projectRepository.findById(request.getProject_id());
		
		
		if(!employee.isPresent()) 
		{
			throw new RuntimeException("Employee doesnt exist");
		}
		
		if(!type.isPresent()) 
		{
			throw new RuntimeException("Type FB doesnt exist");

		}
		
		if(!project.isPresent()) 
		{
			throw new RuntimeException("Project doesnt exist");
		}
		
		FeedBack feedBack = FeedBack.builder().content(request.getContent()).build();
		
		feedBack.setEmployee(employee.get());
		feedBack.setProject(project.get());
		feedBack.setType(type.get());
		
		System.out.println(feedBack.getContent()+" "+feedBack.getEmployee().getCIN()+" "+feedBack.getProject().getProjectName()+" "+feedBack.getType().getName());
		
		feedBackRepository.save(feedBack);
		
		return mapper.entityToResponse(feedBack);
	}

	@Override
	public FeedBackResponse get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeedBackResponse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
}
