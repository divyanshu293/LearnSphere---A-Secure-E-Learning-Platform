package com.hashedin.huspark.repository;


import com.hashedin.huspark.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportRepository extends JpaRepository<Report,Integer> {


}
