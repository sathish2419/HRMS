package com.isys.erp.repository;

import com.isys.erp.entity.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    Page<RoleEntity> findAll(Pageable pageable);
}
