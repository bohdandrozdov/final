/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  javax.transaction.Transactional
 *  org.springframework.data.repository.CrudRepository
 */
package com.example.dao;

import com.example.model.Test;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface TestDao
extends CrudRepository<Test, Integer> {
}

