package com.hashedin.huspark.repository;


import com.hashedin.huspark.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User , Integer> {


    User findByName(String name);
}
