package com.giantlink.glintranet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.glintranet.entities.DocType;

@Repository
public interface DocTypeRepository extends JpaRepository<DocType, Long>
{
	Optional<DocType> findByName(String name);
}
