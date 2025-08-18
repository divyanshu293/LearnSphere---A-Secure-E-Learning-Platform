package com.hashedin.huspark.repository;


import com.hashedin.huspark.model.SubModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SubModuleRepository extends JpaRepository<SubModule ,Integer> {


}
