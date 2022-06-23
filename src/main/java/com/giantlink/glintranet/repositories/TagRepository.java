package com.giantlink.glintranet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giantlink.glintranet.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>
{
	Optional<Tag> findByName(String name);
}
