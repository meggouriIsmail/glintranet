package com.giantlink.glintranet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.giantlink.glintranet.entities.FAQ;

public interface FAQRepository extends JpaRepository<FAQ, Long> {
	
	@Query(value = "SELECT * FROM FAQ WHERE section_id = :section_id", nativeQuery = true)
	List<FAQ> findAllBySection(@Param("section_id") Long id);
	
	
	@Query("select COUNT(*) as totalFAQ from FAQ")
	int getFAQTotal();

//	List<FAQ> findAllOrderByPostingDate();
	
	

}
