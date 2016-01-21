/* 
 * Decompiled with CFR 0_110. 
 *  
 * Could not load the following classes: 
 *  javax.servlet.http.HttpServletResponse 
 *  org.springframework.beans.factory.annotation.Autowired 
 *  org.springframework.web.bind.annotation.PathVariable 
 *  org.springframework.web.bind.annotation.RequestBody 
 *  org.springframework.web.bind.annotation.RequestMapping 
 *  org.springframework.web.bind.annotation.RequestMethod 
 *  org.springframework.web.bind.annotation.RequestParam 
 *  org.springframework.web.bind.annotation.RestController 
 */
package com.example.controller;


import com.example.model.Test;
import com.example.service.TestService;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @Autowired
    private TestService service;


    @RequestMapping(value={"/test/{testId}"})
    public Test getTest(@PathVariable int testId) {
        return this.service.findByIdWithoutAns(testId);
    }


    @RequestMapping(value={"/test/{testId}"}, method={RequestMethod.POST})
    public Map<String, String> passTest(@PathVariable int testId, @RequestBody List<String> userAnswers) {
        HashMap<String, String> answersWithMark = new HashMap<String, String>();
        Test test = this.service.findById(testId);
        for (int i = 0; i < test.getAnswers().size(); ++i) {
            if (test.getAnswers().get(i).equals(userAnswers.get(i))) continue;
            answersWithMark.put(test.getQuestions().get(i), test.getAnswers().get(i));
        }
        answersWithMark.put("mark", Double.toString(100.0 + 100.0 * ((double)(test.getAnswers().size() - answersWithMark.size()) / (double)test.getAnswers().size())));
        return answersWithMark;
    }


    @RequestMapping(value={"/tests"}, method={RequestMethod.GET})
    public Iterable<Test> getTests() {
        return this.service.getAllByIdWithoutAns();
    }


    @RequestMapping(value={"/test"}, method={RequestMethod.POST})
    public void putTest(@RequestBody Test test) {
        this.service.persist(test);
    }


    @RequestMapping(value={"/result"}, method={RequestMethod.GET})
    public void showResult(@RequestParam String request, HttpServletResponse response) throws IOException {
        response.sendRedirect("http://abit-poisk.org.ua/score/result/" + request);
    }
} 
 