package com.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.Entity.Demo;

public interface DemoRepo extends JpaRepository<Demo, Integer> {

    
}
