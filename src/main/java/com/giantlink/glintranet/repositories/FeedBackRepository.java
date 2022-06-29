package com.giantlink.glintranet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giantlink.glintranet.entities.FeedBack;
import com.giantlink.glintranet.entities.Project;

public interface FeedBackRepository extends JpaRepository<FeedBack, Long>
{
	List<FeedBack> findByProject(Project project);
}
