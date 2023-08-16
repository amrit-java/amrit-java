package com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entity.ImagData;
@Repository
public interface StorageRepository extends JpaRepository<ImagData, Long>{
  
	 Optional<ImagData> findByName(String name);
}
