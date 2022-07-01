package com.giantlink.glintranet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.giantlink.glintranet.entities.FeedBack;
import com.giantlink.glintranet.entities.Project;

public interface FeedBackRepository extends JpaRepository<FeedBack, Long>
{
	@Query(value = "SELECT * FROM feedback WHERE project_id = :projectId", nativeQuery = true)
	List<FeedBack> findByProject(@Param("projectId") Long id);
}
