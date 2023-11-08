package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Plan;

@Repository
public interface PlanRepo extends JpaRepository<Plan,Integer>{

}
