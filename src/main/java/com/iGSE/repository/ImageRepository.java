package com.iGSE.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iGSE.entity.EVC;

public interface ImageRepository extends JpaRepository<EVC, Long> {
	Optional<EVC> findByName(String name);

	@Query("SELECT e FROM EVC e where e.evc = ?1")
	EVC findByEvc(String evc);

	@Modifying
	@Query("update EVC e set e.isExpired = true where e.evc=:evc")
	void updateEvcExpiry(@Param("evc") String evc);
}
