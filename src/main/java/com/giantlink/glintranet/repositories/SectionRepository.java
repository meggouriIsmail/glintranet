package com.giantlink.glintranet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.glintranet.entities.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long>
{
	Optional<Section> findByName(String name);
}
