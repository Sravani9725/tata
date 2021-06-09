package com.cg.pack.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.pack.entities.Pack;

@Repository
public interface PackRepository extends JpaRepository<Pack, Long> {

//	Optional<Pack> findBypackName(String packName);
//
//	List<Pack> findPopularPacks();

	

}
