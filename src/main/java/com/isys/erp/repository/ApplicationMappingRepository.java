package com.isys.erp.repository;

import com.isys.erp.entity.ApplicationMappingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ApplicationMappingRepository extends JpaRepository<ApplicationMappingEntity , Long> {

    Page<ApplicationMappingEntity> findAll(Pageable pageable);
}
