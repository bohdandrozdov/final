/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  javax.persistence.ElementCollection
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.Id
 *  javax.persistence.Table
 *  javax.validation.constraints.NotNull
 */
package com.example.model;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tests")
public class Test {
    @Id
    @GeneratedValue
    protected int id;
    @NotNull
    protected int fieldId;
    @NotNull
    @ElementCollection(targetClass=String.class)
    protected List<String> questions;
    @NotNull
    @ElementCollection(targetClass=String.class)
    protected List<String> answers;

    public Test() {
    }

    public Test(int fieldId, List<String> questions, List<String> answers) {
        this.fieldId = fieldId;
        this.questions = questions;
        this.answers = answers;
    }

    public int getFieldId() {
        return this.fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getId() {
        return this.id;
    }

    public List<String> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public List<String> getAnswers() {
        return this.answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Test test = (Test)o;
        if (this.id != test.id) {
            return false;
        }
        if (this.fieldId != test.fieldId) {
            return false;
        }
        if (!this.questions.equals(test.questions)) {
            return false;
        }
        return this.answers != null ? this.answers.equals(test.answers) : test.answers == null;
    }

    public int hashCode() {
        int result = this.id;
        result = 31 * result + this.fieldId;
        result = 31 * result + this.questions.hashCode();
        result = 31 * result + (this.answers != null ? this.answers.hashCode() : 0);
        return result;
    }
}

