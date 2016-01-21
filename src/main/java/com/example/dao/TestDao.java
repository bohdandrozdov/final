/*
 * Decompiled with CFR 0_110.
 *
 * Could not load the following classes:
 *  javax.transaction.Transactional
 *  org.springframework.data.repository.CrudRepository
 */
package com.example.dao;


import com.example.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao
        extends JpaRepository<Test, Integer>{
}
