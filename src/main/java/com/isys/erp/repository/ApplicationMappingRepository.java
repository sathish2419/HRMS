package com.isys.erp.repository;

import com.isys.erp.entity.ApplicationMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ApplicationMappingRepository extends JpaRepository<ApplicationMappingEntity , Long> {
}
