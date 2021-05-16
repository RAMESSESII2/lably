package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.xfactor.lably.entity.Tests;
import com.xfactor.lably.repository.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tests")
public class TestController {

    ArrayList<Tests> labs = new ArrayList<>();

    @Autowired
    TestRepository testRepo;

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello() {
        return "Greetings from XFACTOR!!!";
    }
    //path parameter, 
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "Greetings from " + name + "!!!";
    }

    @GetMapping("/hello2")
    public String helloName2(@RequestParam String name, @RequestParam String age) {
        return "Greetings from hello2 " + name + "!!!" + age;
    }

    @GetMapping("/hello3")
    public Map<String, String> helloName3(@RequestParam String name, @RequestParam String age) {
        Map<String, String> respoMap = new HashMap<>();
        respoMap.put("name", name);
        respoMap.put("age", age);
        return respoMap;
    }

    @GetMapping("/hello4")
    public ArrayList helloName4(@RequestParam String name, @RequestParam String age) {
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(name);
        arrayList.add(age);
        return arrayList;
    }

    @GetMapping("/getTests")
    public List<Tests> getTests() {
        List<Tests> test = testRepo.findAll();
        return test;
    }

    @PostMapping("/addTests")
    // public @ResponseBody Lab addLab(@RequestBody Lab lab) 
    public Tests addTests(@RequestBody Tests te) {
        Tests ptests = testRepo.save(te);
        return ptests;
    }

    @GetMapping("/findTests")
    public Tests find(@RequestParam String name){
        List<Tests> t = testRepo.findAll();
        for( Tests x: t){
            if( x.getName().equalsIgnoreCase(name)){
                return x;
            }
        }
        return null;
    }
    // // http://localhost:8080/test/hello/xfactor
    // @GetMapping("/hello/{name}")
    // @ResponseBody
    // public String index_greetings(@PathVariable String name) {
    // return "Greetings :" + name;
    // }

    // // http://localhost:8080/test/hello2?id=16
    // @GetMapping("/hello2")
    // @ResponseBody
    // public String getFoos(@RequestParam String id) {
    // return "ID: " + id;
    // }

    // @PostMapping("/employees")
    // Employee newEmployee(@RequestBody Employee newEmployee) {
    // return repository.save(newEmployee);
    // }

}
