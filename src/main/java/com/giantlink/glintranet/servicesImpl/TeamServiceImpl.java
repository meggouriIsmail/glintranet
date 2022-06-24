package com.giantlink.glintranet.servicesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.Project;
import com.giantlink.glintranet.entities.Team;
import com.giantlink.glintranet.mappers.EmployeeMapper;
import com.giantlink.glintranet.mappers.ProjectMapper;
import com.giantlink.glintranet.mappers.TeamMapper;
import com.giantlink.glintranet.repositories.EmployeeRepository;
import com.giantlink.glintranet.repositories.ProjectRepository;
import com.giantlink.glintranet.repositories.TeamRepository;
import com.giantlink.glintranet.requests.EmployeeRequest;
import com.giantlink.glintranet.requests.ProjectRequest;
import com.giantlink.glintranet.requests.TeamRequest;
import com.giantlink.glintranet.responses.TeamResponse;
import com.giantlink.glintranet.services.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TeamMapper teamMapper;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private ProjectMapper projectMapper;

	@Override
	public TeamResponse add(TeamRequest teamRequest) {
		Optional<Team> findTeamByName = teamRepository.findByName(teamRequest.getName());
		
		if (findTeamByName.isPresent()) {
			throw new RuntimeException("team already exist");
		} 

		Team team = teamMapper.requestToEntity(teamRequest);

		Set<Employee> employees = new HashSet<>();
		Set<Project> projects = new HashSet<>();

		team.setEmployees(employees);
		team.setProjects(projects);
		
		teamRepository.save(team);
		
		Set<ProjectRequest> projectRequests = teamRequest.getProjects();
		
		if (projectRequests != null && !projectRequests.isEmpty()) {
			projectRequests.forEach(project -> {
				Optional<Project> optional = projectRepository.findByProjectName(project.getProjectName());
				if(optional.isPresent()) {
					projects.add(optional.get());
				}
			});
		}
		team.setProjects(projects);

		Set<EmployeeRequest> employeeRequests = teamRequest.getEmployees();
		
		if (employeeRequests != null && !employeeRequests.isEmpty()) {
			employeeRequests.forEach(employee -> {
				Optional<Employee> optional = employeeRepository.findByCIN(employee.getCIN());
				if(optional.isPresent()) {
					Employee employeeToUpdate = optional.get();
					employees.add(employeeToUpdate);
					employeeToUpdate.setTeam(team);
					employeeRepository.save(employeeToUpdate);
				}
			});
		}
		team.setEmployees(employees);
		
		return teamMapper.entityToResponse(teamRepository.save(team));
	}

	@Override
	public List<TeamResponse> getAll() {
		return teamMapper.mapTeam(teamRepository.findAll());
	}

	@Override
	public TeamResponse get(Long id) {
		return teamMapper.entityToResponse(teamRepository.findById(id).get());
	}

	@Override
	public void delete(Long id) {
		teamRepository.deleteById(id);
	}

	@Override
	public TeamResponse update(Long id, TeamRequest teamRequest) {

		Team team = teamRepository.findById(id).get();

		team.setName(teamRequest.getName());
		team.setDescription(teamRequest.getDescription());
		team.setEmployees(employeeMapper.mapEmployeeRequest(teamRequest.getEmployees()));
		team.setProjects(projectMapper.mapProjectRequest(teamRequest.getProjects()));

		teamRepository.save(team);
		return teamMapper.entityToResponse(team);

	}

	@Override
	public Map<String, Object> getAllPaginations(String name, Pageable pageable) {
		List<TeamResponse> teamList = new ArrayList<>();
		Page<Team> teams = (name.isBlank()) ? teamRepository.findAll(pageable)
				: teamRepository.findByNameContainingIgnoreCase(name, pageable);

		teams.getContent().forEach(team -> {
			TeamResponse response = TeamResponse.builder()
					.id(team.getId())
					.name(team.getName())
					.description(team.getDescription())
					.employeeResponses(EmployeeMapper.INSTANCE.mapEmployeeSimplified(team.getEmployees()))
					.projectResponses(ProjectMapper.INSTANCE.mapProject(team.getProjects()))
					.build();
			teamList.add(response);
		});

		Map<String, Object> teamMap = new HashMap<>();
		teamMap.put("content", teamList);
		teamMap.put("currentPage", teams.getNumber());
		teamMap.put("totalElements", teams.getTotalElements());
		teamMap.put("totalPages", teams.getTotalPages());
		return teamMap;
	}

}
