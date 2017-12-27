/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.safaricom.controllers;

import javax.validation.Valid;
import ke.co.safaricom.dataservices.AuthService;
import ke.co.safaricom.dataservices.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CWEKESA
 */
@RestController
@RequestMapping(produces="application/json")
public class AppEntryController {
    
    @Autowired
    RegisterService register;
    
    @Autowired
    AuthService authservice;
    
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String register(@RequestBody RegisterRequest req) {
        return register.processregistration(req);
    }
    
    @RequestMapping(value="/auth",method = RequestMethod.POST)
    public String requestAuth(@RequestBody AuthRequest req) {
        return authservice.processauth(req);
    }
    
}
