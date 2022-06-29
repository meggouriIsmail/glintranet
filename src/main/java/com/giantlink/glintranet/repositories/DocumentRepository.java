package com.giantlink.glintranet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giantlink.glintranet.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>
{

}
