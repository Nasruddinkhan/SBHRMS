package com.mypractice.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypractice.hrms.model.StateMaster;

public interface StateRepo extends JpaRepository<StateMaster, Integer> {

}
