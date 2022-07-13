package com.giantlink.glintranet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.giantlink.glintranet.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>
{
	@Query("select COUNT(*) as totalDocs from Document")
	int getDocsTotal();

	
	
}
