package com.giantlink.glintranet.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.giantlink.glintranet.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	Optional<Project> findByProjectName(String projectName);
	
	@Query("select COUNT(*) as totalProjects from Project")
	int getTotProjects();

	Page<Project> findByProjectNameContainingIgnoreCase(String projectName, Pageable pageable);

}
