package com.giantlink.glintranet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.glintranet.entities.FeedBackType;

@Repository
public interface FeedBackTypeRepository extends JpaRepository<FeedBackType, Long> 
{
	Optional<FeedBackType> findByName(String name);
}
