package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import com.xfactor.lably.entity.Admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
// -----Admin controller----
// Add Admin (POST)
// List of admins - Must return 5 admin objects (GET)
// Api to return single admin by username (GET)

@RestController
@RequestMapping("/admin")
public class AdminController {

    ArrayList<Admin> admins = new ArrayList<>();

    @GetMapping("/hello")
    public String hello() {
        return "This is admins api";
    }
    @GetMapping("/getAdmins")
    public ArrayList<Admin> getAdmins() {
        return admins;
    }
    @PostMapping("/addAdmins")
    public Admin addLab(@RequestBody Admin adm) {
        admins.add(adm);
        return adm;
    }
    @GetMapping("/get/{uname}")
    public Admin findAdmin(@PathVariable String uname){
        Admin nul = new Admin();
        for( Admin x: admins){
            if( x.getUsername().equals(uname) ){
                return x;
            }
        }
        return nul;
    }

}
