/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.example.service;

import com.example.dao.TestDao;
import com.example.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class TestService  {
    @Autowired
    private TestDao testDao;

    public void persist(Test entity) {
        this.testDao.save((Iterable<Test>) entity);
    }

    public Test findById(Integer id) {
        return (Test)this.testDao.findOne((Integer) id);
    }

    public Test findByIdWithoutAns(Integer id) {
        Test test = this.findById(id);
        test.setAnswers(null);
        return test;
    }

    public void delete(Test entity) {
        this.testDao.delete((Test) entity);
    }

    public Iterable<Test> getAll() {
        return this.testDao.findAll();
    }

    public Iterable<Test> getAllByIdWithoutAns() {
        Iterable<Test> tests = this.getAll();
        tests.forEach(test -> {
            test.setAnswers(null);
        }
        );
        return tests;
    }

    public void deleteAll() {
        this.testDao.deleteAll();
    }
}

