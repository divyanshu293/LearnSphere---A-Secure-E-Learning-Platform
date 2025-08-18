package com.hashedin.huspark.repository;


import com.hashedin.huspark.model.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModuleRepository extends JpaRepository<Module , Integer> {
    Page<Module> findAll(Pageable pageable);
}


