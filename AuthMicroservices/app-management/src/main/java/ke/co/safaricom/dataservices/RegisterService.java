/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.safaricom.dataservices;

import java.util.UUID;
import ke.co.safaricom.controllers.RegisterRequest;
import ke.co.safaricom.dbao.Appmanagerdao;
import ke.co.safaricom.dbentities.Auth;
import ke.co.safaricom.dbentities.Applications;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author CWEKESA
 */

@Service
public class RegisterService {
    
    private final String error="error";
    private final String success="success";
    private final String token="token";
    
    @Autowired(required=true)
    @Qualifier("Appmanagerdao")
    private Appmanagerdao appmanagerdao;
    
    
    public String processregistration(RegisterRequest data){
        JSONObject response=new JSONObject();
        try{
            if(data.getApp_name()!=null&&data.getAuth_type()!=null){
               //lets get the auth first
               Auth auth=appmanagerdao.getAuthtype(data.getAuth_type());
               //check if the auth is OK before procedding
               if(auth!=null){
                   String token_info=tokengenerator();
                   System.out.println("Auth available");
                   Applications app=new Applications();
                   app.setAppName(data.getApp_name());
                   app.setAuthType(auth);
                   app.setToken(token_info);
                   appmanagerdao.addApplication(app);
                   response.put(success, true);
                   response.put(token, token_info);
               }
               else{
                   response.put(error, "auth type specified not known");
               }
            }
            else{
               response.put(error, "check your request and try again, ensure you have app_name and auth_type"); 
            }
        }
        catch(Exception e){
            response.put(error, "check your request and try again");
        }
        return response.toString();
    }
    
    private String tokengenerator(){
        String token="";
        try{
            String first=Long.toHexString(Double.doubleToLongBits(Math.random()));
            String second=UUID.randomUUID().toString().replaceAll("-", "");
            String third=UUID.randomUUID().toString();
            token=first+second+third;
        }
        catch(Exception e){
        }
        return token;
    }
    
}
