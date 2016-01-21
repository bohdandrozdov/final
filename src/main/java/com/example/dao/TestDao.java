package com.example.dao;


import com.example.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao
        extends JpaRepository<Test, Integer>{
}
