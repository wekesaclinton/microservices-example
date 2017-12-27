/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.safaricom.controllers;

import org.json.JSONObject;
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
public class IntroController {
    
    @RequestMapping(value="/stk-initiate",method = RequestMethod.POST)
    public String stk(@RequestBody String req) {
        
        JSONObject response=new JSONObject();
        response.put("success", true);
        response.put("location", "stk-service");
        response.put("description", "welcome to stk-service");
        return response.toString();
    }
    @RequestMapping(value="/info",method = RequestMethod.GET)
    public String info() {
        JSONObject response=new JSONObject();
        response.put("name", "STK-service");
        response.put("description", "This is the service that is used to auth the stk-and service pin requests through the proxy");
        return response.toString();
    }
    
}
