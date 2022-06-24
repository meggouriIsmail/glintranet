package com.giantlink.glintranet.servicesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.Project;
import com.giantlink.glintranet.mappers.ProjectMapper;
import com.giantlink.glintranet.repositories.ProjectRepository;
import com.giantlink.glintranet.requests.ProjectRequest;
import com.giantlink.glintranet.responses.ProjectResponse;
import com.giantlink.glintranet.services.ProjectService;

@Service
public class ProjectServiceImp implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Override
	public ProjectResponse add(ProjectRequest projectRequest) {
		Optional<Project> findByName = projectRepository.findByProjectName(projectRequest.getProjectName());

		if (findByName.isPresent()) {
			throw new RuntimeException("project already exist");
		} else {
			return ProjectMapper.INSTANCE
					.entityToResponse(projectRepository.save(ProjectMapper.INSTANCE.requestToEntity(projectRequest)));
		}
	}

	@Override
	public List<ProjectResponse> getAll() {
		return ProjectMapper.INSTANCE.mapProject(projectRepository.findAll());
	}

	@Override
	public ProjectResponse get(Long id) {
		return ProjectMapper.INSTANCE.entityToResponse(projectRepository.findById(id).get());
	}

	@Override
	public void delete(Long id) {
		projectRepository.deleteById(id);
	}

	@Override
	public ProjectResponse update(Long id, ProjectRequest projectRequest) {
		Project project = projectRepository.findById(id).get();

		project.setProjectName(projectRequest.getProjectName());
		project.setProjectDesc(projectRequest.getProjectDesc());

		return ProjectMapper.INSTANCE.entityToResponse(projectRepository.save(project));
	}

	@Override
	public Map<String, Object> getAllPaginations(String name, Pageable pageable) {
		List<ProjectResponse> projectResponses = new ArrayList<>();
		Page<Project> projects = (name.isBlank()) ? projectRepository.findAll(pageable)
				: projectRepository.findByProjectNameContainingIgnoreCase(name, pageable);
		projects.getContent().forEach(company -> {
			ProjectResponse response = ProjectResponse.builder().id(company.getId())
					.projectName(company.getProjectName()).projectDesc(company.getProjectDesc()).build();
			projectResponses.add(response);
		});
		Map<String, Object> projectResponse = new HashMap<>();
		projectResponse.put("content", projectResponses);
		projectResponse.put("currentPage", projects.getNumber());
		projectResponse.put("totalElements", projects.getTotalElements());
		projectResponse.put("totalPages", projects.getTotalPages());

		return projectResponse;
	}

}
